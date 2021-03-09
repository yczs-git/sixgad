package com.atguigu.jxc.dao;

import com.atguigu.jxc.entity.CustomerReturnList;
import org.apache.ibatis.annotations.Param;

/**
 * @author wqy
 * @version 1.0 2021/3/9
 */
public interface CustomerReturnListDao {
    void saveReturnList(CustomerReturnList customerReturnList);

    CustomerReturnList queryByReturnNumber(@Param("returnNumber") String returnNumber);
}
