package com.works.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.AccessType;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class BaseVendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ApiModelProperty(value= "Tedarikçi adı")
    private String vendor_name;
    @ApiModelProperty(value = "Tedarikçi email")
    private String vendor_email;
    @ApiModelProperty(value = "Tedarikçi Telefon")
    private String vendor_phone;
}
