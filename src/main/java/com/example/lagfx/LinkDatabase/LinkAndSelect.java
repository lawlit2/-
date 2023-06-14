package com.example.lagfx.LinkDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LinkAndSelect {
    public List<Double> GetData(){
        List<Double> DataList = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lagrange","root","123456");
            Statement statement = connection.createStatement()){
            ResultSet set =statement.executeQuery("select * from lagrange.lagdata");
            while (set.next()){
                DataList.add(set.getDouble(1));
            };
        }catch (SQLException e){
            e.printStackTrace();
        }
        return DataList;
    }
}
