package com.hzero.order.infra.repository.impl;

import com.hzero.order.api.dto.OrderDetailHeaderDTO;
import com.hzero.order.domain.entity.HodrCompany;
import com.hzero.order.domain.entity.HodrCustomer;
import com.hzero.order.domain.repository.HodrCustomerRepository;
import io.choerodon.mybatis.pagehelper.PageHelper;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;

import org.springframework.stereotype.Repository;

@Repository
public class HodrCustomerRepositoryImpl extends BaseRepositoryImpl<HodrCustomer> implements HodrCustomerRepository {


    @Override
    public Page<HodrCustomer> pageCustomer(HodrCustomer hodrCustomer, PageRequest pageRequest) {
        return PageHelper.doPage(pageRequest, ()-> this.select(hodrCustomer));
    }

    @Override
    public Long getCustomerIdByDto(OrderDetailHeaderDTO orderDetailHeaderDTO) {
        HodrCustomer hodrCustomerDTO = new HodrCustomer();
        hodrCustomerDTO.setCustomerName(orderDetailHeaderDTO.getCustomerName());
        return this.selectOne(hodrCustomerDTO).getCustomerId();
    }

    @Override
    public Page<HodrCustomer> pageAllCustomer(HodrCompany selectedCompany,PageRequest pageRequest) {
        HodrCustomer hodrCustomer = new HodrCustomer();
        if(selectedCompany != null ) {
            Long companyId = selectedCompany.getCompanyId();
            hodrCustomer.setCompanyId(companyId);
            return PageHelper.doPage(pageRequest, ()-> this.select(hodrCustomer));
        }else {
            return PageHelper.doPage(pageRequest, () -> this.selectAll());
        }
    }
}
