package com.simple.testing.application.factory;

import com.simple.testing.api.response.OrderResponse;
import com.simple.testing.infrasturcture.dto.OrderDTO;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author chenkangkang
 * @date 2023/3/30 8:30 PM
 **/
@Mapper(componentModel = "spring")
public interface OrderDtoToResponseFactory {
    OrderResponse convert(OrderDTO source);

    List<OrderResponse> convert(List<OrderDTO> source);

}
