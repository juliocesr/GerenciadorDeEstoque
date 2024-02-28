package sistema.sistemadegerenciamento.dataBase;

import java.security.PublicKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConxaoSQL {
    private static final String URL = "jdbc:mysql://localhost:3306/estoque";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection connection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void cadastrarItens(String codigo, String produtos, String quantidade) {
        String INSERIR_VALORES = "INSERT INTO ESTOQUE(CODIGO, PRODUTO, QUANTIDADE) VALUES (?, ?, ?)";

        try  {
            Connection connection = ConxaoSQL.connection();
            PreparedStatement statement = connection.prepareStatement(INSERIR_VALORES);
            statement.setString(1, codigo);
            statement.setString(2, produtos);
            statement.setString(3, quantidade);
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados..." + e);
        }
    }
}
