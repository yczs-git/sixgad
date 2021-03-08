package com.atguigu.jxc.entity;

import lombok.Data;

/**
 * 商品采购统计信息
 */
@Data
public class PurchaseGoodsCountVo {


    private String number; //单号
    private String date;  // 进货日期
    private String supplierName; //供应商名称
    private  String code; //商品编号
    private String name;  //商品名称
    private  String model;  //商品型号
    private  String goodsType; //商品类别名
    private  String unit;   //单位
    private  Double price;   //单价
    private Integer num;  //数量
    private  Double total;  //总金额
}
