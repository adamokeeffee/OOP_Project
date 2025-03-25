package ie.atu.OOP_Project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class userLogin {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql//localhost/database", "root", "password");
        Scanner scanner = new Scanner(System.in);
        String Selectsql = "SELECT u.username, u.password" + "FROM users u";

        String username = null;
        String password = null;


    }
}
