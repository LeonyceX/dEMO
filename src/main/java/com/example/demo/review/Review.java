package com.example.demo.review;

import com.example.demo.brand.Brand;
import com.example.demo.product.Product;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Entity
@Setter
@Getter

public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 2, max = 512, message = "Please provide description size between 2 - 512")
    private String description;

    @NotNull
    @Min(value = 10, message = "Please provide rate >10")
    private Float rate;

    @DateTimeFormat
    private Date datetime;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;

}