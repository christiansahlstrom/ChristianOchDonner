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
    private String fName;
    private String lName;
    private String pWord;
    private String uName;
    private String social;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleSaveButton(ActionEvent ev) {

        fName = fNameField.getText().toString();
        lName = lNameField.getText().toString();
        pWord = passwordField.getText().toString();
        uName = userNameField.getText().toString();
        social = socialField.getText().toString();

        addToEmployee();
    }

    public void addToEmployee() {
        DBhandler db = new DBhandler();
        try {
            db.connectingDatabase();
            db.fetchDataIntoEmployee(fName, lName, uName, pWord, social);
        } catch (Exception ex) {

            System.out.print(ex);
        }

    }

}
