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
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Christian Sahlström
 */
public class InputFlightDataController implements Initializable {

    String company;
    double seats;
    @FXML
    TextField fieldCompany;
    @FXML
    TextField passangerSeatField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void handleButtonEvent(ActionEvent event) throws IOException {
        getValues();
        System.out.println(company + seats);
        Stage stage = new Stage();
        Pane myPane = null;
        myPane = FXMLLoader.load(getClass().getResource("InputEmployeeData.fxml"));
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
            seats = Double.parseDouble(passangerSeatField.getText());
        } catch (Exception e) {

        }
    }

}
