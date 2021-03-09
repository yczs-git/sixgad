package com.atguigu.jxc.domain;

import lombok.Data;

@Data
public class SaleOrReturnListGoodsVo {
    //            "number": "XS1605773500926",
//                    "date": "2020-11-19",
//                    "customerName": "家乐福（青石桥店）",
//                    "code": "0003",
//                    "name": "野生东北黑木耳",
//                    "model": "500g装",
//                    "goodsType": "休闲食品",
//                    "unit": "袋",
//                    "price": 38,
//                    "num": 50,
//                    "total": 1900
    private String number;
    private String date;
    private String customerName;
    private String code;
    private String name;
    private String model;
    private String goodsType;
    private String unit;
    private String price;
    private String num;
    private String total;

}
