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
@RestController
@RequestMapping("/saleListGoods")
public class SaleListGoodsController {


    @Autowired
    private SaleListGoodsService saleListGoodsService;


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
