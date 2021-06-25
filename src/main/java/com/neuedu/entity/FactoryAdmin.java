package com.neuedu.entity;

public class FactoryAdmin extends Admin{
    private String FNO;
    private String factoryName;
    private String factoryIntro;

    public FactoryAdmin(String account, String password, String name, String contact, String role, String FNO, String factoryName, String factoryIntro) {
        super(account, password, name, contact, role);
        this.FNO = FNO;
        this.factoryName = factoryName;
        this.factoryIntro = factoryIntro;
    }

    public FactoryAdmin(String account, String password, String name, String contact, String role) {
        super(account, password, name, contact, role);
    }

    public FactoryAdmin(String account, String password, String name, String contact, String role, String FNO) {
        super(account, password, name, contact, role);
        this.FNO = FNO;
    }

    public FactoryAdmin() {
    }

    public String getFNO() {
        return FNO;
    }

    public void setFNO(String FNO) {
        this.FNO = FNO;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public String getFactoryIntro() {
        return factoryIntro;
    }

    public void setFactoryIntro(String factoryIntro) {
        this.factoryIntro = factoryIntro;
    }
}
