package practice;

import java.util.ArrayList;
import java.util.Scanner;

public class CreateRole {

    public static String [] createRole(){
        Scanner scan = new Scanner(System.in);
        String NameRole;
        boolean read = true;
        ArrayList<String> access = new ArrayList<String>();

        String accessSt = "";

        int i = 0;

        System.out.println("Название роли:");
        NameRole = scan.nextLine();

        System.out.println("Список доступных объектов:");

        
        access.add(scan.nextLine());

            
        



        String [] recordRole = {NameRole, accessSt};
        return recordRole;
    }
}
