package com.neuedu.entity;

public class Product {
    private String PNO;
    private String name;
    private String category;
    private String size;
    private String description;

    public Product() {
    }

    public Product(String PNO, String name, String category, String size, String description) {
        this.PNO = PNO;
        this.name = name;
        this.category = category;
        this.size = size;
        this.description = description;
    }

    public String getPNO() {
        return PNO;
    }

    public void setPNO(String PNO) {
        this.PNO = PNO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "PNO='" + PNO + '\'' +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", size='" + size + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
