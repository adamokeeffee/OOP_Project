package ie.atu.OOP_Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CreateAccount {
    public void createNewAccount() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql//localhost/database", "root", "password");
        Scanner sc = new Scanner(System.in);

        System.out.println("===== Create Account =====");
        System.out.println("Enter Username: ");
        String username = sc.nextLine();
        System.out.println("Enter Password: ");
        String password = sc.nextLine();
        System.out.println("Enter Email: ");
        String email = sc.nextLine();
        System.out.println("Enter address: ");
        String address = sc.nextLine();
        System.out.println("Enter insurance number: ");
        String insuranceNumber = sc.nextLine();

        try
        {
            String query ="INSERT INTO users (username, password, email, address, insurance_number, role) VALUES (?,?,?,?,?,'user')";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, email);
            ps.setString(4, address);
            ps.setString(5, insuranceNumber);

            int
        }
    }
}
