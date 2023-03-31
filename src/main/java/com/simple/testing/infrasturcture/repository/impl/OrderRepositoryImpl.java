package com.simple.testing.infrasturcture.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.simple.testing.application.dto.OrderQueryDTO;
import com.simple.testing.common.exception.ErrorCode;
import com.simple.testing.common.exception.UnitTestingException;
import com.simple.testing.infrasturcture.dto.OrderDTO;
import com.simple.testing.infrasturcture.factory.OrderPoToDtoFactory;
import com.simple.testing.infrasturcture.po.OrderPo;
import com.simple.testing.infrasturcture.presistence.OrderMapper;
import com.simple.testing.infrasturcture.repository.OrderRepository;
import com.simple.testing.tool.SnowflakeIdGenerator;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author chenkangkang
 * @date 2023/3/30 7:43 PM
 **/
@Component
public class OrderRepositoryImpl extends ServiceImpl<OrderMapper, OrderPo> implements OrderRepository {
    @Resource
    private OrderPoToDtoFactory orderFactory;

    @Override
    public List<OrderDTO> listByParam(OrderQueryDTO queryDTO) {
        LambdaQueryWrapper<OrderPo> queryWrapper = Wrappers.<OrderPo>lambdaQuery();
        if (queryDTO.getBuyerId() != null) {
            queryWrapper.eq(OrderPo::getBuyerId, queryDTO.getBuyerId());
        }

        if (queryDTO.getSellerId() != null) {
            queryWrapper.eq(OrderPo::getSellerId, queryDTO.getSellerId());
        }

        if (queryDTO.getOrderId() != null) {
            queryWrapper.eq(OrderPo::getId, queryDTO.getOrderId());
        }

        List<OrderPo> list = list(queryWrapper);
        return orderFactory.convert(list);
    }

    @Override
    public void insert(OrderDTO orderDTO) {
        OrderPo orderPo = orderFactory.convert(orderDTO);
        orderPo.setId(SnowflakeIdGenerator.generateId());
        orderPo.setCreateTime(LocalDateTime.now());
        orderPo.setUpdateTime(LocalDateTime.now());
        save(orderPo);
    }

    @Override
    public void updateById(OrderDTO orderDTO) {
        if (orderDTO.getId() == null) {
            throw new UnitTestingException(ErrorCode.PARAMETER_ERROR, "id不能为空");
        }
        OrderPo orderPo = orderFactory.convert(orderDTO);
        orderPo.setUpdateTime(LocalDateTime.now());
        updateById(orderPo);
    }
}
