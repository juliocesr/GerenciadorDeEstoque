module sistema.sistemadegerenciamento {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens sistema.sistemadegerenciamento to javafx.fxml;
    exports sistema.sistemadegerenciamento;
    exports sistema.sistemadegerenciamento.controller;
    opens sistema.sistemadegerenciamento.controller to javafx.fxml;
}