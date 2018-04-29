package login;

import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;

/**
 * @author Alexis Arriola
 */
public class LoginView extends BorderPane
{
    //background
    private Image backgroundImg = new Image("images/hbBlue.png");
    private BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
    private Background background = new Background(new BackgroundImage(backgroundImg, BackgroundRepeat.NO_REPEAT, 
                                                    BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, bSize));
    //forms
    private LoginForm loginForm = new LoginForm();
    private RegisterForm registerForm = new RegisterForm();
    
    //constructor
    public LoginView()
    {
        this.setBackground(background);
        //this.setStyle("-fx-background-color: #a9b1bc;");
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
