package com.atguigu.jxc.controller;

import com.atguigu.jxc.domain.PurchaseListGoodsVo;
import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.entity.PurchaseList;
import com.atguigu.jxc.entity.PurchaseListGoods;
import com.atguigu.jxc.service.PurchaseListGoodsService;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.crypto.hash.Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/purchaseListGoods")
public class PurchaseListGoodsController {

    @Autowired
    private PurchaseListGoodsService purchaseListGoodsService;

    // "Map<rows,List<PurchaseList>>"
    @PostMapping("/list")
    public Map<String, Object> purchaseListGoods(@RequestParam("purchaseNumber") String purchaseNumber,
                                                 @RequestParam("supplierId") Integer supplierId,
                                                 @RequestParam("state")Integer state,
                                                 @RequestParam("eTime") String eTime,
                                                 @RequestParam("sTime") String sTime){

        Map<String, Object> map = new HashMap<>();
        List<PurchaseList> list = this.purchaseListGoodsService.list(purchaseNumber,supplierId,state,eTime,sTime);
        map.put("rows", list);
        System.out.println(map);
        return map;
    }

    @PostMapping("/goodsList")
    public Map<String,Object> queryGoodsList(@RequestParam("purchaseListId") Integer purchaseListId){
        Map<String, Object> map = new HashMap<>();
        List<PurchaseListGoods> list = this.purchaseListGoodsService.queryGoodsListBypurchaseListId(purchaseListId);
        map.put("rows", list);
        return map;
    }

    @PostMapping("/delete")
    public ServiceVO delete(Integer purchaseListId){
        try {
            this.purchaseListGoodsService.delete(purchaseListId);
            return new ServiceVO(100, "请求成功");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("删除失败！");
        }

    }


}
