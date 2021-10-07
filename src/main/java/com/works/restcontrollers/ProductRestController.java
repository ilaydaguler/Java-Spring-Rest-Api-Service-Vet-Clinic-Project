package com.works.restcontrollers;

import com.works.dto.ProductDto;
import com.works.entities.Product;
import com.works.entities.Stock;
import com.works.repositories.StockRepository;
import com.works.utils.Util;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/product")
@Api(value ="ProductRestController",authorizations ={@Authorization(value = "basicAuth")})
public class ProductRestController {

    final ProductDto productDto;
    final StockRepository sRepo;
    final Util util;

    public ProductRestController(ProductDto productDto, StockRepository sRepo, Util util) {
        this.productDto = productDto;
        this.sRepo = sRepo;
        this.util = util;
    }

    @ApiOperation("Ürün ekleme")
    @PostMapping("/addProduct")
    public Map<String,Object> addProduct(@RequestBody @Valid Product product, BindingResult bindingResult){
        return productDto.productAdd(product,bindingResult);
    }
    @ApiOperation("Ürün listesi")
    @GetMapping("/listProduct")
    public Map<String,Object> listProduct(){
        return productDto.productList();
    }

    @ApiOperation("Ürün silme")
    @DeleteMapping("/deleteProduct/{strIndex}")
    public Map<String,Object> deleteProduct(@PathVariable String strIndex){
        return productDto.productDelete(strIndex);
    }

    @ApiOperation("Stok ekleme")
    @PostMapping("/addStock")
    public Map<String,Object> addStock(@RequestBody @Valid Stock stock, BindingResult bindingResult){
        return productDto.stockAdd(stock,bindingResult);
    }

    @ApiOperation("Stok silme")
    @DeleteMapping("/deleteStock/{strIndex}")
    public Map<String,Object> deleteStock(@PathVariable String strIndex){
        return productDto.stockDelete(strIndex);
    }

    @ApiOperation("Depoya göre stok listeleme")
    @GetMapping("/listDepoStock/{depo_id}")
    public Map<String,Object> listDepoStock(@PathVariable String depo_id){
        return productDto.DepoStockList(depo_id);
    }

    @ApiOperation("Stok güncelleme")
    @PutMapping("/updateStock")
    public Map<String, Object> update(@RequestBody @Valid Stock stock,BindingResult bindingResult) {
        return productDto.stockUpdate(stock,bindingResult);
    }





}
