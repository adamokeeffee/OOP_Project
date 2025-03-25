package ie.atu.OOP_Project;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class userLogin {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql//localhost/database", "root", "password");
        Scanner scanner = new Scanner(System.in);
        String Selectsql = "SELECT u.username, u.password" + "FROM users u";

        String username = null;
        String password = null;

        try
        {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(Selectsql);

            while(resultSet.next())
            {
                username = resultSet.getString("username");
                password = resultSet.getString("password");
            }

            System.out.println("====== LOGIN ======");
            System.out.println("Do you have an account? (y/n)");
            String answer = scanner.nextLine();

            if(answer.equalsIgnoreCase("n"))
            {
                System.out.println("Create an account");
                CreateAccount CreateAccount = new CreateAccount();
                CreateAccount.createNewAccount();
            }
            else
            {
                System.out.println("Please enter username");
                String inputUsername = scanner.nextLine();
                System.out.println("Please enter password");
                String inputPassword = scanner.nextLine();


            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

    }
}
