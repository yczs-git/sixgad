package com.atguigu.jxc.domain;

import lombok.Data;

/**
 * @author wqy
 * @version 1.0 2021/3/9
 */
@Data
public class CustomerReturnListDto {


    private Integer goodsId;
    private String goodsCode;
    private String goodsName;
    private String goodsModel;
    private String goodsNum;
    private String goodsUnit;
    private String sellingPrice;
    private String price;
    private double total;
    private Integer customerReturnListId;
    private Integer goodsTypeId;
}
