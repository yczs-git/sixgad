package com.atguigu.jxc.dao;



import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.vo.GoodsListVo;
import com.atguigu.jxc.vo.ReturnListVo;
import org.apache.ibatis.annotations.Param;


import java.util.List;


/**
 * @author ZJC
 * @date 2021/3/8 14:28
 * @InterfaceName ReturnListGoodsDao
 * version : 1.0
 * Description
 **/
public interface ReturnListGoodsDao {

    //根据单据号模糊查询订单
    List<ReturnListVo> getReturnNumber(@Param("returnNumber")String returnNumber,
                                       @Param("supplierId")Integer supplierId,
                                       @Param("state")Integer state,
                                       @Param("sTime")String sTime,
                                       @Param("eTime")String eTime
    );

    //退货单商品信息
    List<GoodsListVo> getGoodsList(@Param("returnListId")Integer returnListId);

    //删除退货单
    ServiceVO deleteReturnList(@Param("returnListId")Integer returnList);
}
