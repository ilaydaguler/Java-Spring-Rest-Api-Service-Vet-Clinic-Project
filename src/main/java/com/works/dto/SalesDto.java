package com.works.dto;

import com.works.utils.Util;
import com.works.entities.*;
import com.works.repositories.*;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class SalesDto {

    final ProductRepository pRepo;
    final BoxRepository bRepo;
    final RetailSaleRepository rRepo;
    final BoxCustomerRepository bcRepo;
    final CustomerPaySaleRepository cpRepo;
    final CustomerRepository cRepo;
    final Util util;

    public SalesDto(ProductRepository pRepo, BoxRepository bRepo, RetailSaleRepository rRepo, BoxCustomerRepository bcRepo, CustomerPaySaleRepository cpRepo, CustomerRepository cRepo, Util util) {
        this.pRepo = pRepo;
        this.bRepo = bRepo;
        this.rRepo = rRepo;
        this.bcRepo = bcRepo;
        this.cpRepo = cpRepo;
        this.cRepo = cRepo;
        this.util = util;
    }

    //Ürünlerin Listesi
    public Map<String,Object> productList(){
        Map<String,Object> hm = new LinkedHashMap<>();
        hm.put("status",true);
        List<Product> ls = pRepo.findAll();
        hm.put("result",ls);
        return hm;
    }
    //Müşteri(Customer) Listesi
    public Map<String,Object> customerList(){
        Map<String,Object> hm = new LinkedHashMap<>();
        hm.put("status",true);
        List<Customer> ls = cRepo.findAll();
        hm.put("result",ls);
        return hm;
    }



    //Sepete ürün ekleme
    public Map<String, Object> boxAdd(Box box, BindingResult bResult) {
        Map<String , Object> hm = new LinkedHashMap<>();
        if(!bResult.hasErrors()){
            try {
                Box box1 = bRepo.save(box);
                hm.put("status", true);
                hm.put("message", "Ekleme başarılı");
                hm.put("result", box1);
            } catch (Exception e) {
                hm.put("status", false);
            }

        }else{
            hm.put("status",false);
            hm.put("errors", util.errors(bResult));
        }
        return hm;
    }

    //totali ve ürünü getirme ödeme kısmına ekleme
    public Map<String, Object> RetailSaleadd (RetailSale retailSale, String box_id, String sales_product_amount, BindingResult bResult) {
        Map<String , Object> hm = new LinkedHashMap<>();
        if(!bResult.hasErrors()){
            try {
                int cuid = Integer.parseInt(box_id);
                int sp = Integer.parseInt(sales_product_amount);
                List<ProductJoinBox> saleTotal = bRepo.productJoinBox(cuid,sp);
                saleTotal.forEach(item->{
                    retailSale.setSaletotal(item.getTotal());
                    retailSale.setProduct_name(item.getProduct_Name());
                    System.out.println(item.getTotal());
                    System.out.println(item.getProduct_Name());
                });
                RetailSale retailSale1 = rRepo.save(retailSale);

                hm.put("status", true);
                hm.put("message", "Ekleme başarılı");
                hm.put("result", retailSale1);

            } catch (Exception e) {
                hm.put("status", false);
            }

        }else{
            hm.put("status",false);
            hm.put("errors", util.errors(bResult));
        }

        return hm;
    }


    //Kayıtlı Müşteri Listeleme
    public Map<String,Object> customerPaylist(){
        Map<String,Object> hm = new LinkedHashMap<>();
        hm.put("status",true);
        List<CustomerPaySale> ls = cpRepo.findAll();
        hm.put("result",ls);
        return hm;
    }

    //Kayıtlı Müşteri sepete ekleme (box_customer)
    public Map<String, Object> boxCustomerAdd(BoxCustomer boxCustomer, BindingResult bResult) {
        Map<String , Object> hm = new LinkedHashMap<>();
        if(!bResult.hasErrors()){
            try {
                BoxCustomer boxc1 = bcRepo.save(boxCustomer);
                hm.put("status", true);
                hm.put("message", "Ekleme başarılı");
                hm.put("result", boxc1);
            } catch (Exception e) {
                hm.put("status", false);
            }

        }else{
            hm.put("status",false);
            hm.put("errors", util.errors(bResult));
        }
        return hm;
    }

    //Kayıtlı Müşteri Ödeme kısmı hesaplanıp eklenilmesi
    public Map<String, Object> CustomerPaySaleadd (CustomerPaySale customerPaySale, String pid, String sale_amount, String cid) {
        Map<String , Object> hm = new LinkedHashMap<>();

        try {
            int cuid = Integer.parseInt(pid);
            int cus_id = Integer.parseInt(cid);
            int sp = Integer.parseInt(sale_amount);
            List<ProductBoxCustomer>  customerSaleTotal = bcRepo.productJoinBoxCustomer(cuid,sp,cus_id);
            customerSaleTotal.forEach(item->{
                customerPaySale.setC_name(item.getCName());
                customerPaySale.setSaleBoxtotal(item.getTotal());
                System.out.println(item.getCName());
                System.out.println(item.getTotal());

            });
            CustomerPaySale customerPaySale1 = cpRepo.save(customerPaySale);

            hm.put("status", true);
            hm.put("message", "Ekleme başarılı");
            hm.put("result", customerPaySale1);

        } catch (Exception e) {
            hm.put("status", false);
        }


        return hm;
    }




}
