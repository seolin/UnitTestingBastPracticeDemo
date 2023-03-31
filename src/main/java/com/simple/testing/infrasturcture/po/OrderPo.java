package com.simple.testing.infrasturcture.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 订单po
 *
 * @author chenkangkang
 * @date 2023/3/30 7:40 PM
 **/
@Data
@TableName("t_order")
public class OrderPo {
    /**
     * 订单id
     */
    @TableId(value = "id")
    private Long id;
    /**
     * 购买者id
     */
    @TableField("buyer_id")
    private Long buyerId;
    /**
     * 购买者名称
     */
    @TableField("buyer_name")
    private String buyerName;
    /**
     * 售卖者id
     */
    @TableField("seller_id")
    private Long sellerId;

    /**
     * 售卖者名称
     */
    @TableField("seller_name")
    private String sellerName;

    /**
     * 商品名称
     */
    @TableField("good_title")
    private String goodTitle;

    /**
     * 价格
     */
    @TableField("price")
    private String price;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private LocalDateTime updateTime;
}
