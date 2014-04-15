/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminprojectrad;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Christian
 */
public class InputEmployeeDataController implements Initializable {

    DBhandler db = new DBhandler();

    private String fName, lName, social,username,password;
    private int empNbr;

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
    TextField usernameField ;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void handleButtonEvent(ActionEvent event) throws Exception {
        getValues();
        System.out.println(fName + lName + social + "E" + empNbr);
        addToDataBase();

//        Node source = (Node) event.getSource();
//        Stage stage1 = (Stage) source.getScene().getWindow();
//        stage1.close();
    }

    private void getValues() {
        fName = firstnameField.getText().toString();
        lName = lastNameField.getText().toString();
        social = socialField.getText().toString();
        username = usernameField.getText().toString();
        password = passwordField.getText().toString();
        try {
            empNbr = Integer.parseInt(empNbrField.getText());
        } catch (Exception e) {
            empNbrField.setStyle("-fx-background-color: red;");
        }
    }

    public void addToDataBase() throws Exception {
        System.out.println(empNbr + fName);
        db.connectingDatabase();
        db.fetchingDataIntoEmployee(empNbr, fName);

    }
}
