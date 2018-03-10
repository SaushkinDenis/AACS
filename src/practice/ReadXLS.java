package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class ReadXLS {
    protected String file = "XLS.xls";
    public ArrayList<Integer> arrayNum = new ArrayList<>();
    public String[] srt;
    public boolean fact;
    protected InputStream inputStream;
    protected HSSFWorkbook workBook;
    protected FileOutputStream outputStream;
    
    public void openStream() throws FileNotFoundException, IOException{
        this.inputStream = new FileInputStream(file);;
        this.workBook = new HSSFWorkbook(inputStream);
    }
    
    public void closeStream() throws FileNotFoundException, IOException{
        this.outputStream = new FileOutputStream(file);
        this.workBook.write(outputStream);
        this.inputStream.close();
        this.outputStream.close();
    }
    
    public ReadXLS(int sheetNum, List<String> ls) throws IOException{
        
        int rowCount;
        JOptionPane optionPane = new JOptionPane();
        UIManager.put("OptionPane.yesButtonText", "Да");
        UIManager.put("OptionPane.noButtonText", "Нет");
        optionPane.updateUI();
        openStream();
       
        Sheet sheet = workBook.getSheetAt(sheetNum);        
        arrayNum = find(sheet, ls.get(0));
        
        if (!arrayNum.isEmpty()){
            int result = JOptionPane.showConfirmDialog(null, "Используемое название/ФИО уже используется. Перезаписать?", "Подтверждение удаления!", 
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            switch(result){
                case JOptionPane.YES_OPTION: 
                    rowCount = (int) arrayNum.get(0);
                    Row row = sheet.createRow(rowCount);
                    for (int cellIndex = 0; cellIndex < ls.size(); cellIndex++) {
                        Cell cell = row.createCell(cellIndex);
                        cell.setCellValue(ls.get(cellIndex));
                    }
                    break;
                case JOptionPane.NO_OPTION:  
                    break;
                case JOptionPane.CLOSED_OPTION:  
                    break;
                default: 
                    break;
	    }
 
        } else  {
            rowCount = sheet.getLastRowNum() + 1;
            Row row = sheet.createRow(rowCount);
            for (int cellIndex = 0; cellIndex < ls.size(); cellIndex++) {
                Cell cell = row.createCell(cellIndex);
                cell.setCellValue(ls.get(cellIndex));
            }
        }

        closeStream();
    }

    public ReadXLS(int sheetNum, String findValue, boolean control) throws IOException{ // Удаление строки по номеру страницы, имени строки и true
       
        fact = false;
        openStream();
       
        Sheet sheet = workBook.getSheetAt(sheetNum);        
        arrayNum = find(sheet, findValue);
        String text = "Подтвердите удаление записи.";
        
        if (!(arrayNum.isEmpty())){
            for (Integer arrayNum1 : arrayNum) {
                fact = removeRow(sheet, sheet.getRow((int) arrayNum1), text);
            }
        }
        
        closeStream();
    }
    
    public ReadXLS(int sheetNum, String findValue) throws IOException{
       
        openStream();
       
        Sheet sheet = workBook.getSheetAt(sheetNum);        
        arrayNum = find(sheet, findValue);
        closeStream();

    }
    
    public ReadXLS(int sheetNum, int numCell, String sort, int numCellPin) throws IOException{  // Поиск sort на позиции numCell на странице sheetNum и вывод ячейки numCellPin 
        //инициализируем потоки
        openStream();
       
        Sheet sheet = workBook.getSheetAt(sheetNum);
        ArrayList<String> st = parse(sheet, numCell, sort, numCellPin);
        srt = new String[st.size()];
        for (int i = 0; i < st.size(); i++){
            srt[i] = st.get(i);
        }
        
        closeStream();

    }
    
    public ReadXLS(int sheetNum, int numRow, int numCellChange, String changeValue) throws IOException{
        
        openStream();
        workBook.getSheetAt(sheetNum).getRow(numRow).getCell(numCellChange).setCellValue(changeValue);
        closeStream();
    }

    public static boolean removeRow(Sheet sheet, Row row, String text) {
        
        JOptionPane optionPane = new JOptionPane();
        UIManager.put("OptionPane.yesButtonText", "Да");
        UIManager.put("OptionPane.noButtonText", "Нет");
        optionPane.updateUI();
        boolean fact = false; 
        int result = JOptionPane.showConfirmDialog(null, text, "Подтверждение редактирования!", 
	JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        switch(result){
	    case JOptionPane.YES_OPTION: 
                sheet.removeRow(row);
                fact = true;
                break;
	    case JOptionPane.NO_OPTION: 
                fact = false; 
                break;
	    case JOptionPane.CLOSED_OPTION:  break;
	    default: break;
	    }
        
        return fact;
    }
    
    public static ArrayList find(Sheet sheet, String findValue) throws IOException{

        ArrayList<Integer> arrayNum = new ArrayList<Integer>();
        String[] chan;
   
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
                    }
                    }
                }  
            }
            
        }  
        return arrayNum; 
    }

    public static ArrayList parse(Sheet sheet, int numCell, String sort, int numCellPin) {

        ArrayList result = new ArrayList();
     //разбираем первый лист входного файла на объектную модель
       
        Iterator<Row> it = sheet.iterator();
     //проходим по всему листу
        while (it.hasNext()) {
            Row row = it.next();
            Iterator<Cell> cells = row.iterator();
            //while (cells.hasNext()) {
                //Cell cell = cells.next();
                Cell cell = row.getCell(numCell);
                    int cellType = cell.getCellType();
                        //перебираем возможные типы ячеек
                    switch (cellType) {
                        case Cell.CELL_TYPE_STRING:
                            if (sort == ""){
                                result.add(cell.getStringCellValue() + "");
                            }else if (cell.getStringCellValue().equals(sort)) {
                                result.add(row.getCell(numCellPin).getStringCellValue());
                            }
                            break;
                        case Cell.CELL_TYPE_NUMERIC:
                            result.add(cell.getNumericCellValue() + "");
                            break;

                        case Cell.CELL_TYPE_FORMULA:
                            result.add(cell.getNumericCellValue() + "");
                            break;
                        default:
                            result.add("");
                            break;
                    //}
                }

            }
        
        return result;
    }
 
}
    
    
    
    
