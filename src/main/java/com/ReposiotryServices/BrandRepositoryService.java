package com.ReposiotryServices;

import com.Domian.BrandEntity;
import com.Exceptions.ResourceNotFoundException;
import com.Reposiotry.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BrandRepositoryService {
    private final BrandRepository brandRepository;

    public List<BrandEntity> getAllBrands() {
        return brandRepository.findAll();
    }

    public BrandEntity getBrandById(Long id) {
        return getBrandEntity(id);
    }

    private BrandEntity getBrandEntity(Long id) {
        return brandRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("id with given brand not found"));
    }


    public BrandEntity createBrand(BrandEntity brand) {
        return getSave(brand);
    }

    private BrandEntity getSave(BrandEntity brand) {
        return brandRepository.save(brand);
    }


    public BrandEntity updateBrand(BrandEntity brand) {
        return getSave(brand);
    }

    public void deleteBrand(Long id) {
        brandRepository.deleteById(id);
    }
}
