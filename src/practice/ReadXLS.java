
package practice;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ReadXLS {
    String file = "XLS.xls";;
    public ArrayList<Integer> arrayNum = new ArrayList<Integer>();
    
    
    public ReadXLS(int sheetNum, List<String> ls) throws IOException{
        InputStream inputStream = null;
        HSSFWorkbook workBook = null;
        int rowCount;
        JOptionPane optionPane = new JOptionPane();
        UIManager.put("OptionPane.yesButtonText", "Да");
        UIManager.put("OptionPane.noButtonText", "Нет");
        optionPane.updateUI();
        
        try {
            inputStream = new FileInputStream(file);
            workBook = new HSSFWorkbook(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
       
        Sheet sheet = workBook.getSheetAt(sheetNum);        
        arrayNum = find(sheet, ls.get(0));
        if (!(arrayNum.size()==0)){
            int result = optionPane.showConfirmDialog(null, "Используемое название/ФИО уже используется. Перезаписать?", "Подтверждение удаления!", 
            optionPane.YES_NO_OPTION, optionPane.QUESTION_MESSAGE);

            switch(result){
                case JOptionPane.YES_OPTION: 
                        rowCount = (int) arrayNum.get(0);
                        Row row = sheet.createRow(rowCount);
                        for (int cellIndex = 0; cellIndex < ls.size(); cellIndex++) {
                            Cell cell = row.createCell(cellIndex);
                            cell.setCellValue(ls.get(cellIndex));
        }
                        break;
                case JOptionPane.NO_OPTION:  break;
                case JOptionPane.CLOSED_OPTION:  break;
                default: break;
	    }
 
        } else  {
            rowCount = sheet.getLastRowNum() + 1;
            Row row = sheet.createRow(rowCount);
                for (int cellIndex = 0; cellIndex < ls.size(); cellIndex++) {
                    Cell cell = row.createCell(cellIndex);
                    cell.setCellValue(ls.get(cellIndex));
        }
        }
   
       
        
       
        FileOutputStream out = new FileOutputStream(file);
        workBook.write(out);
        out.close();
    }

    public ReadXLS(int sheetNum, String findValue, boolean control) throws IOException{
        InputStream inputStream = null;
        HSSFWorkbook workBook = null;
        try {
            inputStream = new FileInputStream(file);
            workBook = new HSSFWorkbook(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
       
        Sheet sheet = workBook.getSheetAt(sheetNum);        
        arrayNum = find(sheet, findValue);
        if (!(arrayNum.size()==0)){
            for (int i = 0;i<arrayNum.size();i++){
                System.out.println(i);
             removeRow(sheet, sheet.getRow((int) arrayNum.get(i)));
       
        }
        }
        FileOutputStream out = new FileOutputStream(file);
        workBook.write(out);
        out.close();
    
    }
    public ReadXLS(int sheetNum, String findValue) throws IOException{
        InputStream inputStream = null;
        HSSFWorkbook workBook = null;
        try {
            inputStream = new FileInputStream(file);
            workBook = new HSSFWorkbook(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
       
        Sheet sheet = workBook.getSheetAt(sheetNum);        
        arrayNum = find(sheet, findValue);
        FileOutputStream out = new FileOutputStream(file);
        workBook.write(out);
        out.close();

    }
    
    
    
    public static void changeCell(String file, InputStream inputStream, Workbook workbook, int sheet, int row, int cell, String change) throws IOException{
        
        workbook.getSheetAt(sheet).getRow(row).getCell(cell).setCellValue(change);
        inputStream.close();
 
        FileOutputStream out = new FileOutputStream(file);
        workbook.write(out);
        out.close();
    }
    public static void removeRow(Sheet sheet, Row row) {
        JOptionPane optionPane = new JOptionPane();
        UIManager.put("OptionPane.yesButtonText", "Да");
        UIManager.put("OptionPane.noButtonText", "Нет");
        optionPane.updateUI();

        int result = optionPane.showConfirmDialog(null, "Используемое название/ФИО уже используется. Перезаписать?", "Подтверждение удаления!", 
	optionPane.YES_NO_OPTION, optionPane.QUESTION_MESSAGE);

        switch(result){
	    case JOptionPane.YES_OPTION: 
                    sheet.removeRow(row);
                    break;
	    case JOptionPane.NO_OPTION:  break;
	    case JOptionPane.CLOSED_OPTION:  break;
	    default: break;
	    }
        
    }
    
    public static ArrayList find(Sheet sheet, String findValue) throws IOException{
        Row record = null;
        Cell block = null;
        ArrayList<Integer> arrayNum = new ArrayList<Integer>();
        String[] chan;
        System.out.println(findValue);
        //инициализируем потоки
        
     //разбираем первый лист входного файла на объектную модель
        Iterator<Row> it = sheet.iterator();
     //проходим по всему листу
        
       
        while (it.hasNext()) {
            Row row = it.next();
            Iterator<Cell> cells = row.iterator();
            while (cells.hasNext()) {
                Cell cell = cells.next();
                if (cell.getCellType() == Cell.CELL_TYPE_STRING){
                    
                    chan = cell.getStringCellValue().toString().split(",");
                    for (String f:chan){
                    if (f.equals(findValue)){
                        arrayNum.add(cell.getRowIndex());     
                        record = row;
                        
                    }
                    }
                }  
            }
            
        }  
        return arrayNum; 
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
    
    
    
    
