package org.example.CLI;

import org.apache.commons.validator.GenericValidator;

import java.util.Arrays;
import java.util.Scanner;

class ProgramInput {
    static String getFunction() {
        boolean first = true;
        Scanner scanner;
        String word;
        do{
            if (first){
                first = false;
            }
            else{
                System.out.println("function is not recognized. Type \"help\" to show available functions");
            }
            System.out.print("Type function: ");
            scanner = new Scanner(System.in);
            word = scanner.nextLine().trim();
        }
        while (!functionIsGood(word));
        return word;
    }
    private static boolean functionIsGood(String word) {
        String[] availableFunctions = new String[] {"exit", "help", "showLog", "addDecision", "searchPerson"};
        return Arrays.asList(availableFunctions).contains(word);
    }
    static String getName(){
        Scanner scanner;
        String name;
        boolean first = true;
        do{
            if (first){
                System.out.print("Type name (max 25 words): ");
                first = false;
            }
            else{
                System.out.print("Name is too long. Type type name again (max 25 words): ");
            }
            scanner = new Scanner(System.in);
            name = scanner.nextLine().trim();
        }
        while (name.length() > 25);
        return name;
    }
    static String getDate(){
        Scanner scanner;
        String date;
        boolean first = true;

        do {
            if (first) {
                System.out.print("Type date [YYYY-MM-DD]: ");
                first = false;
            } else {
                System.out.print("Invalid date. Type again [YYYY-MM-DD]:");
            }
            scanner = new Scanner(System.in);
            date = scanner.nextLine().trim();
        }
        while (!GenericValidator.isDate(date, "yyyy-MM-dd", true));
        return date;
    }
    static int getImportanceGrade(){
        Scanner scanner;
        int grade=-1;
        boolean first = true;
        boolean isValid;
        do {
            if (first) {
                System.out.print("Type importance grade (1-5): ");
                first = false;
            } else {
                System.out.print("Invalid grade. Type again (1-5):");
            }
            scanner = new Scanner(System.in);
            try{
                grade = Integer.parseInt(scanner.nextLine().trim());
                isValid = grade >= 1 && grade <=5;
            }
            catch (NumberFormatException e){
                isValid = false;
            }
        }
        while (!isValid);
        return grade;
    }
    static String getDescription(){
        System.out.print("Type description: ");
        return new Scanner(System.in).nextLine().trim();
    }
}
