package sistema.sistemadegerenciamento.repository;

import sistema.sistemadegerenciamento.controller.MainController;
import sistema.sistemadegerenciamento.dataBase.ConxaoSQL;
import sistema.sistemadegerenciamento.model.Estoque;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstoqueRepository {

    public List<Estoque> getDados() throws SQLException {
        List<Estoque> dados = new ArrayList<>();

        try (Connection connection = ConxaoSQL.connection(); Statement statement = connection.createStatement()) {
            String query = "SELECT * FROM estoque";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Estoque dado = new Estoque(resultSet.getInt("id"), resultSet.getLong("codigo"), resultSet.getString("produto"), resultSet.getInt("quantidade"));
                dados.add(dado);
            }
        }
        return dados;
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

    public void excluirItens(String codigo, String produtos) {
        String DELETAR_VALORES = "DELETE FROM estoque WHERE codigo = ? AND produto = ?";

        try  {
            Connection connection = ConxaoSQL.connection();
            PreparedStatement statement = connection.prepareStatement(DELETAR_VALORES);
            statement.setString(1, codigo);
            statement.setString(2, produtos);
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados..." + e);
        }
    }

    public void editarItens(String codigo, String produtos, String quantidade, String id) {
        String ATUALIZAR_VALORES = "UPDATE estoque SET CODIGO = COALESCE(?, codigo), PRODUTO = COALESCE(?, produto), QUANTIDADE = COALESCE(?, quantidade) WHERE ID = ?";
        if (codigo.isEmpty()) {
            codigo = null;
        }
        if (produtos.isEmpty()) {
            produtos = null;
        }
        if (quantidade.isEmpty()) {
            quantidade = null;
        }

        try  {
            Connection connection = ConxaoSQL.connection();
            PreparedStatement statement = connection.prepareStatement(ATUALIZAR_VALORES);
            statement.setString(1, codigo);
            statement.setString(2, produtos);
            statement.setString(3, quantidade);
            statement.setString(4, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados..." + e);
        }
    }
}
