package com.hzero.order.infra.repository.impl;

import com.hzero.order.api.dto.OrderDetailLineDTO;
import com.hzero.order.domain.entity.HodrItem;
import com.hzero.order.domain.entity.HodrSoHeader;
import com.hzero.order.domain.entity.HodrSoLine;
import com.hzero.order.domain.repository.HodrItemRepository;
import com.hzero.order.domain.repository.HodrSoHeaderRepository;
import com.hzero.order.domain.repository.HodrSoLineRepository;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HodrSoLineRepositoryImpl extends BaseRepositoryImpl<HodrSoLine> implements HodrSoLineRepository {

    @Autowired
    private HodrSoHeaderRepository hodrSoHeaderRepository;
    @Autowired
    private HodrItemRepository hodrItemRepository;
    @Override
    public List<HodrSoLine> getSoLineInfoByHeaderId(Long soHeaderId, PageRequest pageRequest) {
        HodrSoLine hodrSoLine = new HodrSoLine();
        hodrSoLine.setSoHeaderId(soHeaderId);
        return PageHelper.doPage(pageRequest, ()-> this.select(hodrSoLine));
    }

    @Override
    public HodrSoLine getSoLineInfoByHeaderAndLineNumber(HodrSoLine hodrSoLine) {

        return this.selectOne(hodrSoLine);
    }

    @Override
    public List<HodrSoLine> insertOrderLinesInfo(List<OrderDetailLineDTO> orderDetailLineDTOList, HodrSoHeader hodrSoHeader) {
        ArrayList<HodrSoLine> hodrSoLines = new ArrayList<>();
        HodrSoLine hodrSoLine = new HodrSoLine();
        HodrItem hodrItem = new HodrItem();
        HodrSoHeader hodrSoHeaderIncludeId = hodrSoHeaderRepository.getOrderHeaderInfo(hodrSoHeader);//根据订单头对象拿到订单头Id
        for (OrderDetailLineDTO o:orderDetailLineDTOList) {
            hodrItem.setItemCode(o.getItemCode());
            hodrItem.setItemDescription(o.getItemDescription());
            HodrItem hodrItemIncludeId = hodrItemRepository.getHodrItemInfo(hodrItem);//根据物料编码和描述拿到物料对象，进而拿到物料Id
            hodrSoLine.setSoHeaderId(hodrSoHeaderIncludeId.getSoHeaderId());
            hodrSoLine.setItemId(hodrItemIncludeId.getItemId());
            hodrSoLine.setLineNumber(o.getLineNumber());
            hodrSoLine.setOrderQuantity(o.getOrderQuantity());
            hodrSoLine.setOrderQuantityUom(o.getOrderQuantityUom());
            hodrSoLine.setUnitSellingPrice(o.getUnitSellingPrice());
            hodrSoLine.setDescription(o.getDecription());
            hodrSoLine.setAddition1(o.getAddition1());
            hodrSoLine.setAddition2(o.getAddition2());
            hodrSoLine.setAddition3(o.getAddition3());
            hodrSoLine.setAddition4(o.getAddition4());
            hodrSoLine.setAddition5(o.getAddition5());
            this.insert(hodrSoLine);
            hodrSoLines.add(hodrSoLine);
        }
        return hodrSoLines;
    }

    @Override
    public List<HodrSoLine> updateOrderLinesInfo(List<OrderDetailLineDTO> orderDetailLineDTOLists, HodrSoHeader hodrSoHeaderIncludeId) {
        ArrayList<HodrSoLine> hodrSoLines = new ArrayList();
        HodrSoLine hodrSoLine = new HodrSoLine();
        HodrItem hodrItem = new HodrItem();
        for (OrderDetailLineDTO o:orderDetailLineDTOLists) {
            hodrSoLine.setLineNumber(o.getLineNumber());
            hodrSoLine.setSoHeaderId(hodrSoHeaderIncludeId.getSoHeaderId());
            HodrSoLine hodrSoLineIncludeId = this.getSoLineInfoByHeaderAndLineNumber(hodrSoLine);
            hodrItem.setItemCode(o.getItemCode());
            hodrItem.setItemDescription(o.getItemDescription());
            HodrItem hodrItemIncludeId = hodrItemRepository.getHodrItemInfo(hodrItem);//根据物料编码和描述拿到物料对象，进而拿到物料Id
            hodrSoLine.setSoLineId(hodrSoLineIncludeId.getSoLineId());
            hodrSoLine.setItemId(hodrItemIncludeId.getItemId());
            hodrSoLine.setLineNumber(o.getLineNumber());
            hodrSoLine.setOrderQuantity(o.getOrderQuantity());
            hodrSoLine.setOrderQuantityUom(o.getOrderQuantityUom());
            hodrSoLine.setUnitSellingPrice(o.getUnitSellingPrice());
            hodrSoLine.setDescription(o.getDecription());
            hodrSoLine.setAddition1(o.getAddition1());
            hodrSoLine.setAddition2(o.getAddition2());
            hodrSoLine.setAddition3(o.getAddition3());
            hodrSoLine.setAddition4(o.getAddition4());
            hodrSoLine.setAddition5(o.getAddition5());
            this.updateByPrimaryKey(hodrSoLine);
            hodrSoLines.add(hodrSoLine);
        }

        return hodrSoLines;
    }
}
