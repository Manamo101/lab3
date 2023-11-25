package org.example.Logic;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DatabaseFunctionality{
    ArrayList<ArrayList<String>> showAllContent();
    ArrayList<ArrayList<String>> showContainingName(String name);
    void addDecision(String date, String name, int importanceGrade, String description) throws SQLException;
    void close();
}
