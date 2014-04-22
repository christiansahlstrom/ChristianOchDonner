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
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sahlström
 */
public class InputHotelDataController implements Initializable, FieldNullListener {

    private String hotel, country, idfield, cityfield, imageURL, info;
    private boolean allowedToAdd = true;
    @FXML
    Button addButton;
    @FXML
    TextField hotelField;
    @FXML
    TextField countryField;
    @FXML
    TextField cityField;
    @FXML
    TextField idField;
    @FXML
    TextField imageField;
    @FXML
    TextArea infoArea;
    @FXML
    ImageView imageView = new ImageView();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void handleButtonEvent(ActionEvent event) throws IOException {

        hotelField.setStyle("-fx-background-color: green;");
        cityField.setStyle("-fx-background-color: green;");
        countryField.setStyle("-fx-background-color: green;");
        imageField.setStyle("-fx-background-color: green;");
        idField.setStyle("-fx-background-color: green;");

        initializing();
        try {
            if (allowedToAdd) {
                fetchingToDB();
                Scene scene = new Scene(new Group(new Text(50, 50, hotel + " is added to database")));
                Stage stage = new Stage();
                stage.setTitle("Message");
                stage.setScene(scene);
                stage.sizeToScene();
                stage.show();
            } else {
                allowedToAdd = true;
            }
        } catch (Exception ex) {
            System.out.println(ex);
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

    private void initializing() {
        hotel = hotelField.getText().toString();
        if (checkIfFieldIsNull(hotelField)) {
            turnColorField(hotelField);
        }
        country = countryField.getText().toString();
        if (checkIfFieldIsNull(countryField)) {
            turnColorField(countryField);
        }
        idfield = idField.getText().toString();
        if (checkIfFieldIsNull(idField)) {
            turnColorField(idField);
        }
        cityfield = cityField.getText().toString();
        if (checkIfFieldIsNull(cityField)) {
            turnColorField(cityField);
        }
        imageURL = imageField.getText().toString();
        try {
            Image image = new Image(imageURL);
            imageView.setImage(image);
        } catch (Exception e) {
            imageField.setStyle("-fx-background-color: red;");
        }
        info = infoArea.getText().toString();
    }

    private void fetchingToDB() throws Exception {
        DBhandler db = new DBhandler();
        db.connectingDatabase();
        db.fetchingDataIntoHotell(hotel, country, cityfield, idfield, info, imageURL);

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
