package firsthomeworkadvance;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<User> users = new ArrayList<>();


    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/userData?serverTimezone=UTC";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "";

    public static void main(String[] args) throws SQLException {
        Connection myConnection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        Statement statement = myConnection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM  UsersData");

        JOptionPane.showMessageDialog(null, "Welcome to our Bank!!! ", "Welcome", JOptionPane.PLAIN_MESSAGE);
        JOptionPane.showOptionDialog(null, "Would you like to continue and choose some information?", "Choose",  JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);


        CreditDebit visa = new CreditDebit("VISA", 1234, 1000.00);
        System.out.println("Please enter your pin to check balance, add, withdraw money: ");
        System.out.println("Please press 1 to make registration: ");
        System.out.println("Please 2 to delete your account!!");

        int userInput = scanner.nextInt();
        if (userInput == visa.getPinCode()) {
            {
                System.out.println(visa.getBalance());
            }
            if (userInput != visa.getPinCode()) {
                JOptionPane.showMessageDialog(null, "WRONG PIN!", "Warning", JOptionPane.PLAIN_MESSAGE);
            }
            System.out.println("Write an amount you would like to add or withdraw money?");
            double moneyInput = scanner.nextDouble();
            System.out.println(moneyInput + visa.getBalance());
        } else if (userInput == 1) {
            System.out.println("Please register and add information: ");
            System.out.println("Enter name: ");
            String userEnterName = scanner.next();
            System.out.println("Enter account number which is shown in your secret envelope: : ");
            int userEnterDescription = scanner.nextInt();
            System.out.println("Enter amount of money you would like to add or take: ");
            double userEnterPrice = scanner.nextDouble();
            System.out.println("Write your gender man or women: ");
            String userEnterGender = scanner.next();
            System.out.println("Please write your id: ");
            int userEnterId = scanner.nextInt();
            User users = new User(userEnterName, userEnterDescription, userEnterPrice, userEnterGender, userEnterId);
            System.out.println("You was added in our database : " + users.getName() + " " + users.getAccountNumber() + " " + users.getBalance() + " " + users.isMan() + " " + users.getUsersId());

            statement.executeUpdate("INSERT INTO UsersData (name, AccountNumber, Balance, Man, UsersId) VALUES ('" + users.getName() + "'', '" + users.getAccountNumber() + "', '" + users.getBalance() + "', '" + users.isMan() + "', '" + users.getUsersId() + ")");

            myConnection.setAutoCommit(false);


        } else if (userInput == 2) {
            System.out.println("You deleted contact.");
            for (User user : users) {
                System.out.println(user.getName() + " " + user.getAccountNumber() + " " + user.getBalance() + " " + user.isMan() + " " + user.getUsersId());
            }
        } else {
            System.out.println("Wrong input! ");
        }

        while (resultSet.next()) {
            int usersId = resultSet.getInt("usersId");
            String name = resultSet.getString("name");
            String man = resultSet.getString("man");
            double balance = resultSet.getDouble("balance");
            int accountNumber = resultSet.getInt("accountNumber");
            User user = new User(name, accountNumber, balance, man, usersId);
            users.add(user);
        }
        for (User user : users) {
            System.out.println(user.getUsersId() + user.getName() + user.isMan() + user.getBalance() + user.getAccountNumber());

        }

//          statement.executeUpdate("INSERT INTO UsersData (name, AccountNumber,Balance, Man, UsersId ) VALUES ('Ann', 234999, 20.00, 33, 33)");


    }
}
