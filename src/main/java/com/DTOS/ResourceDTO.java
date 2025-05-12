package com.DTOS;

import jdk.jfr.Category;
import lombok.Data;

import java.util.List;

@Data
public class ResourceDTO {
    private Long id;
    private String name;
    private String description;
    private Long ownerId;
    private String category;
    private Boolean available;
}