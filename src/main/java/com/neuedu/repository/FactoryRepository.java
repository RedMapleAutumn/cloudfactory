package com.neuedu.repository;

import com.neuedu.entity.Factory;

import java.util.List;

public interface FactoryRepository {
    public String checkFNO(String FNO);

    public String insert(String FNO,String Fname,String Fintro,String account);

    public List<Factory> findAll();

    public List<Factory> findAllByName(String fname);

    public Factory findByFNO(String FNO);

    public String changeFactoryState(String FNO,String state);
}
