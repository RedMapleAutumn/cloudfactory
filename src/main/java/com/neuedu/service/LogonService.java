package com.neuedu.service;

public interface LogonService {
    public String agencylogon(String account,String password,String name,String tel,String type);

    public String factoryadminlogon(String account,String password,String name,String tel,String type,
                                    String factroyname,String factoryintro);
}
