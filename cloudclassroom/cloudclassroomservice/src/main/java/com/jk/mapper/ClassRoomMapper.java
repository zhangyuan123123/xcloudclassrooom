package com.jk.mapper;

import com.jk.model.CouponModel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.LinkedHashMap;
import java.util.List;

public interface ClassRoomMapper {
    List<CouponModel> refer(@Param("page") Integer page,@Param("limit") Integer limit);

    long count();

    void deletecoupon(@Param("sid") Integer sid);

    void adddiscountcoupon(CouponModel couponModel);

    void addcouponimg(String imgUrl);

    Integer findimgId(String imgUrl);

    CouponModel finddiscountcouponById(Integer id);

    void updatecouponimg(@Param("imgId") Integer imgId,@Param("imgUrl") String imgUrl);

    void updatediscountcoupon(CouponModel couponModel);

    List<LinkedHashMap> exuserrefer(@Param("page") Integer page,@Param("limit") Integer limit);

    long getexuserrefercount();
}
