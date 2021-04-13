package com.example.easyexcel.easyexceldemo.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.handler.SheetWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteWorkbookHolder;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.example.easyexcel.easyexceldemo.dto.SysUserImportExcel;
import com.example.easyexcel.easyexceldemo.util.ExcelUtil;
import com.example.easyexcel.easyexceldemo.util.SysUserWriteHandler;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TemplateController {

    @GetMapping("/downloadExcelModel")
    public void downloadExcelModel(HttpServletResponse response) {
        String fileName = "导入模板";
        String sheetName = "模板";
        try {
//            List<SysUserImportExcel> sysUserImportExcelList = getSysUserImportExcel();
            List<SysUserImportExcel> sysUserImportExcelList = new ArrayList<>();
            //获取数字字典
//            Map<String, Map<String, String>> paramMap = redisService.mget(CommonConstants.CacheKey.REIDS_SYS_PARAM_DATA);
            Map<String, Map<String, String>> paramMap = new HashMap<>(10);
            //输出文件流
            ExcelUtil.exportExcelModel(response, fileName, sheetName, sysUserImportExcelList, SysUserImportExcel.class, new SysUserWriteHandler(paramMap));

        } catch (Exception e) {
            e.printStackTrace();
//            throw new GlobalException(ExceptionCodeEnum.FAIL.getCode(), "下载导入模板失败");
        }
    }
}
