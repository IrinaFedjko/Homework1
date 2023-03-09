package example_1;

import java.sql.*;
import java.util.ArrayList;

public class Main {


    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/jdbcfun?serverTimezone=UTC";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = ""; //didnt create a password in sql

    public static void main(String[] args) throws SQLException {
        Connection myConnection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
//        allows to execute and create statements towards connected database
//        use statement object to execute queries
        Statement statement = myConnection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM projects");

        ArrayList<Project> projects = new ArrayList<>();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int budget = resultSet.getInt("budget");
            Project project = new Project(id, name, budget);
            projects.add(project);
        }

        for (Project project : projects) {
            System.out.println(project);
        }

        System.out.println();
        resultSet = statement.executeQuery("SELECT * FROM projects WHERE budget > 20000 ");
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name") + " " + resultSet.getString("budget"));
        }


        //INSERT INTO PROJECT (name, budget) VALUES ('Nice project', 15000);
////if you want to odify the database you need to executeUpdate
        statement.executeUpdate("INSERT INTO PROJECTS (name, budget) VALUES ('Nice Project', 15000)");
    }


}
