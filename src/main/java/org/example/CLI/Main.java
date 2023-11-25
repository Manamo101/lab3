package org.example.CLI;

import org.example.Logic.DatabaseFunctionality;
import org.example.Logic.SQLiteFunctionality;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        DatabaseFunctionality sqliteManagement = new SQLiteFunctionality(args[0]);

        Execution.printStartingSentence();

        String function;
        do{
            function = ProgramInput.getFunction();
        }
        while (Execution.executeFunction(sqliteManagement, function));
    }
}