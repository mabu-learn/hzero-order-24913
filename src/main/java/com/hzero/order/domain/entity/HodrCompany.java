package com.hzero.order.domain.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
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

@ApiModel("公司信息")
@ModifyAudit
@VersionAudit
@Table(name = "hodr_company")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HodrCompany extends AuditDomain {

    @Id
    @GeneratedValue
    private Long companyId;
    @Length(max = 60)
    @NotBlank
    @ApiModelProperty("公司编号")
    private String companyNumber;
    @Length(max = 240)
    @NotBlank
    @ApiModelProperty("公司名称")
    private String companyName;
    @Length(max = 1)
    @NotBlank
    @ApiModelProperty("启用标识")
    private Long enabledFlag;

    public Long getCompanyId() {
        return companyId;
    }

    public String getCompanyNumber() {
        return companyNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Long getEnableedFlag() {
        return enabledFlag;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public void setCompanyNumber(String companyNumber) {
        this.companyNumber = companyNumber;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setEnableedFlag(Long enableedFlag) {
        this.enabledFlag = enableedFlag;
    }
}
