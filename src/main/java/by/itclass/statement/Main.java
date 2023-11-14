package by.itclass.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("1");


        }

        try (Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/po_2211","root","");
             Statement st=connection.createStatement()){

            String query="INSERT INTO staff(name,age,department,project) value ('employee11',27,5,3)";
            st.execute(query);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("2");
        }

    }
}
