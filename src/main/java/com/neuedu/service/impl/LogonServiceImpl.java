package com.neuedu.service.impl;

import com.neuedu.repository.FactoryRepository;
import com.neuedu.repository.UserRepository;
import com.neuedu.repository.impl.FactoryRepositoryImpl;
import com.neuedu.repository.impl.UserRepositoryImpl;
import com.neuedu.service.LogonService;
import com.neuedu.utils.NumberTools;

public class LogonServiceImpl implements LogonService {
    UserRepository userRepository = new UserRepositoryImpl();
    FactoryRepository factoryRepository = new FactoryRepositoryImpl();
    @Override
    public String agencylogon(String account, String password, String name, String tel, String type) {
        String s = userRepository.checkAccount(account);
        String result = "";
        if(s=="账号不重复"){
            int res = userRepository.agencylogon(account,password,name,tel,type);
        }else{
            result = s;
        }
        return result;
    }

    @Override
    public String factoryadminlogon(String account, String password, String name, String tel, String type,
                                    String factroyname, String factoryintro) {

        String s = userRepository.checkAccount(account);
        String result = "";
        int res = 0;
        int result_f = 0;
        if(s=="账号不重复"){
            //确保工厂编号不重复
            String FNO = "";
            FNO = "FNO" + NumberTools.getNumber();
            String fno = factoryRepository.checkFNO(FNO);
            while (fno=="编号重复"){
                FNO = "FNO" + NumberTools.getNumber();
                fno = factoryRepository.checkFNO(FNO);
            }
            //当账号和工厂编号都不重复时，执行插入操作
            res = userRepository.factoryadminlogon(account,password,name,tel,type,factroyname,factoryintro,FNO);
            result_f = factoryRepository.insert(FNO,factroyname,factoryintro,account);
        }else{
            result = s;
        }
        return result;
    }
}
