package com.atguigu.jxc.vo;

import lombok.Data;

/**
 * @author : ZJC
 * @date : 2021/3/9 10:43
 * className : goodsListVo
 * package: com.atguigu.jxc.vo
 * version : 1.0
 * Description
 */
@Data
public class GoodsListVo {

    private Integer returnListId;

    private Integer purchaseListGoodsId;
    private Integer goodsId;
    private String goodsCode;
    private String goodsName;
    private String goodsModel;
    private String goodsUnit;
    private Integer goodsNum;
    private double price;
    private double total;
    private Integer purchaseListId;
    private Integer goodsTypeId;

}
