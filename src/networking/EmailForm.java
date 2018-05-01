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
    //main email set-up
    private String host = "smtp.gmail.com";
    private String port = "465";
    private String mailFrom = "softwareengineeringutrgv@gmail.com";
    private String password = "utrgvcssw";

    // message info
    private String toAddress = "mahmoud.quweider@gmail.com";
    private String subject = "New email with attachments && CC";
    private String message = "Let the sharing begin...";

    // attachments
    private String[] attachFiles; // Needs 2 text files and 1 image of selected recipe
    
    private Label titleemailLabel = new Label ("Email Form Submission");		
    private Label toAddressLabel = new Label("Target Email Address: ");
    private TextField toAddressTF = new TextField();
    private Label subjectLabel = new Label("Subject: ");
    private TextField subjectTF = new TextField();
    private Label messageLabel = new Label("Message: ");
    private TextArea messageTA = new TextArea("Enter Message Here...");
    TextArea messageTF = new TextArea("Enter Message Here...");
    private Button action1 = new Button("Choose a file...");
    private Button action2 = new Button("Choose files...");
    private Button action3 = new Button("Send Email");
    
    VBox labelandtextHolder = new VBox(10);
    HBox buttonHolder = new HBox(5);

    /**
     * @return the host
     */
    public String GetHost()
    {
        return host;
    }

    /**
     * @param host the host to set
     */
    public void SetHost(String host)
    {
        this.host = host;
    }

    /**
     * @return the port
     */
    public String SetPort()
    {
        return port;
    }

    /**
     * @param port the port to set
     */
    public void SetPort(String port)
    {
        this.port = port;
    }

    /**
     * @return the mailFrom
     */
    public String GetMailFrom()
    {
        return mailFrom;
    }

    /**
     * @param mailFrom the mailFrom to set
     */
    public void SetMailFrom(String mailFrom)
    {
        this.mailFrom = mailFrom;
    }

    /**
     * @return the password
     */
    public String GetPassword()
    {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void SetPassword(String password)
    {
        this.password = password;
    }

    /**
     * @return the toAddress
     */
    public String GetToAddress()
    {
        return toAddress;
    }

    /**
     * @param toAddress the toAddress to set
     */
    public void SetToAddress(String toAddress)
    {
        this.toAddress = toAddress;
    }

    /**
     * @return the subject
     */
    public String GetSubject()
    {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void SetSubject(String subject)
    {
        this.subject = subject;
    }

    /**
     * @return the message
     */
    public String GetMessage()
    {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void SetMessage(String message)
    {
        this.message = message;
    }

    /**
     * @return the attachFiles
     */
    public String[] GetAttachFiles()
    {
        return attachFiles;
    }

    /**
     * @param attachFiles the attachFiles to set
     */
    public void SetAttachFiles(String[] attachFiles)
    {
        this.attachFiles = attachFiles;
    }

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
    
      public EmailForm()
    {
        labelandtextHolder.getChildren().addAll(titleemailLabel,toAddressLabel,toAddressTF,subjectLabel,subjectTF,messageLabel,messageTA);
        buttonHolder.getChildren().addAll(action1,action2,action3);
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
