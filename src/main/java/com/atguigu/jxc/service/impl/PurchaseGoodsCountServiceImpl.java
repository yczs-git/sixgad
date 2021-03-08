package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.GoodsDao;
import com.atguigu.jxc.entity.PurchaseGoodsCountVo;
import com.atguigu.jxc.service.PurchaseGoodsCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class PurchaseGoodsCountServiceImpl implements PurchaseGoodsCountService {

    @Autowired
    private GoodsDao GoodsDao;


    @Override
    public List<PurchaseGoodsCountVo> queryCountList(@RequestParam("sTime") String sTime,
                                                     @RequestParam("eTime")String eTime ,
                                                     @RequestParam("goodsTypeId")Integer goodsTypeId,
                                                     @RequestParam("codeOrName")String codeOrName) {


        List<PurchaseGoodsCountVo> purchaseGoodsCountVos = this.GoodsDao.PurchaseGoodsCountList(sTime, eTime, goodsTypeId, codeOrName);
        if (CollectionUtils.isEmpty(purchaseGoodsCountVos)){
            throw new RuntimeException("进货参数为空");
        }
        return purchaseGoodsCountVos;
    }
}
