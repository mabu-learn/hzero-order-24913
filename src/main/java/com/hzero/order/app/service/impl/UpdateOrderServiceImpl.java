package com.hzero.order.app.service.impl;

import com.hzero.order.api.dto.OrderDetailHeaderDTO;
import com.hzero.order.api.dto.OrderDetailLineDTO;
import com.hzero.order.app.service.UpdateOrderService;
import com.hzero.order.domain.entity.HodrSoHeader;
import com.hzero.order.domain.repository.HodrCompanyRepository;
import com.hzero.order.domain.repository.HodrCustomerRepository;
import com.hzero.order.domain.repository.HodrSoHeaderRepository;
import com.hzero.order.domain.repository.HodrSoLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UpdateOrderServiceImpl implements UpdateOrderService {

    @Autowired
    private HodrSoHeaderRepository hodrSoHeaderRepository;
    @Autowired
    private HodrSoLineRepository hodrSoLineRepository;

    @Override
    public List updateOrder(OrderDetailHeaderDTO orderDetailHeaderDTO,
                            List<OrderDetailLineDTO> orderDetailLineDTOList, String orderNumber) {
        HodrSoHeader hodrSoHeader = new HodrSoHeader();
        hodrSoHeader.setOrderNumber(orderNumber);
        HodrSoHeader hodrSoHeaderIncludeId = hodrSoHeaderRepository.getOrderHeaderInfo(hodrSoHeader);
        hodrSoHeaderRepository.updateOrderHeaderInfo(orderDetailHeaderDTO, hodrSoHeaderIncludeId);
        hodrSoLineRepository.updateOrderLinesInfo(orderDetailLineDTOList, hodrSoHeaderIncludeId);
        return null;
    }
}
