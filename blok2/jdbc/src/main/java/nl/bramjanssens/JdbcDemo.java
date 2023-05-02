package nl.bramjanssens;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        // 1
        // Class.forName("com.mysql.cj.jdbc.Driver"); // SPI

        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo", "root", "root")){
            // 3
            Statement statement = connection.createStatement();

            // 4
            ResultSet result = statement.executeQuery("SELECT * FROM PERSON");

            // List<String> columns = new ArrayList<>();
            // ResultSetMetaData metaData = result.getMetaData();
            // for (int i = 1; i <= metaData.getColumnCount(); i++) {
            //     columns.add(metaData.getColumnName(i));
            // }

            while (result.next()) {
                String name = result.getString("name");
                int age = result.getInt("age");

                System.out.println(name + " - " + age);
            }
        }

        // 2

        // 6
        // statement.close();
        // connection.close();
    }
}
