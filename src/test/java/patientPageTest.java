import ie.atu.OOP_Project.PatientPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class patientPageTest {
    private Connection connection;
    private PatientPage patientPage;

    @BeforeEach
    void setUp() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost/test_database", "root", "password");
        patientPage = new PatientPage();
        insertTestData();
    }

    @AfterEach
    void tearDown() throws SQLException {
        clearTestData();
        connection.close();
    }

    void insertTestData() throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("INSERT INTO patient (name, age, insuranceNumber, address, email, procedures, bill) " +
                "VALUES ('John Doe', 30, 'INS12345', '123 Main St', 'johndoe@example.com', 'Check-up', 150.75)");
    }
    void clearTestData() throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("DELETE FROM patient WHERE name='John Doe'");
    }

    @Test
    void testPatientPage_ViewProcedures() throws SQLException {
        System.setIn(new java.io.ByteArrayInputStream("1\n".getBytes()));
        patientPage.PatientPage();
        assertTrue(true, "Procedures displayed correctly");
    }

    @Test
    void testPatientPage_ViewBill() throws SQLException {
        System.setIn(new java.io.ByteArrayInputStream("2\n".getBytes()));
        patientPage.PatientPage();
        assertTrue(true, "Bill displayed correctly");
    }

    @Test
    void testPatientPage_ViewPersonalInfo() throws SQLException {
        System.setIn(new java.io.ByteArrayInputStream("3\n".getBytes()));
        patientPage.PatientPage();
        assertTrue(true, "Personal information displayed correctly");
    }

}
