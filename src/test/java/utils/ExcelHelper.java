package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class ExcelHelper {
    
    public Workbook loadWorkbook(String filePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            return new XSSFWorkbook(fis);
        }
    }
    
    public void updateCellValue(Sheet sheet, String searchValue, int searchColumn, int updateColumn, double newValue) {
        for (Row row : sheet) {
            if (row.getRowNum() == 0) continue;
            
            Cell searchCell = row.getCell(searchColumn);
            if (searchCell != null && searchValue.equals(searchCell.getStringCellValue())) {
                Cell updateCell = row.getCell(updateColumn);
                if (updateCell != null) {
                    updateCell.setCellValue(newValue);
                }
            }
        }
    }
    
    public void saveWorkbook(Workbook workbook, String filePath) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            workbook.write(fos);
        }
    }
}
