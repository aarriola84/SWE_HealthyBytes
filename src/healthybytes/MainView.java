package healthybytes;

import gui.LoginView;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;

/**
 * @author Alexis Arriola
 */
public class MainView extends BorderPane
{
    //the different views
    LoginView loginView = new LoginView();
    
    public MainView()
    {
        loginView.setAlignment(Pos.CENTER);
        this.setCenter(loginView);
    }
}
