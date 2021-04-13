package com.example.easyexcel.easyexceldemo.controller;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.example.easyexcel.easyexceldemo.dto.ExportUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequestMapping("/excel")
@RestController
public class ExcelController {

    /**
     * 生成文件、下载文件
     * @param request
     * @param response
     */
    @GetMapping("/down")
    public void downloadExcel(HttpServletRequest request, HttpServletResponse response){
//        List<ExportUser> data = getExcelModelData();
        List<ExportUser> data = new ArrayList<>();
        OutputStream out = null;
        ExcelWriter excelWriter = null;
        try {
            out = response.getOutputStream();
            //设置ConetentType CharacterEncoding Header,需要在excelWriter.write()之前设置
            response.setContentType("mutipart/form-data");
            response.setCharacterEncoding("utf-8");
            response.setHeader("Content-disposition","attachment;filename=test.xlsx");

            excelWriter = new ExcelWriter(out, ExcelTypeEnum.XLSX);
            Sheet sheet = new Sheet(0);
            sheet.setSheetName("sheet");
            sheet.setClazz(data.get(0).getClass());
            excelWriter.write(data,sheet);
            excelWriter.finish();
            out.flush();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                out.close();
            }catch (Exception e){
                e.printStackTrace();
            }

        }

    }

    /**
     * 获取实体对象数据
     * @return
     */
    private List<ExportUser> getExcelModelData(){
        List<ExportUser> users = new ArrayList<ExportUser>();
        for(int i=0; i <= 10;i++){
            ExportUser user = new ExportUser();
            user.setName("name" + i);
            user.setAge("age" + i);
            user.setEmail("email" + i);
            user.setAddress("address" + i);
            user.setSax("sax" + i);
            user.setHeigh("heigh" + i);
            user.setLast("last" + i);
            user.setBitthday(new Date());
            users.add(user);
        }
        return users;
    }

}
