package com.hzero.order.app.service;

import com.hzero.order.api.dto.OrderSelectPO;
import com.hzero.order.domain.entity.HodrSoHeader;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;

import java.util.List;

public interface QueryOrderService {

    List<OrderSelectPO> queryOrderByCondition(OrderSelectPO orderSelectPO);
//
//    List<HodrCompany> queryCompanyByNumberOrName(String companyNumber, String companyName);
//
//    List<HodrCustomer> queryCustomerByNumberOrName(String customerNumber, String customerName);

    List queryOrderHeaderAndLine(HodrSoHeader hodrSoHeader, PageRequest pageRequest);
}
