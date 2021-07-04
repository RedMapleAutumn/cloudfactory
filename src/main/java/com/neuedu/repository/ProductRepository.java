package com.neuedu.repository;

import com.neuedu.entity.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductRepository {
    public List<Product> findAll();

    public String checkPNO(@Param("PNO") String PNO);

    public int add(@Param("PNO") String PNO,@Param("name") String name,@Param("PCNO") String PCNO,
                      @Param("size") String size,@Param("des") String description);
}
