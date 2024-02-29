package sistema.sistemadegerenciamento.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sistema.sistemadegerenciamento.Main;
import sistema.sistemadegerenciamento.dataBase.ConxaoSQL;
import sistema.sistemadegerenciamento.repository.EstoqueRepository;

import java.io.IOException;

public class ExcluiriController {
    @FXML
    private TextField codigo;
    @FXML
    private TextField produto;

    public void abrirModal(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("excluir-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.setTitle("Excluir");
        stage.show();
    }

    public void excluirItem() {
        String codigo = this.codigo.getText();
        String produto = this.produto.getText();

        EstoqueRepository excluirItensdaTabela = new EstoqueRepository();
        excluirItensdaTabela.excluirItens(codigo, produto);
        this.codigo.clear();
        this.produto.clear();
    }
}
