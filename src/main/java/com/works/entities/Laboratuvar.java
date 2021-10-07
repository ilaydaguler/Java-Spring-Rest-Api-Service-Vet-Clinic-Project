package com.works.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@ApiModel(value = "Laboratuvar",description = "Laboratuvar sonuç ekleme için kullanılır")
public class Laboratuvar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lid", nullable = false)
    private Integer lid;

    @ApiModelProperty(value = "Laboratuvar türü")
    private int lab_type;
    @ApiModelProperty(value = "Hayvan id")
    private int animalName;
    @ApiModelProperty(value = "Teşhis")
    private String diagnosis;
    @ApiModelProperty(value = "Dosya")
    private String imageName;
    @ApiModelProperty(value = "Müşteri id")
    private int cus_no;


}
