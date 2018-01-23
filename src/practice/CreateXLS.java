package practice;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class CreateXLS {
    
    public static void CreateXLS(String file) throws FileNotFoundException, IOException{
        Workbook wb = new HSSFWorkbook();
        
        Sheet sheet1 = wb.createSheet("Пользователи");
        Row rw = sheet1.createRow(0);
        rw.createCell(1).setCellValue("");
        
        Sheet sheet2 = wb.createSheet("Объекты");
        Sheet sheet3 = wb.createSheet("Роли");
        
        BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(file));
        wb.write(fos);
        fos.close();
    
    }
    
    
    
    public static synchronized void writeToXLS(String file, List<String> newRow, int st) throws IOException {
    Path p = Paths.get(file);
    String fileName = p.toString();

    if (!Files.exists(p)) {
        Files.createFile(p);
        try (BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(new File(fileName)))) {
            Workbook workbook = new HSSFWorkbook();
            workbook.write(fos);
            workbook.close();
        }
    }

    try (BufferedInputStream fis = new BufferedInputStream(new FileInputStream(new File(fileName)))) {

        Workbook workbook = new HSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(st);
        int rowCount = sheet.getPhysicalNumberOfRows();
        Row row = sheet.createRow(rowCount + 1);
        for (int cellIndex = 0; cellIndex < newRow.size(); cellIndex++) {
            Cell cell = row.createCell(cellIndex);
            cell.setCellValue(newRow.get(cellIndex));
        }


        try (BufferedOutputStream fio = new BufferedOutputStream(new FileOutputStream(fileName))) {
            workbook.write(fio);
        }
    }
}
}
