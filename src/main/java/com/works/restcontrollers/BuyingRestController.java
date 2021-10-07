package com.works.restcontrollers;

import com.works.dto.BuyingDto;
import com.works.entities.Buying;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/buying")
@Api(value ="BuyingRestController",authorizations ={@Authorization(value = "basicAuth")})
public class BuyingRestController {

    final BuyingDto buyingDto;

    public BuyingRestController(BuyingDto buyingDto) {
        this.buyingDto = buyingDto;
    }
    @ApiOperation("Alış Listesi")
    @GetMapping("/list")
    public Map<String ,Object> list(){
        return buyingDto.BuyingList();
    }

    @ApiOperation("Alış ekleme")
    @PostMapping("/add/{product_id}")
    public Map<String, Object> add(@RequestBody @Valid Buying buying, BindingResult bResult, @PathVariable String product_id ){

        return buyingDto.Buyingadd(buying,product_id,bResult);
    }
    @ApiOperation("Tedarikçi Listesi")
    @GetMapping("/vendorlist")
    public Map<String ,Object> vendorlist(){
        return buyingDto.VendorList();
    }

    @ApiOperation("Tedarikçilerin ürünleri")
    @GetMapping("/vendorProductlist/{vid}")
    public Map<String ,Object> vendorProductlist(@PathVariable String vid){
        return buyingDto.VendorProductList(vid);
    }
}
