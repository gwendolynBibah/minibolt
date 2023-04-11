package com.gwen.minibolt.export_data;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
@Service
public class ExcelServiceImpl implements ExcelService {
    @Override
    public ResourceDto exportExcel(ExcelMetaDataDto excelMetaDataDto) {
        Resource resource = prepareExcel(excelMetaDataDto);
        final var resourceDto = new ResourceDto();
        resourceDto.setResource(resource);
        resourceDto.setMediaType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
        return resourceDto;
    }

    private Resource prepareExcel(ExcelMetaDataDto excelMetaDataDto) {
        Workbook workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet(excelMetaDataDto.getTableName());
        prepareHeaders(workbook, sheet, excelMetaDataDto.getHeaders());
        fillTable(workbook, sheet, excelMetaDataDto.getData(), excelMetaDataDto.getHeaders());
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            workbook.write(byteArrayOutputStream);
            return new ByteArrayResource(byteArrayOutputStream.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error");
        }
    }

    private void fillTable(Workbook workbook, Sheet sheet, List<Map<String, String>> data, List<String> headers) {
        int rowNo = 1;
        Font font = workbook.createFont();
        font.setFontName("Arial");

        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setFont(font);

        for (Map<String, String> dat : data) {
            Row row = sheet.createRow(rowNo);
            for (int columnNo = 0; columnNo < headers.size(); columnNo++) {
                fillCell(sheet, row,
                        columnNo, String.valueOf(dat.get(headers.get(columnNo))),
                        cellStyle);
            }
            rowNo++;
        }

    }

    private void fillCell(Sheet sheet, Row row, int columnNo, String valueOf, CellStyle cellStyle) {
        Cell cell = row.createCell(columnNo);
        cell.setCellStyle(cellStyle);
        cell.setCellValue(valueOf);
        sheet.autoSizeColumn(columnNo);
    }

    private void prepareHeaders(Workbook workbook, Sheet sheet, List<String> headers) {
        Row headerRow = sheet.createRow(0);
        Font font = workbook.createFont();
        font.setBold(true);
        font.setFontName("Arial");

        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setFillBackgroundColor(IndexedColors.LIGHT_BLUE.index);

        int columnNo = 0;
        for (String header : headers) {
            Cell headerCell = headerRow.createCell(columnNo++);
            headerCell.setCellValue(header);
            headerCell.setCellStyle(cellStyle);
        }
    }
}
