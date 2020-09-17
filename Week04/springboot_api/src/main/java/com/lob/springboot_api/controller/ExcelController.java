package com.lob.springboot_api.controller;

import com.lob.springboot_api.dto.ExcelFileDto;
import com.lob.springboot_api.service.ExcelService;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@Controller
@RequestMapping(value = "/api")
public class ExcelController {

    private final ExcelService excelService;

    public ExcelController(ExcelService excelService) {
        this.excelService = excelService;
    }


    @GetMapping("/downloadExcelFile")
    public void downloadExcelFile(HttpServletResponse response, Model model) throws IOException {
        List<ExcelFileDto> res = excelService.findAllData();
        SXSSFWorkbook workbook = excelService.MakeExcelFileDownload(res);

        OutputStream os = response.getOutputStream();

        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=downloadExcelFile.xlsx");

        workbook.write(os);
        os.flush();
        os.close();
    }

}
