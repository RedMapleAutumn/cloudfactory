package com.neuedu.entity;

public class ProductCategory {
    private String PCNO;
    private String name;
    private String status;

    public ProductCategory(String PCNO, String name, String status) {
        this.PCNO = PCNO;
        this.name = name;
        this.status = status;
    }

    public ProductCategory() {
    }

    public String getPCNO() {
        return PCNO;
    }

    public void setPCNO(String PCNO) {
        this.PCNO = PCNO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ProductCategory{" +
                "PCNO='" + PCNO + '\'' +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
