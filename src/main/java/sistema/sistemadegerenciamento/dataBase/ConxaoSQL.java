package sistema.sistemadegerenciamento.dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConxaoSQL {
    private static final String URL = "jdbc:mysql://localhost:3306/estoque";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection connection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
