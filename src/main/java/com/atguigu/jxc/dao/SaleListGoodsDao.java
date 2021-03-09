package com.atguigu.jxc.dao;


import com.atguigu.jxc.vo.SaleListVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author ZJC
 * @date 2021/3/8 16:48
 * @InterfaceName SaleListGoodsDao
 * version : 1.0
 * Description
 **/
public interface SaleListGoodsDao {

    //根据id修改订单状态
    List<SaleListVo> querySaleListId(@Param("customerName")String customerName);
}
