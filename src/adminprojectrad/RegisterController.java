package adminprojectrad;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Christian
 */
public class RegisterController implements Initializable {

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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleSaveButton(ActionEvent ev) {

    }

}
