package healthybytes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import login.LoginController;
import login.LoginModel;
import login.LoginView;
import mainmenu.MainMenuView;

/**
 * @authors "Night owls"
 */
public class HealthyBytes extends Application
{
    //stage
    Stage mainStage;
    
    //views
    LoginView loginView = new LoginView();
    MainMenuView mainMenuView = new MainMenuView();
    
    //models
    LoginModel loginModel = new LoginModel();
    
    //scenes
    Scene loginScene = new Scene(loginView, 900, 700);
    Scene mainMenuScene = new Scene(mainMenuView, 900, 700);
    
    //controllers
    LoginController lc;
    MainController mc;
    
    @Override
    public void start(Stage primaryStage)
    {
        //set stage instance
        mainStage = primaryStage;
        
        //setup controllers
        lc = new LoginController(mainStage, loginView, loginModel, mainMenuScene);
        mc = new MainController(lc);
        
        //show intial scene
        mainStage.setTitle("Healthy Bytes");
        mainStage.setScene(loginScene);
        mainStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }
    
}
