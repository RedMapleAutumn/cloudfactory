package com.neuedu.repository;

import com.neuedu.entity.ProductCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PCategoryRepo {
    public List<ProductCategory> findAll();

    public String checkFCNO(@Param("PCNO") String PCNO);

    public int add(@Param("PCNO") String PCNO,@Param("name") String name);

    public List<ProductCategory> findAllByName(@Param("name") String name);

    public int modifyByPCNO(@Param("PCNO") String PCNO,@Param("name") String name);

    public int deleteByPCNO(@Param("PCNO") String PCNO);
}
