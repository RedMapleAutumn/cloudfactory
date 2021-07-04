package com.neuedu.repository;

import com.neuedu.entity.Factory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FactoryRepository {
    public String checkFNO(@Param("FNO") String FNO);

    public int insert(@Param("FNO") String FNO,@Param("Fname") String Fname,
                         @Param("Fintro") String Fintro,@Param("account") String account);

    public List<Factory> findAll();

    public List<Factory> findAllByName(@Param("fname") String fname);

    public Factory findByFNO(@Param("FNO") String FNO);

    public int changeFactoryState(@Param("FNO") String FNO,@Param("state") String state);
}
