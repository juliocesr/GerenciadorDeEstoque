package sistema.sistemadegerenciamento.controller;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sistema.sistemadegerenciamento.Main;

import sistema.sistemadegerenciamento.repository.EstoqueRepository;

import java.io.IOException;



public class CadastrarController {
    @FXML
    private TextField codigo;
    @FXML
    private TextField produto;
    @FXML
    private TextField quantidade;

    public CadastrarController(){}

    public void abrirModal(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("cadastrar-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.setTitle("Cadastrar");;
        stage.show();
    }

    public void cadastrarItem() {
        String codigo = this.codigo.getText();
        String produto = this.produto.getText();
        String quantidade = this.quantidade.getText();

        EstoqueRepository inserirItemNaTabela = new EstoqueRepository();
        inserirItemNaTabela.cadastrarItens(codigo, produto, quantidade);
        this.codigo.clear();
        this.produto.clear();
        this.quantidade.clear();
    }
}
