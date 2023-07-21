package sample.controllers;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import sample.dateBase.DateBase;
import sample.models.TransportModel;

import static sample.Main.*;


public class MainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btDelete;

    @FXML
    private Button btExit;

    @FXML
    private Button btInsert;

    @FXML
    private Button btSearch;

    @FXML
    private Button btUpdate;

    @FXML
    private TableView<ObservableList> tableView;

    DateBase bd = new DateBase();

    @FXML
    void initialize() {

        try {
            selectTableView("SELECT * From trans ", tableView);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        btExit.setOnAction(actionEvent -> {
            btExit.getScene().getWindow().hide();
        });

        btInsert.setOnAction(actionEvent -> {
            openView("resource/Insert-View.fxml");
            btInsert.getScene().getWindow().hide();
        });

        btUpdate.setOnAction(actionEvent -> {
            ObservableList<String> collection = tableView.getSelectionModel().getSelectedItem();
            TransportModel.setId(collection.get(0));
            TransportModel.setBrand(collection.get(1));
            TransportModel.setModel(collection.get(2));
            TransportModel.setCategory(collection.get(3));
            TransportModel.setNumber(collection.get(4));
            TransportModel.setType(collection.get(5));
            TransportModel.setDate(collection.get(6));
            TransportModel.setTrailer(collection.get(7));
            openView("resource/Update-View.fxml");
            btUpdate.getScene().getWindow().hide();
        });

        btSearch.setOnAction(actionEvent -> {
            openView("resource/Search-View.fxml");
            btSearch.getScene().getWindow().hide();
        });

        btDelete.setOnAction(actionEvent -> {
            ObservableList<String> collection = tableView.getSelectionModel().getSelectedItem();
            TransportModel.setId(collection.get(0));
            bd.delete("DELETE From trans WHERE id =" + TransportModel.getId());
            try {
                selectTableView("SELECT * From trans ", tableView);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });


    }

}

