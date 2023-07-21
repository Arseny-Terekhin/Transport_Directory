package sample.controllers;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import static sample.Main.openView;
import static sample.Main.selectTableView;

public class SearchController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btExit;

    @FXML
    private Button btSearch;

    @FXML
    private Label lbEror;

    @FXML
    private TableView<ObservableList> tableView;

    @FXML
    private TextField tfBrand;

    @FXML
    private TextField tfCategory;

    @FXML
    private TextField tfModel;

    @FXML
    private TextField tfNumber;


    @FXML
    void initialize() {
        btExit.setOnAction(actionEvent -> {
            openView("resource/Main-View.fxml");
            btExit.getScene().getWindow().hide();
        });

        btSearch.setOnAction(actionEvent -> {
            String str = "Select * from trans Where";
            int d = 0;
            if (!tfBrand.getText().equals("")){d++;}
            if (!tfModel.getText().equals("")){d++;}
            if (!tfNumber.getText().equals("")){d++;}
            if (!tfCategory.getText().equals("")){d++;}
            String brand = tfBrand.getText();
            String model = tfModel.getText();
            String category = tfCategory.getText();
            String number = tfNumber.getText();
            for (int i = 0; i < d; i++){
                if (!brand.equals("")){
                    str += " car_brand LIKE '%" + brand + "%' and";
                    brand = "";
                    continue;}
                if (!model.equals("")){
                    str += " car_model LIKE '%" + model + "%' and";
                    model = "";
                    continue;}
                if (!number.equals("")){
                    str += " state_number LIKE '%" + number + "%' and";
                    number = "";
                    continue;}
                if (!category.equals("")) {
                    str += " car_category LIKE '%" + category + "%' and";
                    category = "";
                    continue; }
            }
            str = str.substring(0, str.length() - 3);
            System.out.println(str);
            try {
                selectTableView(str, tableView);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }

}

