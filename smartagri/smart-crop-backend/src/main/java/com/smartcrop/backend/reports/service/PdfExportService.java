package com.smartcrop.backend.reports.service;

import com.smartcrop.backend.reports.dto.*;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.*;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.properties.TextAlignment;
import org.springframework.stereotype.Service;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class PdfExportService {

    // ===== COMMON HEADER =====

    private void addHeader(Document document, String title) {

        Paragraph header = new Paragraph("SmartCrop Agriculture System")
                .setBold()
                .setFontSize(20)
                .setTextAlignment(TextAlignment.CENTER)
                .setFontColor(ColorConstants.GREEN);

        Paragraph subTitle = new Paragraph(title)
                .setBold()
                .setFontSize(16)
                .setTextAlignment(TextAlignment.CENTER);

        String date = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern(
                        "dd MMM yyyy HH:mm"));

        Paragraph datePara = new Paragraph(
                "Generated on: " + date)
                .setFontSize(10)
                .setTextAlignment(TextAlignment.RIGHT);

        document.add(header);
        document.add(subTitle);
        document.add(datePara);
        document.add(new Paragraph("\n"));
    }


    // ===== TABLE HEADER STYLE =====

    private Cell headerCell(String text) {
        return new Cell()
                .add(new Paragraph(text).setBold())
                .setBackgroundColor(ColorConstants.LIGHT_GRAY)
                .setTextAlignment(TextAlignment.CENTER);
    }


    // ================= FARM REPORT =================

    public ByteArrayInputStream exportFarmReport(
            List<FarmReportDTO> data) {

        ByteArrayOutputStream out =
                new ByteArrayOutputStream();

        try {

            PdfWriter writer = new PdfWriter(out);
            PdfDocument pdfDoc =
                    new PdfDocument(writer);
            Document document =
                    new Document(pdfDoc);

            addHeader(document, "Farm Summary Report");

            Table table = new Table(4)
                    .useAllAvailableWidth();

            table.addHeaderCell(headerCell("Farmer ID"));
            table.addHeaderCell(headerCell("Location"));
            table.addHeaderCell(headerCell("Area"));
            table.addHeaderCell(headerCell("Crop Count"));

            for (FarmReportDTO d : data) {

                table.addCell(
                        String.valueOf(d.getFarmerId()));

                table.addCell(d.getLocation());

                table.addCell(
                        String.valueOf(d.getArea()));

                table.addCell(
                        String.valueOf(
                                d.getCropCount()));
            }

            document.add(table);
            document.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(
                out.toByteArray());
    }


    // ================= DISEASE REPORT =================

    public ByteArrayInputStream exportDiseaseReport(
            List<DiseaseReportDTO> data) {

        ByteArrayOutputStream out =
                new ByteArrayOutputStream();

        try {

            PdfWriter writer = new PdfWriter(out);
            PdfDocument pdfDoc =
                    new PdfDocument(writer);
            Document document =
                    new Document(pdfDoc);

            addHeader(document,
                    "Disease Incidence Report");

            Table table = new Table(3)
                    .useAllAvailableWidth();

            table.addHeaderCell(
                    headerCell("Crop Name"));

            table.addHeaderCell(
                    headerCell("Disease Name"));

            table.addHeaderCell(
                    headerCell("Cases Reported"));

            for (DiseaseReportDTO d : data) {

                table.addCell(d.getCropName());
                table.addCell(d.getDiseaseName());
                table.addCell(
                        String.valueOf(
                                d.getCasesReported()));
            }

            document.add(table);
            document.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(
                out.toByteArray());
    }


    // ================= YIELD REPORT =================

    public ByteArrayInputStream exportYieldReport(
            List<YieldReportDTO> data) {

        ByteArrayOutputStream out =
                new ByteArrayOutputStream();

        try {

            PdfWriter writer = new PdfWriter(out);
            PdfDocument pdfDoc =
                    new PdfDocument(writer);
            Document document =
                    new Document(pdfDoc);

            addHeader(document,
                    "Yield Performance Report");

            Table table = new Table(4)
                    .useAllAvailableWidth();

            table.addHeaderCell(
                    headerCell("Crop Name"));

            table.addHeaderCell(
                    headerCell("Avg Yield"));

            table.addHeaderCell(
                    headerCell("Max Yield"));

            table.addHeaderCell(
                    headerCell("Min Yield"));

            for (YieldReportDTO d : data) {

                table.addCell(d.getCropName());
                table.addCell(
                        String.valueOf(
                                d.getAvgYield()));

                table.addCell(
                        String.valueOf(
                                d.getMaxYield()));

                table.addCell(
                        String.valueOf(
                                d.getMinYield()));
            }

            document.add(table);
            document.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(
                out.toByteArray());
    }
}
