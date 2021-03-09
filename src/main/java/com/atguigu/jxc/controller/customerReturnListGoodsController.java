package com.atguigu.jxc.controller;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.service.CustomerReturnListGoodsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * author:gao
 */

@RestController
@RequestMapping("/customerReturnListGoods")
public class customerReturnListGoodsController {
    @Autowired
    CustomerReturnListGoodsService customerReturnListGoodsService;

    @PostMapping("count")
    @RequiresPermissions(value = {"客户退货查询","客户退货","退货出库"})
    public String queryCustomerReturnListGoodsJson(String sTime, String eTime, Integer goodsTypeId, String codeOrName){
        return customerReturnListGoodsService.queryCustomerReturnListGoodsJson(sTime, eTime, goodsTypeId, codeOrName);
    }

    @PostMapping("delete")
    @RequiresPermissions(value = {"客户退货查询","客户退货","退货出库"})
    public ServiceVO deleteBycustomerReturnListId (Integer customerReturnListId){

        Boolean flag = customerReturnListGoodsService.deleteBycustomerReturnListId(customerReturnListId);
        if (flag){
            return new ServiceVO(100, "请求成功", null);
        }
        return new ServiceVO(999, "请求没成功", null);
    }

    @PostMapping("goodsList")
    @RequiresPermissions(value = {"客户退货查询","客户退货","退货出库"})
    public Map<String,Object> queryCustomerReturnListGoods(Integer customerReturnListId){
        return customerReturnListGoodsService.queryCustomerReturnListGoods(customerReturnListId);
    }

}
