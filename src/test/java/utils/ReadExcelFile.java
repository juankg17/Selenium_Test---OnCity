package utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcelFile {

    public void readExcel(String filePath, String sheetName) throws IOException {
        File file = new File(filePath);
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheet(sheetName);
        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

        for (int i = 0; i <= rowCount; i++){
            XSSFRow row = sheet.getRow(i);

            for (int j = 0; j < row.getLastCellNum(); j++){
                System.out.print(row.getCell(j).getStringCellValue() + " || ");
            }
            System.out.println();
        }
    }

    public XSSFSheet getSheet(String filePath, String sheetName) throws IOException {
        File file = new File(filePath);
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheet(sheetName);
        return sheet;
    }

    public String getCellValue(String filePath, String sheetName, int rowNumber, int cellNumber) throws IOException {
        File file = new File(filePath);
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheet(sheetName);

        XSSFRow row = sheet.getRow(rowNumber);
        XSSFCell cell = row.getCell(cellNumber);

        return cell.getStringCellValue();
    }
}
