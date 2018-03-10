package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;

public class LogisticsRole {
    //public String file = "XLS.xls";
    public static String setRole(String... roleThings) throws IOException{
        ArrayList<ArrayList> stems = new ArrayList<ArrayList>();
        int count;
        int maxcount = 0;
        int posit = 0;
        for (String roleThing:roleThings){
            ReadXLS RXLS = new ReadXLS(1, roleThing);
            stems.add(RXLS.arrayNum);

        }
        ArrayList<Integer> resultMerge = getMergedList(stems.get(0),stems.get(1), stems.get(2));
        
        for (int i=0;i<resultMerge.size();i++){
            count = Collections.frequency(resultMerge, resultMerge.get(i));
            if (count>=maxcount) {
                maxcount = count;
                posit = resultMerge.get(i);
                
            }
        }
        return parseRole(posit);
        
    }
    
    
    
    public static ArrayList<String> getMergedList(ArrayList<String> a, ArrayList<String> b, ArrayList<String> c) {
        final ArrayList<String> d = new ArrayList<>(a.size() + b.size() + c.size());
        final Iterator<String> itA = a.iterator();
        final Iterator<String> itB = b.iterator();
        final Iterator<String> itC = c.iterator();
        while (true) {
            int q = 0;
            if (itA.hasNext()) {
                d.add(itA.next());
                q++;
            }
            if (itB.hasNext()) {
                d.add(itB.next());
                q++;
            }
            if (itC.hasNext()) {
                d.add(itC.next());
                q++;
            }
            if (q == 0) break;
        }
        return d;
    }
    public static String parseRole(int posit){  
    String result = "";
        InputStream inputStream = null;
        HSSFWorkbook workBook = null;
        try {
            inputStream = new FileInputStream("XLS.xls");
            workBook = new HSSFWorkbook(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    result = workBook.getSheetAt(1).getRow(posit).getCell(0).toString();
    return result;
    }

}