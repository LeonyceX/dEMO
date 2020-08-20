package com.example.demo.reviewimage;

import com.example.demo.brand.Brand;
import com.example.demo.review.Review;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Entity
@Setter
@Getter

public class Reviewimage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 2, max = 512, message = "Please provide FullName size between 2 - 512")
    private String FullName;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "review_id",nullable = false)
    private Review review;

}