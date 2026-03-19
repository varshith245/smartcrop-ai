package com.smartcrop.backend.reports.service;

import com.smartcrop.backend.reports.dto.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

@Service
public class ExcelExportService {

    // ===== FARM EXCEL =====
    public ByteArrayInputStream exportFarmExcel(
            List<FarmReportDTO> data)
            throws IOException {

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet =
                workbook.createSheet("Farm Report");

        Row header = sheet.createRow(0);

        header.createCell(0)
              .setCellValue("Farmer ID");
        header.createCell(1)
              .setCellValue("Location");
        header.createCell(2)
              .setCellValue("Area");
        header.createCell(3)
              .setCellValue("Crop Count");

        int rowIdx = 1;

        for (FarmReportDTO d : data) {

            Row row =
              sheet.createRow(rowIdx++);

            row.createCell(0)
               .setCellValue(d.getFarmerId());

            row.createCell(1)
               .setCellValue(d.getLocation());

            row.createCell(2)
               .setCellValue(d.getArea());

            row.createCell(3)
               .setCellValue(d.getCropCount());
        }

        ByteArrayOutputStream out =
                new ByteArrayOutputStream();

        workbook.write(out);
        workbook.close();

        return new ByteArrayInputStream(
                out.toByteArray());
    }
}
