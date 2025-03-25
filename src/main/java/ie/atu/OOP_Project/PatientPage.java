package ie.atu.OOP_Project;

import java.sql.*;
import java.util.Scanner;

public class PatientPage {

    private String patientName = null;
    private int patientAge = 0;
    private String patientInsurance = null;
    private String patientAddress = null;
    private String patientEmail = null;
    private String patientProcedures = null;
    private float patientBill = 0;

    Connection connection = DriverManager.getConnection("jdbc:mysql//localhost/database", "root", "password");
    Scanner scanner = new Scanner(System.in);
    String selectsql = "SELECT p.name, p.age, p.insuranceNumber, p.address, p.email, p.procedures, p.bill" + "FROM patient p";

    public PatientPage() throws SQLException
    {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(selectsql);

        while(rs.next())
        {
            patientName = rs.getString("name");
            patientAge = rs.getInt("age");
            patientInsurance = rs.getString("insuranceNumber");
            patientAddress = rs.getString("address");
            patientEmail = rs.getString("email");
            patientProcedures = rs.getString("procedures");
            patientBill = rs.getFloat("bill");
        }

        System.out.println("===== Patient Details =====");
        System.out.println("Please select what you want to view:");
        System.out.println("1: View procedures");
        System.out.println("2: View bill");
        System.out.println("3: View personal information");
        System.out.println("============================");
        int choice = scanner.nextInt();

        switch(choice)
        {
            case 1:
                System.out.println("This is your upcoming procedures");
                if(patientProcedures!=null){
                    System.out.println(patientProcedures.toString());
                }
                else
                {
                    System.out.println("There is no up coming procedures");
                }
            case 2:
                if(patientBill>0){
                    System.out.println("This is your outstanding bill" + patientBill);
                }
                else{
                    System.out.println("There is no outstanding bill");
                }

            case 3:

            default:
        }
    }
}
