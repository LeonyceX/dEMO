package com.example.demo.promotion;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Entity
@Setter
@Getter

public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 2, max = 512, message = "Please provide Name size between 2 - 512")
    private String Name;

    @NotNull
    private Number discountRate ;

    @NotNull
    private Enum unit  ;

    @NotNull
    private Date effectiveDateFrom ;

    @NotNull
    private Date effectiveDateTo ;

    @NotNull
    private Number remains ;

    @NotNull
    private Number total;

    @NotNull
    private Number minimum ;

    @NotNull
    private Enum type  ;

    @NotNull
    private Boolean  active  ;

}