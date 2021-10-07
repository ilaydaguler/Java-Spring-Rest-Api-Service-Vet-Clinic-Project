package com.works.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
@ApiModel(value = "Kategori",description = "Kategori ekleme için kullanılır")
public class CategoryGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cg_id", nullable = false)
    private Integer cg_id;

    @ApiModelProperty(value = "Kategori adı")
    @NotNull(message = "Kategori Adı boş olamaz")
    @NotEmpty(message = "Kategori Adı boş olamaz")
    private String cg_name;

    @ApiModelProperty(value = "Kategori durumu")
    @NotNull()
    private boolean cg_status;
}