package com.simple.testing.application.factory;

import com.simple.testing.api.request.OrderCreateRequest;
import com.simple.testing.api.request.OrderUpdateRequest;
import com.simple.testing.infrasturcture.dto.OrderDTO;
import org.mapstruct.Mapper;

/**
 * @author chenkangkang
 * @date 2023/3/30 8:29 PM
 **/
@Mapper(componentModel = "spring")
public interface OrderRequestToDtoFactory {

    OrderDTO convert(OrderCreateRequest source);

    OrderDTO convert(OrderUpdateRequest source);

}
