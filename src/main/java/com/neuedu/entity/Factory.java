package com.neuedu.entity;

public class Factory {

    private String FNO;
    private String fname;
    private String description;
    private String account;      //云工厂管理员账号
    private String adminName;
    private String tel;
    private String status;      //关停、开启

    public Factory(String fname, String description, String account, String adminName, String tel, String status, String FNO) {
        this.fname = fname;
        this.description = description;
        this.account = account;
        this.adminName = adminName;
        this.tel = tel;
        this.status = status;
        this.FNO = FNO;
    }

    public Factory() {
    }

    public String getFNO() {
        return FNO;
    }

    public void setFNO(String FNO) {
        this.FNO = FNO;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Factory{" +
                "FNO='" + FNO + '\'' +
                ", fname='" + fname + '\'' +
                ", description='" + description + '\'' +
                ", account='" + account + '\'' +
                ", adminName='" + adminName + '\'' +
                ", tel='" + tel + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
