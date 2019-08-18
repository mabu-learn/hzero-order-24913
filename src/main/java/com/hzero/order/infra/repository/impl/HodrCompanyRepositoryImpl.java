package com.hzero.order.infra.repository.impl;

import com.hzero.order.api.dto.OrderDetailHeaderDTO;
import com.hzero.order.domain.entity.HodrCompany;
import com.hzero.order.domain.repository.HodrCompanyRepository;

import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.springframework.stereotype.Repository;


@Repository
public class HodrCompanyRepositoryImpl extends BaseRepositoryImpl<HodrCompany> implements HodrCompanyRepository {
//
//    @Override
//    public HodrCompany queryCompanyByNameAndNumber(HodrCompany hodrCompany) {
//        return this.selectOne(hodrCompany);
//    }

    @Override
    public Long getCompanyIdByDto(OrderDetailHeaderDTO orderDetailHeaderDTO) {
        HodrCompany hodrCompanyDTO = new HodrCompany();
        hodrCompanyDTO.setCompanyName(orderDetailHeaderDTO.getCompanyName());
        return this.selectOne(hodrCompanyDTO).getCompanyId();
    }
}
