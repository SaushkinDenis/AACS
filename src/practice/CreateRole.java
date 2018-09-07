package practice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CreateRole {

    public static void createRole(String... args){
        ArrayList <String> record = new ArrayList <String>();
        
        for (String g:args){
            record.add(g);
        }
        
        List<String> record2 = record;
        try {
            CreateXLS CXLS = new CreateXLS(record2, args[0]);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "При создании записи (CreateXLS)", "Ошибка!", JOptionPane.ERROR_MESSAGE);
        }
        
    }
}
