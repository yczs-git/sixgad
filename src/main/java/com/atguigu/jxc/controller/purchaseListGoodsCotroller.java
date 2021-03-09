package com.atguigu.jxc.controller;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.entity.PurchaseList;
import com.atguigu.jxc.service.PurchaseListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;

/**
 * @author XieHaidong
 * @create 2021-03-08 18:43
 */
@Controller
@RequestMapping("/purchaseListGoods")
public class purchaseListGoodsCotroller {

    @Autowired
    private PurchaseListService purchaseListService;

    @RequestMapping("/save")
    public ServiceVO save(PurchaseList purchaseList,String purchaseListGoodsStr, String purchaseNumber) {
        ServiceVO serviceVO = purchaseListService.save(purchaseList, purchaseListGoodsStr, purchaseNumber);
        return serviceVO;
    }
}
