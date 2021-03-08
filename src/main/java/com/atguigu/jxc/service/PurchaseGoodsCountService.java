package com.atguigu.jxc.service;


import com.atguigu.jxc.entity.PurchaseGoodsCountVo;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface PurchaseGoodsCountService {

    List<PurchaseGoodsCountVo> queryCountList(
            @RequestParam("sTime") String sTime,
            @RequestParam("eTime")String eTime ,
            @RequestParam("goodsTypeId")Integer goodsTypeId,
            @RequestParam("codeOrName")String codeOrName);
}
