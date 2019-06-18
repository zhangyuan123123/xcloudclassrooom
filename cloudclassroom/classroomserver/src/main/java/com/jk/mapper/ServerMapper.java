package com.jk.mapper;

import com.jk.model.CarModel;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * 积极思考造成积极人生，消极思考造成消极人生
 *
 * @author 赵苑辰
 * @title: ServerMapper
 * @date 2019/6/13  17:40
 */
public interface ServerMapper {

    @Select("select count(1) from t_carguanli")
    Integer getSumSizeCar();

    List<CarModel> findCarGuanli(@Param("page") Integer page,@Param("limit") Integer limit);

    @Update("update t_carguanli set carType=2 where id = #{id}")
    void updategetstop(@Param("id") Integer id);

    @Select("select * from t_carguanli c left JOIN t_mendian m on  c.carMenDianId=m.id where c.id=#{id}")
    CarModel findCarById(@Param("id") Integer id);

    List<CarModel> findmendian();
    @Update("update t_carguanli set carNumber=#{carNumber},carXing=#{carXing},carDangType=#{carDangType},carZuoWei=#{carZuoWei},carMenDianId=#{carMenDianId},carPrice=#{carPrice},carlogo=#{carlogo},carpailiang=#{carpailiang} where id=#{id}")
    void updatecar(CarModel carModel);

    @Update("update t_carguanli set carzucount = carzucount+1 where id = #{carId}")
    void updateZuCount(@Param("carId") Integer carId);

    @Select("select count(1) from t_mendian")
    Integer getSumSizemendian();

    List<CarModel> findmendianmap(@Param("page") Integer page,@Param("limit") Integer limit);

    @Delete("delete from t_mendian where id = #{id}")
    void deleteMenDianById(@Param("id") Integer id);

    @Select("select count(1) from t_sendCarAddress ")
    Integer getSumSizeSendCar();

    List<CarModel> findSendCarAddress(@Param("page") Integer page,@Param("limit") Integer limit);

    @Delete("delete from t_sendCarAddress where id = #{id}")
    void deleteSendCarAddress(Integer id);

    @Select("select * from t_area where pid = 0 and id <>0")
    List<CarModel> findCityAll();

    @Select("select * from t_area where pid = #{selectCityId} ")
    List<CarModel> findShiAll(@Param("selectCityId") Integer selectCityId);

    void addSendCar(@Param("c") CarModel carModel);

    @Select("select count(1) from t_returnCarAddress ")
    Integer getSumSizeReturnCar();

    List<CarModel> findReturnCarAddress(@Param("page") Integer page,@Param("limit") Integer limit);

    @Delete("delete from t_returnCarAddress where id = #{id}")
    void deleteReturnCarAddress(@Param("id") Integer id);

    void addReturnCar(@Param("c") CarModel carModel);

    @Select("select count(1) from ordergoods where returnCarStatus = 0 ")
    Integer getSumSizefindReturnCar();

    List<LinkedHashMap<String, Object>> findReturnCar(@Param("page") Integer page,@Param("limit") Integer limit);

    @Update("update ordergoods set zhuangtai = 2 where goodId = #{goodId}")
    void updateReturnCarShenHe(@Param("goodId") Integer goodId);
}
