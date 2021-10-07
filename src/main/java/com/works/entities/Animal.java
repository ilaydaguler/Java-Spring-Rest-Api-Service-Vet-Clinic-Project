package com.works.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@ApiModel(value = "Hayvan",description = "Hayvan ekleme için kullanılır")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aid", nullable = false)
    private Integer aid;

    @ApiModelProperty(value = "Hayvan adı")
    @NotNull(message = "Hayvan adı null olamaz ")
    @NotEmpty(message = "Hayvan adı boş olamaz")
    private String p_name;

    @ApiModelProperty(value = "Çip no")
    @Column(unique = true)
    private int cip_no;

    @ApiModelProperty(value = "Karne no")
    private int karne_no;

    @ApiModelProperty(value = "Doğum tarihi")
    private Date p_birth;

    @ApiModelProperty(value = "Hayvan tipi")
    @NotNull(message = "Tipi null olamaz ")
    @NotEmpty(message = "Tipi boş olamaz")
    private String p_type;

    @ApiModelProperty(value = "Irkı")
    @NotNull(message = "Irkı null olamaz ")
    @NotEmpty(message = "Irkı boş olamaz")
    private String p_race;

    @ApiModelProperty(value = "Rengi")
    @NotNull(message = "Renk null olamaz ")
    @NotEmpty(message = "Renk boş olamaz")
    private String pcolor;

    @Min(value=1,message = "1 : Erkek, 2: Dişi")
    @Max(value = 2)
    @ApiModelProperty(value = "Cinsiyeti")
    private int gender;

    @ApiModelProperty(value = "Kısırlaştırılmış mı?")
    private boolean spayed;

    @ApiModelProperty(value = "Müşteri No")
    private int cus_no;


}
