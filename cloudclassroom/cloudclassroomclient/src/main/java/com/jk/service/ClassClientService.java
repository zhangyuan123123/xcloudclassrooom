package com.jk.service;

import com.jk.model.CarModel;
import com.jk.model.CouponModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;



@FeignClient("servernamezyc")

public interface ClassClientService {
    @RequestMapping("server/test")
    String getTest();

    @RequestMapping("server/findCarGuanli")
    HashMap<String, Object> findCarGuanli(@RequestParam("page") Integer page,@RequestParam("limit") Integer limit);

    @RequestMapping("server/updategetstop")
    String updategetstop(@RequestParam("id") Integer id);

    @RequestMapping("server/findCarById")
    CarModel findCarById(@RequestParam("id") Integer id);

    @RequestMapping("server/findmendian")
    List<CarModel> findmendian();

    @RequestMapping("server/updatecar")
    void updatecar(@RequestBody CarModel carModel);

    @RequestMapping("server/updateZuCount")
    void updateZuCount(@RequestParam("carId") Integer carId,@RequestParam("status") Integer status);

    @RequestMapping("server/findmendianmap")
    HashMap<String, Object> findmendianmap(@RequestParam("page") Integer page,@RequestParam("limit") Integer limit);

    @RequestMapping("server/deleteMenDianById")
    void deleteMenDianById(@RequestParam("id") Integer id);

    @RequestMapping("server/findSendCarAddress")
    HashMap<String, Object> findSendCarAddress(@RequestParam("page") Integer page,@RequestParam("limit") Integer limit);

    @RequestMapping("server/deleteSendCarAddress")
    void deleteSendCarAddress(@RequestParam("id") Integer id);

    @RequestMapping("server/findCityAll")
    List<CarModel> findCityAll();

    @RequestMapping("server/findShiAll")
    List<CarModel> findShiAll(@RequestParam("selectCityId") Integer selectCityId);

    @RequestMapping("server/addSendCar")
    void addSendCar(@RequestBody CarModel carModel);

    @RequestMapping("server/findReturnCarAddress")
    HashMap<String, Object> findReturnCarAddress(@RequestParam("page") Integer page,@RequestParam("limit") Integer limit);

    @RequestMapping("server/deleteReturnCarAddress")
    void deleteReturnCarAddress(@RequestParam("id") Integer id);

    @RequestMapping("server/addReturnCar")
    void addReturnCar(@RequestBody CarModel carModel);

    @RequestMapping("server/findReturnCar")
    HashMap<String, Object> findReturnCar(@RequestParam("page") Integer page,@RequestParam("limit") Integer limit);

    @RequestMapping("server/updateReturnCarShenHe")
    void updateReturnCarShenHe(@RequestParam("goodId") Integer goodId);

}
