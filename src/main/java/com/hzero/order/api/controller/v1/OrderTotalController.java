package com.hzero.order.api.controller.v1;

import com.hzero.order.api.dto.OrderSelectPO;
import com.hzero.order.app.service.QueryOrderService;
import com.hzero.order.config.SwaggerConfig;
import com.hzero.order.domain.entity.HodrCompany;
import com.hzero.order.domain.entity.HodrCustomer;
import com.hzero.order.domain.entity.HodrItem;
import com.hzero.order.domain.repository.HodrCompanyRepository;
import com.hzero.order.domain.repository.HodrCustomerRepository;
import com.hzero.order.domain.repository.HodrItemRepository;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hzero.core.util.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Api(SwaggerConfig.TOTAL)
@RestController("orderTotalController.v1")
@RequestMapping("/v1/orderTotal")
public class OrderTotalController {

    @Autowired
    private QueryOrderService queryOrderService;
    @Autowired
    private HodrCompanyRepository hodrCompanyRepository;
    @Autowired
    private HodrCustomerRepository hodrCustomerRepository;
    @Autowired
    private HodrItemRepository hodrItemRepository;

    @ApiOperation(value = "根据选定条件查询订单信息")
    @Permission(level = ResourceLevel.SITE, permissionLogin = true)
    @GetMapping
    public ResponseEntity<List<OrderSelectPO>> queryOrderByCondition(
              OrderSelectPO orderSelectPO) {
        return Results.success(queryOrderService.queryOrderByCondition(orderSelectPO));
    }

    @ApiOperation(value = "根据公司代码或名称查询公司信息")
    @Permission(level = ResourceLevel.SITE, permissionLogin = true)
    @GetMapping("query/company")
    public ResponseEntity<HodrCompany> queryCompanyByNumberOrName(
             HodrCompany hodrCompany, HttpSession session) {
        session.setAttribute("selectedCompany",hodrCompany);
        return Results.success(hodrCompanyRepository.selectOne(hodrCompany));
    }

    @ApiOperation(value = "根据客户编码或名称查询客户信息")
    @Permission(level = ResourceLevel.SITE, permissionLogin = true)
    @GetMapping("query/customer")
    public ResponseEntity<List<HodrCustomer>> queryCustomerByNumberOrName(
             HodrCustomer hodrCustomer, PageRequest pageRequest) {
        return Results.success(hodrCustomerRepository.pageCustomer(hodrCustomer, pageRequest));
    }

    @ApiOperation(value = "根据物料描述或编码查询物料信息")
    @Permission(level = ResourceLevel.SITE, permissionLogin = true)
    @GetMapping("query/item")
    public ResponseEntity<List<HodrItem>> queryItemByCodeOrDescription(
             HodrItem hodrItem, PageRequest pageRequest) {
        return Results.success(hodrItemRepository.pageItem(hodrItem, pageRequest));
    }

    @ApiOperation(value = "查询所有公司代码和名称信息")
    @Permission(level = ResourceLevel.SITE, permissionLogin = true)
    @GetMapping("query/allCompany")
    public ResponseEntity<List<HodrCompany>> queryAllCompany(PageRequest pageRequest) {
        return Results.success(PageHelper.doPage(pageRequest, ()->hodrCompanyRepository.selectAll()));
    }

    @ApiOperation(value = "根据公司Id或名称查询客户信息")
    @Permission(level = ResourceLevel.SITE, permissionLogin = true)
    @GetMapping("query/allCustomer")
    public ResponseEntity<List<HodrCustomer>> queryAllCustomer(
            PageRequest pageRequest, HttpSession session) {
        HodrCompany selectedCompany = (HodrCompany) session.getAttribute("selectedCompany");
        return Results.success(hodrCustomerRepository.pageAllCustomer(selectedCompany, pageRequest));
    }

    @ApiOperation(value = "根据公司Id或名称查询客户信息")
    @Permission(level = ResourceLevel.SITE, permissionLogin = true)
    @GetMapping("query/allItem")
    public ResponseEntity<List<HodrItem>> queryAllItem(PageRequest pageRequest) {
        return Results.success(PageHelper.doPage(pageRequest, ()->hodrItemRepository.selectAll()));
    }
}
