package com.hzero.order.api.dto;

import com.hzero.order.domain.entity.HodrItem;
import org.hzero.export.annotation.ExcelColumn;

import org.hzero.export.annotation.ExcelSheet;

import java.util.Date;

@ExcelSheet(zh = "订单信息")
public class OrderSelectPO {
    @ExcelColumn
    private String orderNumber;
    @ExcelColumn
    private String companyName;
    @ExcelColumn
    private String customerName;
    @ExcelColumn
    private Date orderDate;
    @ExcelColumn
    private String orderStatus;
    @ExcelColumn
    private Double totalPrice;
    @ExcelColumn
    private Long lineNumber;
    @ExcelColumn
    private String itemCode;
    @ExcelColumn
    private String itemDescription;
    @ExcelColumn
    private String orderQuantityUom;
    @ExcelColumn
    private Double orderQuantity;
    @ExcelColumn
    private Double unitSellingPrice;
    @ExcelColumn
    private Double lineAmount;
    @ExcelColumn
    private String description;

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Long getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Long lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getOrderQuantityUom() {
        return orderQuantityUom;
    }

    public void setOrderQuantityUom(String orderQuantityUom) {
        this.orderQuantityUom = orderQuantityUom;
    }

    public Double getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(Double orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public Double getUnitSellingPrice() {
        return unitSellingPrice;
    }

    public void setUnitSellingPrice(Double unitSellingPrice) {
        this.unitSellingPrice = unitSellingPrice;
    }

    public Double getLineAmount() {
        return lineAmount;
    }

    public void setLineAmount(Double lineAmount) {
        this.lineAmount = lineAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
