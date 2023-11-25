package org.example.Logic;


import java.sql.SQLException;
import java.util.ArrayList;

public class Functions {
    public static ArrayList<ArrayList<String>> showLog(DatabaseFunctionality dbFunction){
        return dbFunction.showAllContent();
    }
    public static void exit(DatabaseFunctionality dbFunction){
        dbFunction.close();
    }
    public static ArrayList<ArrayList<String>> searchPerson(DatabaseFunctionality dbFunction, String name){
        return dbFunction.showContainingName(name);
    }
    public static void addDecision(DatabaseFunctionality dbFunction, String date, String name, int importanceGrade, String description) throws SQLException {
        dbFunction.addDecision(date, name, importanceGrade, description);
    }
}
