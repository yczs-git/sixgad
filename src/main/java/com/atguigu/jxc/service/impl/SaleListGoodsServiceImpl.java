package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.GoodsDao;
import com.atguigu.jxc.dao.SaleListGoodsDao;
import com.atguigu.jxc.dao.SaleListsDao;
import com.atguigu.jxc.domain.SaleListGoodsl;
import com.atguigu.jxc.entity.SaleList;
import com.atguigu.jxc.entity.SaleListGoods;
import com.atguigu.jxc.service.SaleListGoodsService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wqy
 * @version 1.0 2021/3/8
 */
@Service
public class SaleListGoodsServiceImpl implements SaleListGoodsService {

    @Autowired
    private GoodsDao goodsDao;

    @Autowired
    private SaleListGoodsDao saleListGoodsDao;

    @Autowired
    private SaleListsDao saleListsDao;

    /**
     *
     * @param saleNumber    商品订单号
     * @param saleList      销售单表
     * @param saleListGoodsStr 销售单中的商品表
     * @return
     */
    @Override
    public Boolean bigSave(String saleNumber, SaleList saleList, String saleListGoodsStr) {
        saleList.setSaleNumber(saleNumber);
        try {
            saleListsDao.saveSaleList(saleList);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        //根据saleNumber查询 获取 saleListId
        SaleList saleList1 = saleListsDao.querySaleListByNumber(saleNumber);
        Integer saleListId = saleList1.getSaleListId();
        //获取销售单中商品中的销售数量
        List<SaleListGoodsl> saleListGoodsls = jsonStringConvertToList(saleListGoodsStr, SaleListGoodsl[].class);


        List<SaleListGoods> saleListGoodss = saleListGoodsls.stream().map(saleListGoodsl -> {
            SaleListGoods saleListGoods = new SaleListGoods();
            saleListGoods.setGoodsId(saleListGoodsl.getGoodsId());
            saleListGoods.setGoodsCode(saleListGoodsl.getGoodsCode());
            saleListGoods.setGoodsName(saleListGoodsl.getGoodsName());
            saleListGoods.setGoodsModel(saleListGoodsl.getGoodsModel());
            saleListGoods.setGoodsUnit(saleListGoodsl.getGoodsUnit());
            saleListGoods.setTotal(saleListGoodsl.getTotal());
            saleListGoods.setGoodsTypeId(saleListGoodsl.getGoodsTypeId());
            saleListGoods.setPrice(Double.valueOf(saleListGoodsl.getPrice()));
            Integer goodsNum = Integer.parseInt(saleListGoodsl.getGoodsNum());
            saleListGoods.setGoodsNum(goodsNum);
            saleListGoods.setSaleListId(saleListId);
            return saleListGoods;
        }).collect(Collectors.toList());


        try {
            saleListGoodss.forEach(saleListGoods -> {
                Integer goodsId = saleListGoods.getGoodsId();
                Integer goodsNum = saleListGoods.getGoodsNum();
                //更新商品表goods中的库存数量,另外还需要商品的编号
                goodsDao.updateGoodsNum(goodsNum,goodsId);
                //保存数据到表sale_list_goods中
                saleListGoodsDao.saveSaleListGoods(saleListGoods);
            });


        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;

    }

    public static <T> List<T> jsonStringConvertToList(String string, Class<T[]> cls) {
        Gson gson = new Gson();
        T[] array = gson.fromJson(string, cls);
        return Arrays.asList(array);
    }


}
