package com.works.restcontrollers;

import com.works.dto.NewCaseDto;
import com.works.entities.NewCase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/case")
@Api(value ="CaseRestController",authorizations ={@Authorization(value = "basicAuth")})
public class CaseRestController {
    final NewCaseDto caseDto;

    public CaseRestController(NewCaseDto caseDto) {
        this.caseDto = caseDto;
    }

    @ApiOperation("Kasa ekleme")
    @PostMapping("/add")
    public Map<String,Object> add(@RequestBody @Valid NewCase newCase, BindingResult bindingResult){
        return caseDto.caseAdd(newCase, bindingResult);
    }
    @ApiOperation("Kasa Listesi")
    @GetMapping("/list")
    public Map<String,Object> list(){
        return caseDto.list();
    }

    @ApiOperation("Kasa silme")
    @DeleteMapping("/delete/{strIndex}")
    public Map<String,Object> delete(@PathVariable String strIndex){
        return caseDto.caseDelete(strIndex);
    }
}