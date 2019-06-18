package com.jk.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @Package com.jk.mapper
 * @作者 韩慧鑫
 * @创建时间 2019/6/12 16:35
 */
public interface ClassRoomMapper {
    List<LinkedHashMap> findaptitude(@Param("page") Integer page,@Param("limit") Integer limit);

    Long getAptitudeSumSize();

    void shenhejujue(@Param("id") Integer id,@Param("liyou") String liyou);

    void shenhetongguo(@Param("id") Integer id);

    List<LinkedHashMap> findaptitudeName(@Param("page") Integer page,@Param("limit") Integer limit,@Param("name") String name);

    List<LinkedHashMap> findzucheliang(@Param("page") Integer page, Integer limit);

    Long getzucheliangSumSize();

    List<LinkedHashMap> findzuchexinxi(@Param("page")Integer page,@Param("limit") Integer limit,@Param("id") Integer id);

    Long getzuchexinxi();

    List<LinkedHashMap> orderrefer(@Param("page")Integer page,@Param("limit") Integer limit);

    Long ordercount();

    Integer updateStatus(@Param("xid") Integer xid);

    HashMap<String, Object> refer(@Param("xid") Integer xid);

    HashMap<String, Object> userrefer(@Param("xid") Integer xid);
}
