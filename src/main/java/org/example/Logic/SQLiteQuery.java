package org.example.Logic;

import java.sql.*;
import java.util.ArrayList;

class SQLiteQuery {
    private final Connection connection;
    SQLiteQuery(Connection connection){
        this.connection = connection;
    }

     ArrayList<ArrayList<String>> selectAll(){
         ArrayList<ArrayList<String>> list = new ArrayList<>();
         try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM decisions");

            while (result.next()){
                list.add(new ArrayList<>());
                list.get(list.size()-1).add(result.getString(1));
                list.get(list.size()-1).add(result.getString(2));
                list.get(list.size()-1).add(result.getString(3));
                list.get(list.size()-1).add(result.getString(4));
                list.get(list.size()-1).add(result.getString(5));
            }
            result.close();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
         return list;
    }
    static boolean doesExist(Connection connection){
        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT COUNT(name) FROM sqlite_master WHERE name='decisions' ");
            return result.getInt("COUNT(name)") == 1;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    ArrayList<ArrayList<String>> selectName(String name){
         ArrayList<ArrayList<String>> list;
         try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM decisions WHERE name LIKE '%" + name + "%'");
            list = new ArrayList<>();
            while (result.next()){
                list.add(new ArrayList<>());
                list.get(list.size()-1).add(result.getString(1));
                list.get(list.size()-1).add(result.getString(2));
                list.get(list.size()-1).add(result.getString(3));
                list.get(list.size()-1).add(result.getString(4));
                list.get(list.size()-1).add(result.getString(5));
            }
            result.close();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
         return list;
    }
    void insertInto(String date, String name, int importanceGrade, String description){
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO decisions values (?,?,?,?,?)");
            ps.setString(2, date);
            ps.setString(3, name);
            ps.setInt(4, importanceGrade);
            ps.setString(5, description);
            int i = ps.executeUpdate();
            System.out.println(i);
            ps.close();
        }
        catch (SQLException e){
        throw new RuntimeException(e);
        }
    }
}
