/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networking;

import java.io.File;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import utilities.Email;
import utilities.HBError;
import utilities.Recipe;

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
    private TextArea messageTA = new TextArea();
    private Button action1 = new Button("Choose a file...");
    private Button action2 = new Button("Choose files...");
    private Button action3 = new Button("Send Email");
    private Button action4 = new Button("Return to My Recipes");
    private Stage myStage;
    
    VBox labelandtextHolder = new VBox(10);
    HBox buttonHolder = new HBox(5);
    
    //Needed to open a window for file choosing
    FileChooser fileChooser = new FileChooser();
    
    //String of attached Files that wil be added to Email Object for submission
    String attachFiles[];

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
    
    public void SetStage(Stage myStage)
    {
        this.myStage = myStage;
    }
    
      public EmailForm(Recipe recipe)
    {
        labelandtextHolder.getChildren().addAll(titleemailLabel,toAddressLabel,toAddressTF,subjectLabel,subjectTF,messageLabel,messageTA);
        buttonHolder.getChildren().addAll(action1,action2,action3,action4);
        this.add(labelandtextHolder, 0, 0);
        this.add(buttonHolder,0,1);
        this.setAlignment(Pos.CENTER);
        AttachHandlers();
        
        subjectTF.setText(recipe.GetName());
        messageTA.appendText(recipe.GetName() + "\n");
        messageTA.appendText(recipe.GetDescription() + "\n");
        messageTA.appendText(recipe.GetInfo() + "\n");
    }
      
     public void ClearFields()
     {
         toAddressTF.clear();
         subjectTF.clear();
         messageTA.clear();
     }
     
     public void AttachHandlers()
     {
         //Choose a file (Action 1)
        action1.setOnAction(new EventHandler <ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                try
                {           
                    File file = fileChooser.showOpenDialog(null);
                        if(file != null)
                        {
                        attachFiles[0] = file.toString();            
                        System.out.println("File has been attached.");
                        }
                }
                catch(Exception e)
                {
                    System.out.println("Exception at EmailForm, Function ChooseFile: " + e);
                }            
            }    
        });
        
        //Choose Multiple files (Action 2)
        action2.setOnAction(new EventHandler <ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                try
                {
                    List<File> list = fileChooser.showOpenMultipleDialog(null);           
                    attachFiles = new String[list.size()];
                    if(list != null)
                        {   
                            for (int i = 0; i < list.size(); i++)
                            {
                                attachFiles[i] = list.get(i).toString();
                            }
                        }
                    System.out.println("Files have been attached.");
                }
                catch (Exception e)
                {
                    System.out.println("Exception at EmailForm, Function ChooseMultiple: " + e);
                }
            }    
        });
        
        //Send Email (Action 3)
        action3.setOnAction(new EventHandler <ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                try
                {                  
                   Email myEmail = new Email();
                   myEmail.setHost("smtp.gmail.com");
                   String host = myEmail.getHost();
                   myEmail.setPort("465");
                   String port = myEmail.getPort();
                   //Method to get user email account name and password
                   myEmail.setMailFrom("swe.healthybytes@gmail.com");
                   String mailFrom = myEmail.getMailFrom();
                   myEmail.setPassword("night_hb18");
                   String password = myEmail.getPassword();
                   //check blanks
                   String toAddress = GetToAddressTF().getText();
                   String subject = GetSubjectTF().getText();
                   String message = GetMessageTA().getText();
                   
                   if (toAddress.trim().length() == 0 || subject.trim().length() == 0 || message.trim().length() == 0)
                   {
                        //blank fields
                        HBError.ErrorAlert("Error", "Empty text fields",
                                     "Cannot enter empty text fields please fill out all fields.");
                   }
                   else
                   {
                       EmailAttachmentSender.sendEmailWithAttachments(host, port, mailFrom, password, toAddress, subject, message, attachFiles);                   
                       HBError.ErrorAlert("Information Dialog", "Mail Sent",
                                     "Email has been sent to: " + toAddress);
                       ClearFields();
                       myStage.close();
                   }
                   
                }
                catch (Exception e)
                {
                    System.out.println("Exception at EmailForm, Function SendEmail: " + e);
                }
                
                //Get rid of any attachments sent
                if(attachFiles != null)
                {
                   for (int i = 0; i < attachFiles.length; i++)
                   {
                        attachFiles[i] = null;
                   }  
                }
                
            }    
        });
     }
}