package com.atguigu.jxc.controller;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.service.PurchaseListGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author : SongMc
 * @date : 2021/3/8 20:27
 * className : PurchaseListGoodsController
 * package: com.atguigu.jxc.controller
 * version : 1.0
 * Description
 */
@RestController
@RequestMapping("/purchaseListGoods")
public class PurchaseListGoodsController {

    @Autowired
    private PurchaseListGoodsService purchaseListGoodsService;

    @PostMapping("/updateState")
    public ServiceVO purchaseListGoods(Integer purchaseListId){
        return this.purchaseListGoodsService.updateState(purchaseListId);

    }

}
