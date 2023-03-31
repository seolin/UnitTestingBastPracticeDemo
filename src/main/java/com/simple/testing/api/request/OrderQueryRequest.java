package com.simple.testing.api.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 查询订单请求
 *
 * @author chenkangkang
 * @date 2023/3/30 5:28 PM
 **/
@Getter
@Setter
@ToString
public class OrderQueryRequest {
    /**
     * 订单id
     */
    private Long orderId;
    /**
     * 购买者id
     */
    private Long buyerId;
    /**
     * 售卖者id
     */
    private Long sellerId;
}
