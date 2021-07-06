package com.neuedu.service.impl;

import com.neuedu.entity.Factory;
import com.neuedu.repository.FactoryRepository;
import com.neuedu.repository.impl.FactoryRepositoryImpl;
import com.neuedu.service.FactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FactoryServiceImpl implements FactoryService {
    @Autowired
    FactoryRepository factoryRepository;
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
        int result = 0;
        if(s.equals("1")){
            result = factoryRepository.changeFactoryState(FNO,state);
        }
        return result+"";
    }
}
