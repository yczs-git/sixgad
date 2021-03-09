package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.SaleListGoodsDao;
import com.atguigu.jxc.domain.SaleOrReturnListGoodsVo;
import com.atguigu.jxc.service.SaleListGoodsService;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SaleListGoodsServiceImpl implements SaleListGoodsService {

    @Resource
    SaleListGoodsDao saleListGoodsDao;

    @Override
    public String querySaleListGoodsString(String sTime, String eTime, Integer goodsTypeId, String codeOrName) {
        List<SaleOrReturnListGoodsVo> list = saleListGoodsDao.querySaleListGoods(sTime, eTime, goodsTypeId, codeOrName);
        if (CollectionUtils.isEmpty(list)){
            return null;
        }
        String s = new Gson().toJson(list);
        return s;
    }
}
