package com.example.easyexcel.easyexceldemo.util;

import com.alibaba.excel.write.handler.SheetWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteWorkbookHolder;
import io.netty.util.internal.ObjectUtil;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.DataValidationConstraint;
import org.apache.poi.ss.usermodel.DataValidationHelper;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SysUserWriteHandler implements SheetWriteHandler {

    private Map<String, Map<String, String>> paramMap = null;

    public SysUserWriteHandler() {}

    public SysUserWriteHandler(Map<String, Map<String, String>> paramMap) {
        this.paramMap = paramMap;
    }

    @Override
    public void beforeSheetCreate(WriteWorkbookHolder writeWorkbookHolder, WriteSheetHolder writeSheetHolder) {

    }

    @Override
    public void afterSheetCreate(WriteWorkbookHolder writeWorkbookHolder, WriteSheetHolder writeSheetHolder) {
        //性别
//        Map<String, String> userSexMap = paramMap.get("userSexName");
//        //过滤key为-1的值
//        Map<String, String> newUserSexMap = userSexMap.entrySet().stream().filter(map -> ObjectUtils.not(CommonConstants.TOP_KEY, map.getKey()))
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
//        //名称转成数组
//        List<String> userSexList = newUserSexMap.values().stream().collect(Collectors.toList());
//        String[] userSex = userSexList.toArray(new String[userSexList.size()]);
//
//        //干部类别
//        Map<String, String> leaderTypeMap = paramMap.get(SysParamConstants.USER_LEADER_TYPE);
//        //过滤key为-1的值
//        Map<String, String> newLeaderTypeMap = leaderTypeMap.entrySet().stream().filter(map -> ObjectUtil.notEqual(CommonConstants.TOP_KEY, map.getKey()))
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
//        //名称转成数组
//        List<String> leaderTypeList = newLeaderTypeMap.values().stream().collect(Collectors.toList());
//        String[] leaderType = leaderTypeList.toArray(new String[leaderTypeList.size()]);
//
//        Map<Integer,String[]> mapDropDown = new HashMap<>();
//        mapDropDown.put(1,userSex); //性别
//        mapDropDown.put(6,leaderType); //干部类别
//
//
//        Sheet sheet = writeSheetHolder.getSheet();
//
//        //设置下拉框
//        DataValidationHelper helper = sheet.getDataValidationHelper();
//
//        mapDropDown.forEach((k, v) -> {
//            // 下拉列表约束数据
//            DataValidationConstraint constraint = helper.createExplicitListConstraint(v);
//            // 设置下拉单元格的首行 末行 首列 末列
//            CellRangeAddressList rangeList = new CellRangeAddressList(2, 65536, k, k);
//            // 设置约束
//            DataValidation validation = helper.createValidation(constraint, rangeList);
//            // 阻止输入非下拉选项的值
//            validation.setErrorStyle(DataValidation.ErrorStyle.STOP);
//            validation.setShowErrorBox(true);
//            validation.setSuppressDropDownArrow(true);
//            validation.createErrorBox("提示","此值与单元格定义格式不一致");
//            // validation.createPromptBox("填写说明：","填写内容只能为下拉数据集中的单位，其他单位将会导致无法入仓");
//            sheet.addValidationData(validation);
//
//        });
    }

    /**
     * 设置模板表格的表头
     * @return
     */
    private List<List<String>> getMorningCheckHead(){
//        String bigTitle= "填写须知： \n" +
//                "1.第1、2行为固定结构，不可更改；以下示例行，导入前请先删除\n" +
//                "2.请严格按照填写规则输入数据，不合规的数据无法成功导入";
        List<List<String>> head = new ArrayList<List<String>>();
        List<String> head0 = new ArrayList<>();
//        head0.add(bigTitle);
        head0.add("姓名（必填）");
        List<String> head1 = new ArrayList<>();
//        head1.add(bigTitle);
        head1.add("性别（必填）");
        List<String> head2 = new ArrayList<>();
//        head2.add(bigTitle);
        head2.add("手机号码（必填）");
        List<String> head3 = new ArrayList<>();
//        head3.add(bigTitle);
        head3.add("出生年月（必填）");
        List<String> head4 = new ArrayList<>();
//        head4.add(bigTitle);
        head4.add("工作单位(必填)");
        List<String> head5 = new ArrayList<>();
//        head5.add(bigTitle);
        head5.add("职务(必填)");
        List<String> head6 = new ArrayList<>();head.add(head0);
        head.add(head1);
        head.add(head2);
        head.add(head3);
        head.add(head4);
        head.add(head5);

        return head;
    }


}
