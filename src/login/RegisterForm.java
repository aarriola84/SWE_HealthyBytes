package login;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

/**
 *
 * @author Matthew Rodriguez
 * Date: April 18, 2018
 * Revision Date: April 18, 2018
 */
public class RegisterForm extends GridPane
{
    private Label titleLabel = new Label ("User Registration Form");
    private Label errorLabel = new Label ("Duplicate Username and/or password.\nEnter unique username and password");
    private Label usernameLabel = new Label("Enter User Name for Registration");
    private Label passwordLabel = new Label("Enter password for Login Authentication");
    private TextField usernameTF = new TextField();
    private TextField passwordTF = new TextField();
    private Button registerBtn = new Button("Register");
    private Button cancelBtn = new Button("Cancel");
    VBox labelTFVBox = new VBox(10);
    HBox buttonHBox = new HBox(5);

    //constructors
    /**
     * Main RegisterView GUI Start Up
     */
    public RegisterForm()
    {
        titleLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 40));
        labelTFVBox.getChildren().addAll(usernameLabel,usernameTF,passwordLabel,passwordTF);
        buttonHBox.getChildren().addAll(registerBtn,cancelBtn);
        this.add(titleLabel,0,0);
        this.add(labelTFVBox,0,1);
        this.add(buttonHBox,0,2);
        this.setAlignment(Pos.CENTER);
    }
    
    //properties
    /**
     * @return the titleLabel
     */
    public Label GetTitleLabel()
    {
        return titleLabel;
    }

    /**
     * @param titleLabel the titleLabel to set
     */
    public void SetTitleLabel(Label titleLabel)
    {
        this.titleLabel = titleLabel;
    }

    /**
     * @return the usernameLabel
     */
    public Label GetUsernameLabel()
    {
        return usernameLabel;
    }

    /**
     * @param usernameLabel the usernameLabel to set
     */
    public void SetUsernameLabel(Label usernameLabel)
    {
        this.usernameLabel = usernameLabel;
    }

    /**
     * @return the passwordLabel
     */
    public Label GetPasswordLabel()
    {
        return passwordLabel;
    }

    /**
     * @param passwordLabel the passwordLabel to set
     */
    public void SetPasswordLabel(Label passwordLabel)
    {
        this.passwordLabel = passwordLabel;
    }

    /**
     * @return the usernameTF
     */
    public TextField GetUsernameTF()
    {
        return usernameTF;
    }

    /**
     * @param usernameTF the usernameTF to set
     */
    public void SetUsernameTF(TextField usernameTF)
    {
        this.usernameTF = usernameTF;
    }

    /**
     * @return the passwordTF
     */
    public TextField GetPasswordTF()
    {
        return passwordTF;
    }

    /**
     * @param passwordTF the passwordTF to set
     */
    public void SetPasswordTF(TextField passwordTF)
    {
        this.passwordTF = passwordTF;
    }

    /**
     * @return the registerBtn
     */
    public Button GetRegisterBtn()
    {
        return registerBtn;
    }

    /**
     * @param registerBtn the registerBtn to set
     */
    public void SetRegisterBtn(Button registerBtn)
    {
        this.registerBtn = registerBtn;
    }

    /**
     * @return the cancelBtn
     */
    public Button GetCancelBtn()
    {
        return cancelBtn;
    }

    /**
     * @param cancelBtn the cancelBtn to set
     */
    public void SetCancelBtn(Button cancelBtn)
    {
        this.cancelBtn = cancelBtn;
    }   
    
    /**
     * @return the errorLabel
     */
    public Label GetErrorLabel()
    {
        return errorLabel;
    }

    /**
     * @param errorLabel the errorLabel to set
     */
    public void SetErrorLabel(Label errorLabel)
    {
        this.errorLabel = errorLabel;
    }
    
    /**
     * GUI is called when the username being entered
     */
    public void RegisterViewDuplicateUserNameOrPassword()
    {
        this.getChildren().clear();
        titleLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 40));
        errorLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 20));
        labelTFVBox.getChildren().addAll(usernameLabel,usernameTF,passwordLabel,passwordTF);
        buttonHBox.getChildren().addAll(registerBtn,cancelBtn);
        this.add(titleLabel,0,0);
        this.add(errorLabel,0,1);
        this.add(labelTFVBox,0,2);
        this.add(buttonHBox,0,3);
        this.setAlignment(Pos.CENTER);
    }
}