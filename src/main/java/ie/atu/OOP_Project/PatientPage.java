package ie.atu.OOP_Project;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PatientPage {

    private String patientName = null;
    private int patientAge = 0;
    private String patientInsurance = null;
    private String patientAddress = null;
    private String patientEmail = null;
    private String patientProcedures = null;
    private float patientBill = 0;

    Connection connection = DriverManager.getConnection("jdbc:mysql//localhost/database", "root", "password");

    public PatientPage() throws SQLException
    {

    }
}
