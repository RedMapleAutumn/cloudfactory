package com.neuedu.service;

import com.neuedu.entity.Factory;

import java.util.List;

public interface FactoryService {
    public List<Factory> findAll();

    public List<Factory> findAllByName(String fname);

    public String changeFactoryState(String FNO,String state);
}
