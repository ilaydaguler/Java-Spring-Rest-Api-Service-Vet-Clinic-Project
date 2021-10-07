package com.works.dto;

import com.works.entities.User;
import com.works.entities.UserList;
import com.works.repositories.RoleRepository;
import com.works.repositories.UserRepository;
import com.works.services.UserService;
import org.springframework.stereotype.Service;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class SettingsDto {
    final UserService uService;
    final UserRepository uRepo;
    final RoleRepository rRepo;

    public SettingsDto(UserService uService, UserRepository uRepo, RoleRepository rRepo) {
        this.uService = uService;
        this.uRepo = uRepo;
        this.rRepo = rRepo;
    }

    public Map<String, Object> add(User user) {
        Map<String, Object> hm = new LinkedHashMap<>();
        hm.put("status", true);
        try {
            hm.put("user", uService.register(user));
            hm.put("message","Ekleme Başarılı!");
        }catch (Exception ex) {
            hm.put("user", null );
            hm.put("message","Ekleme sırasında hata oluştu!");
        }
        return hm;
    }

    public Map<String,Object> list(){
        Map<String,Object> hm = new LinkedHashMap<>();
        hm.put("status",true);
        List<UserList> ls = uRepo.userList();
        hm.put("result",ls);
        return hm;
    }

    public Map<String, Object> UserDelete (String strIndex){
        Map<String, Object> hm = new LinkedHashMap<>();
        int cuid = Integer.parseInt(strIndex);
        try{
            if(uRepo.existsById(cuid)){
                uRepo.deleteById(cuid);
                hm.put("status", true);
                hm.put("message", "silme başarılı");
                hm.put("result", cuid);
            }else{
                hm.put("status", false);
                hm.put("message", "Silme Başarısız. Girilen Id yanlış");
                hm.put("result", cuid);
            }
        }catch (Exception ex){
            hm.put("status", false);
            hm.put("message", "silme gerçekleşmedi");
            hm.put("result", cuid);
        }
        return hm;
    }
}

