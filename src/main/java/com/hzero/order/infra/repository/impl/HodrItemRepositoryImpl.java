package com.hzero.order.infra.repository.impl;

import com.hzero.order.domain.entity.HodrItem;
import com.hzero.order.domain.repository.HodrItemRepository;
import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.springframework.stereotype.Repository;

@Repository
public class HodrItemRepositoryImpl extends BaseRepositoryImpl<HodrItem> implements HodrItemRepository {
    @Override
    public Page<HodrItem> pageItem(HodrItem hodrItem, PageRequest pageRequest) {
        return PageHelper.doPage(pageRequest, ()-> new HodrItemRepositoryImpl().select(hodrItem));
    }

    @Override
    public HodrItem getHodrItemInfo(HodrItem hodrItem) {
        return this.selectOne(hodrItem);
    }
}
