package com.atguigu.jxc.service;

import com.atguigu.jxc.entity.CustomerReturnList;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CustomerReturnListService {

    Map<String, Object> queryCustomerReturnListByCondition(String returnNumber, Integer customerId, Integer state, String sTime, String eTime);


}
