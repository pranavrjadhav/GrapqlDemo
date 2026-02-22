package com.testGrapql.demo.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductInput {

    private String name;
    private String category;
    private Float price;
    private Integer stock;

    // getters & setters
}
