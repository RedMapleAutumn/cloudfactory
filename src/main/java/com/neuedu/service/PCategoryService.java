package com.neuedu.service;

import com.neuedu.entity.ProductCategory;

import java.util.List;

public interface PCategoryService {
    public List<ProductCategory> findAll();

    public String add(String name);

    public List<ProductCategory> findAllByName(String name);
}
