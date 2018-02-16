package practice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CreateRecord {

    public static void createRecord(String... args) throws IOException  {
        ArrayList <String> record = new ArrayList <String>();
        for (String g:args){
            record.add(g);
        }

        List<String> record2 = record;
        record2.remove(0);
            ReadXLS RXLS = new ReadXLS(Integer.valueOf(args[0]), record2);  
    }
}

