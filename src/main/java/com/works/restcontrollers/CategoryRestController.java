package com.works.restcontrollers;


import com.works.dto.CategoryDto;
import com.works.entities.CategoryGroup;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/category")
@Api(value ="CategoryRestController",authorizations ={@Authorization(value = "basicAuth")})
public class CategoryRestController {
    final CategoryDto categoryDto;

    public CategoryRestController(CategoryDto categoryDto) {
        this.categoryDto = categoryDto;
    }

    @ApiOperation("Kategori ekleme")
    @PostMapping("/add")
    public Map<String,Object> add(@RequestBody @Valid CategoryGroup categoryGroup, BindingResult bindingResult){
        return categoryDto.categoryAdd(categoryGroup,bindingResult);
    }
    @ApiOperation("Kategori Listesi")
    @GetMapping("/list")
    public Map<String,Object> list(){
        return categoryDto.list();
    }

    @ApiOperation("Kategori Sil")
    @DeleteMapping("/delete/{strIndex}")
    public Map<String,Object> delete(@PathVariable String strIndex){
        return categoryDto.categoryDelete(strIndex);
    }
}
