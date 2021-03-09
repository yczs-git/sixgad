package com.atguigu.jxc.dao;

import com.atguigu.jxc.entity.CustomerReturnList;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerReturnListDao {

    void saveReturnList(CustomerReturnList customerReturnList);

    CustomerReturnList queryByReturnNumber(@Param("returnNumber") String returnNumber);

    List<CustomerReturnList> queryCustomerReturnListByCondition(@Param("returnNumber")String returnNumber,@Param("customerId") Integer customerId,@Param("state") Integer state,@Param("sTime") String sTime,@Param("eTime") String eTime);

    Integer deleteBycustomerReturnListById(Integer customerReturnListId);


}
