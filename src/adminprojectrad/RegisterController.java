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
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Christian
 */
public class RegisterController implements Initializable, FieldNullListener {

    private boolean allowedToAdd = true;
    @FXML
    TextField fNameField;
    @FXML
    TextField lNameField;
    @FXML
    TextField repPasswordField;
    @FXML
    TextField passwordField;
    @FXML
    TextField userNameField;
    @FXML
    TextField socialField;
    @FXML
    Button saveUserButton;
    private String fName;
    private String lName;
    private String pWord;
    private String uName;
    private String social;
    private String repeatPword;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleSaveButton(ActionEvent ev) {
        fNameField.setStyle("-fx-background-color: green;");
        lNameField.setStyle("-fx-background-color: green;");
        socialField.setStyle("-fx-background-color: green;");
        passwordField.setStyle("-fx-background-color: green;");
        repPasswordField.setStyle("-fx-background-color: green;");
        userNameField.setStyle("-fx-background-color: green;");

        getValues();
    }

    @FXML
    private void handleBackButton(ActionEvent event) throws IOException {
        Pane myPane = null;
        Stage stage = new Stage();
        myPane = FXMLLoader.load(getClass().getResource("LogInAdmin.fxml"));
        Scene scene = new Scene(myPane);
        stage.setScene(scene);
        stage.show();

        Node source = (Node) event.getSource();
        Stage stage1 = (Stage) source.getScene().getWindow();
        stage1.close();
    }

    public void addToEmployee() {
        DBhandler db = new DBhandler();
        try {
            db.connectingDatabase();
            db.fetchDataIntoEmployee(fName, lName, uName, pWord, social);
            Scene scene = new Scene(new Group(new Text(50, 50, "Added to database")));
            Stage stage = new Stage();
            stage.setTitle("Message");
            stage.setScene(scene);
            stage.sizeToScene();
            stage.show();
        } catch (Exception ex) {

            System.out.print(ex);
        }

    }

    private void getValues() {

        fName = fNameField.getText().toString();
        if (checkIfFieldIsNull(fNameField)) {
            turnColorField(fNameField);
        }
        lName = lNameField.getText().toString();
        if (checkIfFieldIsNull(lNameField)) {
            turnColorField(lNameField);
        }
        pWord = passwordField.getText().toString();
        if (checkIfFieldIsNull(passwordField)) {
            turnColorField(passwordField);
        }
        repeatPword = repPasswordField.getText().toString();
        if (checkIfFieldIsNull(repPasswordField)) {
            turnColorField(repPasswordField);
        } else if (repeatPword.equals(pWord)) {

        } else {
            turnColorField(repPasswordField);
        }
        uName = userNameField.getText().toString();
        if (checkIfFieldIsNull(userNameField)) {
            turnColorField(userNameField);
        }
        social = socialField.getText().toString();
        if (checkIfFieldIsNull(socialField) || social.length() > 11) {
            turnColorField(socialField);
        }
        if (allowedToAdd) {
            addToEmployee();
        } else {
            allowedToAdd = true;
        }

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
