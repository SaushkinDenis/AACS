
package practice;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ReadXLS {
    
    public static void changeCell(String file, int sheet, int row, int cell, String change) throws IOException{
        
        
        InputStream inputStream = null;
        HSSFWorkbook workbook = null;
      
        try {
            inputStream = new FileInputStream(file);
            workbook = new HSSFWorkbook(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        workbook.getSheetAt(sheet).getRow(row).getCell(cell).setCellValue(change);
        inputStream.close();
 
        FileOutputStream out = new FileOutputStream(file);
        workbook.write(out);
        out.close();
    }
    
    public static void removeRow(String file, InputStream inputStream, Workbook workbook, Sheet sheet, Row row) throws FileNotFoundException, IOException{
 
        sheet.removeRow(row);
        inputStream.close();
 
        FileOutputStream out = new FileOutputStream(file);
        workbook.write(out);
        out.close();
    
    }
    
    public static void find(String file, String findValue) throws IOException{
        Row result = null;

        //инициализируем потоки
        InputStream inputStream = null;
        HSSFWorkbook workBook = null;
        try {
            inputStream = new FileInputStream(file);
            workBook = new HSSFWorkbook(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
     //разбираем первый лист входного файла на объектную модель
        Sheet sheet = workBook.getSheetAt(0);
        Iterator<Row> it = sheet.iterator();
     //проходим по всему листу
        while (it.hasNext()) {
            Row row = it.next();
            Iterator<Cell> cells = row.iterator();
            while (cells.hasNext()) {
                Cell cell = cells.next();
                if (cell.getCellType() == Cell.CELL_TYPE_STRING){
                    if (cell.getStringCellValue().toString().equals(findValue)){
                       //System.out.println(cell.getRowIndex());     
                       result = row;
                    }
                }  
            }
        }
        //return result;
        removeRow(file, inputStream, workBook, sheet, result);
    }

    public static String parse(String fileName) {
    //инициализируем потоки
        String result = "";
        InputStream inputStream = null;
        HSSFWorkbook workBook = null;
        try {
            inputStream = new FileInputStream(fileName);
            workBook = new HSSFWorkbook(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
     //разбираем первый лист входного файла на объектную модель
        Sheet sheet = workBook.getSheetAt(0);
        Iterator<Row> it = sheet.iterator();
     //проходим по всему листу
        while (it.hasNext()) {
            Row row = it.next();
            Iterator<Cell> cells = row.iterator();
            while (cells.hasNext()) {
                Cell cell = cells.next();
                int cellType = cell.getCellType();
      //перебираем возможные типы ячеек
                switch (cellType) {
                    case Cell.CELL_TYPE_STRING:
                        result += cell.getStringCellValue() + ":";
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        result += " " + cell.getNumericCellValue() + "";
                        break;
 
                    case Cell.CELL_TYPE_FORMULA:
                        result += " " + cell.getNumericCellValue() + "";
                        break;
                    default:
                        result += "|";
                        break;
                }
            }
            result += "\n";
        }
 
        return result;
    }
 
}
    
    
    
    
