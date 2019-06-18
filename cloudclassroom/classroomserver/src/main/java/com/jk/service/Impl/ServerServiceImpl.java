package com.jk.service.Impl;

import com.jk.mapper.ServerMapper;
import com.jk.model.CarModel;
import com.jk.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 积极思考造成积极人生，消极思考造成消极人生
 *
 * @author 赵苑辰
 * @title: ServerServiceImpl
 * @date 2019/6/13  17:39
 */
@Service
public class ServerServiceImpl implements ServerService {
    @Autowired
    private ServerMapper serverMapper;


    @Override
    public HashMap<String, Object> findCarGuanli(Integer page ,Integer limit) {
        HashMap<String, Object> hashMap = new HashMap<>();
        Integer count = serverMapper.getSumSizeCar();
        List<CarModel> list = serverMapper.findCarGuanli((page-1)*limit,limit);
        hashMap.put("count",count);
        hashMap.put("data",list);
        hashMap.put("code",0);
        hashMap.put("msg","");
        return hashMap;
    }

    @Override
    public String updategetstop(Integer id) {
        if(id!=null){
            serverMapper.updategetstop(id);
        }
        return "1";
    }

    @Override
    public CarModel findCarById(Integer id) {

        return serverMapper.findCarById(id);
    }

    @Override
    public List<CarModel> findmendian() {
        return serverMapper.findmendian();
    }

    @Override
    public void updatecar(CarModel carModel) {
        serverMapper.updatecar(carModel);
    }

    @Override
    public void updateZuCount(Integer carId, Integer status) {
        if (status==1){
            serverMapper.updateZuCount(carId);
        }

    }

    @Override
    public HashMap<String, Object> findmendianmap(Integer page, Integer limit) {
        HashMap<String, Object> hashMap = new HashMap<>();
        Integer count = serverMapper.getSumSizemendian();
        List<CarModel> list = serverMapper.findmendianmap((page-1)*limit,limit);
        hashMap.put("count",count);
        hashMap.put("data",list);
        hashMap.put("code",0);
        hashMap.put("msg","");
        return hashMap;

    }

    @Override
    public void deleteMenDianById(Integer id) {
        serverMapper.deleteMenDianById(id);
    }

    @Override
    public HashMap<String, Object> findSendCarAddress(Integer page, Integer limit) {
        HashMap<String, Object> hashMap = new HashMap<>();
        Integer count = serverMapper.getSumSizeSendCar();
        List<CarModel> list = serverMapper.findSendCarAddress((page-1)*limit,limit);
        hashMap.put("count",count);
        hashMap.put("data",list);
        hashMap.put("code",0);
        hashMap.put("msg","");
        return hashMap;
    }

    @Override
    public void deleteSendCarAddress(Integer id) {
        serverMapper.deleteSendCarAddress(id);
    }

    @Override
    public List<CarModel> findCityAll() {
        return serverMapper.findCityAll();
    }

    @Override
    public List<CarModel> findShiAll(Integer selectCityId) {
        return serverMapper.findShiAll(selectCityId);
    }

    @Override
    public void addSendCar(CarModel carModel) {
        serverMapper.addSendCar(carModel);
    }

    @Override
    public HashMap<String, Object> findReturnCarAddress(Integer page, Integer limit) {
        HashMap<String, Object> hashMap = new HashMap<>();
        Integer count = serverMapper.getSumSizeReturnCar();
        List<CarModel> list = serverMapper.findReturnCarAddress((page-1)*limit,limit);
        hashMap.put("count",count);
        hashMap.put("data",list);
        hashMap.put("code",0);
        hashMap.put("msg","");
        return hashMap;
    }

    @Override
    public void deleteReturnCarAddress(Integer id) {
        serverMapper.deleteReturnCarAddress(id);
    }

    @Override
    public void addReturnCar(CarModel carModel) {
        serverMapper.addReturnCar(carModel);
    }

    @Override
    public HashMap<String, Object> findReturnCar(Integer page, Integer limit) {
        HashMap<String, Object> hashMap = new HashMap<>();
        Integer count = serverMapper.getSumSizefindReturnCar();
        List<LinkedHashMap<String,Object>> list = serverMapper.findReturnCar((page-1)*limit,limit);
        hashMap.put("count",count);
        hashMap.put("data",list);
        hashMap.put("code",0);
        hashMap.put("msg","");
        return hashMap;
    }

    @Override
    public void updateReturnCarShenHe(Integer goodId) {
        serverMapper.updateReturnCarShenHe(goodId);
    }


}
