package login;

import javafx.scene.layout.BorderPane;

/**
 * @author Alexis Arriola
 */
public class LoginView extends BorderPane
{
    //forms
    private LoginForm loginForm = new LoginForm();
    private RegisterForm registerForm = new RegisterForm();
    
    //constructor
    public LoginView()
    {
        this.setStyle("-fx-background-color: #ff8800;");
        this.setCenter(loginForm);
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
        this.setCenter(loginForm);
    }
    
    public void SetRegisterForm()
    {
        this.getChildren().clear();
        this.setCenter(registerForm);
    }
}
