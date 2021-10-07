package com.works.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.Date;

@Entity
@Data
@ApiModel(value = "Kayıtlı Tedarikçi satış ödeme",description = "Kayıtlı tedarikçi satış ödeme için kullanılır")
public class CustomerPaySale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cp_id", nullable = false)
    private Integer cp_id;

    @ApiModelProperty("Sepet toplamı")
    private int saleBoxtotal;

    @ApiModelProperty(value = "Müşteri adı")
    private String c_name;

    @ApiModelProperty(value = "İşlem")
    private int customer_process;

    @ApiModelProperty(value = "Fatura no")
    private int customerBillNumber;
    @ApiModelProperty(value = "Tarih")
    private Date box_cus_date;
}
