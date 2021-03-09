package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.ReturnListGoodsDao;
import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.service.ReturnListGoodsService;
import com.atguigu.jxc.vo.GoodsListVo;
import com.atguigu.jxc.vo.ReturnListVo;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author : ZJC
 * @date : 2021/3/8 14:12
 * className : RreturnListGoodsService
 * package: com.atguigu.jxc.service.impl
 * version : 1.0
 * Description
 */
@Service
public class ReturnListGoodsServiceImpl implements ReturnListGoodsService {

    @Autowired
    private ReturnListGoodsDao returnListGoodsDao;

    @Override
    public Map<String, Object> queryReturnList(String returnNumber, Integer supplierId, Integer state, String sTime, String eTime) {

        List<ReturnListVo> listGoods = returnListGoodsDao.getReturnNumber(returnNumber, supplierId, state, sTime, eTime);

        if (CollectionUtils.isEmpty(listGoods)){
            return null;
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("rows", listGoods);

        return map;
    }

    @Override
    public Map<String, Object> queryReGoodsList(Integer returnListId) {

        List<GoodsListVo> goodsList = returnListGoodsDao.getGoodsList(returnListId);

        if (CollectionUtils.isEmpty(goodsList)){
            return null;
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("rows", goodsList);

        return map;
    }

    @Override
    public ServiceVO deleteReturnList(Integer returnListId) {

        ServiceVO vo = this.returnListGoodsDao.deleteReturnList(returnListId);

        if (vo == null) {
            return null;
        }
        return vo;
    }
}
