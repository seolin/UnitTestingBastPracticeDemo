package com.simple.testing.application.dto;

import lombok.Data;

/**
 * 订单查询dto
 *
 * @author chenkangkang
 * @date 2023/3/30 8:08 PM
 **/
@Data
public class OrderQueryDTO {

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
