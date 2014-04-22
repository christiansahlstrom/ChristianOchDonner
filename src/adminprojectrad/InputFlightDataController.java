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
 * @author Christian Sahlström
 */
public class InputFlightDataController implements Initializable, FieldNullListener {

    private String company, takeOff;
    private boolean allowedToAdd = true;
    private int seats = 0;
    @FXML
    TextField fieldCompany;
    @FXML
    TextField passangerSeatField;
    @FXML
    TextField takeOffStart;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void handleButtonEvent(ActionEvent event) throws IOException, Exception {
        fieldCompany.setStyle("-fx-background-color: green;");
        passangerSeatField.setStyle("-fx-background-color: green;");
        takeOffStart.setStyle("-fx-background-color: green;");
        getValues();
        if (allowedToAdd) {
            addToDataBase();
            Scene scene = new Scene(new Group(new Text(50, 50, company + " flight is added to database")));
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
        try {
            company = fieldCompany.getText().toString();
            if (checkIfFieldIsNull(fieldCompany)) {
                turnColorField(fieldCompany);
            }
            takeOff = takeOffStart.getText().toString();
            if (checkIfFieldIsNull(takeOffStart)) {
                turnColorField(takeOffStart);
            }
            seats = Integer.parseInt(passangerSeatField.getText());
        } catch (Exception e) {
            if (seats <= 0) {
                turnColorField(passangerSeatField);
            }
        }
    }

    private void addToDataBase() throws Exception {
        DBhandler db = new DBhandler();
        db.connectingDatabase();
        db.fetchingDataToflight(company, seats, company);
    }

    @Override
    public boolean checkIfFieldIsNull(TextField currentField) {
        if (currentField.getText().equals("")) {
            return true;
        } else {
            allowedToAdd = true;
            return false;
        }
    }

    @Override
    public void turnColorField(TextField nullField) {
        allowedToAdd = false;
        nullField.setStyle("-fx-background-color: red;");
    }
}
