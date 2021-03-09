package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.CustomerReturnListDao;
import com.atguigu.jxc.entity.CustomerReturnList;
import com.atguigu.jxc.service.CustomerReturnListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerReturnListImpl implements CustomerReturnListService {

    @Resource
    CustomerReturnListDao customerReturnListDao;


    @Override
    public Map<String, Object> queryCustomerReturnListByCondition(String returnNumber, Integer customerId, Integer state, String sTime, String eTime) {
        List<CustomerReturnList> customerReturnLists = customerReturnListDao.queryCustomerReturnListByCondition(returnNumber, customerId, state, sTime, eTime);
        if (CollectionUtils.isEmpty(customerReturnLists)){
            return null;
        }
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("rows", customerReturnLists);
        return hashMap;
    }
}
