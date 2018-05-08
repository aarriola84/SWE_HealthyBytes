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
    //labels
    private Label titleLabel = new Label ("User Registration Form");
    private Label errorLabel = new Label ("Duplicate Username and/or password.\nEnter unique username and password");
    private Label fNameLabel = new Label ("First name:");
    private Label lNameLabel = new Label ("Last name:");
    private Label usernameLabel = new Label("Email:");
    private Label passwordLabel = new Label("Password:");
    private Label dobLabel = new Label("Date of birth:");
    
    //textfields
    private TextField fNameTF = new TextField();
    private TextField lNameTF = new TextField();
    private TextField usernameTF = new TextField();
    private TextField passwordTF = new TextField();
    private TextField dobTF = new TextField();
    
    //buttons
    private Button registerBtn = new Button("Register");
    private Button cancelBtn = new Button("Cancel");
    
    //boxes
    VBox labelTFVBox = new VBox(10);
    HBox buttonHBox = new HBox(5);

    //constructors
    /**
     * Main RegisterView GUI Start Up
     */
    public RegisterForm()
    {
        this.setVgap(3);
        //change fonts of labels
        titleLabel.setFont(Font.font("Book Antiqua", FontWeight.BOLD, FontPosture.ITALIC, 40));
        titleLabel.setStyle("-fx-background-color: white");
        errorLabel.setFont(Font.font("Book Antiqua", FontWeight.BOLD, FontPosture.REGULAR, 16));
        errorLabel.setStyle("-fx-background-color: white");
        fNameLabel.setFont(Font.font("Book Antiqua", FontWeight.BOLD, FontPosture.REGULAR, 16));
        fNameLabel.setStyle("-fx-background-color: white");
        lNameLabel.setFont(Font.font("Book Antiqua", FontWeight.BOLD, FontPosture.REGULAR, 16));
        lNameLabel.setStyle("-fx-background-color: white");
        usernameLabel.setFont(Font.font("Book Antiqua", FontWeight.BOLD, FontPosture.REGULAR, 16));
        usernameLabel.setStyle("-fx-background-color: white");
        passwordLabel.setFont(Font.font("Book Antiqua", FontWeight.BOLD, FontPosture.REGULAR, 16));
        passwordLabel.setStyle("-fx-background-color: white");
        dobLabel.setFont(Font.font("Book Antiqua", FontWeight.BOLD, FontPosture.REGULAR, 16));
        dobLabel.setStyle("-fx-background-color: white");
        
        labelTFVBox.getChildren().addAll(fNameLabel,fNameTF, lNameLabel, lNameTF,
                                         usernameLabel,usernameTF,passwordLabel,passwordTF, dobLabel, dobTF);
        buttonHBox.getChildren().addAll(registerBtn,cancelBtn);
        this.add(titleLabel,0,0);
        this.add(labelTFVBox,0,1);
        this.add(buttonHBox,0,2);
        this.setAlignment(Pos.CENTER);
    }
    
    //properties
    //labels
    /**
     * @return the fNameLabel
     */
    public Label GetfNameLabel()
    {
        return fNameLabel;
    }

    /**
     * @param fNameLabel the fNameLabel to set
     */
    public void SetfNameLabel(Label fNameLabel)
    {
        this.fNameLabel = fNameLabel;
    }

    /**
     * @return the lNameLabel
     */
    public Label GetlNameLabel()
    {
        return lNameLabel;
    }

    /**
     * @param lNameLabel the lNameLabel to set
     */
    public void SetlNameLabel(Label lNameLabel)
    {
        this.lNameLabel = lNameLabel;
    }
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
     * @return the dobLabel
     */
    public Label GetDobLabel()
    {
        return dobLabel;
    }

    /**
     * @param dobLabel the dobLabel to set
     */
    public void SetDobLabel(Label dobLabel)
    {
        this.dobLabel = dobLabel;
    }
    
    //textfields
    /**
     * @return the fNameTF
     */
    public TextField GetfNameTF()
    {
        return fNameTF;
    }

    /**
     * @param fNameTF the fNameTF to set
     */
    public void SetfNameTF(TextField fNameTF)
    {
        this.fNameTF = fNameTF;
    }

    /**
     * @return the lNameTF
     */
    public TextField GetlNameTF()
    {
        return lNameTF;
    }

    /**
     * @param lNameTF the lNameTF to set
     */
    public void SetlNameTF(TextField lNameTF)
    {
        this.lNameTF = lNameTF;
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
     * @return the dobTF
     */
    public TextField GetDobTF()
    {
        return dobTF;
    }

    /**
     * @param dobTF the dobTF to set
     */
    public void SetDobTF(TextField dobTF)
    {
        this.dobTF = dobTF;
    }
    
    //buttons
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
    
    //functions
    public void ClearTF()
    {
        fNameTF.clear();
        lNameTF.clear();
        usernameTF.clear();
        passwordTF.clear();
        dobTF.clear();
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