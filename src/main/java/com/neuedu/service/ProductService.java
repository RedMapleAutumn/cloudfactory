package com.neuedu.service;

import com.neuedu.entity.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductService {
    public List<Product> findAll();

    public String add(String name,String PCNO,String size,String description);

    public Product findByIPNO(String PNO);

    public List<Product> findAllByName( String pname);

    public String deleteByPNO(String PNO);

    public String modify( String PNO, String name,String PCNO, String size, String description);

}
