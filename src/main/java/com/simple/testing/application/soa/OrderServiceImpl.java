package com.simple.testing.application.soa;

import com.simple.testing.api.OrderService;
import com.simple.testing.api.base.Result;
import com.simple.testing.api.request.OrderCreateRequest;
import com.simple.testing.api.request.OrderQueryRequest;
import com.simple.testing.api.request.OrderUpdateRequest;
import com.simple.testing.api.response.OrderResponse;
import com.simple.testing.application.factory.OrderDtoToResponseFactory;
import com.simple.testing.application.factory.OrderQueryFactory;
import com.simple.testing.application.factory.OrderRequestToDtoFactory;
import com.simple.testing.infrasturcture.dto.OrderDTO;
import com.simple.testing.infrasturcture.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.List;

/**
 * 订单服务
 *
 * @author chenkangkang
 * @date 2023/3/30 5:27 PM
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderRepository orderRepository;

    @Resource
    private OrderQueryFactory orderQueryFactory;
    @Resource
    private OrderDtoToResponseFactory orderDtoToResponseFactory;
    @Resource
    private OrderRequestToDtoFactory orderRequestToDtoFactory;

    @Override
    public Result<List<OrderResponse>> queryOrderListByParam(OrderQueryRequest request) {
        List<OrderDTO> resultList = orderRepository.listByParam(orderQueryFactory.convert(request));
        return Result.ok(orderDtoToResponseFactory.convert(resultList));
    }

    @Override
    public Result<Void> createOrder(OrderCreateRequest request) {
        orderRepository.insert(orderRequestToDtoFactory.convert(request));
        return Result.ok(null);
    }

    @Override
    public Result<Void> updateOrderById(@Validated OrderUpdateRequest request) {
        orderRepository.updateById(orderRequestToDtoFactory.convert(request));
        return Result.ok(null);
    }
}
