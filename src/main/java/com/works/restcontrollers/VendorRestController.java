package com.works.restcontrollers;

import com.works.utils.Util;
import com.works.dto.VendorDto;
import com.works.model.Vendor;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/vendor")
@Api(value ="VendorRestController",authorizations ={@Authorization(value = "basicAuth")})
public class VendorRestController {

    final VendorDto vendorDto;
    final Util util;

    public VendorRestController(VendorDto vendorDto,  Util util) {
        this.vendorDto = vendorDto;
        this.util = util;
    }

    @ApiOperation("Tedarikçi ekleme")
    @PostMapping("/add")
    public Map<String, Object> add(@RequestBody @Valid Vendor vendor,BindingResult bResult){

        return vendorDto.Vendoradd(vendor,bResult);
    }

    @ApiOperation("Tedarikçi listesi")
    @GetMapping("/list")
    public Map<String ,Object> list(){
        return vendorDto.Vendorlist();
    }

    @ApiOperation("Tedarikçi silme")
    @DeleteMapping("/delete/{strIndex}")
    public Map<String, Object> delete(@PathVariable String strIndex){
        return vendorDto.Vendordelete(strIndex);
    }





}
