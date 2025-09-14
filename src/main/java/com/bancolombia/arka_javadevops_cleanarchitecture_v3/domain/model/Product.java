package com.bancolombia.arka_javadevops_cleanarchitecture_v3.domain.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
 
    private String id;
    private String name;
    private double price;
    private List<Comment> comments;
}
