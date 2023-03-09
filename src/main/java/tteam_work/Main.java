package tteam_work;

import example_1.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/jdbcfun?serverTimezone=UTC";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "";

    public static void main(String[] args) throws SQLException {
        Connection myConnection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        //allows to execute and create statements towards connected database
        //use statement object to execute queries
        Statement statement = myConnection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM cosmetics");

        List<Cosmetic> cosmetics = new ArrayList<>();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int price = resultSet.getInt("price");
            String brand = resultSet.getString("brand");
            int quantity = resultSet.getInt("quantity");
            Cosmetic cosmetic = new Cosmetic(id, name, price, brand, quantity);
            cosmetics.add(cosmetic);
        }

        for (Cosmetic cosmetic : cosmetics) {
            System.out.println(cosmetic);

        }
        System.out.println();
        resultSet = statement.executeQuery("SELECT * FROM cosmetics WHERE quantity > 15");
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("quantity") + " -  " + resultSet.getString("name"));
        }

        statement.executeUpdate("INSERT INTO cosmetics (id, name, price, brand, quantity) VALUES (10, 'wax', 10, 'loreal', 2)");

        statement.executeUpdate("ALTER TABLE cosmetics ADD compound VARCHAR (100)");

        statement.executeUpdate("UPDATE cosmetics SET compound = 'camomille'");

        statement.executeUpdate("DELETE FROM cosmetics WHERE brand = 'dove'");

//
//        public ResultSet findByName(String projectName) throws SQLException {
//            Statement statement = DatabaseUtils.databaseConnection.createStatement();
//            return statement.executeQuery("SELECT * FROM cosmetics WHERE name = '" + projectName + "'");
//            System.out.println(proj);
//        }


    }


}
