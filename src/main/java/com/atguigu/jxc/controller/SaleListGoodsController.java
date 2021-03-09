package com.atguigu.jxc.controller;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.domain.SuccessCode;
import com.atguigu.jxc.service.SaleListGoodsService;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author : ZJC
 * @date : 2021/3/8 16:47
 * className : SaleListGoodsController
 * package: com.atguigu.jxc.controller
 * version : 1.0
 * Description
 */
@Controller
@ResponseBody
public class SaleListGoodsController {

    @Autowired
    private SaleListGoodsService saleListGoodsService;

    @PostMapping("/saleListGoods/list")
    public Map<String,Object> updateState(@RequestParam("customerName")String customerName){

        Map<String, Object> map = this.saleListGoodsService.updateState(customerName);

        if (CollectionUtils.isEmpty(map)){
            throw new RuntimeException("abc");
        }
        return map;
    }

}
