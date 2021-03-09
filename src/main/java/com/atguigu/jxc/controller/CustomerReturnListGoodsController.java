package com.atguigu.jxc.controller;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.service.CustomerReturnListGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wqy
 * @version 1.0 2021/3/9
 */
@RestController
@RequestMapping("/customerReturnListGoods")
public class CustomerReturnListGoodsController {


    @Autowired
    private CustomerReturnListGoodsService returnListGoodsService;

    @PostMapping("/save")
    public ServiceVO saveReturnList(
            @RequestParam(value = "returnNumber")String returnNumber,
            @RequestParam(value = "customerId")Integer customerId,
            @RequestParam(value = "amountPayable")double amountPayable,
            @RequestParam(value = "amountPaid")double amountPaid,
            @RequestParam(value = "returnDate")String returnDate,
            @RequestParam(value = "remarks")String remarks,
            @RequestParam(value = "state")Integer state,
            @RequestParam(value = "customerReturnListGoodsStr")String returnListGoodsStr
    ){

      Boolean flag =  returnListGoodsService.saveReturnList(returnNumber,customerId,amountPayable,amountPaid,returnDate,remarks,state,returnListGoodsStr);

        if (flag) {
            return new ServiceVO(100,"请求成功",null);
        }else {
            return new ServiceVO(100, "请求失败", null);
        }
    }
}
