package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.GoodsDao;
import com.atguigu.jxc.dao.SaleListDao;
import com.atguigu.jxc.dao.SaleListGoodsDao;
import com.atguigu.jxc.dao.SaleListGoodsStrDao;
import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.entity.Goods;
import com.atguigu.jxc.entity.SaleList;
import com.atguigu.jxc.entity.SaleListGoods;
import com.atguigu.jxc.service.SaleListGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;

/**
 * @author : SongMc
 * @date : 2021/3/8 15:21
 * className : SaleListGoodsServiceImpl
 * package: com.atguigu.jxc.service.impl
 * version : 1.0
 * Description
 */
@Service
public class SaleListGoodsServiceImpl implements SaleListGoodsService {

    @Autowired
    private SaleListGoodsDao saleListGoodsDao;

    @Autowired
    private SaleListDao saleListDao;

    @Autowired
    private GoodsDao goodsDao;

    @Autowired
    private SaleListGoodsStrDao saleListGoodsStrDao;


    /**
     * 未完成
     * @Param saleNumber 销售单号
     * @Param saleList 销售清单
     * @Param saleListGoodsStr 销售清单商品参数
     * @return com.atguigu.jxc.domain.ServiceVO
     */
    @Override
    public ServiceVO save(String saleNumber, SaleList saleList, String saleListGoodsStr) {


        // 当用户点击保存，进行销售出库单新增
        saleList.setSaleNumber(saleNumber);
        // 获取客户id
//        saleList.getCustomerId(); 外键 不会加
        // 获取应付金额
        saleList.setAmountPaid(saleList.getAmountPaid());
        // 获取实付金额
        saleList.setAmountPayable(saleList.getAmountPayable());
        // 获取销售订单创建日期
        saleList.setSaleDate(saleList.getSaleDate());
        // 获取备注
        saleList.setRemarks(saleList.getRemarks());
        // 获取支付状态
        saleList.setState(saleList.getState());

        // 获取销售清单商品参数表 从销售清单商品参数表获取销售清单
        SaleListGoods saleListGoods = new SaleListGoods();
        // 获取单价
        double price = saleListGoods.getPrice();
        // 获取总金额
        double total = saleListGoods.getTotal();
        // 获取销售商品参数表的id
        saleListGoods.getSaleListGoodsId();
        int count = saleListGoods.getGoodsNum();
        // 更新销售商品参数表的销售数据
        saleListGoods.setGoodsNum((int) (count + (total / price)));


        // 更新商品的库存数量
        Goods goods = new Goods();
        goods.setInventoryQuantity(goods.getInventoryQuantity() - count);

        // 进行保存
        // 保存销售清单
        this.saleListDao.save(saleList);
        // 更新商品销售属性
        this.saleListGoodsDao.update(saleListGoods );
        // 更新库存
        this.goodsDao.updateGoods(goods);


        return save(saleNumber,saleList,saleListGoodsStr);
    }
}
