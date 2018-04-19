package login;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

/**
 * @author Alexis Arriola
 */
public class LoginView extends GridPane
{
    //forms
    private LoginForm loginForm = new LoginForm();
    private RegisterForm registerForm = new RegisterForm();
    private MainMenuForm mainMenuForm = new MainMenuForm();
    
    //constructor
    public LoginView()
    {
        this.add(loginForm, 0, 0);
        this.setAlignment(Pos.CENTER);
    }
    
    //properties
    /**
     * @return the loginForm
     */
    public LoginForm GetLoginForm()
    {
        return loginForm;
    }

    /**
     * @param loginForm the loginForm to set
     */
    public void SetLoginForm(LoginForm loginForm)
    {
        this.loginForm = loginForm;
    }

    /**
     * @return the registerForm
     */
    public RegisterForm GetRegisterForm()
    {
        return registerForm;
    }

    /**
     * @param registerForm the registerForm to set
     */
    public void SetRegisterForm(RegisterForm registerForm)
    {
        this.registerForm = registerForm;
    }
    
    //functions
    public void SetLoginForm()
    {
        this.getChildren().clear();
        this.add(loginForm, 0, 0);
    }
    
    public void SetRegisterForm()
    {
        this.getChildren().clear();
        this.add(registerForm, 0, 0);
    }
    
    public void SetMainMenuForm()
    {
        this.getChildren().clear();
        this.add(mainMenuForm, 0, 0);
    }
}
