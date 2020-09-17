package com.lob.springboot_api.controller;

import com.lob.springboot_api.dto.ExcelResponseDto;
import com.lob.springboot_api.dto.RequestInfoDto;
import com.lob.springboot_api.service.ExcelService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.core.io.InputStreamResource;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
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
    public void downloadExcelFile(HttpServletResponse response, Model model) throws IOException {
        List<ExcelResponseDto> res = excelService.findAllData();
        SXSSFWorkbook workbook = excelService.MakeExcelFileDownload(res);

        OutputStream os = response.getOutputStream();

        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=downloadExcelFile.xlsx");

        workbook.write(os);
        os.flush();
        os.close();
    }


}
