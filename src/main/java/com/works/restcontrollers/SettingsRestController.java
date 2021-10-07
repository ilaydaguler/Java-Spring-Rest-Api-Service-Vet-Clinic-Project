package com.works.restcontrollers;

import com.works.dto.SettingsDto;
import com.works.entities.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/settings")
@Api(value ="SettingsRestController",authorizations ={@Authorization(value = "basicAuth")})
public class SettingsRestController {

    final SettingsDto sDto;


    public SettingsRestController(SettingsDto sDto) {
        this.sDto = sDto;

    }

    @ApiOperation("Kullanıcı ekleme")
    @PostMapping("/add")
    public Map<String, Object> add(@RequestBody User user) {
        return sDto.add(user);
    }

    @ApiOperation("Kullanıcı listesi")
    @GetMapping("/list")
    public Map<String,Object> list(){
        return sDto.list();
    }

    @ApiOperation("Çıkış yap")
    @GetMapping("/logout")
    public Map<String ,Object> logout(){
        Map<String ,Object> hm=new LinkedHashMap<>();
        hm.put("status",true);
        return hm;
    }

    @ApiOperation("Kullanıcı silme")
    @DeleteMapping("/delete/{strIndex}")
    public Map<String, Object> delete(@PathVariable String strIndex){
        return sDto.UserDelete(strIndex);
    }




}

