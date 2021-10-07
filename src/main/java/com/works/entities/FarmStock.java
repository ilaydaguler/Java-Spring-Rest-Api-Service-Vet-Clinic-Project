package com.works.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Data
@ApiModel(value = "Çiftlik Aşı Stok",description = "Çiftlik aşı stok ekleme için kullanılır")
public class FarmStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fsid", nullable = false)
    private Integer fsid;

    @ApiModelProperty(value = "Çiftlik aşı id")
    @Min(value = 0)
    private int farm_vac;

    @ApiModelProperty(value = "Depo id")
    @Min(value = 0)
    private int warehouse;

    @ApiModelProperty(value = "Çiftlik aşı miktarı")
    @Min(value = 0)
    private int number;

}
