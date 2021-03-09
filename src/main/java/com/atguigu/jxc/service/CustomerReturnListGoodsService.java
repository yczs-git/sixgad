package com.atguigu.jxc.service;

/**
 * @author wqy
 * @version 1.0 2021/3/9
 */
public interface CustomerReturnListGoodsService {
    Boolean saveReturnList(String returnNumber, Integer customerId, double amountPayable, double amountPaid, String returnDate, String remarks, Integer state, String returnListGoodsStr);
}
