package com.works.dto;

import com.works.entities.Customers;
import com.works.entities.ScheduleCalendar;
import com.works.entities.Stocks;
import com.works.repositories.*;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class DashboardDto {

    final ScheduleCalendarRepository sRepo;
    final CustomerRepository cRepo;
    final CustomerPaySaleRepository cpRepo;
    final RetailSaleRepository rRepo;
    final BuyingRepository bRepo;
    final StockRepository stRepo;


    public DashboardDto(ScheduleCalendarRepository sRepo, CustomerRepository cRepo, CustomerPaySaleRepository cpRepo, RetailSaleRepository rRepo, BuyingRepository bRepo, StockRepository stRepo) {
        this.sRepo = sRepo;
        this.cRepo = cRepo;
        this.cpRepo = cpRepo;
        this.rRepo = rRepo;
        this.bRepo = bRepo;
        this.stRepo = stRepo;
    }
    //Randevu listesi
    public Map<String,Object> CalendarList(){
        Map<String,Object> hm = new LinkedHashMap<>();
        hm.put("status",true);
        List<ScheduleCalendar> ls = sRepo.findAll();
        hm.put("result",ls);
        return hm;
    }

    //toplam müşteri
    public Map<String,Object> CustomerTotalList(){
        Map<String,Object> hm = new LinkedHashMap<>();
        hm.put("status",true);
        List<Customers> ls = cRepo.totalCustomer();
        hm.put("result",ls);
        return hm;
    }

    //toplam satış miktarı
    public Map<String,Object> totalSaleCount(){
        Map<String,Object> hm = new LinkedHashMap<>();
        hm.put("status",true);
        int total1 = cpRepo.countSale();
        int total2 = rRepo.countSale();
        int sum = total1 + total2;
        hm.put("result",sum);
        return hm;
    }

    //toplam Kazanım
    public Map<String,Object> total(){
        Map<String,Object> hm = new LinkedHashMap<>();
        hm.put("status",true);
        int customer_pay = cpRepo.customerSale();
        int retail_pay = rRepo.retailSale();
        int buying_pay = bRepo.customerBuying();
        int sum = (customer_pay+retail_pay)-buying_pay;
        hm.put("result",sum);
        return hm;
    }

    //toplam stok değeri
    public Map<String,Object> totalStockList(){
        Map<String,Object> hm = new LinkedHashMap<>();
        hm.put("status",true);
        List<Stocks> ls = stRepo.stocks();
        hm.put("result",ls);
        return hm;
    }

}
