package com.works.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@ApiModel(value = "Alış",description = "Alış ekleme için kullanılır")
public class Buying {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bid", nullable = false)
    private Integer bid;


    private int name;
    private int productName;
    private int total;

    @NotNull(message = "Fatura No Null Olamaz")
    @NotEmpty(message = "Fatura No Boş olamaz")
    @ApiModelProperty(value = "Fatura No ")
    private String billNumber;

    private int process;

    @NotNull(message = "Alış Notu Null Olamaz")
    @NotEmpty(message = "Alış Notu Boş olamaz")
    @ApiModelProperty(value = "Alış Notu ")
    private String buyingNote;
    private Date buying_date;

}
