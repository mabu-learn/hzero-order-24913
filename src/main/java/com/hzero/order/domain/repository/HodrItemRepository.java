package com.hzero.order.domain.repository;

import com.hzero.order.domain.entity.HodrItem;
import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hzero.mybatis.base.BaseRepository;


public interface HodrItemRepository extends BaseRepository<HodrItem> {

    Page<HodrItem> pageItem(HodrItem hodrItem, PageRequest pageRequest);

    HodrItem getHodrItemInfo(HodrItem hodrItem);
}
