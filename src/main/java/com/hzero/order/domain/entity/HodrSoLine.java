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

@ModifyAudit
@ApiModel("消息订单头信息")
@VersionAudit
@Table(name = "hodr_so_line")
public class HodrSoLine extends AuditDomain {

    @Id
    @GeneratedValue
    private Long soLineId;
    @NotBlank
    @Length(max = 20)
    @ApiModelProperty("订单头ID")
    private Long soHeaderId;
    @NotBlank
    @Length(max = 10)
    @ApiModelProperty("行号")
    private Long lineNumber;
    @NotBlank
    @Length(max = 20)
    @ApiModelProperty("产品ID")
    private Long itemId;
    @NotBlank
    @Length(max = 20)
    @ApiModelProperty("数量")
    private Double orderQuantity;
    @NotBlank
    @Length(max = 60)
    @ApiModelProperty("产品单位")
    private String orderQuantityUom;
    @NotBlank
    @Length(max = 20)
    @ApiModelProperty("销售单价")
    private Double unitSellingPrice;
    @Length(max = 240)
    @ApiModelProperty("描述")
    private String description;
    @Length(max = 150)
    @ApiModelProperty("附加信息1")
    private String addition1;
    @Length(max = 150)
    @ApiModelProperty("附加信息2")
    private String addition2;
    @Length(max = 150)
    @ApiModelProperty("附加信息3")
    private String addition3;
    @Length(max = 150)
    @ApiModelProperty("附加信息4")
    private String addition4;
    @Length(max = 150)
    @ApiModelProperty("附加信息5")
    private String addition5;

    public Long getSoLineId() {
        return soLineId;
    }

    public void setSoLineId(Long soLineId) {
        this.soLineId = soLineId;
    }

    public Long getSoHeaderId() {
        return soHeaderId;
    }

    public void setSoHeaderId(Long soHeaderId) {
        this.soHeaderId = soHeaderId;
    }

    public Long getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Long lineNumber) {
        this.lineNumber = lineNumber;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Double getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(Double orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public String getOrderQuantityUom() {
        return orderQuantityUom;
    }

    public void setOrderQuantityUom(String orderQuantityUom) {
        this.orderQuantityUom = orderQuantityUom;
    }

    public Double getUnitSellingPrice() {
        return unitSellingPrice;
    }

    public void setUnitSellingPrice(Double unitSellingPrice) {
        this.unitSellingPrice = unitSellingPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String decription) {
        this.description = description;
    }

    public String getAddition1() {
        return addition1;
    }

    public void setAddition1(String addition1) {
        this.addition1 = addition1;
    }

    public String getAddition2() {
        return addition2;
    }

    public void setAddition2(String addition2) {
        this.addition2 = addition2;
    }

    public String getAddition3() {
        return addition3;
    }

    public void setAddition3(String addition3) {
        this.addition3 = addition3;
    }

    public String getAddition4() {
        return addition4;
    }

    public void setAddition4(String addition4) {
        this.addition4 = addition4;
    }

    public String getAddition5() {
        return addition5;
    }

    public void setAddition5(String addition5) {
        this.addition5 = addition5;
    }
}
