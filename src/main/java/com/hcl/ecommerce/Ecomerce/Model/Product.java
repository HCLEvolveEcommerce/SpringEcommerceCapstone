package com.hcl.ecommerce.Ecomerce.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private int id;
    private String name;
    private String category;
    private Double price;
    private String image;


    public Product() {
    }


    public Product(int id, String name, String category, Double price, String image) {
        super();
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.image = image;
    }

    public Product(String name, String category, Double price, String image) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.image = image;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", category=" + category + ", price=" + price + ", image="
                + image + "]";
    }

}

