package com.atguigu.jxc.controller;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.entity.SaleList;
import com.atguigu.jxc.service.SaleListGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Service;

/**
 * @author wqy
 * @version 1.0 2021/3/8
 */

import com.atguigu.jxc.entity.SaleListGoods;
import com.atguigu.jxc.service.SaleListGoodsService;
import com.google.gson.Gson;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.entity.SaleList;
import com.atguigu.jxc.entity.SaleListGoods;
import com.atguigu.jxc.service.SaleListGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/saleListGoods")
public class SaleListGoodsController {

    @Autowired

    SaleListGoodsService saleListGoodsService;

    @PostMapping("count")
    @RequiresPermissions(value = {"销售单据查询","商品销售统计"})
    public String querySaleListGoodsString(String sTime, String eTime, Integer goodsTypeId, String codeOrName){
        String s = saleListGoodsService.querySaleListGoodsString(sTime,eTime,goodsTypeId,codeOrName);
        return s;
    }




    @PostMapping("list")
    public Map<String, Object> list(@RequestParam("saleNumber") String saleNumber,
                                    @RequestParam("customerId") Integer customerId,
                                    @RequestParam("state") Integer state,
                                    @RequestParam("sTime") String sTime,
                                    @RequestParam("eTime") String eTime) {

        Map<String,Object> saleListHashMap = new HashMap<>();
        List<SaleList> list = this.saleListGoodsService.list(saleNumber,
                                                            customerId,
                                                            state,
                                                            sTime,
                                                            eTime);
        saleListHashMap.put("rows", list);
        return saleListHashMap;
    }


    @PostMapping("/goodsList")
    public Map<String,Object> getGoodsList(@RequestParam("saleListId") Integer  saleListId){

        Map<String, Object> map = new HashMap<>();
        List<SaleListGoods> listGoods = this.saleListGoodsService.getGoodsList(saleListId);
        map.put("rows", listGoods);
        return map;
    }


    @PostMapping("/delete")
    public ServiceVO delete(@RequestParam("saleListId") Integer saleListId){

        try {
            this.saleListGoodsService.delete(saleListId);
            return new ServiceVO(100,"请求成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new ServiceVO(400,"请求失败！");
        }
    }





    /**
     * 销售单保存
     * @param saleNumber 商品编号
     * @return
     */
    @PostMapping("/save")
    public ServiceVO bigSave(
            @RequestParam(value = "saleNumber")String saleNumber,
            @RequestParam(value = "saleListGoodsStr")String saleListGoodsStr,
            @RequestParam(value = "customerId")Integer customerId,
            @RequestParam(value = "amountPayable")double amountPayable,
            @RequestParam(value = "amountPaid")double amountPaid,
            @RequestParam(value = "saleDate")String saleDate,
            @RequestParam(value = "remarks")String remarks,
            @RequestParam(value = "state")Integer state
            ){
        //将部分数据封装到saleList中传递给后端
        SaleList saleList = new SaleList();
        saleList.setAmountPaid(amountPaid);
        saleList.setAmountPayable(amountPayable);
        saleList.setCustomerId(customerId);
        saleList.setSaleDate(saleDate);
        saleList.setRemarks(remarks);
        saleList.setState(state);
        saleList.setUserId(1);
        Boolean flag =  saleListGoodsService.bigSave(saleNumber,saleList,saleListGoodsStr);

        if (flag) {
            return new ServiceVO(100,"请求成功",null);
        }else {
            return new ServiceVO(100, "请求失败", null);
        }


    }
}
