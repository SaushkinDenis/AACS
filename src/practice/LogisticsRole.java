package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import static practice.ReadXLS.answerOfRemove;
import practice.Windows.WindowCreateRecord;
import practice.Windows.WindowCreateRole;

public class LogisticsRole {
    //public String file = "XLS.xls";
    public static String setRole(String... roleThings) throws IOException{
        ArrayList<ArrayList> stems = new ArrayList();
        int count = 0;
        int maxcount = 0;
        int posit = 0;
        ArrayList setrole = new ArrayList();
        ReadXLS RXLS;
        ArrayList controlCollection = new ArrayList();
        
        for (String roleThing:roleThings){
            RXLS = new ReadXLS(1, roleThing);
            stems.add(RXLS.arrayNum);
        }
        ArrayList<Integer> resultMerge = getMergedList(stems.get(0),stems.get(1), stems.get(2));
        
        for (int i=0;i<resultMerge.size();i++){
            if(!(controlCollection.contains(resultMerge.get(i)))){
                controlCollection.add(resultMerge.get(i));
                count = Collections.frequency(resultMerge, resultMerge.get(i));
                if (count > maxcount) {
                    maxcount = count;
                    posit = resultMerge.get(i);

                }else if(count == maxcount){
                    posit = 0;
                }
            }
        }
        if(posit == 0){
            JOptionPane optionPaneCreateOrChoise = new JOptionPane();
            UIManager.put("OptionPane.yesButtonText", "Создать");
            UIManager.put("OptionPane.noButtonText", "Выбрать роль");
            optionPaneCreateOrChoise.updateUI();
            
            int result = optionPaneCreateOrChoise.showConfirmDialog(null, "Система не подобрала пользователю роль. Создайте или выберите роль из уже существующих.", "Ошибка", 
            optionPaneCreateOrChoise.YES_NO_OPTION, optionPaneCreateOrChoise.QUESTION_MESSAGE);

            switch(result){
                case JOptionPane.YES_OPTION: 
                    WindowCreateRole.main();
                    break;
                case JOptionPane.NO_OPTION:        
                    try {
                        RXLS = new ReadXLS(1,0,"",0);
                        if(RXLS.srt.length == 0){
                            JOptionPane optionPaneCreate = new JOptionPane();
                            UIManager.put("OptionPane.yesButtonText", "Создать");
                            UIManager.put("OptionPane.noButtonText", "Отмена");
                            optionPaneCreate.updateUI();
                            result = optionPaneCreate.showConfirmDialog(null, "Роли отсутствуют.", "Ошибка", 
                            optionPaneCreate.YES_NO_OPTION, optionPaneCreate.QUESTION_MESSAGE); 
                            switch(result){
                                case JOptionPane.YES_OPTION: 
                                    WindowCreateRole.main();
                                    break;
                                case JOptionPane.NO_OPTION: 
                                    break;
                            }
                                          
                        }else {
                            for (String item:RXLS.srt){
                                setrole.add(item);
                            }
                            Object changeRole = JOptionPane.showInputDialog(null,"Выберите роль","Выбор роли",JOptionPane.QUESTION_MESSAGE, null, setrole.toArray(), setrole.get(0) );
                            String role = (String) changeRole; 
                            RXLS = new ReadXLS(1,role);
                            posit = RXLS.arrayNum.get(0);
                            return parseRole(posit);
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(WindowCreateRecord.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;   
                
                case JOptionPane.CLOSED_OPTION:  break;
                default: break;
                }
            return "";
        } else return parseRole(posit);
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