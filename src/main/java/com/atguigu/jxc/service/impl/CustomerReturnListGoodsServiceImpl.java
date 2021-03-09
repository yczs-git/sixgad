package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.CustomerReturnListDao;
import com.atguigu.jxc.dao.CustomerReturnListGoodsDao;
import com.atguigu.jxc.dao.GoodsDao;
import com.atguigu.jxc.domain.CustomerReturnListDto;
import com.atguigu.jxc.entity.CustomerReturnList;
import com.atguigu.jxc.entity.CustomerReturnListGoods;
import com.atguigu.jxc.service.CustomerReturnListGoodsService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.jxc.domain.SaleOrReturnListGoodsVo;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class CustomerReturnListGoodsServiceImpl implements CustomerReturnListGoodsService {


    @Autowired
    private CustomerReturnListDao returnListDao;

    @Autowired
    private CustomerReturnListGoodsDao returnListGoodsDao;

    @Autowired
    private GoodsDao goodsDao;

    @Override
    public Boolean saveReturnList(String returnNumber, Integer customerId, double amountPayable, double amountPaid, String returnDate, String remarks, Integer state, String returnListGoodsStr) {
        //保存用户退货商品数据
        CustomerReturnList customerReturnList = new CustomerReturnList();
        customerReturnList.setCustomerId(customerId);
        customerReturnList.setAmountPaid(amountPaid);
        customerReturnList.setAmountPayable(amountPayable);
        customerReturnList.setReturnDate(returnDate);
        customerReturnList.setRemarks(remarks);
        customerReturnList.setState(state);
        customerReturnList.setReturnNumber(returnNumber);
        customerReturnList.setUserId(1);
        try {
            returnListDao.saveReturnList(customerReturnList);
            //根据退单编号查询客户退单号id
            customerReturnList = returnListDao.queryByReturnNumber(returnNumber);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        Integer customerReturnListId = customerReturnList.getCustomerReturnListId();
        //将json类型的数据转为CustomerReturnListDto,原因前端传来的参数有问题
        Gson gson = new Gson();
        List<CustomerReturnListDto> customerReturnListDtos = jsonStringConvertToList(returnListGoodsStr, CustomerReturnListDto[].class);
        //将customerReturnListDtos保存到CustomerReturnListGoods中
        List<CustomerReturnListGoods> customerReturnListGoodss = customerReturnListDtos.stream().map(customerReturnListDto -> {
            CustomerReturnListGoods customerReturnListGoods = new CustomerReturnListGoods();
            customerReturnListGoods.setGoodsId(customerReturnListDto.getGoodsId());
            customerReturnListGoods.setGoodsCode(customerReturnListDto.getGoodsCode());
            customerReturnListGoods.setGoodsName(customerReturnListDto.getGoodsName());
            customerReturnListGoods.setGoodsModel(customerReturnListDto.getGoodsModel());
            customerReturnListGoods.setGoodsNum(Integer.parseInt(customerReturnListDto.getGoodsNum()));
            customerReturnListGoods.setGoodsUnit(customerReturnListDto.getGoodsUnit());
            customerReturnListGoods.setPrice(Double.valueOf(customerReturnListDto.getPrice()));
            customerReturnListGoods.setTotal(customerReturnListDto.getTotal());
            customerReturnListGoods.setCustomerReturnListId(customerReturnListId);
            customerReturnListGoods.setGoodsTypeId(customerReturnListDto.getGoodsTypeId());
            return customerReturnListGoods;
        }).collect(Collectors.toList());

        try {
            //遍历数据，更新商品库存
            customerReturnListGoodss.forEach(customerReturnListGoods -> {
                //需要两个参数1.退货数量，2.商品id
                Integer goodsId = customerReturnListGoods.getGoodsId();
                Integer goodsNum = customerReturnListGoods.getGoodsNum();
                goodsDao.updateGoodsByNum(goodsId,goodsNum);
                //保存退货商品
                returnListGoodsDao.saveGoods(customerReturnListGoods);
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
