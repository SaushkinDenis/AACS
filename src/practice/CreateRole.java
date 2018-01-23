package practice;

import java.util.Scanner;

public class CreateRole {

    public static String [] createRole(){
        Scanner scan = new Scanner(System.in);
        String NameRole;
        boolean read = true;
        String [] access = new String[3];

        String accessSt = "";

        int i = 0;

        System.out.println("Название роли:");
        NameRole = scan.nextLine();

        System.out.println("Список доступных объектов:");

        for (int j = 0; j < 3; j++) {
            access[j] = scan.nextLine();

            accessSt += access[j] + " ";

        }



        String [] recordRole = {NameRole, accessSt};
        return recordRole;
    }
}
