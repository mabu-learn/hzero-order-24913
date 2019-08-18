package com.hzero.order.infra.repository.impl;

import com.hzero.order.api.dto.OrderDetailHeaderDTO;
import com.hzero.order.api.dto.OrderSelectPO;
import com.hzero.order.domain.entity.HodrSoHeader;
import com.hzero.order.domain.repository.HodrCompanyRepository;
import com.hzero.order.domain.repository.HodrCustomerRepository;
import com.hzero.order.domain.repository.HodrSoHeaderRepository;
import com.hzero.order.infra.mapper.HodrSoHeaderMapper;
import io.choerodon.core.exception.CommonException;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HodrSoHeaderRepositoryImpl extends BaseRepositoryImpl<HodrSoHeader> implements HodrSoHeaderRepository {

    @Autowired
    private HodrCompanyRepository hodrCompanyRepository;
    @Autowired
    private HodrCustomerRepository hodrCustomerRepository;


    /**  根据某几个字段获取整条数据信息
     *   hodrSoHeader对象中orderNumber属性不能为空，否者无法唯一标识。
     */
    @Override
    public HodrSoHeader getOrderHeaderInfo(HodrSoHeader hodrSoHeader) {

        return this.selectOne(hodrSoHeader);
    }

    /**
     * 插入订单头信息
     * @param orderDetailHeaderDTO
     * @param companyId
     * @param customerId
     * @return
     */
    @Override
    public HodrSoHeader insertOrderHeaderInfo(OrderDetailHeaderDTO orderDetailHeaderDTO, Long companyId, Long customerId) {
        HodrSoHeader hodrSoHeader = new HodrSoHeader();
        hodrSoHeader.setOrderNumber(orderDetailHeaderDTO.getOrderNumber());
        if(this.selectOne(hodrSoHeader) != null) {
            throw new CommonException("订单号已存在");
        }
        hodrSoHeader.setCompanyId(companyId);
        hodrSoHeader.setCustomerId(customerId);
        hodrSoHeader.setOrderNumber(orderDetailHeaderDTO.getOrderNumber());
        hodrSoHeader.setOrderDate(orderDetailHeaderDTO.getOrderDate());
        hodrSoHeader.setOrderStatus(orderDetailHeaderDTO.getOrderStatus());
        this.insert(hodrSoHeader);
        return hodrSoHeader;
    }

    @Override
    public HodrSoHeader updateOrderHeaderInfo(OrderDetailHeaderDTO orderDetailHeaderDTO, HodrSoHeader hodrSoHeaderIncludeId) {
        Long companyId = hodrCompanyRepository.getCompanyIdByDto(orderDetailHeaderDTO);
        Long customerId = hodrCustomerRepository.getCustomerIdByDto(orderDetailHeaderDTO);
        hodrSoHeaderIncludeId.setCompanyId(companyId);
        hodrSoHeaderIncludeId.setCustomerId(customerId);
        hodrSoHeaderIncludeId.setOrderNumber(orderDetailHeaderDTO.getOrderNumber());
        hodrSoHeaderIncludeId.setOrderDate(orderDetailHeaderDTO.getOrderDate());
        hodrSoHeaderIncludeId.setOrderStatus(orderDetailHeaderDTO.getOrderStatus());
        this.updateByPrimaryKey(hodrSoHeaderIncludeId);

        return hodrSoHeaderIncludeId;
    }

}
