package com.neuedu.repository;

import com.neuedu.entity.Product;

import java.util.List;

public interface ProductRepository {
    public List<Product> findAll();

    public String checkPNO(String PNO);

    public String add(String PNO,String name, String PCNO, String size, String description);
}
