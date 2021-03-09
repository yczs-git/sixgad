package com.atguigu.jxc.controller;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.entity.SaleList;
import com.atguigu.jxc.entity.SaleListGoods;
import com.atguigu.jxc.service.SaleListGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author : SongMc
 * @date : 2021/3/8 15:02
 * className : SaleListGoodsController
 * package: com.atguigu.jxc.controller
 * version : 1.0
 * Description
 */
@RequestMapping("/saleListGoods")
@RestController
public class SaleListGoodsController {

    @Autowired
    private SaleListGoodsService saleListGoodsService;

    /**
     * 保存销售表(未完成)(错误报400)
     * @Param saleNumber
     * @Param saleList
     * @Param saleListGoodsStr
     * @return com.atguigu.jxc.domain.ServiceVO
     */
    @PostMapping("/save")
    public ServiceVO save(
            @RequestParam("saleNumber")String saleNumber,
            @RequestParam SaleList saleList,
            @RequestParam String saleListGoodsStr){

        return this.saleListGoodsService.save(saleNumber,saleList,saleListGoodsStr);
    }
}
