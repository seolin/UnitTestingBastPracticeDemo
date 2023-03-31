package com.simple.testing.infrasturcture.repository;

import com.baomidou.mybatisplus.extension.service.IService;
import com.simple.testing.application.dto.OrderQueryDTO;
import com.simple.testing.infrasturcture.dto.OrderDTO;
import com.simple.testing.infrasturcture.po.OrderPo;

import java.util.List;


/**
 * @author chenkangkang
 * @date 2023/3/30 7:27 PM
 **/
public interface OrderRepository extends IService<OrderPo> {


    /**
     * 根据条件查询列表
     *
     * @param queryDTO 查询条件
     * @return 订单列表
     */
    List<OrderDTO> listByParam(OrderQueryDTO queryDTO);

    /**
     * 插入
     *
     * @param orderDTO 插入的订单信息
     */
    void insert(OrderDTO orderDTO);


    /**
     * 更新
     *
     * @param orderDTO 更新的订单信息
     */
    void updateById(OrderDTO orderDTO);

}
