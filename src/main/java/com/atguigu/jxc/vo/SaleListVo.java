package com.atguigu.jxc.vo;

import lombok.Data;

/**
 * @author : ZJC
 * @date : 2021/3/8 18:25
 * className : saleListVo
 * package: com.atguigu.jxc.vo
 * version : 1.0
 * Description
 */
@Data
public class SaleListVo {

     private String customerName;

     private String saleDate;
     private String saleNumber;

     private String state;
     private String userId;
     private String remarks;
     private double total;



}
