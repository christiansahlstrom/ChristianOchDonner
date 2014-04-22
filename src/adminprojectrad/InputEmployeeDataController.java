/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminprojectrad;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Christian
 */
public class InputEmployeeDataController implements Initializable, FieldNullListener {

    DBhandler db = new DBhandler();

    private String fName, lName, social, username, password, repeatPassword;

    @FXML
    TextField firstnameField;
    @FXML
    TextField lastNameField;
    @FXML
    TextField socialField;
    @FXML
    TextField empNbrField;
    @FXML
    TextField passwordField;
    @FXML
    TextField usernameField;
    @FXML
    TextField repeatField;
    private boolean allowedToAdd = true;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void handleButtonEvent(ActionEvent event) throws Exception {
        firstnameField.setStyle("-fx-background-color: green;");
        lastNameField.setStyle("-fx-background-color: green;");
        socialField.setStyle("-fx-background-color: green;");
        passwordField.setStyle("-fx-background-color: green;");
        repeatField.setStyle("-fx-background-color: green;");
        usernameField.setStyle("-fx-background-color: green;");
        getValues();
        if (allowedToAdd) {
            addToDataBase();
            Scene scene = new Scene(new Group(new Text(50, 50, fName + " is added to database")));
            Stage stage = new Stage();
            stage.setTitle("Message");
            stage.setScene(scene);
            stage.sizeToScene();
            stage.show();
        } else {
            allowedToAdd = true;
        }
    }

    @FXML
    private void handleBackButtonEvent(ActionEvent event) throws IOException {
        Pane myPane = null;
        Stage stage = new Stage();

        myPane = FXMLLoader.load(getClass().getResource("InputData.fxml"));
        Scene scene = new Scene(myPane);
        stage.setScene(scene);
        stage.show();
        Node source = (Node) event.getSource();
        Stage stage1 = (Stage) source.getScene().getWindow();
        stage1.close();
    }

    private void getValues() {
        fName = firstnameField.getText().toString();
        if (checkIfFieldIsNull(firstnameField)) {
            turnColorField(firstnameField);
        }
        lName = lastNameField.getText().toString();
        if (checkIfFieldIsNull(lastNameField)) {
            turnColorField(lastNameField);
        }

        social = socialField.getText().toString();
        if (checkIfFieldIsNull(socialField) || social.length() > 11) {
            turnColorField(socialField);
        }
        username = usernameField.getText().toString();
        if (checkIfFieldIsNull(usernameField)) {
            turnColorField(usernameField);
        }
        password = passwordField.getText().toString();
        if (checkIfFieldIsNull(passwordField)) {
            turnColorField(passwordField);
        }
        repeatPassword = repeatField.getText().toString();
        if (checkIfFieldIsNull(repeatField)) {
            turnColorField(repeatField);
        } else if (repeatPassword.equals(password)) {

        } else {
            turnColorField(repeatField);
        }
    }

    private void addToDataBase() throws Exception {
        db.connectingDatabase();
        db.fetchDataIntoEmployee(fName, lName, username, password, social);
    }

    @Override
    public boolean checkIfFieldIsNull(TextField currentField) {
        if (currentField.getText().equals("")) {
            allowedToAdd = true;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void turnColorField(TextField nullField) {
        allowedToAdd = false;
        nullField.setStyle("-fx-background-color: red;");
    }
}
