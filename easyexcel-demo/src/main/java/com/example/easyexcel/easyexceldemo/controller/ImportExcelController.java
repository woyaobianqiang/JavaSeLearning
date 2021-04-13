package com.example.easyexcel.easyexceldemo.controller;

import com.example.easyexcel.easyexceldemo.dto.ImportModel;
import com.example.easyexcel.easyexceldemo.util.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RequestMapping("/excel")
@RestController
public class ImportExcelController {

    @Autowired
    private ExcelUtil excelUtil;

    //导入excel
    @RequestMapping(value = "excelImport", method = {RequestMethod.GET, RequestMethod.POST})
    public void excelImport(Model model, @RequestParam("file") MultipartFile file) throws Exception {
        if (file != null) {
//            MultipartFile file = files[0];
            List<Object> result = ExcelUtil.readExcel(file, new ImportModel(), 1, 1);
//            Boolean flag = (Boolean) result.get("flag");
//            List<Object> list = (List<Object>) result.get("datas");
            if (result != null && result.size() > 0) {
//                for (Object o : result) {
//                    ImportModel importModel = (ImportModel) o;
//                    System.out.println(importModel.getBusinessType() + "/" + importModel.getCustomerBusiness() + "/" + importModel.getCustomerCompany());
//                }
                for (int i = 0; i < result.size() - 1; i++) {
                    ImportModel importModel = (ImportModel) result.get(i);
                    System.out.println(importModel.getBusinessType() + "/" + importModel.getCustomerBusiness() + "/" + importModel.getCustomerCompany());
                }
            }

        }
    }

}
