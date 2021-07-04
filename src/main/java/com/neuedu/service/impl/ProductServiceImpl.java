package com.neuedu.service.impl;

import com.neuedu.entity.Product;
import com.neuedu.repository.ProductRepository;
import com.neuedu.repository.impl.ProductRepositoryImpl;
import com.neuedu.service.ProductService;
import com.neuedu.utils.NumberTools;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    ProductRepository productRepository = new ProductRepositoryImpl();
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public String add(String name, String PCNO, String size, String description) {
        String PNO = "";
        PNO = "PNO" + NumberTools.getNumber();
        String s = productRepository.checkPNO(PNO);
        while(s.equals("编号重复")){
            PCNO = "PNO" + NumberTools.getNumber();
            s = productRepository.checkPNO(PNO);
        }
        int result = productRepository.add(PNO,name,PCNO,size,description);
        return result+"";
    }
}
