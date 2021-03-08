package com.atguigu.jxc.controller;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.entity.CustomerReturnList;
import com.atguigu.jxc.entity.DamageList;
import com.atguigu.jxc.service.CustomerReturnListService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * author:gao
 */

@RestController
@RequestMapping("/customerReturnListGoods")
public class CustomerReturnListController {

    @Autowired
    CustomerReturnListService customerReturnListService;

    @PostMapping("/list")
    @RequiresPermissions(value = "客户退货查询")
    public Map<String, Object> queryCustomerReturnListByCondition(@RequestParam("returnNumber") String returnNumber
            ,@RequestParam("customerId") Integer customerId
            ,@RequestParam("state")  Integer state,@RequestParam("sTime") String sTime,@RequestParam("eTime") String eTime) {
        Map<String, Object> stringListMap = customerReturnListService.queryCustomerReturnListByCondition(returnNumber, customerId, state, sTime, eTime);
        return stringListMap;
    }


}
