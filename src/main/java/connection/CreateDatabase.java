package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateDatabase {
    private static final String databaseName = "";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/" + databaseName;
    private static final String USER = "root";
    private static final String PASSWORD = "0398878422suti?";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection connection;
        Class.forName(DRIVER);
        System.out.println("Dang ket noi toi co so du lieu ...");
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
        return connection;
    }
}
