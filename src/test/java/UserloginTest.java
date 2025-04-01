import ie.atu.OOP_Project.userLogin;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class UserloginTest  {

    private Connection connection;

    @BeforeEach
    void setUp() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost/test_database", "root", "password");
        insertTestData();
    }

    @AfterEach
    void tearDown() throws SQLException {
        clearTestData();
        connection.close();
    }

    void insertTestData() throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("INSERT INTO users (username, password, email, address, insurance_number) " +
                "VALUES ('testUser', 'testPass', 'test@example.com', '123 Main St', 'INS12345')");
    }

    void clearTestData() throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("DELETE FROM users WHERE username='testUser'");
    }

    @Test
    void testUserLogin_SuccessfulLogin() {
        String simulatedInput = "y\n" + "testUser\n" + "testPass\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        assertDoesNotThrow(() -> userLogin.main(new String[]{}));
    }

    @Test
    void testUserLogin_FailedLogin() {
        String simulatedInput = "y\n" + "wrongUser\n" + "wrongPass\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        assertDoesNotThrow(() -> userLogin.main(new String[]{}));
    }

    @Test
    void testUserLogin_CreateAccount() {
        String simulatedInput = "n\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        assertDoesNotThrow(() -> userLogin.main(new String[]{}));
    }
}
