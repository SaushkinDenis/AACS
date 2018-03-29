package practice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import static practice.ReadXLS.answerOfRemove;

public class CreateRecord {

    public static boolean createRecord(String... args) throws IOException  {
        ArrayList <String> record = new ArrayList <String>();
        String[] date = null;
        for (String data:args){  
            if(!data.isEmpty())
                if (data.contains("[")){
                    data = data.substring(1, data.length()-1);
                    record.add(data);
                }else record.add(data);
        }

        List<String> record2 = record;
        record2.remove(0);
        ReadXLS RXLS = new ReadXLS(Integer.valueOf(args[0]), record2); 
        return answerOfRemove;
    }
}

