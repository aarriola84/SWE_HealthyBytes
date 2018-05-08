package healthybytes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import login.LoginController;
import login.LoginModel;
import login.LoginView;
import mainmenu.MainMenuController;
import mainmenu.MainMenuView;
import myrecipes.MyRecipesController;
import myrecipes.MyRecipesModel;
import myrecipes.MyRecipesView;
import networking.EmailController;
import networking.EmailModel;
import networking.EmailView;
import search.SearchController;
import search.SearchModel;
import search.SearchView;

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
    SearchView searchView = new SearchView();
    MyRecipesView myRecipesView = new MyRecipesView();
    //EmailView emailView = new EmailView();
    
    //models
    LoginModel loginModel = new LoginModel();
    SearchModel searchModel = new SearchModel();
    MyRecipesModel myRecipesModel = new MyRecipesModel();
    //EmailModel  emailModel = new EmailModel();
    
    //scenes
    Scene loginScene = new Scene(loginView, 900, 700);
    Scene mainMenuScene = new Scene(mainMenuView, 900, 700);
    Scene searchScene = new Scene(searchView, 900, 700);
    Scene myRecipesScene = new Scene(myRecipesView, 900, 700);
    //Scene emailScene = new Scene(emailView, 900, 700);
    
    //controllers
    LoginController lc;
    MainMenuController mmc;
    SearchController sc;
    MyRecipesController mrc;
    //EmailController ec;
    MainController mc;
    
    @Override
    public void start(Stage primaryStage)
    {
        //set stage instance
        mainStage = primaryStage;
        
        //setup controllers
        lc = new LoginController(mainStage, loginView, loginModel, mainMenuScene);
        sc = new SearchController(mainStage, searchView, searchModel, mainMenuScene);
        mrc = new MyRecipesController(mainStage, myRecipesView, myRecipesModel, mainMenuScene);
        //ec = new EmailController(mainStage, emailView, emailModel, mainMenuScene);
        mmc = new MainMenuController(mainStage, mainMenuView, loginScene, searchScene, myRecipesScene, mrc);
        mc = new MainController(lc, mmc, sc, mrc);
        
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
