package com.hzero.order.domain.entity;

import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.choerodon.mybatis.domain.AuditDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import org.hzero.core.util.Regexs;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;

@ApiModel("物料信息")
@VersionAudit
@ModifyAudit
@Table(name = "hodr_item")
public class HodrItem extends AuditDomain {

    @Id
    @GeneratedValue
    private Long itemId;
    @Length(max = 60)
    @NotBlank
    @ApiModelProperty("物料编码")
    private String itemCode;
    @Length(max = 60)
    @NotBlank
    @ApiModelProperty("物料单位")
    private String itemUom;
    @Length(max = 240)
    @NotBlank
    @ApiModelProperty("物料描述")
    private String itemDescription;
    @Length(max = 1)
    @NotBlank
    @ApiModelProperty("可销售标识")
    private Long saleableFlag;
    @ApiModelProperty("生效起始日期")
    @Pattern(regexp = Regexs.DATE)
    private Date startActiveDate;
    @ApiModelProperty("生效结束时间")
    @Pattern(regexp = Regexs.DATE)
    private Date endActiveDate;
    @Length(max = 1)
    @NotBlank
    @ApiModelProperty("启用标识")
    private Long enabledFlag;

    public Long getItemId() {
        return itemId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public String getItemUom() {
        return itemUom;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public Long getSaleableFlag() {
        return saleableFlag;
    }

    public Date getStartActiveDate() {
        return startActiveDate;
    }

    public Date getEndActiveDate() {
        return endActiveDate;
    }

    public Long getEnableFlag() {
        return enabledFlag;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public void setItemUom(String itemUom) {
        this.itemUom = itemUom;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public void setSaleableFlag(Long saleableFlag) {
        this.saleableFlag = saleableFlag;
    }

    public void setStartActiveDate(Date startActiveDate) {
        this.startActiveDate = startActiveDate;
    }

    public void setEndActiveDate(Date endActiveDate) {
        this.endActiveDate = endActiveDate;
    }

    public void setEnableFlag(Long enableFlag) {
        this.enabledFlag = enableFlag;
    }
}
