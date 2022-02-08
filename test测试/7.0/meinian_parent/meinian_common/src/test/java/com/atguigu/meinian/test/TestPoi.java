package com.atguigu.meinian.test;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//读取excel
public class TestPoi {
    //@Test
    public void readExcel() throws IOException {
        //创建工作簿
        XSSFWorkbook workbook = new XSSFWorkbook("");
        //获取工资表
        XSSFSheet sheet = workbook.getSheetAt(0);
        //遍历表对象
        for (Row row : sheet) {
            //遍历单元格对象
            for (Cell cell : row) {
                //获取单元格的值
                String value = cell.getStringCellValue();
                System.out.println("value = " + value);
            }
        }
        //关闭
        workbook.close();
    }
    //@Test
    public void exportExcel_lastRow() throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook("");
        XSSFSheet sheet = workbook.getSheetAt(0);
        //获取工作表最后一行行号
        int lastRowNum = sheet.getLastRowNum();
        for (int i = 0; i < lastRowNum; i++) {
            //获取行号
            XSSFRow row = sheet.getRow(i);
            //获取行中的单元格
            short lastCellNum = row.getLastCellNum();
            //循环获取单元格中的值
            for (short j=0;j<lastCellNum;j++){
                String value = row.getCell(j).getStringCellValue();
                System.out.println(value);
            }

        }
workbook.close();
        }


        public void importExcel() throws IOException {
        //在内存中创建一个excel文件
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("沈功波");

            //创建第一行从0开始(0)
            XSSFRow row = sheet.createRow(0);
            //给行中的每一列 设置值  列从0开始
            row.createCell(0).setCellValue("编号");
            row.createCell(1).setCellValue("姓名");
            row.createCell(2).setCellValue("年龄");

            //创建第二行(1)
            XSSFRow row1 = sheet.createRow(1);
            row1.createCell(0).setCellValue("1");
            row1.createCell(1).setCellValue("小明");
            row1.createCell(2).setCellValue("10");

            XSSFRow row2 = sheet.createRow(2);
            row2.createCell(0).setCellValue("2");
            row2.createCell(1).setCellValue("小王");
            row2.createCell(2).setCellValue("20");

            //通过流导出到磁盘中
            FileOutputStream out = new FileOutputStream("D:\\导出.xlsx");
            workbook.write(out);
            //对流
            out.flush();//刷新
            out.close();//关闭
            //对工作簿
            workbook.close();


        }
    }

