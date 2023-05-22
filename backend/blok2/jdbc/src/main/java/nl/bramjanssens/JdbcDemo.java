package nl.bramjanssens;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class JdbcDemo {

    public static void main(String[] args) throws SQLException {

        // 1
        // Class.forName("com.mysql.cj.jdbc.Driver"); // SPI

        // 2
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo", "root", "root")) {
            createDatabase(connection);

            // 3
            Statement statement = connection.createStatement();

            insertFamilyTransactional(connection);

            // 4
            ResultSet result = statement.executeQuery("SELECT * FROM person");

            // 5 (basic)
            while (result.next()) {
                int id = result.getInt(1);
                String name = result.getString(2);
                int age = result.getInt(3);
                System.out.println(id + " | " + name + " | " + age);
            }

            // 5 (generic)
            result = statement.executeQuery("SELECT * FROM person");

            List<String> columns = new ArrayList<>();
            ResultSetMetaData metaData = result.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                columns.add(metaData.getColumnName(i));
            }

            while (result.next()) {
                StringJoiner sj = new StringJoiner(" | ");
                for (String column : columns) {
                    String value = result.getString(column);
                    sj.add(value);
                }
                System.out.println(sj);
            }

            // Statement is not safe for SQL-injection...
            // String name = "'Bram'; DROP DATABASE; --";
            // statement.executeQuery("SELECT * from person where name = " + name);

            // Use prepared statement instead:
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * from person where name LIKE ? AND id = ?");
            preparedStatement.setString(1, "Bram");
            preparedStatement.setInt(2, 42);
            ResultSet resultSet = preparedStatement.executeQuery();

        }
        // 6 auto closed
    }

    private static void insertFamilyTransactional(Connection conn) throws SQLException {
        try {
            conn.setAutoCommit(false);
            var stmt = conn.prepareStatement("INSERT INTO person(name, age) VALUES (?,?)");

            insertPerson(stmt, "Bram", 43);
            insertPerson(stmt, "Mieke", 43);
            insertPerson(stmt, "Niek", 13);
            insertPerson(stmt, "Gijs", 9);

            stmt.executeBatch();

            // if everything went ok:
            conn.commit();
        } catch (SQLException e) {
            // if something went wrong
            System.err.println("Transaction aborted. Something in the database went wrong: " + e.getMessage());
            conn.rollback();
        } finally {
            // always
            conn.setAutoCommit(true);
        }
    }

    private static void insertPerson(PreparedStatement s, String name, int age) throws SQLException {
        s.setString(1, name);
        s.setInt(2, age);
        s.addBatch();
    }

    public static void createDatabase(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("drop table if exists person;");
        statement.execute("drop table if exists gender;");
        statement.execute("create table person(id int auto_increment primary key, name varchar(255) null, age int null, genderId int null);");
        statement.execute("create table gender(id int null, name varchar(255) null);");
        statement.execute("insert into gender(id, name) values (1, 'Man')");
        statement.execute("insert into gender(id, name) values (2, 'Vrouw')");
    }
}

