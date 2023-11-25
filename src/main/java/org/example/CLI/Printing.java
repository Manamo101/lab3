package org.example.CLI;

import java.util.ArrayList;

public class Printing {
    static void Title(){
        System.out.println("\n\t\t\tDECISION LOG\n");
    }
    static void Menu(){
        System.out.println("Available functions. Type one of those:");
        System.out.println("showLog........Show all decisions");
        System.out.println("addDecision....Add new decision");
        System.out.println("searchPerson...show decisions made by particular person");
        System.out.println("exit...........close program");
        System.out.println();
    }
    static void printTable(ArrayList<ArrayList<String>> table){

        if (table != null){
            System.out.printf("%-2s | %-10s | %-25s | %s | %s\n\n", "id", "date", "name", "importance grade", "description");
            for (ArrayList<String> record : table){
                System.out.printf("%-2s | %-8s | %-25s | %-16s | %s\n", record.get(0), record.get(1), record.get(2), record.get(3), record.get(4));
            }
        }
        else {
            System.out.println("No found data");
        }
    }
}
