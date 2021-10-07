package com.works.restcontrollers;

import com.works.dto.CustomerDto;
import com.works.entities.Customer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/customer")
@Api(value ="CustomerRestController",authorizations ={@Authorization(value = "basicAuth")})
public class CustomerRestController {
    final CustomerDto cDto;

    public CustomerRestController(CustomerDto cDto) {
        this.cDto = cDto;
    }
    @ApiOperation("Müşteri ekleme")
    @PostMapping("/add")
    public Map<String,Object> add(@RequestBody @Valid Customer customer, BindingResult bindingResult){
        return cDto.add(customer,bindingResult) ;
    }

    @ApiOperation("Müşteri Listesi")
    @GetMapping("/list/{pageNumber}")
    public Map<String,Object> list(@PathVariable String pageNumber){
        return cDto.list(pageNumber);
    }

    @ApiOperation("Müşteri silme")
    @DeleteMapping("/delete/{cid}")
    public Map<String, Object> delete( @PathVariable String cid ) {
        return cDto.delete(cid);
    }


}
