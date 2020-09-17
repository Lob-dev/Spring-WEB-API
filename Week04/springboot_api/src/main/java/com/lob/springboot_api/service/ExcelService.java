package com.lob.springboot_api.service;

import com.lob.springboot_api.Repository.RequestApiRepository;
import com.lob.springboot_api.dto.ExcelResponseDto;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Transactional
@Service
public class ExcelService {

    private final RequestApiRepository requestApiRepository;

    public ExcelService(RequestApiRepository requestApiRepository) {
        this.requestApiRepository = requestApiRepository;
    }

    public SXSSFWorkbook MakeExcelFileDownload(List<ExcelResponseDto> res) {
        return this.makeExcelWorkbook(res);
    }

    public SXSSFWorkbook makeExcelWorkbook(List<ExcelResponseDto> list){
        SXSSFWorkbook workbook = new SXSSFWorkbook();
        SXSSFSheet sheet = workbook.createSheet("API 접속자 통계");

        sheet.setColumnWidth(1, 4000);
        sheet.setColumnWidth(2, 4000);
        sheet.setColumnWidth(3, 4000);
        sheet.setColumnWidth(4, 4000);
        sheet.setColumnWidth(5, 4000);
        sheet.setColumnWidth(6, 4000);
        sheet.setColumnWidth(7, 4000);

        CellStyle rowStyle = workbook.createCellStyle();
        rowStyle.setAlignment(HorizontalAlignment.CENTER);
        rowStyle.setVerticalAlignment(VerticalAlignment.CENTER);

        Row headerRow = sheet.createRow(0);

        Cell headerCell = headerRow.createCell(0);
        headerCell.setCellValue("요청 수");

        headerCell = headerRow.createCell(1);
        headerCell.setCellValue("requestID");

        headerCell = headerRow.createCell(2);
        headerCell.setCellValue("requestCode");

        headerCell = headerRow.createCell(3);
        headerCell.setCellValue("userID");

        headerCell = headerRow.createCell(4);
        headerCell.setCellValue("CreateDate");

        headerCell = headerRow.createCell(5);
        headerCell.setCellValue("HR_ORGAN");

        headerCell = headerRow.createCell(6);
        headerCell.setCellValue("userName");

        headerCell = headerRow.createCell(7);
        headerCell.setCellValue("Password");

        Row bodyRow;
        Cell bodyCell = null;
        for(int i=0; i<list.size(); i++){
            ExcelResponseDto re = list.get(i);

            bodyRow = sheet.createRow(i+1);
            bodyCell = bodyRow.createCell(0);
            bodyCell.setCellValue(i + 1);

            bodyCell = bodyRow.createCell(1);
            bodyCell.setCellValue(re.getRequestID());

            bodyCell = bodyRow.createCell(2);
            bodyCell.setCellValue(re.getRequestCode());

            bodyCell = bodyRow.createCell(3);
            bodyCell.setCellValue(re.getUserID());

            bodyCell = bodyRow.createCell(4);
            bodyCell.setCellValue(re.getCreateDate());

            bodyCell = bodyRow.createCell(5);
            bodyCell.setCellValue(re.getHr_Organ());

            bodyCell = bodyRow.createCell(6);
            bodyCell.setCellValue(re.getUsername());

            bodyCell = bodyRow.createCell(7);
            bodyCell.setCellValue(re.getPassword());

        }
        
        return workbook;
    }

    public List<ExcelResponseDto> findAllData() {
        List<ExcelResponseDto> res = requestApiRepository.findAll();
        return res;
    }
}
