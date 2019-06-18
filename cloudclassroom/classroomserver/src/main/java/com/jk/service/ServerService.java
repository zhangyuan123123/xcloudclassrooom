package com.jk.service;

import com.jk.model.CarModel;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 积极思考造成积极人生，消极思考造成消极人生
 *
 * @author 赵苑辰
 * @title: ServerService
 * @date 2019/6/13  17:38
 */
public interface ServerService {
    HashMap<String, Object> findCarGuanli(Integer page ,Integer limit);

    String updategetstop(Integer id);

    CarModel findCarById(Integer id);

    List<CarModel> findmendian();

    void updatecar(CarModel carModel);

    void updateZuCount(Integer carId, Integer status);

    HashMap<String, Object> findmendianmap(Integer page, Integer limit);

    void deleteMenDianById(Integer id);

    HashMap<String, Object> findSendCarAddress(Integer page, Integer limit);

    void deleteSendCarAddress(Integer id);

    List<CarModel> findCityAll();

    List<CarModel> findShiAll(Integer selectCityId);

    void addSendCar(CarModel carModel);

    HashMap<String, Object> findReturnCarAddress(Integer page, Integer limit);

    void deleteReturnCarAddress(Integer id);

    void addReturnCar(CarModel carModel);

    HashMap<String, Object> findReturnCar(Integer page, Integer limit);

    void updateReturnCarShenHe(Integer goodId);
}
