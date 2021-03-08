package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.SaleListDao;
import com.atguigu.jxc.dao.SaleListGoodsDao;
import com.atguigu.jxc.entity.SaleList;
import com.atguigu.jxc.entity.SaleListGoods;
import com.atguigu.jxc.service.SaleListGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SaleListGoodsServiceImpl implements SaleListGoodsService {

    @Resource
    private SaleListDao saleListDao;
    @Resource
    private SaleListGoodsDao saleListGoodsDao;

    @Override
    public List<SaleList> list(String saleNumber, Integer customerId, Integer state, String sTime, String eTime) {

        return this.saleListDao.list(saleNumber,customerId,state,sTime,eTime);

    }

    @Override
    public List<SaleListGoods> getGoodsList(Integer saleListId) {
        if (saleListId == null){
            return null;
        }
        return this.saleListDao.getGoodsList(saleListId);
    }

    @Override
    @Transactional
    public void delete(Integer saleListId) {


        // 根据 saleListId删除订单详情
        this.saleListGoodsDao.delete(saleListId);
        // 根据 saleListId 删除订单
        this.saleListDao.delete(saleListId);
    }
}
