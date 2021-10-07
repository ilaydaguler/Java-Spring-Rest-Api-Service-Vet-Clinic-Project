package com.works.restcontrollers;

import com.works.dto.LaboratuvarDto;
import com.works.entities.LabInterlayer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@RestController
@RequestMapping("/laboratuvar")
@Api(value ="LaboratuvarRestController",authorizations ={@Authorization(value = "basicAuth")})
public class LaboratuvarRestController {
    final LaboratuvarDto lDto;


    public LaboratuvarRestController( LaboratuvarDto lDto) {
        this.lDto = lDto;

    }

    @ApiOperation("Laboratuvar sonuç ekleme")
    @PostMapping("/upload")
    public Map<String, Object> upload(@RequestParam("imageName") MultipartFile file, LabInterlayer laboratuvar) {
        return lDto.upload(file,laboratuvar);
    }
    @ApiOperation("Laboratuvar listesi")
    @GetMapping("/list")
    public Map<String,Object> labList(){
        return lDto.labList();
    }

    @ApiOperation("Laboratuvar sonuç silme")
    @DeleteMapping("/delete/{strlid}")
    public Map<String, Object> delete (@PathVariable String strlid) {
        return lDto.delete(strlid);
    }

}
