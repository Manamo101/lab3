package org.example.Logic;

import java.sql.Connection;
import java.util.ArrayList;

public class SQLiteFunctionality implements DatabaseFunctionality{
    private final SQLiteConnection sqliteConnection;
    private final SQLiteQuery sqliteQuery;

    public SQLiteFunctionality(String databaseName){
        sqliteConnection = new SQLiteConnection(databaseName);
        Connection connection = sqliteConnection.getConnection();
        sqliteQuery = new SQLiteQuery(connection);
    }

    public void close(){
        sqliteConnection.closeConnection();
    }
    public ArrayList<ArrayList<String>> showAllContent(){
        return sqliteQuery.selectAll();
    }
    public ArrayList<ArrayList<String>> showContainingName(String name){
        return sqliteQuery.selectName(name);
    }
    public void addDecision(String date, String name, int importanceGrade, String description){
        sqliteQuery.insertInto(date, name, importanceGrade, description);
    }

}
