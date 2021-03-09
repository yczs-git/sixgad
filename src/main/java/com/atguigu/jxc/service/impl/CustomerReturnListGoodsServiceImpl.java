package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.CustomerReturnListDao;
import com.atguigu.jxc.dao.CustomerReturnListGoodsDao;
import com.atguigu.jxc.domain.SaleOrReturnListGoodsVo;
import com.atguigu.jxc.entity.CustomerReturnListGoods;
import com.atguigu.jxc.service.CustomerReturnListGoodsService;
import com.atguigu.jxc.service.CustomerReturnListService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CustomerReturnListGoodsServiceImpl implements CustomerReturnListGoodsService {

    @Resource
    CustomerReturnListGoodsDao customerReturnListGoodsDao;
    @Resource
    CustomerReturnListDao customerReturnListDao;

    @Override
    public Map<String, Object> queryCustomerReturnListGoods(Integer customerReturnListId) {
        List<CustomerReturnListGoods> list = customerReturnListGoodsDao.queryCustomerReturnListGoods(customerReturnListId);
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("rows", list);
        return stringObjectHashMap;
    }

    @Override
    public Boolean deleteBycustomerReturnListId(Integer customerReturnListId) {
        Integer result1 = customerReturnListGoodsDao.deleteBycustomerReturnListGoodsId(customerReturnListId);
        Integer result2 = customerReturnListDao.deleteBycustomerReturnListById(customerReturnListId);
        if (result1 > 0 || result2 > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String queryCustomerReturnListGoodsJson(String sTime, String eTime, Integer goodsTypeId, String codeOrName) {
        List<SaleOrReturnListGoodsVo> list = customerReturnListGoodsDao.queryCustomerReturnListGoodsJson(sTime, eTime, goodsTypeId, codeOrName);
        if (CollectionUtils.isEmpty(list)){
            return null;
        }
        String s = new Gson().toJson(list);
        return s;
    }
}
