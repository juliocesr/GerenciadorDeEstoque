package sistema.sistemadegerenciamento.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sistema.sistemadegerenciamento.Main;

import java.io.IOException;

public class EditarController {
    public void abrirModal(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("editar-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.setTitle("Editar");
        stage.show();
    }
}
