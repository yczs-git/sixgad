package com.atguigu.jxc.entity;

import lombok.Data;
/**
 * 进货单
 */
@Data
public class PurchaseList {

// Mybatis-plus生成的pojo对象有用 @Table() 声明了和数据库字段的对应关系。
// 这里的pojo对象未引入Mybatis-plus需要在配置文件自己手动起别名来和此对象的字段进行映射。

  private Integer purchaseListId;
  private String purchaseNumber;
  private double amountPaid;
  private double amountPayable;
  private String purchaseDate;
  private String remarks;
  private Integer state;
  private Integer supplierId;
  private Integer userId;

  private String supplierName;
  private String trueName;

}
