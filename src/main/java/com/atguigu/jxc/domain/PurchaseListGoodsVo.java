package com.atguigu.jxc.domain;

import lombok.Data;

@Data
public class PurchaseListGoodsVo {

    // 进货单号
    String purchaseNumber;
    // 进货商Id
    Integer supplierId;
    // 是否付款
    Integer state;
    // 开始时间
    String sTime;
    // 结束时间
    String eTime;
}
