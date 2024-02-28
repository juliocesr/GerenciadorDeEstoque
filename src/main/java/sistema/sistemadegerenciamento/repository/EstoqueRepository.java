package sistema.sistemadegerenciamento.repository;

import sistema.sistemadegerenciamento.dataBase.ConxaoSQL;
import sistema.sistemadegerenciamento.model.Estoque;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EstoqueRepository {

    public List<Estoque> getDados() throws SQLException {
        List<Estoque> dados = new ArrayList<>();

        try (Connection connection = ConxaoSQL.connection(); Statement stmt = connection.createStatement()) {
            String query = "SELECT * FROM estoque";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Estoque dado = new Estoque(rs.getInt("id"), rs.getLong("codigo"), rs.getString("produto"), rs.getInt("quantidade"));
                dados.add(dado);
            }
        }
        return dados;
    }


}
