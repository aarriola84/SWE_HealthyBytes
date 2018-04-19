package healthybytes;

import login.LoginView;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * @author Alexis Arriola
 */
public class MainView extends BorderPane
{
    public MainView()
    {
        
    }
    
    public void SetCurrentView(Pane loginView)
    {
        this.setStyle("-fx-background-color: #ff8800;");
        this.setCenter(loginView);
    }
}
