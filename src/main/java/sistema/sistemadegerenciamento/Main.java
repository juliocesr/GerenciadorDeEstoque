package sistema.sistemadegerenciamento;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sistema.sistemadegerenciamento.controller.MainController;
import sistema.sistemadegerenciamento.dataBase.ConxaoSQL;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        try {
            Connection connection = ConxaoSQL.connection();
            System.out.println("Conectado.....");
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados..." + e);
        }

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main-view.fxml"));

        Parent root = fxmlLoader.load();
        MainController controller = fxmlLoader.getController();

        Scene scene = new Scene(root);
        stage.setTitle("ESTOQUE");
        stage.setScene(scene);
        stage.setFullScreen(false);
        stage.show();

        controller.inicializar();
    }

    public static void main(String[] args) {
        launch();
    }
}