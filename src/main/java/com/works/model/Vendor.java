package com.works.model;

import com.works.model.BaseVendor;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@ApiModel(value = "Tedarikçi",description = "Tedarikçi ekleme için kullanılır")
public class Vendor extends BaseVendor {

}
