package com.works.dto;

import com.works.utils.Util;
import com.works.entities.Buying;
import com.works.entities.ProductJoinVendor;
import com.works.model.Vendor;
import com.works.entities.VendorProductStock;
import com.works.repositories.BuyingRepository;
import com.works.repositories.ProductRepository;
import com.works.repositories.VendorRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class BuyingDto {

    final BuyingRepository bRepo;
    final ProductRepository pRepo;
    final VendorRepository vRepo;
    final Util util;

    public BuyingDto(BuyingRepository bRepo, ProductRepository pRepo, VendorRepository vRepo, Util util) {
        this.bRepo = bRepo;
        this.pRepo = pRepo;
        this.vRepo = vRepo;
        this.util = util;
    }

    //Alış Ekleme
    public Map<String, Object> Buyingadd (Buying buying, String product_id, BindingResult bResult) {
        Map<String , Object> hm = new LinkedHashMap<>();
        if(!bResult.hasErrors()){
            try {
                int cuid = Integer.parseInt(product_id);
                List<VendorProductStock> total = pRepo.vendorJoinProductJoinStock(cuid);
                total.forEach(item->{
                    buying.setTotal(item.getTotal());
                });
                Buying agendaDb = bRepo.save(buying);

                hm.put("status", true);
                hm.put("message", "Ekleme başarılı");
                hm.put("result", agendaDb);

            } catch (Exception e) {
                hm.put("status", false);
            }

        }else{
            hm.put("status",false);
            hm.put("errors", util.errors(bResult));
        }

        return hm;
    }


    //Alış Listeleme
    public Map<String,Object> BuyingList(){
        Map<String,Object> hm = new LinkedHashMap<>();
        hm.put("status",true);
        List<Buying> ls = bRepo.findAll();
        hm.put("result",ls);
        return hm;
    }

    //select içindeki tedarikçileri listeleme
    public Map<String,Object> VendorList(){
        Map<String,Object> hm = new LinkedHashMap<>();
        hm.put("status",true);
        List<Vendor> ls = vRepo.findAll();
        hm.put("result",ls);
        return hm;
    }

    //select içindeki tedarikçilerin ürünlerini listeleme
    public Map<String,Object> VendorProductList(String vid){
        Map<String,Object> hm = new LinkedHashMap<>();
        int cuid = Integer.parseInt(vid);
        hm.put("status",true);
        List<ProductJoinVendor> ls = pRepo.productJoinVendor(cuid);
        hm.put("result",ls);
        return hm;
    }



}
