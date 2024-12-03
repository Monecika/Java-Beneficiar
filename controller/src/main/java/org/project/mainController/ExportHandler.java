package org.project.mainController;

import com.itextpdf.text.Document;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import java.io.FileOutputStream;

public class ExportHandler {

    public void exportToPDF(JTable table, String filePath) {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            PdfPTable pdfTable = new PdfPTable(table.getColumnCount());
            pdfTable.setWidthPercentage(100);

            for (int i = 0; i < table.getColumnCount() - 1; i++) {
                pdfTable.addCell(new PdfPCell(new Phrase(table.getColumnName(i))));
            }

            for (int row = 0; row < table.getRowCount(); row++) {
                for (int col = 0; col < table.getColumnCount() - 1; col++) {
                    pdfTable.addCell(new PdfPCell(new Phrase(table.getValueAt(row, col).toString())));
                }
            }

            document.add(pdfTable);
            document.close();

            JOptionPane.showMessageDialog(null, "Data exported to PDF successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error exporting to PDF: " + e.getMessage());
        }
    }

    public void exportToExcel(JTable table, String filePath) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Data");

            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < table.getColumnCount() - 1; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(table.getColumnName(i));
            }

            for (int row = 0; row < table.getRowCount(); row++) {
                Row excelRow = sheet.createRow(row + 1);
                for (int col = 0; col < table.getColumnCount() - 1; col++) {
                    Cell cell = excelRow.createCell(col);
                    Object value = table.getValueAt(row, col);
                    cell.setCellValue(value == null ? "" : value.toString());
                }
            }

            try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
                workbook.write(outputStream);
            }

            JOptionPane.showMessageDialog(null, "Data exported to Excel successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error exporting to Excel: " + e.getMessage());
        }
    }
}
