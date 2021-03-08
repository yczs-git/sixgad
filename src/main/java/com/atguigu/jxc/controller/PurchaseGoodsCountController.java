package com.atguigu.jxc.controller;

import com.atguigu.jxc.entity.PurchaseGoodsCountVo;
import com.atguigu.jxc.service.PurchaseGoodsCountService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 商品采购统计信息
 */
@RestController
@RequestMapping("/purchaseListGoods")
public class PurchaseGoodsCountController {

    @Autowired
    private PurchaseGoodsCountService countService;

    @PostMapping("/count")
    public String queryCountList(
            @RequestParam("sTime") String sTime,
            @RequestParam("eTime")String eTime ,
            @RequestParam("goodsTypeId")Integer goodsTypeId,
            @RequestParam("codeOrName")String codeOrName)
    {
        List<PurchaseGoodsCountVo> purchaseGoodsCountVos = this.countService.queryCountList(
                sTime, eTime, goodsTypeId, codeOrName);
        if (CollectionUtils.isEmpty(purchaseGoodsCountVos)){
            throw  new RuntimeException("没有要查询的商品");
        }
        Gson gson = new Gson();
        String s = gson.toJson(purchaseGoodsCountVos);
        return s;
    }
}
