package com.atguigu.jxc.dao;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.entity.SaleList;
import org.apache.ibatis.annotations.Param;

/**
 * @author : SongMc
 * @date : 2021/3/8 16:01
 * className : SaleListDao
 * package: com.atguigu.jxc.dao
 * version : 1.0
 * Description
 */
public interface SaleListDao {

    void save(SaleList saleList);
}
