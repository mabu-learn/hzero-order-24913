package com.hzero.order.domain.entity;

import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.choerodon.mybatis.domain.AuditDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@ApiModel("消息订单头信息")
@ModifyAudit
@VersionAudit
@Table(name = "hodr_so_header")
public class HodrSoHeader extends AuditDomain {

    @Id
    @GeneratedValue
    private Long soHeaderId;
    @NotBlank
    @Length(max = 60)
    @ApiModelProperty("订单编号")
    private String orderNumber;
    @NotBlank
    @Length(max = 20)
    @ApiModelProperty("公司ID")
    private Long companyId;
    @NotBlank
    @ApiModelProperty("订单日期")
    private Date orderDate;
    @Length(max = 30)
    @NotBlank
    @ApiModelProperty("订单状态")
    private String orderStatus;
    @Length(max = 20)
    @NotBlank
    @ApiModelProperty("客户ID")
    private Long customerId;

    public Long getSoHeaderId() {
        return soHeaderId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setSoHeaderId(Long soHeaderId) {
        this.soHeaderId = soHeaderId;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
