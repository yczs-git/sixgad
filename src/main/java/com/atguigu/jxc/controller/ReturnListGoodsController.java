package com.atguigu.jxc.controller;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.service.ReturnListGoodsService;
import com.google.gson.Gson;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author : ZJC
 * @date : 2021/3/8 14:07
 * className : RreturnListGoodsController
 * package: com.atguigu.jxc.controller
 * version : 1.0
 * Description
 */
@Controller
@ResponseBody
public class ReturnListGoodsController {

    @Autowired
    private ReturnListGoodsService returnListGoodsService;

    @PostMapping("/returnListGoods/list")
    public Map<String, Object> returnList(@RequestParam("returnNumber")String returnNumber,
                                          @RequestParam("supplierId")Integer supplierId,
                                          @RequestParam("supplierId")Integer state,
                                          @RequestParam("sTime")String sTime,
                                          @RequestParam("eTime")String eTime){

        Map<String, Object> map = this.returnListGoodsService.queryReturnList(returnNumber, supplierId, state, sTime, eTime);
        if (CollectionUtils.isEmpty(map)){
            map = null;
        }
        return map;
    }

    @PostMapping("/returnListGoods/goodsList")
    public Map<String,Object> goodsList(@RequestParam("returnListId")Integer returnListId){
        Map<String, Object> map = this.returnListGoodsService.queryReGoodsList(returnListId);
        if (CollectionUtils.isEmpty(map)){
            throw new RuntimeException("abc");
        }
        return map;
    }

    @PostMapping("/returnListGoods/delete")
    public ServiceVO deleteReturnList(@RequestParam("returnListId")Integer returnListId){

        ServiceVO delList = this.returnListGoodsService.deleteReturnList(returnListId);
        if (delList == null){
            throw new RuntimeException("abc");
        }
        return delList;
    }
}
