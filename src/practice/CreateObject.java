package practice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CreateObject {

    public static void createObject(String...args) throws IOException{
        ArrayList <String> record = new ArrayList <String>();
        
        for (String g:args){
            record.add(g);
        }
        
        List<String> record2 = record;
        //try {
            CreateXLS CXLS = new CreateXLS(record2, "2");
        //} catch (IOException ex) {
       //     JOptionPane.showMessageDialog(null, "При создании записи (CreateXLS)", "Ошибка!", JOptionPane.ERROR_MESSAGE);
       // }
        
    }
}