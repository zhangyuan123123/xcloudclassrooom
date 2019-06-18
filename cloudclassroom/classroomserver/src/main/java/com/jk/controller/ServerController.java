package com.jk.controller;

import com.jk.model.CarModel;
import com.jk.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 积极思考造成积极人生，消极思考造成消极人生
 *
 * @author 赵苑辰
 * @title: ServerController
 * @date 2019/6/12  16:38
 */
@Controller
@RequestMapping("server")
public class ServerController {
    @Autowired
    private ServerService serverService;

    /**
     * 测试
     * @return
     */
    @RequestMapping("test")
    @ResponseBody
    public String getTest(){
        return "success!!!!!!!!!!!!!!";
    }

    //车辆查询 findCarGuanli
    @RequestMapping("findCarGuanli")
    @ResponseBody
    public HashMap<String,Object> findCarGuanli(Integer page ,Integer limit){
        return serverService.findCarGuanli(page,limit);
    }

    //车辆停用 updategetstop
    @RequestMapping("updategetstop")
    @ResponseBody
    public String updategetstop(Integer id){
        return serverService.updategetstop(id);
    }

    //车辆信息查询 findOne
    @RequestMapping("findCarById")
    @ResponseBody
    public CarModel findOne(Integer id){
        CarModel carModel= serverService.findCarById(id);
        return carModel;
    }
    //门店查询 findmendian
    @RequestMapping("findmendian")
    @ResponseBody
    public List<CarModel> findmendian(){
        List<CarModel> list= serverService.findmendian();
        return list;
    }
    //修改car updatecar
    @RequestMapping("updatecar")
    @ResponseBody
    public String updatecar(@RequestBody CarModel carModel){
        serverService.updatecar(carModel);
        return null;
    }

    //updateZuCount 当前车的租车辆+1
    @RequestMapping("updateZuCount")
    @ResponseBody
    public String updateZuCount(Integer carId , Integer status){
        serverService.updateZuCount(carId,status);
        return "1";
    }
    //门店查询 findmendianmap
    @RequestMapping("findmendianmap")
    @ResponseBody
    public HashMap<String,Object> findmendianmap(Integer page ,Integer limit){
        return serverService.findmendianmap(page,limit);
    }
    //deleteMenDianById 门店删除
    @RequestMapping("deleteMenDianById")
    @ResponseBody
    public String deleteMenDianById(Integer id){
        serverService.deleteMenDianById(id);
        return "1";
    }

    //送车点管理 findSendCarAddress
    @RequestMapping("findSendCarAddress")
    @ResponseBody
    public HashMap<String,Object> findSendCarAddress(Integer page ,Integer limit){
        return serverService.findSendCarAddress(page,limit);
    }
    //删除送车点   deleteSendCarAddress
    @RequestMapping("deleteSendCarAddress")
    @ResponseBody
    public String deleteSendCarAddress(Integer id){
        serverService.deleteSendCarAddress(id);
        return "1";
    }

    //城市回显  findCityAll
    @RequestMapping("findCityAll")
    @ResponseBody
    public List<CarModel> findCityAll(){
        List<CarModel> list= serverService.findCityAll();
        return list;
    }
    //市回显 findShiAll
    @RequestMapping("findShiAll")
    @ResponseBody
    public List<CarModel> findShiAll(Integer selectCityId){
        List<CarModel> list= serverService.findShiAll(selectCityId);
        return list;
    }
    //送车点新增  addSendCar
    @RequestMapping("addSendCar")
    @ResponseBody
    public String addSendCar(@RequestBody  CarModel carModel){
        serverService.addSendCar(carModel);
        return null;
    }
    //还车点管理  查询 findReturnCarAddress
    @RequestMapping("findReturnCarAddress")
    @ResponseBody
    public HashMap<String,Object> findReturnCarAddress(Integer page ,Integer limit){
        return serverService.findReturnCarAddress(page,limit);
    }
    //删除还车点 deleteReturnCarAddress
    @RequestMapping("deleteReturnCarAddress")
    @ResponseBody
    public String deleteReturnCarAddress(Integer id){
        serverService.deleteReturnCarAddress(id);
        return "1";
    }
    //还车点新增  addReturnCar
    @RequestMapping("addReturnCar")
    @ResponseBody
    public String addReturnCar(@RequestBody  CarModel carModel){
        serverService.addReturnCar(carModel);
        return "1";
    }
    //还车审核  findReturnCar
    @RequestMapping("findReturnCar")
    @ResponseBody
    public HashMap<String,Object> findReturnCar(Integer page ,Integer limit){
        return serverService.findReturnCar(page,limit);
    }

    //审核成功  updateReturnCarShenHe
    @RequestMapping("updateReturnCarShenHe")
    @ResponseBody
    public String updateReturnCarShenHe(Integer goodId){
        serverService.updateReturnCarShenHe(goodId);
        return "1";
    }






}
