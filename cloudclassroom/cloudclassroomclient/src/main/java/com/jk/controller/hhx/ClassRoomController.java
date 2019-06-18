package com.jk.controller.hhx;

import com.jk.service.hhx.MsgShenHeService;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Package com.jk.controller.hhx
 * @作者 韩慧鑫
 * @创建时间 2019/6/12 16:23
 */
@Controller
@RequestMapping("hhx")
public class ClassRoomController {

    @Autowired
    private MsgShenHeService msgShenHeService;
    @RequestMapping("toaptitude")
    public String toentermsg(){
        return "aptitudeshenhe";
    }
    @RequestMapping("tozucheliang")
    public String tozucheliang(){
        return "zucheliang";
    }
    @RequestMapping("tozuchexaingqing")
    public String tozuchexaingqing(Integer id, Model model){
        model.addAttribute("id",id);
        return "zuchexiangqing";
    }
    //身份待审核查询
    @RequestMapping("findaptitude")
    @ResponseBody
    public HashMap<String,Object> findaptitude(Integer page,Integer limit,String name){
        HashMap<String,Object> map=msgShenHeService.findaptitude(page,limit,name);
        return map;
    }
    @RequestMapping("shenhejujue")
    @ResponseBody
    public String shenhejujue(Integer id,String liyou){
        msgShenHeService.shenhejujue(id,liyou);
        return null;
    }



    //-------------------身份证审核接口-----------------------------------------
    @RequestMapping(value="tongguo",produces="application/json;charset=utf-8")
    @ResponseBody
    public String httpPost(Integer id,String name,String sfz){
        //创建httpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //传参用的集合
        ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("key", "6srKrpmsAE4HUi3nGpKFnx"));
        params.add(new BasicNameValuePair("secret", "b0bbccb766894102bc191e7450c878f7"));
        params.add(new BasicNameValuePair("trueName", name));
        params.add(new BasicNameValuePair("idenNo", sfz));//
        params.add(new BasicNameValuePair("typeId", 3001+""));
        params.add(new BasicNameValuePair("format", "json"));

        //设置参数的编码格式
        UrlEncodedFormEntity Entity=null;
        try {
            Entity = new UrlEncodedFormEntity(params, "UTF-8");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }

        HttpPost httpPost = new HttpPost("http://netocr.com/verapi/veridenNo.do");

        httpPost.setEntity(Entity);

        httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1;"
                + " Win64; x64; rv:50.0) Gecko/20100101 Firefox/50.0");
        httpPost.setHeader("Accept", "application/json");

        httpPost.setHeader("Accept-Encoding", "gzip, deflate");
        httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(30000)  		//设置链接超时的时间1秒钟
                .setSocketTimeout(30000) 		//设置读取超时1秒钟
                .build(); 						//RequestConfig静态方法  setProxy  设置代理


        httpPost.setConfig(config);

        CloseableHttpResponse response=null;
        String jsonStr="";
        try {
            response= httpClient.execute(httpPost);
            jsonStr = EntityUtils.toString(response.getEntity(), "UTF-8"); // json {}
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                httpClient.close();
                response.close();
                httpPost.abort();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.print("---------------------"+jsonStr);
        return  jsonStr;
    }
    @RequestMapping("shenhetongguo")
    @ResponseBody
    public String shenhetongguo(Integer id) {
        msgShenHeService.shenhetongguo(id);
        return null;
    }
    @RequestMapping("findzucheliang")
    @ResponseBody
    public HashMap<String,Object> findzucheliang(Integer page,Integer limit) {
        HashMap<String,Object> hashMap= msgShenHeService.findzucheliang(page,limit);
        return hashMap;
    }
    @RequestMapping("findzuchexinxi")
    @ResponseBody
    public HashMap<String,Object> findzuchexinxi(Integer page,Integer limit,Integer id) {
        HashMap<String,Object> hashMap= msgShenHeService.findzuchexinxi(page,limit,id);
        return hashMap;
    }

    /**
     * 订单查询
     * @param
     * @param
     * @return
     */

    @RequestMapping("toordertables")
    public String toordertables(){
        return "ordertables";
    }
    @RequestMapping("orderrefer")
    @ResponseBody
    public HashMap<String,Object> orderrefer(Integer page,Integer limit){
        return msgShenHeService.orderrefer(page,limit);
    }

    /**
     * 订单审核
     * @param xid
     */
    @RequestMapping("updateStatus")
    @ResponseBody
    public void updateStatus(Integer xid){
        msgShenHeService.updateStatus(xid);
    }
}
