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
        loginView.GetLoginForm().GetLoginBtn().setOnAction(
                new EventHandler<ActionEvent>()
                {
                     public void handle(ActionEvent event)
                     {
                         String email = loginView.GetLoginForm().GetEmailTF().getText();
                         String pass = loginView.GetLoginForm().GetPassTF().getText();
                         
                         boolean isValid = loginModel.VerifyUser(email, pass);
                         
                         if(isValid)
                         {
                             loginView.GetLoginForm().ClearTF();
                             mainStage.setScene(mainMenuScene);
                         }
                         else
                         {
                             //some error
                             System.out.println("Invalid User!");
                         }
                         
                     }
                });
        
        loginView.GetLoginForm().GetRegisterBtn().setOnAction(
                new EventHandler<ActionEvent>()
                {
                     public void handle(ActionEvent event)
                     {
                         loginView.GetLoginForm().ClearTF();
                         loginView.SetRegisterForm();
                     }
                });
        
        //register form buttons
        loginView.GetRegisterForm().GetRegisterBtn().setOnAction(
                new EventHandler<ActionEvent>()
                {
                     public void handle(ActionEvent event)
                     {
                         String fName = loginView.GetRegisterForm().GetfNameTF().getText();
                         String lName = loginView.GetRegisterForm().GetlNameTF().getText();
                         String email = loginView.GetRegisterForm().GetUsernameTF().getText();
                         String pass = loginView.GetRegisterForm().GetPasswordTF().getText();
                         String dob = loginView.GetRegisterForm().GetDobTF().getText();
                         
                         User newUser = new User(0,fName, lName, email, pass, dob);
                         
                         //do database work here
                         loginModel.RegisterUser(newUser);
                         
                         loginView.GetRegisterForm().ClearTF();
                         loginView.SetLoginForm();
                     }
                });
         loginView.GetRegisterForm().GetCancelBtn().setOnAction(
                new EventHandler<ActionEvent>()
                {
                     public void handle(ActionEvent event)
                     {
                         loginView.GetRegisterForm().ClearTF();
                         loginView.SetLoginForm();
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
