package com.simple.testing.application.factory;

import com.simple.testing.api.request.OrderQueryRequest;
import com.simple.testing.application.dto.OrderQueryDTO;
import org.springframework.stereotype.Component;

/**
 * 转换工厂
 * 该方法本来应该通过mapstruct来处理，但是mapstruct对配置有要求，暂时不这么处理
 *
 * @author chenkangkang
 * @date 2023/3/30 8:09 PM
 **/
@Component
public class OrderQueryFactory {
    public OrderQueryDTO convert(OrderQueryRequest request) {
        if (request == null) {
            return null;
        }

        OrderQueryDTO orderQueryDTO = new OrderQueryDTO();

        orderQueryDTO.setOrderId(request.getOrderId());
        orderQueryDTO.setBuyerId(request.getBuyerId());
        orderQueryDTO.setSellerId(request.getSellerId());

        return orderQueryDTO;
    }
}
