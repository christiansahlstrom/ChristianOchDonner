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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Sahlström
 */
public class InputHotelDataController implements Initializable {

    private String hotel, country, idfield, cityfield, imageURL,info;

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
        initializing();
        System.out.println(hotel + country + idfield + cityfield+info);
//        Stage stage = new Stage();
//        Pane myPane = null;
//        myPane = FXMLLoader.load(getClass().getResource("InputFlightData.fxml"));
//        Scene scene = new Scene(myPane);
//        stage.setScene(scene);
//        stage.show();
//        Node source = (Node) event.getSource();
//        Stage stage1 = (Stage) source.getScene().getWindow();
//        stage1.close();
    }

    private void initializing() {
        hotel = hotelField.getText().toString();
        country = countryField.getText().toString();
        idfield = idField.getText().toString();
        cityfield = cityField.getText().toString();
        imageURL = imageField.getText().toString();
        info = infoArea.getText().toString();

        try {
            Image image = new Image(imageURL);
            imageView.setImage(image);
            System.out.println("Funkar");
        } catch (Exception e) {
            imageField.setStyle("-fx-background-color: red;");
            System.out.println("Gick ej");
        }

    }
}
