package com.simple.testing.application.soa;

import cn.hutool.core.collection.CollectionUtil;
import com.simple.testing.BaseTest;
import com.simple.testing.api.OrderService;
import com.simple.testing.api.base.Result;
import com.simple.testing.api.request.OrderCreateRequest;
import com.simple.testing.api.request.OrderQueryRequest;
import com.simple.testing.api.request.OrderUpdateRequest;
import com.simple.testing.api.response.OrderResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author chenkangkang
 * @date 2023/3/30 8:39 PM
 **/
@Slf4j
public class OrderServiceTest extends BaseTest {

    public static final Long IPHONE_BUYER_ID = 138995358538520100L;
    public static final String IPHONE_BUYER_NAME = "小芳";
    public static final Long IPHONE_SELLER_ID = 138995358538520101L;
    public static final String IPHONE_SELLER_NAME = "大壮数码";
    public static final String IPHONE_GOODS_TITLE = "Apple iPhone 14ProMax";
    public static final String IPHONE_PRICE = "8169.00";
    public static final String IPHONE_PROMOTIONAL_PRICE = "6169.00";

    @Resource
    private OrderService orderService;


    @Test
    public void createOrder() {
        OrderCreateRequest request = createOrderRequest();
        Result<Void> result = orderService.createOrder(request);
        Assertions.assertNotNull(result, "返回结果为空");
        Assertions.assertEquals(result.getCode(), Result.SUCCESS, "插入处理失败");
    }

    @Test
    public void queryOrderListByBuyerId() {
        OrderQueryRequest request = new OrderQueryRequest();
        request.setBuyerId(IPHONE_BUYER_ID);
        queryOrderListByParam(request);
    }

    @Test
    public void queryOrderListBySellerId() {
        OrderQueryRequest request = new OrderQueryRequest();
        request.setSellerId(IPHONE_SELLER_ID);
        queryOrderListByParam(request);
    }

    @Test
    public void updateOrderById() {
        OrderQueryRequest orderQueryRequest = new OrderQueryRequest();
        orderQueryRequest.setBuyerId(IPHONE_BUYER_ID);
        List<OrderResponse> orderResponseList = queryOrderListByParam(orderQueryRequest);
        OrderResponse orderResponse = orderResponseList.get(0);

        OrderUpdateRequest orderUpdateRequest = new OrderUpdateRequest();
        orderUpdateRequest.setId(orderResponse.getId());
        orderUpdateRequest.setPrice(IPHONE_PROMOTIONAL_PRICE);
        Result<Void> result = orderService.updateOrderById(orderUpdateRequest);
        Assertions.assertNotNull(result, "返回结果为空");
        Assertions.assertEquals(result.getCode(), Result.SUCCESS, "更新处理失败");

        OrderQueryRequest updatedOrderQueryRequest = new OrderQueryRequest();
        updatedOrderQueryRequest.setOrderId(orderResponse.getId());
        List<OrderResponse> updatedOrderResponseList = queryOrderListByParam(updatedOrderQueryRequest);
        OrderResponse updatedOrderResponse = updatedOrderResponseList.get(0);
        Assertions.assertEquals(updatedOrderResponse.getPrice(), IPHONE_PROMOTIONAL_PRICE);
    }

    /**
     * 根据条件查询订单信息
     *
     * @return 根据条件查询订单信息
     */
    public List<OrderResponse> queryOrderListByParam(OrderQueryRequest request) {
        Result<List<OrderResponse>> result = orderService.queryOrderListByParam(request);
        Assertions.assertNotNull(result, "返回结果为空");
        Assertions.assertTrue(CollectionUtil.isNotEmpty(result.getData()), "查询数据为空");
        return result.getData();
    }

    /**
     * 获取创建订单的请求
     *
     * @return 创建订单的请求
     */
    private OrderCreateRequest createOrderRequest() {
        OrderCreateRequest request = new OrderCreateRequest();
        request.setBuyerId(IPHONE_BUYER_ID);
        request.setBuyerName(IPHONE_BUYER_NAME);
        request.setSellerId(IPHONE_SELLER_ID);
        request.setSellerName(IPHONE_SELLER_NAME);
        request.setGoodTitle(IPHONE_GOODS_TITLE);
        request.setPrice(IPHONE_PRICE);
        return request;
    }
}
