package sistema.sistemadegerenciamento.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sistema.sistemadegerenciamento.Main;
import sistema.sistemadegerenciamento.controller.MainController;
import sistema.sistemadegerenciamento.dataBase.ConxaoSQL;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class CadastrarApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        try {
            Connection connection = ConxaoSQL.connection();
            System.out.println("Conectado.....");
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados..." + e);
        }

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("cadastrar-view.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setTitle("ESTOQUE");
        stage.setScene(scene);
        stage.setFullScreen(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
