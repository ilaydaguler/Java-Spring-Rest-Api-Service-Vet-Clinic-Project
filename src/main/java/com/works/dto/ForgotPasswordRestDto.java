package com.works.dto;

import com.works.entities.ChangePassword;

import com.works.entities.User;

import com.works.repositories.UserRepository;
import com.works.services.UserService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;


@Service
public class ForgotPasswordRestDto {

    final UserRepository userRepository;
    final UserService userService;


    public ForgotPasswordRestDto(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;

    }

    public Map<Object, Object> forgotpassword(ChangePassword changePasswordInterlayer,String us_mail){
        Map<Object, Object> hm = new LinkedHashMap<>();
        Optional<User> optUser = userRepository.findByEmailEqualsAllIgnoreCase(us_mail);
        if (optUser.isPresent()) {
            if (changePasswordInterlayer.getNewpassword().equals(changePasswordInterlayer.getNewpassword_confirm())) {
                optUser.get().setPassword(userService.encoder().encode(changePasswordInterlayer.getNewpassword()));
                userRepository.saveAndFlush(optUser.get());
                hm.put("status", true);
                hm.put("result",optUser.get().getPassword());
            } else {
                hm.put("status", false);

            }
        }else{
            hm.put("status", false);
            hm.put("message", "Mail bulunamadı.");
        }
        return hm;
    }
}


