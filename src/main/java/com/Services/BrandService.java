package com.Services;

import com.DTOS.BrandDTO;

import java.util.List;

public interface BrandService {

    List<BrandDTO> getAllBrands();

    BrandDTO getBrandById(Long id);

    BrandDTO createBrand(BrandDTO brand);

    BrandDTO updateBrand(BrandDTO brand);


    void deleteBrand(Long id);
}