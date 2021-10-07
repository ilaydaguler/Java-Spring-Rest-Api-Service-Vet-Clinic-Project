package com.works.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Data
@ApiModel(value = "Ürün Stok",description = "Ürün stok ekleme için kullanılır")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sid", nullable = false)
    private Integer sid;

    @ApiModelProperty(value = "Depo id")
    @Min(value = 0)
    private int depo;

    @ApiModelProperty(value = "Ürün miktarı")
    @Min(value = 0)
    private int amount;

    @ApiModelProperty(value = "Ürün id")
    @Min(value = 0)
    private int product;




}

