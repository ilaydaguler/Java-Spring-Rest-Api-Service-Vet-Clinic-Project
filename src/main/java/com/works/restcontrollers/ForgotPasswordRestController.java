package com.works.restcontrollers;
import com.works.dto.ForgotPasswordRestDto;
import com.works.entities.ChangePassword;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("password")
@Api(value ="ForgotPasswordRestController",authorizations ={@Authorization(value = "basicAuth")})
public class ForgotPasswordRestController {
    final ForgotPasswordRestDto forgotPasswordRestDto;

    public ForgotPasswordRestController(ForgotPasswordRestDto forgotPasswordRestDto) {
        this.forgotPasswordRestDto = forgotPasswordRestDto;
    }

    @ApiOperation("Şifre Değiştirme")
    @PutMapping("/change/{us_mail}")
    public Map<Object, Object> add(@RequestBody ChangePassword changePassword, @PathVariable String us_mail){
        return forgotPasswordRestDto.forgotpassword(changePassword,us_mail);
    }
}