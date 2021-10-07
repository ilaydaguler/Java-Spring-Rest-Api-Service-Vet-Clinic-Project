package com.works.restcontrollers;

import com.works.dto.DepoDto;
import com.works.entities.Depo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/depo")
@Api(value ="DepoRestController",authorizations ={@Authorization(value = "basicAuth")})
public class DepoRestController {
    final DepoDto depoDto;

    public DepoRestController(DepoDto depoDto) {
        this.depoDto = depoDto;
    }
    @ApiOperation("Depo ekleme")
    @PostMapping("/add")
    public Map<String,Object> add(@RequestBody @Valid Depo depo, BindingResult bindingResult){
        return depoDto.DepoAdd(depo,bindingResult);
    }
    @ApiOperation("Depo listesi")
    @GetMapping("/list")
    public Map<String,Object> list(){
        return depoDto.list();
    }

    @ApiOperation("Depo silme")
    @DeleteMapping("/delete/{strIndex}")
    public Map<String,Object> delete(@PathVariable String strIndex){
        return depoDto.depoDelete(strIndex);
    }
}
