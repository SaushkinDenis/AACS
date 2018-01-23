package practice;

import java.util.ArrayList;
import java.util.Scanner;

public class CreateObject {

    public static String[] createObject(){
        Scanner scan = new Scanner(System.in);
        String NameProfile;
        ArrayList SetRule = new ArrayList();
        String[] SetRule1 = {};

        System.out.println("Название профиля:");
        NameProfile = scan.nextLine();

        System.out.println("Выберите роли:");

        SetRule.add(NameProfile);
        
        


        return SetRule1;
    }
}