package com.ServiceImpl;

import com.DTOS.BrandDTO;
import com.Domian.BrandEntity;
import com.Exceptions.ResourceNotFoundException;
import com.Mapper.BrandMapper;
import com.ReposiotryServices.BrandRepositoryService;
import com.Services.BrandService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class BrandServiceImpl implements BrandService {
    private final BrandRepositoryService repositoryService;
    private final BrandMapper mapper;
    private final Validator validator;

    @Override
    public List<BrandDTO> getAllBrands() {
        return repositoryService.getAllBrands().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public BrandDTO getBrandById(Long id) {
        BrandEntity getBrandByID = getGetBrandByID(id);
        return mapper.toDto(getBrandByID);
    }

    private BrandEntity getGetBrandByID(Long id) {
        BrandEntity getBrandByID = repositoryService.getBrandById(id);
        return getBrandByID;
    }

    @Override
    public BrandDTO createBrand(BrandDTO brand) {

        BrandEntity brandEntity = mapper.toEntity(brand);
        validateBrand(brandEntity);
        BrandEntity savedBrand = repositoryService.createBrand(brandEntity);
        return mapper.toDto(savedBrand);
    }

    @Override
    public BrandDTO updateBrand(BrandDTO brand) {

        BrandEntity existingBrand = repositoryService.getBrandById(brand.getId());
        if (existingBrand == null) {
            throw new ResourceNotFoundException("Brand not found with ID: " + brand.getId());
        }
        validateBrand(existingBrand);
        mapper.updateEntityFromDto(brand, existingBrand);
        BrandEntity brandEntity = repositoryService.updateBrand(existingBrand);

        return mapper.toDto(brandEntity);
    }


    @Override
    public void deleteBrand(Long id) {
        if (id == null) {
            throw new NullPointerException("Brand ID cannot be null");
        }

        if (!(id instanceof Long)) {
            throw new ClassCastException("Brand ID must be of type Long");
        }
        repositoryService.deleteBrand(id);


    }

    private void validateBrand(BrandEntity brandEntity) {
        Set<ConstraintViolation<BrandEntity>> violations = validator.validate(brandEntity);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }
}
