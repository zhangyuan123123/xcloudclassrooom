package com.jk.service;

import com.jk.mapper.ClassRoomMapper;
import com.jk.model.CouponModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class ClassRoomServiceImpl implements ClassRoomService{

    @Resource
    private ClassRoomMapper classRoomMappper;
    @Override
    public HashMap<String, Object> refer(Integer page, Integer limit) {
        List<CouponModel> list=classRoomMappper.refer((page-1)*limit,limit);
        long count=classRoomMappper.count();
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg","");
        map.put("data",list);
        map.put("count",count);
        map.put("code",0);
        return map;
    }

    @Override
    public void deletecoupon(Integer sid) {
        classRoomMappper.deletecoupon(sid);
    }

    @Override
    public void adddiscountcoupon(CouponModel couponModel) {
        classRoomMappper.addcouponimg(couponModel.getImgUrl());
        Integer imgId=classRoomMappper.findimgId(couponModel.getImgUrl());
        couponModel.setImgId(imgId);
        classRoomMappper.adddiscountcoupon(couponModel);
    }

    @Override
    public CouponModel finddiscountcouponById(Integer id) {
        return classRoomMappper.finddiscountcouponById(id);
    }

    @Override
    public void updatediscountcoupon(CouponModel couponModel) {

        classRoomMappper.updatecouponimg(couponModel.getImgId(),couponModel.getImgUrl());
        classRoomMappper.updatediscountcoupon(couponModel);
    }

    @Override
    public HashMap<String, Object> exuserrefer(Integer page, Integer limit) {
        List<LinkedHashMap> list=classRoomMappper.exuserrefer((page-1)*limit,limit);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        for(int i=0;i<list.size();i++){
            Date parse = null;
            long end=0;
            long time=0;
            long l=0;
            try {
                 parse = format.parse(list.get(i).get("endTime").toString());
                 end=parse.getTime();
                 time = date.getTime();
                 l = (time - end) / (60 * 60 * 1000);
                list.get(i).put("guoqiTime",l);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        long count=classRoomMappper.getexuserrefercount();
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg","");
        map.put("data",list);
        map.put("count",count);
        map.put("code",0);
        return map;
    }
}
