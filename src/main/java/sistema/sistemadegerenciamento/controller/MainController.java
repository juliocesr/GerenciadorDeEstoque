package sistema.sistemadegerenciamento.controller;

import javafx.beans.binding.Bindings;

import javafx.fxml.FXML;


import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import sistema.sistemadegerenciamento.model.Estoque;
import sistema.sistemadegerenciamento.repository.EstoqueRepository;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class MainController {

    @FXML
    private TableView<Estoque> tabela;
    @FXML
    private TableColumn<Estoque, Integer> id;
    @FXML
    private TableColumn<Estoque, String> codigo;
    @FXML
    private TableColumn<Estoque, String> produto;
    @FXML
    private TableColumn<Estoque, String> quantidade;
    private EstoqueRepository repository;
    @FXML
    public void inicializar() {
        repository = new EstoqueRepository();
        popularTabela();
    }
    @FXML
    public void cadastrarNovoItem() throws IOException{
        CadastrarController cadastrar = new CadastrarController();
        cadastrar.abrirModal(new Stage());
    }
    @FXML
    public void excluirItem() throws IOException {
        ExcluiriController excluir = new ExcluiriController();
        excluir.abrirModal(new Stage());
    }
    @FXML
    public void editarItem() throws IOException {
        EditarController editar = new EditarController();
        editar.abrirModal(new Stage());
    }

    private void popularTabela() {
        for (TableColumn colunas : tabela.getColumns()) {
            colunas.setStyle("-fx-alignment: CENTER; -fx-font-size: 15pt;");
        }

        try {
            tabela.getItems().clear();
            List<Estoque> dados = repository.getDados();
            id.setCellValueFactory(celula -> Bindings.createObjectBinding(() -> celula.getValue().getId()));
            codigo.setCellValueFactory(celula -> Bindings.createObjectBinding(() -> celula.getValue().getCodigo().toString()));
            produto.setCellValueFactory(celula -> Bindings.createObjectBinding(() -> celula.getValue().getProduto()));
            quantidade.setCellValueFactory(celula -> Bindings.createObjectBinding(() -> celula.getValue().getQuantidade().toString()));
            this.tabela.getItems().addAll(dados);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void atualizarTabela() {
        popularTabela();
    }
}