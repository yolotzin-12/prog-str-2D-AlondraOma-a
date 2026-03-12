package com.example.demolistview.Controllers;

import com.example.demolistview.Service.PersonService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.List;

public class AppController {

    @FXML
    private ListView<String> listView;
    @FXML
    private Label lblMsg;

    @FXML
    private TextField textName;

    @FXML
    private TextField textEmail;

    @FXML
    private TextField textAge;



    @FXML
    private final ObservableList<String> data = FXCollections.observableArrayList();

    private PersonService Service= new PersonService();

    @FXML
    public void initialize(){ //se va a ejecutar el inicio, en cuanto se cargue el controller
        //Inicializar ListView

        loadFromFile();
        listView.setItems(data);
    }
    public void onAddPerson(){
        try{
            String name= textName.getText();
            String email= textEmail.getText();
            int age = Integer.parseInt(textAge.getText());

            Service.addPerson(name,email,age);

            lblMsg.setText("Persona agregada con exito");
            lblMsg.setStyle("-fx-text-fill: green");
            textName.clear();
            textEmail.clear();
            textAge.clear();
            loadFromFile();

        }catch(IOException e){
            lblMsg.setText("Hubo un error con el archivo");
            lblMsg.setStyle("-fx-text-fill: red");
        }catch (IllegalArgumentException ex){
            lblMsg.setText("Hubo un error con los datos");
            lblMsg.setStyle("-fx-text-fill: red");
        }
    }

    private void loadFromFile(){
        try{
            List<String> items = Service.loadDataforList();
            data.setAll(items);
            lblMsg.setText("Datos cargados exitosamente ");
            lblMsg.setStyle("-fx-text-fill: green");
        } catch (IOException e) {
            lblMsg.setText(e.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");
        }

    }

}