package com.example.demo.product;

import com.example.demo.brand.Brand;
import com.example.demo.category.Category;
import com.example.demo.tag.Tag;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Setter
@Getter

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 2, max = 512, message = "Please provide productName size between 2 - 512")
    private String productName;

    @NotNull
    @Size(min = 2, max = 512, message = "Please provide detail size between 2 - 512")
    private String detail;

    @NotNull
    private Number warranty;

    @NotNull
    @Size(min = 2, max = 512, message = "Please provide termAndCondition size between 2 - 512")
    private String termAndCondition;

    @ManyToOne (fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "category_Id",nullable = false)
    private Category category;

    @ManyToOne (fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "brand_Id",nullable = false)
    private Brand brand;

    @ManyToOne (fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "tag_Id",nullable = false)
    private Tag tag;


}