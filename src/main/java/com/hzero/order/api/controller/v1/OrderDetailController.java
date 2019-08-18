package com.hzero.order.api.controller.v1;


import com.hzero.order.api.dto.OrderDetailHeaderDTO;
import com.hzero.order.api.dto.OrderDetailLineDTO;
import com.hzero.order.app.service.CreateOrderService;
import com.hzero.order.app.service.QueryOrderService;
import com.hzero.order.app.service.UpdateOrderService;
import com.hzero.order.app.service.impl.UpdateOrderServiceImpl;
import com.hzero.order.config.SwaggerConfig;
import com.hzero.order.domain.entity.HodrCompany;
import com.hzero.order.domain.entity.HodrSoHeader;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hzero.core.util.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@Api(SwaggerConfig.DETAIL)
@RestController("orderDetailController.v1")
@RequestMapping("/v1/orderDetail")
public class OrderDetailController {

    @Autowired
    private QueryOrderService queryOrderService;
    @Autowired
    private CreateOrderService createOrderService;
    @Autowired
    private UpdateOrderService updateOrderService;

    @ApiOperation(value = "根据订单头编号查询订单头信息和订单行信息")
    @Permission(level = ResourceLevel.SITE, permissionLogin = true)
    @GetMapping("query/orderHeaderAndLineInfo")
    public ResponseEntity<List> queryOrderHeaderAndLines(
             HodrSoHeader hodrSoHeader, PageRequest pageRequest, HttpSession session) {
        session.setAttribute("orderNumber", hodrSoHeader);
        return Results.success(queryOrderService.queryOrderHeaderAndLine(hodrSoHeader, pageRequest));
    }

    @ApiOperation(value = "导出订单信息")
    @Permission(level = ResourceLevel.SITE, permissionLogin = true)
    @GetMapping("query/deriveOrderHeaderAndLines")
    public ResponseEntity<List> deriveOrderHeaderAndLines(
            HodrSoHeader hodrSoHeader, PageRequest pageRequest, HttpSession session) {
        session.setAttribute("orderNumber", hodrSoHeader);
        return Results.success(queryOrderService.queryOrderHeaderAndLine(hodrSoHeader, pageRequest));
    }


    @ApiOperation(value = "新增订单")
    @Permission(level = ResourceLevel.SITE, permissionLogin = true)
    @GetMapping("query/addOrder")
    public ResponseEntity<List> addOrder(OrderDetailHeaderDTO orderDetailHeaderDTO,
                                    List<OrderDetailLineDTO> orderDetailLineDTOList) {
        return Results.success(createOrderService.createOrder(orderDetailHeaderDTO, orderDetailLineDTOList));
    }

    @ApiOperation(value = "更新订单")
    @Permission(level = ResourceLevel.SITE, permissionLogin = true)
    @GetMapping("query/modifyOrder")
    public ResponseEntity modifyOrder( OrderDetailHeaderDTO orderDetailHeaderDTO,
                                       List<OrderDetailLineDTO> orderDetailLineDTOList, HttpSession session) {
        String orderNumber = (String) session.getAttribute("orderNumber");
        return Results.success(updateOrderService.updateOrder(orderDetailHeaderDTO, orderDetailLineDTOList, orderNumber));
    }
}
