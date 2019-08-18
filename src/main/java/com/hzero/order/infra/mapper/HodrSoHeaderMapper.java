package com.hzero.order.infra.mapper;

import com.hzero.order.api.dto.OrderSelectPO;
import com.hzero.order.domain.entity.HodrSoHeader;
import io.choerodon.mybatis.common.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


public interface HodrSoHeaderMapper extends BaseMapper<HodrSoHeader> {
    List<OrderSelectPO> queryOrderByCondition(OrderSelectPO orderSelectPO);
}
