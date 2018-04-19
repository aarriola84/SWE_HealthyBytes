package gui;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * @author Alexis Arriola
 */
public class LoginView extends GridPane
{
    //boxes
    private HBox buttonBox = new HBox(2);
    private VBox formBox = new VBox(10);
    
    //labels
    private Label emailLabel = new Label("Enter email:");
    private Label passLabel = new Label("Enter password:");
    
    //textfields
    private TextField emailTF = new TextField();
    private TextField passTF = new TextField();
    
    //buttons
    private Button loginButton = new Button("Login");
    private Button registerButton = new Button("Register");
    
    //constructor
    public LoginView()
    {
        //add to button box
        buttonBox.getChildren().addAll(loginButton, registerButton);
        
        formBox.getChildren().addAll(emailLabel, emailTF, passLabel, passTF, buttonBox);
        
        //add all fields to the GridPane
        this.add(formBox, 0,0);
        this.add(buttonBox, 0, 1);
    }
    
    //properties
    /**
     * @return the emailLabel
     */
    public Label getEmailLabel()
    {
        return emailLabel;
    }

    /**
     * @param emailLabel the emailLabel to set
     */
    public void setEmailLabel(Label emailLabel)
    {
        this.emailLabel = emailLabel;
    }

    /**
     * @return the passLabel
     */
    public Label getPassLabel()
    {
        return passLabel;
    }

    /**
     * @param passLabel the passLabel to set
     */
    public void setPassLabel(Label passLabel)
    {
        this.passLabel = passLabel;
    }

    /**
     * @return the emailTF
     */
    public TextField getEmailTF()
    {
        return emailTF;
    }

    /**
     * @param emailTF the emailTF to set
     */
    public void setEmailTF(TextField emailTF)
    {
        this.emailTF = emailTF;
    }

    /**
     * @return the passTF
     */
    public TextField getPassTF()
    {
        return passTF;
    }

    /**
     * @param passTF the passTF to set
     */
    public void setPassTF(TextField passTF)
    {
        this.passTF = passTF;
    }

    /**
     * @return the buttonBox
     */
    public HBox getButtonBox()
    {
        return buttonBox;
    }

    /**
     * @param buttonBox the buttonBox to set
     */
    public void setButtonBox(HBox buttonBox)
    {
        this.buttonBox = buttonBox;
    }

    /**
     * @return the loginButton
     */
    public Button getLoginButton()
    {
        return loginButton;
    }

    /**
     * @param loginButton the loginButton to set
     */
    public void setLoginButton(Button loginButton)
    {
        this.loginButton = loginButton;
    }

    /**
     * @return the registerButton
     */
    public Button getRegisterButton()
    {
        return registerButton;
    }

    /**
     * @param registerButton the registerButton to set
     */
    public void setRegisterButton(Button registerButton)
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
