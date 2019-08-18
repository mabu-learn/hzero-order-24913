package com.hzero.order.domain.repository;

import com.hzero.order.api.dto.OrderDetailHeaderDTO;
import com.hzero.order.domain.entity.HodrCompany;
import org.hzero.mybatis.base.BaseRepository;


public interface HodrCompanyRepository extends BaseRepository<HodrCompany> {

    Long getCompanyIdByDto(OrderDetailHeaderDTO orderDetailHeaderDTO);
}
