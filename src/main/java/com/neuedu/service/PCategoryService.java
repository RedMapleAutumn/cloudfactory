package com.neuedu.service;

import com.neuedu.entity.ProductCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PCategoryService {
    public List<ProductCategory> findAll();

    public String add(String name);

    public List<ProductCategory> findAllByName(String name);

    public int modifyByPCNO( String PCNO,  String name);

    public int deleteByPCNO( String PCNO);
}
