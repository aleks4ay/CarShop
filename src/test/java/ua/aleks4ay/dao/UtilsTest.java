package ua.aleks4ay.dao;

import org.junit.*;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class UtilsTest {

    @Test
    public void getConnectionTest() throws SQLException {
        try (Connection connection = Utils.getConnection()) {
            assertTrue(connection.isValid(1));
            assertFalse(connection.isClosed());
        }
    }

    @Test
    public void getConnectionTestTest() throws SQLException {
        try (Connection connection = Utils.getConnectionTest()) {
            assertTrue(connection.isValid(1));
            assertFalse(connection.isClosed());
        }
    }
}