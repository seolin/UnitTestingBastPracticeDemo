package com.simple.testing.api.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 插入请求
 *
 * @author chenkangkang
 * @date 2023/3/30 8:26 PM
 **/
@Data
public class OrderUpdateRequest {
    /**
     * 订单id
     */
    @NotNull(message = "更新时候传入的订单id不能为空")
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
}
