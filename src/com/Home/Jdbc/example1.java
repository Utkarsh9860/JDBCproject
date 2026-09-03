package com.Home.Jdbc;

import java.sql.*;

public class example1 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//1.Load The Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

//2.Open Connection using dburl
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Students",
                "root",
                "root"
        );


         //3.Create Statement
        Statement statement = connection.createStatement();


        // 4.EXECUTE SQL QUERY
        //Insert
//        int resultset = statement.executeUpdate("INSERT  INTO student VALUES (103,'Raj',25)");

            //Display
//        ResultSet resultset = statement.executeQuery("SELECT * FROM student");

        // Update
        int resultset=statement.executeUpdate("UPDATE student set name = 'utk' where id=103");

            // Delete
//        int resultset = statement.executeUpdate("DELETE FROM student WHERE id = 103");


        // 5.process the result
        System.out.println(resultset + " row updated");


        connection.close();
    }
}