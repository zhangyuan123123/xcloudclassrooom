package com.jk.controller;

import com.jk.model.CouponModel;
import com.jk.model.CarModel;
import com.jk.service.ClassClientService;
import com.jk.util.OssFileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.HashMap;

import java.util.List;

@Controller
@RequestMapping("client")
public class ClassClientController {
    @Resource
    private ClassClientService classClientService;




    @RequestMapping("test")
    @ResponseBody
    public String getTest(){
        return classClientService.getTest();
    }

    //登录页面  toLogin
    @RequestMapping("toLogin")
    public String toLogin(){
        return "login";
    }

    //车辆管理页面
    @RequestMapping("tocarguanli")
    public String tocarguanli(){
        return "carguanli";
    }
    //门店管理页面
    @RequestMapping("tocarmendian")
    public String tocarmendian(){
        return "carmendian";
    }
    //送车点管理页面
    @RequestMapping("tosendCarAddress")
    public String tosendCarAddress(){
        return "sendCarAddress";
    }
    //还车点管理页面
    @RequestMapping("toreturnCarAddress")
    public String toreturnCarAddress(){
        return "returnCarAddress";
    }
    //还车审核
    @RequestMapping("toreturnCarShenHe")
    public String toreturnCarShenHe(){
        return "returnCarShenHe";
    }





    //车辆查询 findCarGuanli
    @RequestMapping("findCarGuanli")
    @ResponseBody
    public HashMap<String,Object> findCarGuanli(Integer page , Integer limit){
        return classClientService.findCarGuanli(page,limit);
    }
    //车辆停用 updategetstop
    @RequestMapping("updategetstop")
    @ResponseBody
    public String updategetstop(Integer id){
        return classClientService.updategetstop(id);
    }
   //车辆信息查询 findOne
    @RequestMapping("findCarById")
    public String findOne(Integer id, Model model){
        CarModel carModel= classClientService.findCarById(id);
        model.addAttribute("car",carModel);
        return "findCarById";
    }
    //车辆信息查询 findOne
    @RequestMapping("toupdateCarXinXi")
    public String toupdateCarXinXi(Integer id, Model model){
        CarModel carModel= classClientService.findCarById(id);
        model.addAttribute("car",carModel);
        return "updateCar";
    }
    //oss上传图片
    @RequestMapping("upload")
    @ResponseBody
    public HashMap<String,Object> upload(MultipartFile file , HttpServletRequest request, HttpServletResponse response){
        HashMap<String,Object> hashMap=new HashMap();
        HashMap<String,Object> hashMap1=new HashMap();
        String src="";
        try {
            String originalFilename = file.getOriginalFilename();
            src= OssFileUtils.uploadFile(file,originalFilename);
            hashMap1.put("src",src);
            hashMap.put("code",0);
            hashMap.put("msg", " ");
            hashMap.put("data",hashMap1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return hashMap;
    }
    //门店查询 findmendian
    @RequestMapping("findmendian")
    @ResponseBody
    public List<CarModel> findmendian(){
        List<CarModel> list= classClientService.findmendian();
        return list;
    }
    //修改car updatecar
    @RequestMapping("updatecar")
    @ResponseBody
    public String updatecar(CarModel carModel){
        carModel.setCarlogo(carModel.getCarlogo().substring(1));
          classClientService.updatecar(carModel);
        return null;
    }

    //updateZuCount 当前车的租车辆+1   和订单表相关联
    @RequestMapping("updateZuCount")
    @ResponseBody
    public String updateZuCount(Integer carId , Integer status){
        classClientService.updateZuCount(carId,status);
        return "1";
    }
    //门店查询 findmendianmap
    @RequestMapping("findmendianmap")
    @ResponseBody
    public HashMap<String,Object> findmendianmap(Integer page ,Integer limit){
        return classClientService.findmendianmap(page,limit);
    }
    //findMenDianById 查看门店详情
    /*@RequestMapping("findMenDianById")
    public String findMenDianById(Integer id, Model model){
        CarModel carModel= classClientService.findMenDianById(id);
        model.addAttribute("mendian",carModel);
        return "findMenDianById";
    }*/
    //deleteMenDianById 门店删除
    @RequestMapping("deleteMenDianById")
    @ResponseBody
    public String deleteMenDianById(Integer id){
        classClientService.deleteMenDianById(id);
        return "1";
    }
    //送车点管理 findSendCarAddress
    @RequestMapping("findSendCarAddress")
    @ResponseBody
    public HashMap<String,Object> findSendCarAddress(Integer page ,Integer limit){
        return classClientService.findSendCarAddress(page,limit);
    }
    //删除送车点   deleteSendCarAddress
    @RequestMapping("deleteSendCarAddress")
    @ResponseBody
    public String deleteSendCarAddress(Integer id){
        classClientService.deleteSendCarAddress(id);
        return "1";
    }

    //新增送车点 addSendCarAddress
    @RequestMapping("addSendCarAddress")
    public ModelAndView addSendCarAddress(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("addSendCarAddress");
        return mv;
    }

    //省回显  findCityAll
    @RequestMapping("findCityAll")
    @ResponseBody
    public List<CarModel> findCityAll(){
        List<CarModel> list= classClientService.findCityAll();
        return list;
    }
    //市回显 findShiAll
    @RequestMapping("findShiAll")
    @ResponseBody
    public List<CarModel> findShiAll(Integer selectCityId){
        List<CarModel> list= classClientService.findShiAll(selectCityId);
        return list;
    }

    //送车点新增  addSendCar
    @RequestMapping("addSendCar")
    @ResponseBody
    public String addSendCar(CarModel carModel){
        classClientService.addSendCar(carModel);
        return "1";
    }

    //还车点管理  查询 findReturnCarAddress
    @RequestMapping("findReturnCarAddress")
    @ResponseBody
    public HashMap<String,Object> findReturnCarAddress(Integer page ,Integer limit){
        return classClientService.findReturnCarAddress(page,limit);
    }
    //删除还车点 deleteReturnCarAddress
    @RequestMapping("deleteReturnCarAddress")
    @ResponseBody
    public String deleteReturnCarAddress(Integer id){
        classClientService.deleteReturnCarAddress(id);
        return "1";
    }

    // addReturnCarAddress
    @RequestMapping("addReturnCarAddress")
    public ModelAndView addReturnCarAddress(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("addReturnCarAddress");
        return mv;
    }
    //还车点新增  addReturnCar
    @RequestMapping("addReturnCar")
    @ResponseBody
    public String addReturnCar(CarModel carModel){
        classClientService.addReturnCar(carModel);
        return "1";
    }

    //还车审核  findReturnCar
    @RequestMapping("findReturnCar")
    @ResponseBody
    public HashMap<String,Object> findReturnCar(Integer page ,Integer limit){
        return classClientService.findReturnCar(page,limit);
    }
    //审核成功  updateReturnCarShenHe
    @RequestMapping("updateReturnCarShenHe")
    @ResponseBody
    public String updateReturnCarShenHe(Integer goodId){
        classClientService.updateReturnCarShenHe(goodId);
        return "1";
    }










}
