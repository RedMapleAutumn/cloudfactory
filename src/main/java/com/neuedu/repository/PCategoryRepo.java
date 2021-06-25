package com.neuedu.repository;

import com.neuedu.entity.ProductCategory;

import java.util.List;

public interface PCategoryRepo {
    public List<ProductCategory> findAll();

    public String checkFCNO(String PCNO);

    public String add(String PCNO,String name);

    public List<ProductCategory> findAllByName(String name);
}
