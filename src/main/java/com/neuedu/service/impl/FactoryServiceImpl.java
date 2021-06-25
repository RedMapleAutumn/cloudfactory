package com.neuedu.service.impl;

import com.neuedu.entity.Factory;
import com.neuedu.repository.FactoryRepository;
import com.neuedu.repository.impl.FactoryRepositoryImpl;
import com.neuedu.service.FactoryService;

import java.util.List;

public class FactoryServiceImpl implements FactoryService {
    FactoryRepository factoryRepository = new FactoryRepositoryImpl();
    @Override
    public List<Factory> findAll() {
        return factoryRepository.findAll();
    }

    @Override
    public List<Factory> findAllByName(String fname) {
        return factoryRepository.findAllByName(fname);
    }

    @Override
    public String changeFactoryState(String FNO,String state) {
        String s = factoryRepository.checkFNO(FNO);
        String result = "";
        if(s.equals("编号存在")){
            result = factoryRepository.changeFactoryState(FNO,state);
        }
        return result;
    }
}
