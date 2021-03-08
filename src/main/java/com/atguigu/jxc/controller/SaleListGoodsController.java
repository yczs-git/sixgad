package com.atguigu.jxc.controller;

import com.atguigu.jxc.entity.SaleListGoods;
import com.atguigu.jxc.service.SaleListGoodsService;
import com.google.gson.Gson;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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


}
