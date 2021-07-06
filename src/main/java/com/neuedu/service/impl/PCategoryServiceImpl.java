package com.neuedu.service.impl;

import com.neuedu.entity.ProductCategory;
import com.neuedu.repository.PCategoryRepo;
import com.neuedu.repository.impl.PCategoryRepoImpl;
import com.neuedu.service.PCategoryService;
import com.neuedu.utils.NumberTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PCategoryServiceImpl implements PCategoryService {
    @Autowired
    PCategoryRepo pCategoryRepo;
    @Override
    public List<ProductCategory> findAll() {
        return pCategoryRepo.findAll();
    }

    @Override
    public String add(String name) {
        String PCNO = "";
        PCNO = "PCNO" + NumberTools.getNumber();
        String s = pCategoryRepo.checkFCNO(PCNO);
        while(s.equals("1")){
            PCNO = "FCNO" + NumberTools.getNumber();
            s = pCategoryRepo.checkFCNO(PCNO);
        }
        int result = pCategoryRepo.add(PCNO,name);
        return result+"";
    }

    @Override
    public List<ProductCategory> findAllByName(String name) {
        return pCategoryRepo.findAllByName(name);
    }
}
