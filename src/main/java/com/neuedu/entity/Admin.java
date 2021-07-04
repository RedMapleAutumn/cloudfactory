package com.neuedu.entity;

public class Admin {
    private String account;
    private String password;
    private String name;
    private String contact;
    private String role;
    private String DStatus;

    public Admin(String account, String password, String name, String contact, String role) {
        this.account = account;
        this.password = password;
        this.name = name;
        this.contact = contact;
        this.role = role;
        this.DStatus = "1";
    }

    public Admin() {
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDStatus() {
        return DStatus;
    }

    public void setDStatus(String DStatus) {
        this.DStatus = DStatus;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", role='" + role + '\'' +
                ", DStatus='" + DStatus + '\'' +
                '}';
    }
}
