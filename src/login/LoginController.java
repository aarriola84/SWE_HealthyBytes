package login;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Alexis Arriola
 */
public class LoginController 
{
    //stage ref
    Stage mainStage;
    
    //scenes
    Scene mainMenuScene;

    //views
    private LoginView loginView;
    
    //model
    private LoginModel loginModel;
    
    //constructor
    public LoginController(Stage mainStage, LoginView loginView, LoginModel loginModel, Scene mainMenuScene)
    {
        this.mainStage = mainStage;
        this.loginView = loginView;
        this.mainMenuScene = mainMenuScene;
        this.loginModel = loginModel;
    }
    
    public void attachHandlers()
    {
        //login form buttons
        GetLoginView().GetLoginForm().GetLoginBtn().setOnAction(
                new EventHandler<ActionEvent>()
                {
                     public void handle(ActionEvent event)
                     {
                         mainStage.setScene(mainMenuScene);
                     }
                });
        
        GetLoginView().GetLoginForm().GetRegisterBtn().setOnAction(
                new EventHandler<ActionEvent>()
                {
                     public void handle(ActionEvent event)
                     {
                         GetLoginView().SetRegisterForm();
                     }
                });
        
        //register form buttons
        GetLoginView().GetRegisterForm().GetRegisterBtn().setOnAction(
                new EventHandler<ActionEvent>()
                {
                     public void handle(ActionEvent event)
                     {
                         //do database work here
                     }
                });
         GetLoginView().GetRegisterForm().GetCancelBtn().setOnAction(
                new EventHandler<ActionEvent>()
                {
                     public void handle(ActionEvent event)
                     {
                         GetLoginView().SetLoginForm();
                     }
                });
    }
    /**
     * @return the loginView
     */
    public LoginView GetLoginView()
    {
        return loginView;
    }

    /**
     * @param loginView the loginView to set
     */
    public void SetLoginView(LoginView loginView)
    {
        this.loginView = loginView;
    }
     /**
     * @return the loginModel
     */
    public LoginModel GetLoginModel()
    {
        return loginModel;
    }

    /**
     * @param loginModel the loginModel to set
     */
    public void SetLoginModel(LoginModel loginModel)
    {
        this.loginModel = loginModel;
    }
}
