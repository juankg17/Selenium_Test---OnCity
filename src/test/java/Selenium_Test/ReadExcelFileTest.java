package Selenium_Test;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import utils.ReadExcelFile;

import java.io.IOException;

public class ReadExcelFileTest {
    private static ReadExcelFile readExcelFile;

    @BeforeAll
    public static void setUp(){
        readExcelFile = new ReadExcelFile();
        System.out.println("Se ejecuto el Before");
    }

    @Test
    @Disabled
    public void test() throws IOException {
        String projectPath = System.getProperty("user.dir");
        String path = projectPath + "\\src\\test\\resources\\excelfiles\\Usuarios.xlsx";
        System.out.println("path:" + path);
        readExcelFile.readExcel(path, "Hoja1");
    }

    @Test
    public void mostrarSheet() throws IOException {
        String projectPath = System.getProperty("user.dir");
        String path = projectPath + "\\src\\test\\resources\\excelfiles\\Usuarios.xlsx";
        XSSFSheet sheet = readExcelFile.getSheet(path,"Hoja1");

        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

        for (int i = 0; i <= rowCount; i++){
            XSSFRow row = sheet.getRow(i);

            for (int j = 0; j < row.getLastCellNum(); j++){
                System.out.print("Se leyo: " + row.getCell(j).getStringCellValue() + " || ");
            }
            System.out.println();
        }
    }


}