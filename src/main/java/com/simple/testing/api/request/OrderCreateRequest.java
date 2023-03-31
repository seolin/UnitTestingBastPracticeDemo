package com.simple.testing.api.request;

import lombok.Data;

/**
 * 插入请求
 *
 * @author chenkangkang
 * @date 2023/3/30 8:26 PM
 **/
@Data
public class OrderCreateRequest {
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
