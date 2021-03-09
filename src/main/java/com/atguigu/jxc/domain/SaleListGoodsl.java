package com.atguigu.jxc.domain;

import lombok.Data;

/**
 * @author wqy
 * @version 1.0 2021/3/8
 */
@Data
public class SaleListGoodsl {

    private Integer goodsId;
    private Integer goodsTypeId;
    private String goodsCode;
    private String goodsName;
    private String goodsModel;
    private String goodsUnit;
    private String goodsNum;

    private double sellingPrice;
    private String price;
    private double total;

}
