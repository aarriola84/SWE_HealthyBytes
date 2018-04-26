package login;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

/**
 * @author Alexis Arriola
 */
public class LoginForm extends GridPane
{
    //boxes
    private HBox buttonBox = new HBox(2);
    private VBox formBox = new VBox(10);
    
    //labels
    private Label emailLabel = new Label("Enter email:");
    private Label passLabel = new Label("Enter password:");
    
    //textfields
    private TextField emailTF = new TextField();
    private PasswordField passTF = new PasswordField();
    
    //buttons
    private Button loginButton = new Button("Login");
    private Button registerButton = new Button("Register");
    
    //login images
    private Image loginImage = new Image("images/hb.png");
    private ImageView loginIV = new ImageView(loginImage);
    
    //constructor
    public LoginForm()
    {
        //resize image
        loginIV.setFitHeight(350);
        loginIV.setFitWidth(400);
        
        //change label
        emailLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 16));
        passLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 16));
        
        //add to button box
        buttonBox.getChildren().addAll(loginButton, registerButton);
        
        //add to form box
        formBox.getChildren().addAll(emailLabel, emailTF, passLabel, passTF, buttonBox);
        
        //add all fields to the VBox
        this.add(loginIV, 0, 0);
        this.add(formBox, 0, 1);
        this.add(buttonBox, 0, 2);
       
        this.setAlignment(Pos.CENTER);
    }
    
    //properties
    /**
     * @return the emailLabel
     */
    public Label GetEmailLabel()
    {
        return emailLabel;
    }

    /**
     * @param emailLabel the emailLabel to set
     */
    public void SetEmailLabel(Label emailLabel)
    {
        this.emailLabel = emailLabel;
    }

    /**
     * @return the passLabel
     */
    public Label GetPassLabel()
    {
        return passLabel;
    }

    /**
     * @param passLabel the passLabel to set
     */
    public void SetPassLabel(Label passLabel)
    {
        this.passLabel = passLabel;
    }

    /**
     * @return the emailTF
     */
    public TextField GetEmailTF()
    {
        return emailTF;
    }

    /**
     * @param emailTF the emailTF to set
     */
    public void SetEmailTF(TextField emailTF)
    {
        this.emailTF = emailTF;
    }

    /**
     * @return the passTF
     */
    public PasswordField GetPassTF()
    {
        return passTF;
    }

    /**
     * @param passTF the passTF to set
     */
    public void SetPassTF(PasswordField passTF)
    {
        this.passTF = passTF;
    }

    /**
     * @return the buttonBox
     */
    public HBox GetButtonBox()
    {
        return buttonBox;
    }

    /**
     * @param buttonBox the buttonBox to set
     */
    public void SetButtonBox(HBox buttonBox)
    {
        this.buttonBox = buttonBox;
    }

    /**
     * @return the loginButton
     */
    public Button GetLoginBtn()
    {
        return loginButton;
    }

    /**
     * @param loginButton the loginButton to set
     */
    public void SetLoginBtn(Button loginButton)
    {
        this.loginButton = loginButton;
    }

    /**
     * @return the registerButton
     */
    public Button GetRegisterBtn()
    {
        return registerButton;
    }

    /**
     * @param registerButton the registerButton to set
     */
    public void SetRegisterBtn(Button registerButton)
    {
        this.registerButton = registerButton;
    }
    
    //functions
    public void ClearTF()
    {
        emailTF.clear();
        passTF.clear();
    }
}
