package adminprojectrad;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AdminProjectRAD extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        DBhandler db = new DBhandler();
        db.connectingDatabase();
//        db.fetchingDataIntoCostumer("940506-6344", "Greger", "Nicklasson","greger.cool@msn.com" , "nybovägen", "254-37", "046543322", "0733624439");
        Pane myPane = null;
        myPane = FXMLLoader.load(getClass().getResource("LogInAdmin.fxml"));
        Scene scene = new Scene(myPane);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws IOException {
        launch(args);
    }

}
