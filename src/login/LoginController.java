package login;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * @author Alexis Arriola
 */
public class LoginController 
{

    //views
    private LoginView loginView;
    
    //models
    
    public LoginController(LoginView loginView)
    {
        this.loginView = loginView;
    }
    
    public void attachHandlers()
    {
        //login view buttons
        GetLoginView().GetLoginForm().GetLoginBtn().setOnAction(
                new EventHandler<ActionEvent>()
                {
                     public void handle(ActionEvent event)
                     {
                         GetLoginView().SetMainMenuForm();
                     }
                });
        
        GetLoginView().GetLoginForm().GetRegisterBtn().setOnAction(new EventHandler<ActionEvent>()
                {
                     public void handle(ActionEvent event)
                     {
                         GetLoginView().SetRegisterForm();
                     }
                });
        
        //register view buttons
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
}
