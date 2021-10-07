package com.works.restcontrollers;


import com.works.utils.Util;
import com.works.dto.AgendaDto;
import com.works.entities.Agenda;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/agenda")
@Api(value ="AgendaRestController",authorizations ={@Authorization(value = "basicAuth")})
public class AgendaRestController {

    final AgendaDto agendaDto;
    final Util util;

    public AgendaRestController(AgendaDto agendaDto, Util util) {
        this.agendaDto = agendaDto;
        this.util = util;
    }
    @ApiOperation("Ajanda ekleme")
    @PostMapping("/add")
    public Map<String, Object> add(@RequestBody @Valid Agenda agenda, BindingResult bResult){
        return agendaDto.Agendaadd(agenda,bResult);
    }
    @ApiOperation("Ajanda Listesi")
    @GetMapping("/list")
    public Map<String ,Object> list(){
        return agendaDto.Agendalist();
    }

    @ApiOperation("Ajanda Sil")
    @DeleteMapping("/delete/{strIndex}")
    public Map<String, Object> delete(@PathVariable String strIndex){
        return agendaDto.Agendadelete(strIndex);
    }
}
