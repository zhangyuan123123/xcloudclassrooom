package com.jk.controller.zys;

import com.jk.model.CouponModel;
import com.jk.service.zys.ClassClientService;
import com.jk.util.OssFileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.util.HashMap;

/**
 * 积极思考造成积极人生，消极思考造成消极人生
 *
 * @author 赵苑辰
 * @title: ClassClientController
 * @date 2019/6/18  10:43
 */
@Controller
public class ZysClassClientController {
    @Resource
    private ClassClientService classClientService;
    @RequestMapping("todiscountcoupon")
    public String todiscountcoupon(){
        return "discountcoupon";
    }
    /**
     * 去新增优惠券页面的方法
     * @param
     */
    @RequestMapping("toadddiscountcoupon")
    public String toadddiscountcoupon(Integer id, Model model){
        if(id!=null){
            CouponModel couponModel= classClientService.finddiscountcouponById(id);
            model.addAttribute("couponModel",couponModel);
        }
        return "adddiscountcoupon";
    }
    @RequestMapping("refer")
    @ResponseBody
    public HashMap<String,Object> refer(Integer page, Integer limit){

        return  classClientService.refer(page,limit);
    }

    @RequestMapping("deletecoupon")
    @ResponseBody
    public void deletecoupon(Integer sid){
        classClientService.deletecoupon(sid);
    }


    /**
     * 图片上传oss服务器
     * @param file
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("upload")
    @ResponseBody
    public HashMap<String,Object> upload(MultipartFile file , HttpServletRequest request, HttpServletResponse response){
        HashMap<String,Object> hashMap=new HashMap();
        HashMap<String,Object> hashMap1=new HashMap();
        String src=null;
        try {
            String originalFilename = file.getOriginalFilename();
            src= OssFileUtils.uploadFile(file,originalFilename);
            hashMap1.put("src",src);
            hashMap.put("code",0);
            hashMap.put("msg","");
            hashMap.put("data",hashMap1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }
        return hashMap;
    }
    @RequestMapping("adddiscountcoupon")
    @ResponseBody
    public  String adddiscountcoupon(CouponModel couponModel){
        long startTime = couponModel.getCouponStarttime().getTime();
        long endTime = couponModel.getCouponEndtime().getTime();
        long l = (endTime - startTime) / (24 * 60 * 60 * 1000);
        couponModel.setCouponTimeliness(l+"天");
        if(couponModel.getCouponId()!=null){
            classClientService.updatediscountcoupon(couponModel);
        }else{

            classClientService.adddiscountcoupon(couponModel);
        }
        return null;
    }
    @RequestMapping("exuserrefer")
    @ResponseBody
    public HashMap<String,Object> exuserrefer(Integer page, Integer limit){
        return classClientService.exuserrefer(page,limit);
    }
    @RequestMapping("toexuser")
    public String toexuser(){
        return "exuser";
    }
}
