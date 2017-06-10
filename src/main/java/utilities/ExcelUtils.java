package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
    
    public Sheet readExcel(String filePath, String fileName, String sheetName) throws IOException{
    File file = new File(filePath);
    FileInputStream inputStream = new FileInputStream(file);
    Workbook workbook = null;
    String fileExtension = fileName.substring(fileName.indexOf("."));
    if(fileExtension.equals(".xlsx"))
    	workbook = new XSSFWorkbook(inputStream);
    else if(fileExtension.equals(".xls"))
    	workbook = new HSSFWorkbook(inputStream);
    Sheet guru99Sheet = workbook.getSheet(sheetName);
    workbook.close();
    return guru99Sheet;   
    } 
}

