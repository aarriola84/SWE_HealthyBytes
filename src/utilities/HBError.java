package utilities;

import javafx.scene.control.Alert;

/**
 * @author Alexis Arriola
 */
public class HBError 
{
    public static void ErrorAlert(String title, String Header, String Content)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(Header);
        alert.setContentText(Content);
        alert.showAndWait();
    }

}
