package adminprojectrad;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Christian
 */
public class LogInAdminController implements Initializable, FieldNullListener {

    private String confirmUsername, confirmPassword;
    DBhandler db = new DBhandler();
    @FXML
    TextField usernameField;
    @FXML
    PasswordField passwordField;
    @FXML
    Button loginButton;
    @FXML
    Button registerButton;

    @FXML
    private void handleLoginButton(ActionEvent event) throws IOException, SQLException, Exception {
        passwordField.setStyle("-fx-background-color: green;");
        usernameField.setStyle("-fx-background-color: green;");
        confirmUsername = usernameField.getText().toString();
        if (checkIfFieldIsNull(usernameField)) {
            turnColorField(usernameField);
        }
        confirmPassword = passwordField.getText();
        if (checkIfFieldIsNull(passwordField)) {
            turnColorField(passwordField);
        }
        db.connectingDatabase();
        if (db.getEmployeeData(confirmUsername, confirmPassword)) {

            Stage stage = new Stage();
            Pane myPane = null;
            myPane = FXMLLoader.load(getClass().getResource("InputData.fxml"));
            Scene scene = new Scene(myPane);
            stage.setScene(scene);
            stage.show();
            Node source = (Node) event.getSource();
            Stage stage1 = (Stage) source.getScene().getWindow();
            stage1.close();

        } else {
            turnColorField(usernameField);
            turnColorField(passwordField);
        }
    }

    @FXML
    private void handleRegisterButton(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Pane registerPane = null;
        registerPane = FXMLLoader.load(getClass().getResource("RegisterController.fxml"));
        Scene scene = new Scene(registerPane);
        stage.setScene(scene);
        stage.show();
        Node source = (Node) event.getSource();
        Stage stage1 = (Stage) source.getScene().getWindow();
        stage1.close();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb
    ) {
        // TODO
    }

    @Override
    public boolean checkIfFieldIsNull(TextField currentField) {
        if (currentField.getText().equals("")) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void turnColorField(TextField nullField) {
        nullField.setStyle("-fx-background-color: red;");
    }
}
