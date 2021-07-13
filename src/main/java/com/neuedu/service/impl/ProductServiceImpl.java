package com.neuedu.service.impl;

import com.neuedu.entity.Product;
import com.neuedu.repository.ProductRepository;
import com.neuedu.repository.impl.ProductRepositoryImpl;
import com.neuedu.service.ProductService;
import com.neuedu.utils.NumberTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository ;
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public String add(String name, String PCNO, String size, String description) {
        String PNO = "";
        PNO = "PNO" + NumberTools.getNumber();
        String s = productRepository.checkPNO(PNO);
        while(s.equals("1")){
            PCNO = "PNO" + NumberTools.getNumber();
            s = productRepository.checkPNO(PNO);
        }
        int result = productRepository.add(PNO,name,PCNO,size,description);
        return result+"";
    }

    @Override
    public Product findByIPNO(String PNO) {
        Product byIPNO = productRepository.findByIPNO(PNO);
        return byIPNO;
    }

    @Override
    public List<Product> findAllByName(String pname) {
        List<Product> allByName = productRepository.findAllByName(pname);
        return allByName;
    }

    @Override
    public String deleteByPNO(String PNO) {
        int i = productRepository.deleteByPNO(PNO);
        return i+"";
    }

    @Override
    public String modify(String PNO, String name, String PCNO, String size, String description) {
        int modify = productRepository.modify(PNO, name, PCNO, size, description);
        return modify+"";
    }
}
