package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.PurchaseListDao;
import com.atguigu.jxc.dao.PurchaseListGoodsDao;
import com.atguigu.jxc.domain.PurchaseListGoodsVo;
import com.atguigu.jxc.entity.PurchaseList;
import com.atguigu.jxc.entity.PurchaseListGoods;
import com.atguigu.jxc.service.PurchaseListGoodsService;
import com.atguigu.jxc.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PurchaseListGoodsServiceImpl implements PurchaseListGoodsService {

    @Resource
    private PurchaseListGoodsDao purchaseListGoodsDao;

    @Resource
    private PurchaseListDao purchaseListDao;

    @Override
    public List<PurchaseList> list(String purchaseNumber,
                                   Integer supplierId,
                                   Integer state,
                                   String eTime,
                                   String sTime) {


        // 检测单据号
//        String purchaseNumber = purchaseListGoodsVo.getPurchaseNumber();
//        Integer supplierId = purchaseListGoodsVo.getSupplierId();
//        Integer state = purchaseListGoodsVo.getState();
//        String eTime = purchaseListGoodsVo.getETime();
//        String sTime = purchaseListGoodsVo.getSTime();
        List<PurchaseList> listList = purchaseListGoodsDao.getPurchaseListGoodsByNumber(purchaseNumber, supplierId, state, eTime, sTime);
        System.out.println(listList);
        return listList;
    }

    @Override
    public List<PurchaseListGoods> queryGoodsListBypurchaseListId(Integer purchaseListId) {
        List<PurchaseListGoods> listGoods = this.purchaseListGoodsDao.queryGoodsListBypurchaseListId(purchaseListId);
        return listGoods;
    }


    @Override
    @Transactional
    public void delete(Integer purchaseListId) {
        if (purchaseListId!=null){
            this.purchaseListGoodsDao.delete(purchaseListId);
            this.purchaseListDao.delete(purchaseListId);
        }
    }
}
