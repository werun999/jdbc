package by.itclass.prepared;

import by.itclass.Model.Staff;

import java.io.PipedReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
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

        String query="Select s.name,s.age,d.name FROM staff s LEFT JOIN department d on s.department=d.id  where s.age>? AND d.name LIKE ?";

        try (Connection cn= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD); PreparedStatement ps= cn.prepareStatement(query)){
            List<Staff> staffs=new ArrayList<>();
            ps.setInt(1,10);
            ps.setString(2,"Dev%");
            ResultSet resultSet = ps.executeQuery();
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
