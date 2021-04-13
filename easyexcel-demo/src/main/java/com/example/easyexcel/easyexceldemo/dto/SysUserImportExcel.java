package com.example.easyexcel.easyexceldemo.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.util.StringUtils;
import lombok.Data;

import java.util.Date;

//@HeadFontStyle(color =2)
/**
 * @author： kuangql@fadada.com
 * @date： 2020/11/27 19:53
 * @description： TODO
 */
@Data
public class SysUserImportExcel {

    private static final String bigTitle= "填写须知： \n" +
            "1.第1、2行为固定结构，不可更改；以下示例行，导入前请先删除\n" +
            "2.请严格按照填写规则输入数据，不合规的数据无法成功导入";

    @ExcelProperty(value = {bigTitle,"姓名（必填）"}, index = 0)
    private String userName;

    @ExcelProperty(value = {bigTitle,"性别（必填）"}, index = 1)
    private String userSexName;

    @ExcelProperty(value = {bigTitle,"手机号码（必填）"}, index = 2)
    private String userMobile;

    @ExcelProperty(value = {bigTitle,"出生年月（必填）"}, index = 3)
    private Date userBirthday;

    @ExcelProperty(value = {bigTitle,"工作单位(必填)"}, index = 4)
    private String deptName;

    @ExcelProperty(value = {bigTitle,"职务(必填)"}, index = 5)
    private String unitPosition;

    @ExcelProperty(value = {bigTitle,"干部类别(必填)"}, index = 6)
    private String leaderTypeName;

    @ExcelProperty(value = {bigTitle,"用户状态(必填)"}, index = 7)
    private String userStatusName;

}