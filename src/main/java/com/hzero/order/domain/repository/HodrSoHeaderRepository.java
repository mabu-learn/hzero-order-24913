package com.hzero.order.domain.repository;

import com.hzero.order.api.dto.OrderDetailHeaderDTO;
import com.hzero.order.domain.entity.HodrSoHeader;
import org.hzero.mybatis.base.BaseRepository;


public interface HodrSoHeaderRepository extends BaseRepository<HodrSoHeader> {

    HodrSoHeader getOrderHeaderInfo(HodrSoHeader hodrSoHeader);

    HodrSoHeader insertOrderHeaderInfo(OrderDetailHeaderDTO orderDetailHeaderDTO, Long companyId, Long customerId);

    HodrSoHeader updateOrderHeaderInfo(OrderDetailHeaderDTO orderDetailHeaderDTO, HodrSoHeader hodrSoHeaderInclude);

}
