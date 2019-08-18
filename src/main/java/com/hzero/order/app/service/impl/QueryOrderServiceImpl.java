package com.hzero.order.app.service.impl;

import com.hzero.order.api.dto.OrderSelectPO;
import com.hzero.order.app.service.QueryOrderService;
import com.hzero.order.domain.entity.HodrSoHeader;
import com.hzero.order.domain.entity.HodrSoLine;
import com.hzero.order.domain.repository.HodrSoHeaderRepository;
import com.hzero.order.domain.repository.HodrSoLineRepository;
import com.hzero.order.infra.mapper.HodrSoHeaderMapper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QueryOrderServiceImpl implements QueryOrderService {

    @Autowired
    private HodrSoHeaderMapper hodrSoHeaderMapper;
    @Autowired
    private HodrSoHeaderRepository hodrSoHeaderRepository;
    @Autowired
    private HodrSoLineRepository hodrSoLineRepository;


    @Override
    public List<OrderSelectPO> queryOrderByCondition(OrderSelectPO orderSelectPO) {
        return hodrSoHeaderMapper.queryOrderByCondition(orderSelectPO);
    }



//    @Override
//    public List<HodrCompany> queryCompanyByNumberOrName(String companyNumber, String companyName) {
//        return orderSelectMapper.queryCompanyByNumberOrName(companyNumber,companyName);
//    }
//
//    @Override
//    public List<HodrCustomer> queryCustomerByNumberOrName(String customerNumber, String customerName) {
//        return orderSelectMapper.queryCustomerByNumberOrName(customerNumber,customerName);
//    }

    @Override
    public List queryOrderHeaderAndLine(HodrSoHeader hodrSoHeader, PageRequest pageRequest) {
        ArrayList orderHeaderAndLineList = new ArrayList();
        HodrSoHeader hodrSoHeaderInfo=hodrSoHeaderRepository.getOrderHeaderInfo(hodrSoHeader); //根据订单号拿到订单头信息
        Long soHeaderId = hodrSoHeaderInfo.getSoHeaderId();//从订单头信息中拿到订单头Id
        hodrSoHeaderInfo.setSoHeaderId(soHeaderId); //将订单头Id注入订单头对象和订单行对象中
        List<HodrSoLine> soLines = hodrSoLineRepository.getSoLineInfoByHeaderId(soHeaderId,pageRequest);//根据订单头Id查询订单行信息

        orderHeaderAndLineList.add(hodrSoHeader);
        orderHeaderAndLineList.add(soLines);
        return orderHeaderAndLineList;
    }


}
