package by.itclass.statement;

import by.itclass.Model.Staff;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main1 {
    public static final String DB_URL="jdbc:mysql://localhost:3306/po_2211";
    public static final String DB_USER="root";
    public static final String DB_PASSWORD="";
    public static final String DRIVER_CLASS="com.mysql.cj.jdbc.Driver";


    public static void main(String[] args) {

        try {
            Class.forName(DRIVER_CLASS);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("1");


        }

        try (Connection cn= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
             Statement st= cn.createStatement()){

            List<Staff> staffs=new ArrayList<>();
            String query="Select s.name,s.age,d.name FROM staff s LEFT JOIN department d on s.department=d.id";

            ResultSet resultSet = st.executeQuery(query);
            while (resultSet.next()){
                String name=resultSet.getString(1);
                int age=resultSet.getInt("age");
                String department=resultSet.getString(3);
                staffs.add(new Staff(name,age,department));
                }
            staffs.forEach(System.out::println);


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
