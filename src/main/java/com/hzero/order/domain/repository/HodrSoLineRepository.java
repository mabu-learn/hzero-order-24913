package com.hzero.order.domain.repository;

import com.hzero.order.api.dto.OrderDetailLineDTO;
import com.hzero.order.domain.entity.HodrSoHeader;
import com.hzero.order.domain.entity.HodrSoLine;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hzero.mybatis.base.BaseRepository;

import java.util.List;


public interface HodrSoLineRepository extends BaseRepository<HodrSoLine> {

    List<HodrSoLine> getSoLineInfoByHeaderId(Long soHeaderId, PageRequest pageRequest);

    List<HodrSoLine> insertOrderLinesInfo(List<OrderDetailLineDTO> orderDetailLineDTOList, HodrSoHeader hodrSoHeader);

    List<HodrSoLine> updateOrderLinesInfo(List<OrderDetailLineDTO> orderDetailLineDTOList, HodrSoHeader hodrSoHeader);

    HodrSoLine getSoLineInfoByHeaderAndLineNumber(HodrSoLine hodrSoLine);
}
