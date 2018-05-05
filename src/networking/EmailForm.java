/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networking;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Matthew Rodriguez
 */
public class EmailForm extends GridPane
{  
    private Label titleemailLabel = new Label ("Email Form Submission");		
    private Label toAddressLabel = new Label("Target Email Address: ");
    private TextField toAddressTF = new TextField();
    private Label subjectLabel = new Label("Subject: ");
    private TextField subjectTF = new TextField();
    private Label messageLabel = new Label("Message: ");
    private TextArea messageTA = new TextArea("Enter Message Here...");
    private Button action1 = new Button("Choose a file...");
    private Button action2 = new Button("Choose files...");
    private Button action3 = new Button("Send Email");
    private Button action4 = new Button("Return to My Recipes");
    
    VBox labelandtextHolder = new VBox(10);
    HBox buttonHolder = new HBox(5);

    /**
     * @return the titleemailLabel
     */
    public Label GetTitleEmailLabel()
    {
        return titleemailLabel;
    }

    /**
     * @param titleemailLabel the titleemailLabel to set
     */
    public void SetTitleEmailLabel(Label titleemailLabel)
    {
        this.titleemailLabel = titleemailLabel;
    }

    /**
     * @return the toAddressLabel
     */
    public Label GetToAddressLabel()
    {
        return toAddressLabel;
    }

    /**
     * @param toAddressLabel the toAddressLabel to set
     */
    public void SetToAddressLabel(Label toAddressLabel)
    {
        this.toAddressLabel = toAddressLabel;
    }

    /**
     * @return the toAddressTF
     */
    public TextField GetToAddressTF()
    {
        return toAddressTF;
    }

    /**
     * @param toAddressTF the toAddressTF to set
     */
    public void SetToAddressTF(TextField toAddressTF)
    {
        this.toAddressTF = toAddressTF;
    }

    /**
     * @return the subjectLabel
     */
    public Label GetSubjectLabel()
    {
        return subjectLabel;
    }

    /**
     * @param subjectLabel the subjectLabel to set
     */
    public void SetSubjectLabel(Label subjectLabel)
    {
        this.subjectLabel = subjectLabel;
    }

    /**
     * @return the subjectTF
     */
    public TextField GetSubjectTF()
    {
        return subjectTF;
    }

    /**
     * @param subjectTF the subjectTF to set
     */
    public void SetSubjectTF(TextField subjectTF)
    {
        this.subjectTF = subjectTF;
    }

    /**
     * @return the messageLabel
     */
    public Label GetMessageLabel()
    {
        return messageLabel;
    }

    /**
     * @param messageLabel the messageLabel to set
     */
    public void SetMessageLabel(Label messageLabel)
    {
        this.messageLabel = messageLabel;
    }

    /**
     * @return the messageTA
     */
    public TextArea GetMessageTA()
    {
        return messageTA;
    }

    /**
     * @param messageTA the messageTA to set
     */
    public void SetMessageTA(TextArea messageTA)
    {
        this.messageTA = messageTA;
    }
    
    /**
     * @return the action1
     */
    public Button GetAction1()
    {
        return action1;
    }

    /**
     * @param button the action1 to set
     */
    public void SetAction1(Button button)
    {
        this.action1 = button;
    }

    /**
     * @return the action2
     */
    public Button GetAction2()
    {
        return action2;
    }

    /**
     * @param button the action2 to set
     */
    public void SetAction2(Button button)
    {
        this.action2 = button;
    }

    /**
     * @return the action3
     */
    public Button GetAction3()
    {
        return action3;
    }

    /**
     * @param button the action3 to set
     */
    public void SetAction3(Button button)
    {
        this.action3 = button;
    }
    
    /**
     * @return the action4
     */
    public Button GetAction4()
    {
        return action4;
    }

    /**
     * @param action4 the action4 to set
     */
    public void SetAction4(Button action4)
    {
        this.action4 = action4;
    }
    
      public EmailForm()
    {
        labelandtextHolder.getChildren().addAll(titleemailLabel,toAddressLabel,toAddressTF,subjectLabel,subjectTF,messageLabel,messageTA);
        buttonHolder.getChildren().addAll(action1,action2,action3,action4);
        this.add(labelandtextHolder, 0, 0);
        this.add(buttonHolder,0,1);
        this.setAlignment(Pos.CENTER);
    }
      
     public void clearFields()
     {
         toAddressTF.clear();
         subjectTF.clear();
         messageTA.clear();
     }
}