package adminprojectrad;

import javafx.scene.control.TextField;

/**
 *
 * @author Christian Sahlström
 */
public interface FieldNullListener {

    boolean checkIfFieldIsNull(TextField currentField);
    void turnColorField(TextField nullField);

}
