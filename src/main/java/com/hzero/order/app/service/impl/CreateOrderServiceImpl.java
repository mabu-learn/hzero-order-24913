package com.hzero.order.app.service.impl;

import com.hzero.order.api.dto.OrderDetailHeaderDTO;
import com.hzero.order.api.dto.OrderDetailLineDTO;
import com.hzero.order.app.service.CreateOrderService;
import com.hzero.order.domain.entity.HodrSoHeader;
import com.hzero.order.domain.entity.HodrSoLine;
import com.hzero.order.domain.repository.HodrCompanyRepository;
import com.hzero.order.domain.repository.HodrCustomerRepository;
import com.hzero.order.domain.repository.HodrSoHeaderRepository;
import com.hzero.order.domain.repository.HodrSoLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreateOrderServiceImpl implements CreateOrderService {

    @Autowired
    private HodrCompanyRepository hodrCompanyRepository;
    @Autowired
    private HodrCustomerRepository hodrCustomerRepository;
    @Autowired
    private HodrSoHeaderRepository hodrSoHeaderRepository;
    @Autowired
    private HodrSoLineRepository hodrSoLineRepository;

    @Override
    public List createOrder(OrderDetailHeaderDTO orderDetailHeaderDTO,
                                    List<OrderDetailLineDTO> orderDetailLineDTOList) {
        Long companyId = hodrCompanyRepository.getCompanyIdByDto(orderDetailHeaderDTO);
        Long customerId = hodrCustomerRepository.getCustomerIdByDto(orderDetailHeaderDTO);
        HodrSoHeader hodrSoHeader = hodrSoHeaderRepository.
                insertOrderHeaderInfo(orderDetailHeaderDTO, companyId, customerId);
        hodrSoLineRepository.insertOrderLinesInfo(orderDetailLineDTOList, hodrSoHeader);

        return null;
    }
}
