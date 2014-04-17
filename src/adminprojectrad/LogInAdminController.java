package adminprojectrad;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
public class LogInAdminController implements Initializable {

    private String user = "root";
    private String pass = "root";
    private String confirmUsername, confirmPassword;

    @FXML
    TextField usernameField;
    @FXML
    PasswordField passwordField;
    @FXML
    Button loginButton;
    @FXML
    Button registerButton;

    @FXML
    private void handleLoginButton(ActionEvent event) throws IOException {
        confirmUsername = usernameField.getText().toString();
        confirmPassword = passwordField.getText();
        if (confirmUsername.equals(user) && confirmPassword.equals(pass)) {
            Stage stage = new Stage();
            Pane myPane = null;
            myPane = FXMLLoader.load(getClass().getResource("InputData.fxml"));
            Scene scene = new Scene(myPane);
            stage.setScene(scene);
            stage.show();

        } else {

            System.out.println("Wrong username or password");
            System.out.println(pass + user);
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

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
