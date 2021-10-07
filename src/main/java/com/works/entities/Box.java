package com.works.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.annotation.security.PermitAll;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
@ApiModel(value = "Parekende Satış Sepet",description = "Satış ürün ekleme için kullanılır")
public class Box {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "box_id", nullable = false)
    private Integer box_id;

    @Min(value = 1)
    @ApiModelProperty(value = "Ürün ıd")
    private int retail_pro_search;

    @Min(value = 1)
    @ApiModelProperty(value = "Ürün Miktarı")
    private int sales_product_amount;

    @NotNull(message = "Satış Notu Null Olamaz")
    @NotEmpty(message = "Satış Notu Boş olamaz")
    @ApiModelProperty(value = "Satış Notu")
    private String sales_note;

}