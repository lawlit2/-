package com.example.lagfx.LinkDatabase;

import com.example.lagfx.ValueAndFun;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LinkAndSelect {
    public List<Double> GetData(){
        List<Double> DataList = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lagrange","root","123456");
            Statement statement = connection.createStatement()){
            ResultSet set =statement.executeQuery("select dat0 from lagrange.lagdata");
            while (set.next()){
                DataList.add(set.getDouble(1));
            };
        }catch (SQLException e){
            e.printStackTrace();
        }
        return DataList;
    }
    public List<Double> GetFunction(){
        List<Double> DataList1 = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lagrange","root","123456");
            Statement statement = connection.createStatement()){
            ResultSet set =statement.executeQuery("select function from lagrange.lagdata");
            while (set.next()){
                DataList1.add(set.getDouble(1));
            };
        }catch (SQLException e){
            e.printStackTrace();
        }
        return DataList1;
    }
    public List<ValueAndFun> GetFunctionAndValue(){
        List<ValueAndFun> valueAndFuns=new ArrayList<>();

        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lagrange","root","123456");
            Statement statement = connection.createStatement()){
            ResultSet set =statement.executeQuery("select * from lagrange.lagdata");
            while (set.next()){
                ValueAndFun rdd = new ValueAndFun();
                rdd.setX(set.getDouble(1));
                rdd.setY(set.getDouble(2));
              valueAndFuns.add(rdd);

            };
        }catch (SQLException e){
            e.printStackTrace();
        }
        return valueAndFuns;
    }

}
