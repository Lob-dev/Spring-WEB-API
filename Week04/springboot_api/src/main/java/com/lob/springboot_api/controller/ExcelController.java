package com.lob.springboot_api.controller;

import com.lob.springboot_api.dto.ExcelResponseDto;
import com.lob.springboot_api.dto.RequestInfoDto;
import com.lob.springboot_api.service.ExcelService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping(value = "/api")
public class ExcelController {

    private final ExcelService excelService;

    public ExcelController(ExcelService excelService) {
        this.excelService = excelService;
    }


    @GetMapping("/downloadExcelFile")
    public ResponseEntity<Object> downloadExcelFile(Model model) throws IOException {
        List<ExcelResponseDto> res = excelService.findAllData();
        SXSSFWorkbook workbook = excelService.MakeExcelFileDownload(res);
        System.out.println("엑셀파일 완성");
        System.out.println(workbook);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        workbook.write(out);
        ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=API 접속자 통계.xlsx");

        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(new InputStreamResource(in));
    }


}
