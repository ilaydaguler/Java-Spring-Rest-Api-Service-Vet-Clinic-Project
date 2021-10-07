package com.works.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
@ApiModel(value = "Kayıtlı Tedarikçi Satış Sepet",description = "Satış ürün ekleme için kullanılır")
public class BoxCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bc_id", nullable = false)
    private Integer bc_id;

    @Min(value = 1)
    @ApiModelProperty(value = "Ürün adı")
    private int productName;

    @Min(value = 1)
    @ApiModelProperty(value = "Müşteri Adı")
    private int customerName;
    @Min(value = 1)
    @ApiModelProperty(value = "Ürün miktarı")
    private int box_customer_amount;

    @NotNull(message = "Kayıtlı müşteri satış notu Null Olamaz")
    @NotEmpty(message = "Kayıtlı müşteri satış notu Boş olamaz")
    @ApiModelProperty(value = "Müşteri notu")
    private String customer_note;

}