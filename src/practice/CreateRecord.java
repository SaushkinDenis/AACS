package practice;

import java.util.Scanner;

public class CreateRecord {

    public static String[] createRecord(){
        String Name, surName, lastName, profession, activity, rule;
        Scanner scan = new Scanner(System.in, "Cp1251");


        System.out.println("Создание профиля!");

        System.out.println("Имя:");
        Name = scan.nextLine();

        System.out.println("Фамилия:");
        surName = scan.nextLine();

        System.out.println("Отчество:");
        lastName = scan.nextLine();

        System.out.println("Занимаемая должность:");
        profession = scan.nextLine();

        System.out.println("Направление деятельности:");
        activity = scan.nextLine();

        System.out.println("Права доступа:");
        rule = scan.nextLine();

        String[] record = {Name, surName, lastName, profession, activity, rule};

        return record;

    }
}

