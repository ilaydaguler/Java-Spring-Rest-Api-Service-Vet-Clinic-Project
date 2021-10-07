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
@ApiModel(value = "Ürün",description = "Ürün ekleme için kullanılır")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private Integer product_id;

    @ApiModelProperty(value = "Ürün adı")
    @NotNull(message = "Ürün adı boş olamaz")
    @NotEmpty(message = "Ürün boş olamaz")
    private String product_name;

    @ApiModelProperty(value = "Ürün birimi")
    @NotNull(message = "Ürün birimi boş olamaz")
    @NotEmpty(message = "Ürün birimi boş olamaz")
    private String product_unit;

    @ApiModelProperty(value = "Kategori id")
    @Min(value = 0)
    private int category_group_cg_id;

    @ApiModelProperty(value = "Tedarikçi id")
    @Min(value = 0)
    private int vendor_vid;

    @ApiModelProperty(value = "Ürün türü")
    @NotNull(message = "Ürün türü boş olamaz")
    private String product_type;

    @ApiModelProperty(value = "Ürün barkodu")
    @Min(value = 0)
    private int product_barcode;

    @ApiModelProperty(value = "Ürün kodu")
    @Min(value = 0)
    private int product_code;

    @ApiModelProperty(value = "Ürün KDV oranı")
    @Min(value = 0)
    private int product_kdv;

    @ApiModelProperty(value = "Ürün alış fiyatı")
    @Min(value = 0)
    private int product_buying;

    @ApiModelProperty(value = "Ürün satış fiyatı")
    @Min(value = 0)
    private int product_sales;

    @ApiModelProperty(value = "Ürün kritik stok miktarı")
    @Min(value = 0)
    private int product_stock;

    @ApiModelProperty(value = "Ürün durumu Aktif/Değil")
    @NotNull()
    private boolean product_status;

    @ApiModelProperty(value = "Ürün satış fiyatına KDV dahil mi?")
    @NotNull()
    private boolean product_sales_kdv;

    @ApiModelProperty(value = "Ürün alış fiyatına KDV dahil mi?")
    @NotNull()
    private boolean product_buying_kdv;

    @ApiModelProperty(value = "Miktarlı satışlarda fiyat sabitlensin mi?")
    @NotNull()
    private boolean product_amount_fixed;

}
