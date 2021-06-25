package com.neuedu.service;

import com.neuedu.entity.Product;

import java.util.List;

public interface ProductService {
    public List<Product> findAll();

    public String add(String name,String PCNO,String size,String description);

//    public String modify(String PNO,String name,String PCNO,String size,String description);
}
