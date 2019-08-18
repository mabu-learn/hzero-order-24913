package com.hzero.order.domain.repository;

import com.hzero.order.api.dto.OrderDetailHeaderDTO;
import com.hzero.order.domain.entity.HodrCompany;
import com.hzero.order.domain.entity.HodrCustomer;
import org.hzero.mybatis.base.BaseRepository;
import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;


public interface HodrCustomerRepository extends BaseRepository<HodrCustomer> {

    Page<HodrCustomer> pageCustomer(HodrCustomer hodrCustomer, PageRequest pageRequest);

    Long getCustomerIdByDto(OrderDetailHeaderDTO orderDetailHeaderDTO);

    Page<HodrCustomer> pageAllCustomer(HodrCompany hodrCompany, PageRequest pageRequest);
}
