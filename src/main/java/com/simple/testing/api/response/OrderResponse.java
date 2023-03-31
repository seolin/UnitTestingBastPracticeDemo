package com.simple.testing.api.response;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 订单信息
 *
 * @author chenkangkang
 * @date 2023/3/30 5:28 PM
 **/
@Data
public class OrderResponse {
    /**
     * 订单id
     */
    private Long id;
    /**
     * 购买者id
     */
    private Long buyerId;
    /**
     * 购买者名称
     */
    private String buyerName;
    /**
     * 售卖者id
     */
    private Long sellerId;

    /**
     * 售卖者名称
     */
    private String sellerName;

    /**
     * 商品名称
     */
    private String goodTitle;

    /**
     * 价格
     */
    private String price;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
