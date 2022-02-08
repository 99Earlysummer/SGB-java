package com.atguigu.meinian.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.meinian.constant.MessageConstant;
import com.atguigu.meinian.entity.Result;
import com.atguigu.meinian.service.MemberService;
import com.atguigu.meinian.service.ReportService;
import com.atguigu.meinian.service.SetmealService;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Target;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/report")
public class ReportController {
    @Reference
    private MemberService memberService;
    @Reference
    private ReportService reportService;
    @Reference
    private SetmealService setmealService;

    /**
     * 折线图(统计会员注册数量)
     *
     * @return
     */
    @RequestMapping("/getMemberCountByMonth")
    public Result getMemberCountByMonth() {
        // 获取日历对象
        Calendar calendar = Calendar.getInstance();
        //根据当前时间，获取前12个月的日历(当前日历2020-02，12个月前，日历时间2019-03)
        //第一个参数，日历字段
        //第二个参数，要添加到字段中的日期或时间
        calendar.add(Calendar.MONTH, -12);

        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 12; i++) {
            //第一个参数是月份 2018-7
            //第二个参数是月份+1个月
            calendar.add(Calendar.MONTH, 1);
            list.add(new SimpleDateFormat("yyyy-MM").format(calendar.getTime()));
        }

        Map<String, Object> map = new HashMap<String, Object>();
        // 把过去12个月的日期存储到map里面
        map.put("months", list);
        // 查询所有的会员
        List<Integer> memberCount = memberService.findMemberCountByMonth(list);
        map.put("memberCount", memberCount);
        return new Result(true, MessageConstant.GET_MEMBER_NUMBER_REPORT_SUCCESS, map);
    }

    /**
     * getBusinessReportData运营数据统计
     *
     * @param
     */
    // 运营数据统计（页面）
    @RequestMapping(value = "/getBusinessReportData")
    public Result getBusinessReportData() {
        try {
            Map<String, Object> map = reportService.getBusinessReportData();
            return new Result(true, MessageConstant.GET_BUSINESS_REPORT_SUCCESS, map);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.GET_BUSINESS_REPORT_FAIL);
        }
    }

    /* 统计套餐预约人数占比（饼图）getSetmealReport*/
    @RequestMapping("/getSetmealReport")
    public Result getSetmealReport() {
        //获取预约的所有套餐的名称和数量
        List<Map> list = setmealService.getSetmealData();
        return new Result(true, MessageConstant.GET_SETMEAL_COUNT_REPORT_SUCCESS, list);
    }


    @RequestMapping("/exportBusinessReport")
    public void exportBusinessReport(HttpServletRequest request, HttpServletResponse response) {
        try {
            //获取运营数据
            Map result = reportService.getBusinessReportData();
            String reportDate = (String) result.get("reportDate");
            Integer todayNewMember = (Integer) result.get("todayNewMember");
            Integer totalMember = (Integer) result.get("totalMember");
            Integer thisWeekNewMember = (Integer) result.get("thisWeekNewMember");
            Integer thisMonthNewMember = (Integer) result.get("thisMonthNewMember");
            Integer todayOrderNumber = (Integer) result.get("todayOrderNumber");
            Integer thisWeekOrderNumber = (Integer) result.get("thisWeekOrderNumber");
            Integer thisMonthOrderNumber = (Integer) result.get("thisMonthOrderNumber");
            Integer todayVisitsNumber = (Integer) result.get("todayVisitsNumber");
            Integer thisWeekVisitsNumber = (Integer) result.get("thisWeekVisitsNumber");
            Integer thisMonthVisitsNumber = (Integer) result.get("thisMonthVisitsNumber");
            List<Map> hotSetmeal = (List<Map>) result.get("hotSetmeal");
            //获取模板文件的路径（D:\IDEA\workspace\WH1018\meinian_parent\meinian_web\src\main\webapp\template\report_template.xlsx）
            String templateFilePath = request.getSession().getServletContext().getRealPath("template") + File.separator + "report_template.xlsx";
            //读取模板excel文件
            XSSFWorkbook workbook = new XSSFWorkbook(templateFilePath);
            //获取工作表对象
            XSSFSheet sheet = workbook.getSheetAt(0);
            sheet.getRow(2).getCell(5).setCellValue(reportDate);
            sheet.getRow(4).getCell(5).setCellValue(todayNewMember);
            sheet.getRow(4).getCell(7).setCellValue(totalMember);
            sheet.getRow(5).getCell(5).setCellValue(thisWeekNewMember);
            sheet.getRow(5).getCell(7).setCellValue(thisMonthNewMember);
            sheet.getRow(7).getCell(5).setCellValue(todayOrderNumber);
            sheet.getRow(7).getCell(7).setCellValue(todayVisitsNumber);
            sheet.getRow(8).getCell(5).setCellValue(thisWeekOrderNumber);
            sheet.getRow(8).getCell(7).setCellValue(thisWeekVisitsNumber);
            sheet.getRow(9).getCell(5).setCellValue(thisMonthOrderNumber);
            sheet.getRow(9).getCell(7).setCellValue(thisMonthVisitsNumber);
            int num = 12;
            for (Map map : hotSetmeal) {
                String name = (String) map.get("name");
                Long setmeal_count = (Long) map.get("setmeal_count");
                BigDecimal proportion = (BigDecimal) map.get("proportion");
                sheet.getRow(num).getCell(4).setCellValue(name);
                sheet.getRow(num).getCell(5).setCellValue(setmeal_count);
                sheet.getRow(num).getCell(6).setCellValue(proportion.doubleValue());
                num++;
            }
            //设置响应到浏览器的内容格式(excel文件)
            response.setContentType("application/vnd.ms-excel");
            //设置下载方式
            response.setHeader("content-Disposition", "attachment;filename=report.xlsx");
            //获取响应输出流
            ServletOutputStream os = response.getOutputStream();
            //将工作簿所对应的文件响应到浏览器
            workbook.write(os);
            os.close();
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}





 /*   @RequestMapping("/exprotBusinessReport")//getSetmealReport
    public void exprotBusinessReport(HttpServletRequest request, HttpServletResponse response){
    try {
        Map map=reportService.exprotBusinessRepor
;        //获取文件真实路径
        String realPath = request.getSession().getServletContext().getRealPath("template"+ File.separator+report_template.xlsx);
        //
        XSSFWorkbook workbook=new XSSFWorkbook(realPath);
        //将文件中的工作簿读取-----读取模板工作簿
        XSSFSheet sheetAt = workbook.getSheetAt(0);
        sheetAt.getRow(2).getCell(5);
        sheetAt.getRow(4).getCell(5);
        sheetAt.getRow(4).getCell(7);
        sheetAt.getRow(5).getCell(5);
        sheetAt.getRow(5).getCell(7);
        sheetAt.getRow(7).getCell(5);
        sheetAt.getRow(7).getCell(7);
        sheetAt.getRow(8).getCell(5);
        sheetAt.getRow(8).getCell(7);
        sheetAt.getRow(9).getCell(5);
        sheetAt.getRow(9).getCell(7);
int num =12;
for (Map map:hotSetmeal){
            String name = (String) map.get("name");
            String setmeal = (String) map.get("setmeal");
            map.get("propaer");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
response.set

}
*/


