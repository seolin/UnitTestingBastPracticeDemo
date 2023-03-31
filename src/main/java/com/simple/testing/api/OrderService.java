package com.simple.testing.api;

import com.simple.testing.api.base.Result;
import com.simple.testing.api.request.OrderCreateRequest;
import com.simple.testing.api.request.OrderQueryRequest;
import com.simple.testing.api.request.OrderUpdateRequest;
import com.simple.testing.api.response.OrderResponse;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * 订单服务
 *
 * @author chenkangkang
 * @date 2023/3/30 5:27 PM
 **/
@Service
public interface OrderService {


    /**
     * 根据条件查询订单列表
     *
     * @param request 条件参数
     * @return 订单列表
     */
    Result<List<OrderResponse>> queryOrderListByParam(OrderQueryRequest request);

    /**
     * 创建订单
     *
     * @param request 创建订单请求
     * @return 创建情况
     */
    Result<Void> createOrder(OrderCreateRequest request);

    /**
     * 更新订单
     *
     * @param request 更新订单请求
     * @return 更新情况
     */
    Result<Void> updateOrderById(@Validated OrderUpdateRequest request);

}
