package final_project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/Barbora?serverTimezone=UTC";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "";

    public static void main(String[] args) throws SQLException, IOException {
        Connection myConnection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        Statement statement = myConnection.createStatement();

        ResultSet resultSetProducts = statement.executeQuery("SELECT * FROM products");

        ArrayList<DatabaseOfOrders> products = new ArrayList<>();

        FileReader fileReader = new FileReader("src/main/java/final_project/ListOfAllProducts.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();

        resultSetProducts(resultSetProducts, products);

        BarborasMenu();
        int userSelection = scanner.nextInt();
        if (userSelection == 1) {

            while (line != null) {
                System.out.println(line);
                line = bufferedReader.readLine();
            }

        } else if (userSelection == 2) {
            System.out.println("Please enter your first name: ");
            String firstName = scanner.next();
            System.out.println("Please enter your last name: ");
            String lastName = scanner.next();
            System.out.println("Please enter your address: ");
            String address = scanner.next();
            System.out.println("Please enter your phone number: ");
            String phoneNumber = scanner.next();
            System.out.println("Please enter your country: ");
            String country = scanner.next();

            statement.executeUpdate("INSERT INTO clients (firstname, lastName, address, phoneNumber, country) VALUES ('" + firstName + " ' , '" + lastName + "','" + address + "','" + phoneNumber + "','" + country + "')");
        }
        if (userSelection == 3) {
            Authentication authentication = new Authentication();
            authentication.checkPassword();
            
            for (DatabaseOfOrders product : products) {
                System.out.println(product);
            }
        } else {
            System.out.println("Wrong input!!");
        }
    }

    private static void resultSetProducts(ResultSet resultSetProducts, ArrayList<DatabaseOfOrders> products) throws SQLException {
        while (resultSetProducts.next()) {
            int clientsId = resultSetProducts.getInt("clientsId");
            String name = resultSetProducts.getString("name");
            LocalDate expiredDate = LocalDate.parse(resultSetProducts.getString("expired_date"));
            double price = resultSetProducts.getDouble("price");
            int quantity = resultSetProducts.getInt("quantity");
            DatabaseOfOrders product = new DatabaseOfOrders(name, clientsId, expiredDate, price, quantity);
            products.add(product);
        }
    }

    private static void BarborasMenu() {
        System.out.println("---------------BARBORA----------------------");
        System.out.println("Welcome  to Barbora! Here is the menu: ");
        System.out.println("1. Show items in the shop");
        System.out.println("2. Register new user");
        System.out.println("3. Barbora's private access");
        System.out.println("Please choose: 1/2/3");
    }
}




