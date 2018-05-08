/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networking;

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
 */
public class AuthenticationForm extends GridPane
{
    private Label titleLabel = new Label ("User Authentication Form");
    private Label emailLabel = new Label ("Enter Email Address");
    private Label verificationLabel = new Label ("Enter Verification Code Here");
    private TextField emailTF = new TextField();
    private TextField verificationTF = new TextField();
    private Button action1 = new Button ("Enter Code");
    
    VBox labelTextFieldBox = new VBox(10);
    HBox buttonBox = new HBox(5);
    
    public AuthenticationForm()
    {
        this.setVgap(3);
        //style the labels
        titleLabel.setFont(Font.font("Book Antiqua", FontWeight.BOLD, FontPosture.ITALIC, 40));
        titleLabel.setStyle("-fx-background-color: white");
        emailLabel.setFont(Font.font("Book Antiqua", FontWeight.BOLD, FontPosture.REGULAR, 16));
        emailLabel.setStyle("-fx-background-color: white");
        verificationLabel.setFont(Font.font("Book Antiqua", FontWeight.BOLD, FontPosture.REGULAR, 16));
        verificationLabel.setStyle("-fx-background-color: white");
        labelTextFieldBox.getChildren().addAll(emailLabel,emailTF,verificationLabel,verificationTF);
        buttonBox.getChildren().addAll(action1);
        
        this.add(titleLabel, 0, 0);
        this.add(labelTextFieldBox,0,1);
        this.add(buttonBox, 0, 2);
        this.setAlignment(Pos.CENTER);
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
     * @return the verificationLabel
     */
    public Label GetVerificationLabel()
    {
        return verificationLabel;
    }

    /**
     * @param verificationLabel the verificationLabel to set
     */
    public void SetVerificationLabel(Label verificationLabel)
    {
        this.verificationLabel = verificationLabel;
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
     * @return the verificationTF
     */
    public TextField GetVerificationTF()
    {
        return verificationTF;
    }

    /**
     * @param verificationTF the verificationTF to set
     */
    public void SetVerificationTF(TextField verificationTF)
    {
        this.verificationTF = verificationTF;
    }

    /**
     * @return the action1
     */
    public Button GetAction1()
    {
        return action1;
    }

    /**
     * @param action1 the action1 to set
     */
    public void SetAction1(Button action1)
    {
        this.action1 = action1;
    }

    public void ClearFields()
    {
        emailTF.clear();
        verificationTF.clear();
    }
}