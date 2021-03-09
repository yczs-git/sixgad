package com.atguigu.jxc.vo;

import lombok.Data;

/**
 * @author : ZJC
 * @date : 2021/3/8 18:59
 * className : ReturnListVo
 * package: com.atguigu.jxc.vo
 * version : 1.0
 * Description
 */
@Data
public class ReturnListVo {

    private Integer returnListId;

    private String returnNumber;
    private String returnDate;
    private double amountPaid;
    private double amountPayable;
    private double price;
    private String remarks;
    private Integer state;
    private Integer supplierId;
    private Integer userId;
    private String supplierName;
    private String trueName;

}
