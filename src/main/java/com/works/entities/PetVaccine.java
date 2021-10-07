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
@ApiModel(value = "Pet Aşı",description = "Pet aşı ekleme için kullanılır")
public class PetVaccine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pet_vaccine_id", nullable = false)
    private Integer pet_vaccine_id;


    @NotNull(message = "Pet aşı adı boş olamaz")
    @NotEmpty(message = "Pet aşı boş olamaz")
    @ApiModelProperty(value = "Pet Aşı adı")
    private String pet_vaccine_name;


    @NotNull(message = "Pet aşı birim boş olamaz")
    @NotEmpty(message = "Pet aşı birim boş olamaz")
    @ApiModelProperty(value = "Pet aşı birim")
    private String pet_vaccine_unit;


    @Min(value = 0)
    @ApiModelProperty(value = "Kategori id")
    private int category_group_cg_id;


    @Min(value = 0)
    @ApiModelProperty(value = "Tedarikçi id")
    private int vendor_vid;

    @NotNull(message = "Pet aşı türü boş olamaz")
    @NotEmpty(message = "Pet aşı türü boş olamaz")
    @ApiModelProperty(value = "Pet türü")
    private String pet_vaccine_type;

    @Min(value = 0)
    @ApiModelProperty(value = "Pet aşı barkodu")
    private int pet_vaccine_barcode;

    @Min(value = 0)
    @ApiModelProperty(value = "Pet aşı kodu")
    private int pet_vaccine_code;

    @Min(value = 0)
    @ApiModelProperty(value = "Pet aşı KDV oranı")
    private int pet_vaccine_kdv;

    @Min(value = 0)
    @ApiModelProperty(value = "Pet aşı alış fiyatı")
    private int pet_vaccine_buying;

    @Min(value = 0)
    @ApiModelProperty(value = "Pet aşı satış fiyatı")
    private int pet_vaccine_sales;

    @Min(value = 0)
    @ApiModelProperty(value = "Pet aşı kritik stok miktarı")
    private int pet_vaccine_stock;


    @NotNull()
    @ApiModelProperty(value = "Pet aşı durumu Aktif/Değil")
    private boolean pet_vaccine_status;


    @NotNull()
    @ApiModelProperty(value = "Pet aşı satış fiyatına KDV dahil mi?")
    private boolean pet_vaccine_sales_kdv;


    @NotNull()
    @ApiModelProperty(value = "Pet aşı alış fiyatına KDV dahil mi?")
    private boolean pet_vaccine_buying_kdv;


    @NotNull()
    @ApiModelProperty(value = "Miktarlı satışlarda fiyat sabitlensin mi?")
    private boolean pet_vaccine_amount_fixed;

    @NotNull(message = "Pet aşı tipi boş olamaz")
    @NotEmpty(message = "Pet aşı tipi boş olamaz")
    @ApiModelProperty(value = "Pet aşı tipi")
    private String pet_vaccine_tip;

    @Min(value = 0)
    @ApiModelProperty(value = "Pet aşı tekrar sayısı")
    private int pet_vaccine_number;
}
