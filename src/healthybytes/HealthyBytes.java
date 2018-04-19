package healthybytes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import login.LoginController;
import login.LoginView;

/**
 * @authors "Night owls"
 */
public class HealthyBytes extends Application
{
    MainView mainView = new MainView();
    MainModel mainModel = new MainModel();
    LoginView loginView = new LoginView();
    LoginController lc = new LoginController(loginView);
    MainController mc = new MainController(mainModel,mainView, lc);
    
    @Override
    public void start(Stage primaryStage)
    {
        
        Scene scene = new Scene(mainView, 900, 700);
        
        primaryStage.setTitle("Healthy Bytes");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }
    
}
