package com.works.restcontrollers;

import com.works.dto.VaccineDto;
import com.works.entities.*;
import com.works.utils.Util;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/vaccine")
@Api(value ="VaccineRestController",authorizations ={@Authorization(value = "basicAuth")})
public class VaccineRestController {

    final VaccineDto vaccineDto;
    final Util util;

    public VaccineRestController(VaccineDto vaccineDto, Util util) {
        this.vaccineDto = vaccineDto;
        this.util = util;
    }

    //pet vaccine
    @ApiOperation("Pet aşı ekleme")
    @PostMapping("/addPetVaccine")
    public Map<String,Object> addPetVaccine(@RequestBody @Valid PetVaccine petVaccine, BindingResult bindingResult){
        return vaccineDto.petVaccineAdd(petVaccine,bindingResult);
    }
    @ApiOperation("Pet aşı listesi")
    @GetMapping("/listPetVaccine")
    public Map<String,Object> listPetvaccine(){
        return vaccineDto.petVaccineList();
    }

    @ApiOperation("Pet aşı silme")
    @DeleteMapping("/deletePetVaccine/{strIndex}")
    public Map<String,Object> deletePetVaccine(@PathVariable String strIndex){
        return vaccineDto.petVaccineDelete(strIndex);
    }
    @ApiOperation("Pet aşı stok ekleme")
    @PostMapping("/addPetStock")
    public Map<String,Object> addPetStock(@RequestBody @Valid PetStock petStock, BindingResult bindingResult){
        return vaccineDto.petstockAdd(petStock,bindingResult);
    }

    @ApiOperation("Pet aşı stok silme")
    @DeleteMapping("/deletePetStock/{strIndex}")
    public Map<String,Object> deletePetStock(@PathVariable String strIndex){
        return vaccineDto.petstockDelete(strIndex);
    }
    @ApiOperation("Depoya göre pet aşı stok listesi")
    @GetMapping("/listDepoPetStock/{depo_id}")
    public Map<String,Object> listDepoPetStock(@PathVariable String depo_id){
        return vaccineDto.DepoPetStockList(depo_id);
    }

    @ApiOperation("Pet aşı stok güncelleme")
    @PutMapping("/updatePetStock")
    public Map<String, Object> updatePetStock(@RequestBody @Valid PetStock petStock,BindingResult bindingResult) {
        return vaccineDto.petstockUpdate(petStock,bindingResult);
    }

    //farm vaccine
    @ApiOperation("Çiftlik aşı ekleme")
    @PostMapping("/addFarmVaccine")
    public Map<String,Object> addFarmVaccine(@RequestBody @Valid FarmVaccine farmVaccine, BindingResult bindingResult){
        return vaccineDto.farmvaccineAdd(farmVaccine,bindingResult);
    }

    @ApiOperation("Çİftlik aşı listeleme")
    @GetMapping("/listFarmVaccine")
    public Map<String,Object> listFarmvaccine(){
        return vaccineDto.farmvaccineList();
    }

    @ApiOperation("Çiftlik aşı silme")
    @DeleteMapping("/deleteFarmVaccine/{strIndex}")
    public Map<String,Object> deleteFarmVaccine(@PathVariable String strIndex){
        return vaccineDto.farmvaccineDelete(strIndex);
    }

    @ApiOperation("Çiftlik aşı stok ekleme")
    @PostMapping("/addFarmStock")
    public Map<String,Object> addFarmStock(@RequestBody @Valid FarmStock farmStock, BindingResult bindingResult){
        return vaccineDto.farmstockAdd(farmStock,bindingResult);
    }

    @ApiOperation("Çİftlik aşı stok silme")
    @DeleteMapping("/deleteFarmStock/{strIndex}")
    public Map<String,Object> deleteFarmStock(@PathVariable String strIndex){
        return vaccineDto.farmstockDelete(strIndex);
    }

    @ApiOperation("Depoya göre çiftlik aşı stok listesi")
    @GetMapping("/listDepoFarmStock/{depo_id}")
    public Map<String,Object> listDepoFarmStock(@PathVariable String depo_id){
        return vaccineDto.DepofarmStockList(depo_id);
    }

    @ApiOperation("Çiftlik aşı stok güncelleme")
    @PutMapping("/updateFarmStock")
    public Map<String, Object> updateFarmStock(@RequestBody @Valid FarmStock farmStock,BindingResult bindingResult) {
        return vaccineDto.farmstockUpdate(farmStock,bindingResult);
    }





}
