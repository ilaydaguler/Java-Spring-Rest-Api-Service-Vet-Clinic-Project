package com.works.restcontrollers;

import com.works.model.CitySession;
import com.works.redisrepositories.CitySessionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/redis")
public class CityRestController {

    final CitySessionRepository cRepo;

    public CityRestController(CitySessionRepository cRepo) {
        this.cRepo = cRepo;
    }


    @PostMapping("add")
    public Map<String, Object> add(@RequestBody CitySession citySession){
        Map<String , Object> hm = new LinkedHashMap<>();
        CitySession citySession1 =cRepo.save(citySession);
        hm.put("status", true);
        hm.put("result", citySession1);
        return hm;

    }

    @GetMapping("/list")
    public Map<String,Object> list(){
        Map<String,Object> hm = new LinkedHashMap<>();
        hm.put("status",true);
        Iterable<CitySession> ls = cRepo.findAll();
        hm.put("result",ls);
        return hm;
    }
}