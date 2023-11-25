package org.example.CLI;

import org.example.Logic.DatabaseFunctionality;
import org.example.Logic.Functions;

import java.sql.SQLException;
import java.util.ArrayList;


public class Execution {
    static void printStartingSentence(){
        Printing.Title();
        Printing.Menu();
    }
    static boolean executeFunction(DatabaseFunctionality db, String function) throws SQLException {
        ArrayList<ArrayList<String>> result;
        String name;
        boolean isNotOver = true;
        switch (function){
            case "help" :
                Printing.Menu();
                return isNotOver;
            case "exit" :
                Functions.exit(db);
                return !isNotOver;
            case "showLog" :
                result = Functions.showLog(db);
                Printing.printTable(result);
                return isNotOver;
            case "searchPerson" :
                name = ProgramInput.getName();
                result = Functions.searchPerson(db, name);
                Printing.printTable(result);
                return isNotOver;
            case "addDecision" :
                String date = ProgramInput.getDate();
                name = ProgramInput.getName();
                int importanceGrade = ProgramInput.getImportanceGrade();
                String description = ProgramInput.getDescription();
                Functions.addDecision(db, date, name, importanceGrade, description);
                return isNotOver;
            default:
                System.out.println("error");
                return !isNotOver;
        }
    }
}
