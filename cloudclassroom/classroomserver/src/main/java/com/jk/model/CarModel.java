package com.jk.model;

import lombok.Data;

/**
 * 积极思考造成积极人生，消极思考造成消极人生
 *
 * @author 赵苑辰
 * @title: CarModel
 * @date 2019/6/13  17:44
 */
@Data
public class CarModel {
    /**
     * 汽车管理model
     */
   private Integer id;
   private String carNumber;
   private Integer carXing;
   private String carXiangTi;
   private String carDangType;
   private Integer carZuoWei;
   private Integer carMenDianId;
   private Integer carPrice;
   private Integer carType;
   private String carlogo;
   private String carpailiang;

   /**
    * 所在门店 model
    */
   private String menDianName;
   private Integer cityId;
   private String address;
   private String phone;
   private String workDate;
   /**
    * 城市model
    */
   private String name;
   private Integer pid;

   /**
    * 汽车类型 model
    */
   private String carXingName;

   /**
    * 送车点model
    */
   private String sendCarName;
   private String sendCarAddress;
   private Integer mendianId;

   /**
    * 还车点model
    */
   private String returnCarName;
   private String returnCarAddress;

}
