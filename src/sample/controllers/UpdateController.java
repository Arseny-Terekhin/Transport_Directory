package sample.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.dateBase.DateBase;
import sample.models.TransportModel;

import static sample.Main.openView;

public class UpdateController  {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btExit;

    @FXML
    private Button btIUpdate;

    @FXML
    private CheckBox checkBox;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private Label lbEror;

    @FXML
    private TextField tfBrand;

    @FXML
    private TextField tfCategory;

    @FXML
    private TextField tfDate;

    @FXML
    private TextField tfModel;

    @FXML
    private TextField tfNumber;

    DateBase bd = new DateBase();

    @FXML
    void initialize() {
        ObservableList<String> list = FXCollections.observableArrayList();
        list.add("Легковой автомобиль");
        list.add("Грузовой автомобиль");
        list.add("Фургон");
        list.add("Мотоцикл");
        list.add("Автобус");

        comboBox.setItems(list);

        tfBrand.setText(TransportModel.getBrand());
        tfModel.setText(TransportModel.getModel());
        tfCategory.setText(TransportModel.getCategory());
        tfNumber.setText(TransportModel.getNumber());
        tfDate.setText(TransportModel.getDate());

        comboBox.getSelectionModel().select(TransportModel.getType());
        btExit.setOnAction(actionEvent -> {
            openView("resource/Main-View.fxml");
            btExit.getScene().getWindow().hide();
        });

        btIUpdate.setOnAction(actionEvent -> {
            String brand = tfBrand.getText();
            String model = tfModel.getText();
            String category = tfCategory.getText();
            String number = tfNumber.getText();
            String type = comboBox.getSelectionModel().getSelectedItem();
            int date = Integer.valueOf(tfDate.getText());
            boolean c = checkBox.isSelected();
            String trailer = "нет";
            if(c){trailer = "есть";}
            if (brand.equals("") && model.equals("") && category.equals("")  && number.equals("")){
                lbEror.setText("Заполните все поля ввода");
            }else {
                    bd.update(Integer.valueOf(TransportModel.getId()) ,brand, model, category, number, type, date, trailer);
                    openView("resource/Main-View.fxml");
                    btExit.getScene().getWindow().hide();
            }


        });
    }

}

