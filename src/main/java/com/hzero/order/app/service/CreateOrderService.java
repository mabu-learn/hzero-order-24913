package com.hzero.order.app.service;

import com.hzero.order.api.dto.OrderDetailHeaderDTO;
import com.hzero.order.api.dto.OrderDetailLineDTO;

import java.util.List;

public interface CreateOrderService {
   List createOrder(OrderDetailHeaderDTO orderDetailHeaderDTO,
                            List<OrderDetailLineDTO> orderDetailLineDTOList);
}
