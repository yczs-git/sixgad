package com.atguigu.jxc.service;
import java.util.Map;
public interface CustomerReturnListGoodsService {
    Boolean saveReturnList(String returnNumber, Integer customerId, double amountPayable, double amountPaid, String returnDate, String remarks, Integer state, String returnListGoodsStr);


    Map<String, Object> queryCustomerReturnListGoods(Integer customerReturnListId);

    Boolean deleteBycustomerReturnListId(Integer customerReturnListId);

    String queryCustomerReturnListGoodsJson(String sTime, String eTime, Integer goodsTypeId, String codeOrName);
}
