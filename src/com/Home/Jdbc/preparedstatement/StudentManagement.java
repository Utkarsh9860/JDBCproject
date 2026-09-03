package com.Home.Jdbc.preparedstatement;

import java.sql.*;
import java.util.Scanner;

public class StudentManagement {
    static Scanner sc = new Scanner(System.in);

    public static Connection dbConnect() throws ClassNotFoundException, SQLException {
        //1.Load the driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2.open connection
        Connection connnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Students",
                "root","root"
        );
        return connnection;
    }

    public static void addStudent() throws SQLException, ClassNotFoundException {

        PreparedStatement prepareStatement = dbConnect().prepareStatement("insert into student values (?,?,?)");
        System.out.println("Enter Student ID");
        prepareStatement.setInt(1, sc.nextInt());
        System.out.println("Enter Student Name");
        prepareStatement.setString(2, sc.next());
        System.out.println("Enter Students age ");
        prepareStatement.setInt(3, sc.nextInt());

        int result = prepareStatement.executeUpdate();
        System.out.println("Query ok " + result + "rows affected ");

    }

    public static void updateStudent() throws SQLException, ClassNotFoundException {


    }


    public static void deleteStudent(){

    }


    public static void displayAllStudents() throws SQLException, ClassNotFoundException {
        PreparedStatement statement = dbConnect().prepareStatement("select * from student");
        ResultSet set = statement.executeQuery();

        System.out.println("-----------Student details -------");
        while(set.next()){
            System.out.println(set.getInt(1) + " | " + set.getString(2) + " | " + set.getInt(3) );
        }
        statement.close();
    }


    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        boolean flag = true;
        while (flag) {
            System.out.println("\n------Student Management System------");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1 -> addStudent();
                case 2 -> updateStudent();
                case 3 -> deleteStudent();
                case 4 -> displayAllStudents();
                case 5 -> flag = false;
                default -> System.out.println("Invalid choice");
            }
        }
    }

 }

