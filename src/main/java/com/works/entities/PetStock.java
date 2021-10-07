package com.works.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Data
@ApiModel(value = "Pet Aşı Stok",description = "Pet aşı stok ekleme için kullanılır")
public class PetStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "psid", nullable = false)
    @Min(value = 1, message = "Bu değer Mutlaka girilmelidir")
    private Integer psid;

    @ApiModelProperty(value = "Depo id")
    @Min(value = 0)
    private int depo;

    @ApiModelProperty(value = "Pet aşı id")
    @Min(value = 0)
    private int pet_vac;

    @ApiModelProperty(value = "Pet aşı miktarı")
    @Min(value = 0)
    private int amount;
}
