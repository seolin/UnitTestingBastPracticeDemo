package com.simple.testing.infrasturcture.factory;

import com.simple.testing.infrasturcture.dto.OrderDTO;
import com.simple.testing.infrasturcture.po.OrderPo;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * 转换工厂
 * 该方法本来应该通过mapstruct来处理，但是mapstruct对配置有要求，暂时不这么处理
 *
 * @author chenkangkang
 * @date 2023/3/30 8:02 PM
 **/
@Mapper(componentModel = "spring")
public interface OrderPoToDtoFactory {

    OrderDTO convert(OrderPo source);

    OrderPo convert(OrderDTO source);

    List<OrderDTO> convert(List<OrderPo> source);

}
