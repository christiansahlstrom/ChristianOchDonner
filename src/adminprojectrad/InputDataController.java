package adminprojectrad;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class InputDataController implements Initializable {

    private String choiceToBeMade = "";
    @FXML
    Button continueButton;
    @FXML
    Button logOut;
    @FXML
    ChoiceBox cb;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setUpChoiceBox();
    }

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Pane myPane = null;

        if (choiceToBeMade.equals("Hotel")) {
            myPane = FXMLLoader.load(getClass().getResource("InputHotelData.fxml"));
            Scene scene = new Scene(myPane);
            stage.setScene(scene);
            stage.show();

        } else if (choiceToBeMade.equals("Flight")) {
            myPane = FXMLLoader.load(getClass().getResource("InputFlightData.fxml"));
            Scene scene = new Scene(myPane);
            stage.setScene(scene);
            stage.show();
        } else if (choiceToBeMade.equals("Employee")) {
            myPane = FXMLLoader.load(getClass().getResource("InputEmployeeData.fxml"));
            Scene scene = new Scene(myPane);
            stage.setScene(scene);
            stage.show();
        }

        Node source = (Node) event.getSource();
        Stage stage1 = (Stage) source.getScene().getWindow();
        stage1.close();

    }

    @FXML
    private void handleLogOutButtonEvent(ActionEvent event) throws IOException {

        Stage stage = new Stage();
        Pane myPane = null;
        myPane = FXMLLoader.load(getClass().getResource("LogInAdmin.fxml"));
        Scene scene = new Scene(myPane);
        stage.setScene(scene);
        stage.show();
        Node source = (Node) event.getSource();
        Stage stage1 = (Stage) source.getScene().getWindow();
        stage1.close();

    }

    public void setUpChoiceBox() {
        cb.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue ov, Object t, Object t1) {
                switch ((int) t1) {
                    case 0:
                        choiceToBeMade = "Hotel";
                        break;
                    case 1:
                        choiceToBeMade = "Flight";
                        break;
                    case 2:
                        choiceToBeMade = "Employee";
                        break;
                }
            }
        });
    }

}
