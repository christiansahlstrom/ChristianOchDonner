package adminprojectrad;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AdminProjectRAD extends Application {

    DBhandler db = new DBhandler();

    @Override
    public void start(Stage stage) throws Exception {
        db.connectingDatabase();
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
