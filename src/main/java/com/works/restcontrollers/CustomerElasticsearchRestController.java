package com.works.restcontrollers;

import com.works.dto.CustomerElasticSearchDto;
import com.works.model.CustomerDoc;
import io.swagger.annotations.Api;
import io.swagger.annotations.Authorization;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@Api(value ="CustomerElasticsearchRestController",authorizations ={@Authorization(value = "basicAuth")})
public class  CustomerElasticsearchRestController {


    final CustomerElasticSearchDto cdDto;

    public CustomerElasticsearchRestController(CustomerElasticSearchDto cdDto) {
        this.cdDto = cdDto;
    }

    @PostMapping("/add")
    public Map<String, Object> add(@RequestBody CustomerDoc cd){
        return cdDto.add(cd);
    }

    @GetMapping("/list")
    public Map<String, Object> list(){
        return cdDto.list();
    }


    @DeleteMapping("/delete/{strIndex}")
    public Map<String, Object> delete(@PathVariable String strIndex){
        return cdDto.delete(strIndex);
    }


    @GetMapping("/search/{data}")
    public Map<String, Object> search(@PathVariable String data){
        return cdDto.search(data);
    }





}



