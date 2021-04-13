package com.example.easyexcel.easyexceldemo.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author admin
 */
@Data
public class ImportModel extends BaseRowModel {

    @ExcelProperty(index = 0, value = "月份")
    private String dataDate;

    @ExcelProperty(index = 1, value = "供应商有无后台")
    private String supplierHasBack;

    @ExcelProperty(index = 2, value = "供应商预付/后付")
    private String supplierPaymentType;

//    @ExcelProperty(index = 3, value = "项目编号")
    //项目编号
//    @ExcelProperty(index = 4, value = "项目名称")
    //项目名称

    @ExcelProperty(index = 3, value = "产品名称")
    private String productName;

    //产品接入部门
//    @ExcelProperty(index = 6, value = "产品接入部门")
    //事业部
//    @ExcelProperty(index = 7, value = "事业部")

    @ExcelProperty(index = 4, value = "运营类型")
    private String operationType;

    @ExcelProperty(index = 5, value = "业务类型")
    private String businessType;

    //供应商大类
//    @ExcelProperty(index = 10, value = "供应商大类")
    //供应商小类
//    @ExcelProperty(index = 11, value = "供应商小类")

    @ExcelProperty(index = 6, value = "供应商名称")
    private String supplierName;

    //积分通道名称
//    @ExcelProperty(index = 13, value = "积分通道名称")

    @ExcelProperty(index = 7, value = "运营归属")
    private String operator;

    @ExcelProperty(index = 8, value = "供应商商务")
    private String supplierBusiness;

    @ExcelProperty(index = 9, value = "客户商务")
    private String customerBusiness;

    //成本价
    @ExcelProperty(index = 10, value = "成本价（元）")
    private String initPrice;

    //销售价
    @ExcelProperty(index = 11, value = "销售价（元）")
    private String outPrice;

//    @ExcelProperty(index = 19, value = "供应商结算方式")
//    private String customerName;

    //供应商结算方式
    @ExcelProperty(index = 12, value = "供应商结算方式")
    private String settlementMethod;

    //客户结算方式
    @ExcelProperty(index = 13, value = "客户结算方式")
    private String outSettlementMethod;

    //应付数据
    @ExcelProperty(index = 14, value = "应付数据")
    private String payableData;

    //应收数据
    @ExcelProperty(index = 15, value = "应收数据")
    private String receivableData;

    //应付金额
    @ExcelProperty(index = 16, value = "应付金额（元）")
    private String payableMoney;

    //应收金额
    @ExcelProperty(index = 17, value = "应收金额（元）")
    private String receivableMoney;

    //毛利
    @ExcelProperty(index = 18, value = "毛利（元）")
    private String profit;

    //供应商税点
//    @ExcelProperty(index = 26, value = "供应商产品税点(%)")
    //积分通道税点
//    @ExcelProperty(index = 27, value = "积分通道税点(%)")

    //客户公司名称
    @ExcelProperty(index = 19, value = "客户公司名称")
    private String customerCompany;

    //开票主体
    @ExcelProperty(index = 20, value = "开票主体")
    private String partnerCompany;

    //供应商公司名称
    @ExcelProperty(index = 21, value = "供应商公司名称")
    private String supplierCompany;

    //付款主体
    @ExcelProperty(index = 22, value = "付款主体")
    private String payCompany;

//    private BigDecimal supplierDiscount;
//
//    private BigDecimal outDiscount;
//
//    private BigDecimal inPrice;
//
//    private BigDecimal flow;
//
//    private String lastOperator;
//
//    private Date createTime;
//
//    private Date updateTime;

}
