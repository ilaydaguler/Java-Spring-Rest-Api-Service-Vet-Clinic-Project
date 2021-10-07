package com.works.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
@ApiModel(value = "Kasa",description = "Kasa ekleme için kullanılır")
public class NewCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "case_id", nullable = false)
    private Integer case_id;

    @ApiModelProperty(value = "Kasa tipi")
    @NotNull(message = "Kasa tipi boş olamaz")
    @NotEmpty(message = "Kasa tipi boş olamaz")
    private String case_type;

    @ApiModelProperty(value = "Kasa adı")
    @NotNull(message = "Kasa adı boş olamaz")
    @NotEmpty(message = "Kasa adı boş olamaz")
    private String case_name;

    @ApiModelProperty(value = "Kasa Durumu")
    @NotNull()
    private boolean case_status;
}