package sistema.sistemadegerenciamento.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sistema.sistemadegerenciamento.Main;
import sistema.sistemadegerenciamento.repository.EstoqueRepository;

import java.io.IOException;

public class EditarController {
    @FXML
    private TextField codigo;
    @FXML
    private TextField produto;
    @FXML
    private TextField quantidade;
    @FXML
    private TextField id;

    public void abrirModal(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("editar-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.setTitle("Editar");
        stage.show();
    }

    public void editarItem() {
        String codigo = this.codigo.getText();
        String produto = this.produto.getText();
        String quantidade = this.quantidade.getText();
        String id = this.id.getText();

        EstoqueRepository editarItensdaTabela = new EstoqueRepository();
        editarItensdaTabela.editarItens(codigo, produto, quantidade, id);
        this.codigo.clear();
        this.produto.clear();
        this.quantidade.clear();
    }
}
