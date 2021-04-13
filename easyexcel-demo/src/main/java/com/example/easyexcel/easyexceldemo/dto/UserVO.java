package com.example.easyexcel.easyexceldemo.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class UserVO {
    @ExcelProperty("姓名")
    private String userName;
    @ExcelProperty("邮箱")
    private String email;
    @ExcelProperty("年龄")
    private Integer age;
}