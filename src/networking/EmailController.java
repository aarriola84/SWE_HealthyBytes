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
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import utilities.Email;

/**
 *
 * @author Matthew Rodriguez
 */
public class EmailController
{
    //Needed to open a window for file choosing
    FileChooser fileChooser = new FileChooser();
    
    //String of attached Files that wil be added to Email Object for submission
    String attachFiles[];
    
    //Test Code <- Should be replaced with rng code later on with GenereateValidationCode();
    int generatedCode = 8302830;
    
    //stage ref
    Stage mainStage;
    
    //scenes
    Scene mainMenuScene;
    
    //models
    private EmailModel emailModel;
    
    //views
    private EmailView emailView;
    private AuthenticationForm authenticationView;
    
    public EmailController(Stage mainStage, EmailView emailView, EmailModel emailModel, Scene mainMenuScene)
    {
        this.mainStage = mainStage;
        this.mainMenuScene = mainMenuScene;
        this.emailModel = emailModel;
        this.emailView = emailView;
    }

    public void attachHandlers()
    {
        // EmailForm Buttons
        //Choose a file (Action 1)
        emailView.GetEmailForm().GetAction1().setOnAction(new EventHandler <ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                try
                {           
                    File file = fileChooser.showOpenDialog(mainStage);
                        if(file != null)
                        {
                        attachFiles[0] = file.toString();            
                        System.out.println("File has been attached.");
                        }
                }
                catch(Exception e)
                {
                    System.out.println("Error: " + e);
                }            
            }    
        });
        
        //Choose Multiple files (Action 2)
        emailView.GetEmailForm().GetAction2().setOnAction(new EventHandler <ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                try
                {
                    List<File> list = fileChooser.showOpenMultipleDialog(mainStage);           
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
                    System.out.println("Error: " + e);
                }
            }    
        });
        
        //Send Email (Action 3)
        emailView.GetEmailForm().GetAction3().setOnAction(new EventHandler <ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                try
                {                  
                   Email myEmail = emailModel.getCurrentEmail();
                   myEmail.setHost("smtp.gmail.com");
                   String host = myEmail.getHost();
                   myEmail.setPort("465");
                   String port = myEmail.getPort();
                   //Method to get user email account name and password
                   myEmail.setMailFrom("swe.healthybytes@gmail.com");
                   String mailFrom = myEmail.getMailFrom();
                   myEmail.setPassword("night_hb18");
                   String password = myEmail.getPassword();
                   String toAddress = emailView.GetEmailForm().GetToAddressTF().getText();
                   String subject = emailView.GetEmailForm().GetSubjectTF().getText();
                   String message = emailView.GetEmailForm().GetMessageTA().getText();                   
                   EmailAttachmentSender.sendEmailWithAttachments(host, port, mailFrom, password, toAddress, subject, message, attachFiles);                   
                   Alert alert = new Alert(Alert.AlertType.INFORMATION);
                   alert.setTitle("Information Dialog");
                   alert.setHeaderText("Mail Sent");
                   alert.setContentText("Email has been sent to: " + toAddress);
                   alert.showAndWait();
                }
                catch (Exception e)
                {
                    System.out.println("Error: " + e);
                }
                
                //Get rid of any attachments sent
                if(attachFiles != null)
                {
                   for (int i = 0; i < attachFiles.length; i++)
                   {
                        attachFiles[i] = null;
                   }  
                }
                //Clear TextFields and Areas
                emailView.GetEmailForm().ClearFields();
            }    
        });
        
        //Return to My Recipes
        emailView.GetEmailForm().GetAction4().setOnAction(new EventHandler <ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
               // Return to My Recipes Screen
                System.out.println("No Functionality Given Yet.");
            }    
        });
       
        //This section most likely needed to be moved to login package
        //Authentication Form Buttons
        // Submit Code Button (Action 1)
        emailView.GetAuthenticationForm().GetAction1().setOnAction(new EventHandler <ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                String email = emailView.GetAuthenticationForm().GetEmailTF().getText();
                int userInputCode = Integer.parseInt(emailView.GetAuthenticationForm().GetVerificationTF().getText());
                //Check if email suffix is valid or not
                if(email.endsWith("@gmail.com") || email.endsWith("@yahoo.com") || email.endsWith("@utrgv.edu"))
               {
                    int userId = emailModel.GetUserIdFromDatabase(email);
                        // If user does not exist
                        if(userId == -1)
                        {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Error");
                            alert.setHeaderText("User ID Does not Exist");
                            alert.setContentText("The email provided does not have a user ID recorded within the Database.");
                            alert.showAndWait();
                            emailView.GetAuthenticationForm().ClearFields();
                        }
                        else
                        {
                            boolean toggled = emailModel.ToggleAuthenticate(userId, userInputCode, generatedCode);
                            if(toggled)
                            {
                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setTitle("Email Validation Complete");
                                alert.setHeaderText("The Email Has Been Verified.");
                                alert.setContentText("Now Returning to Login Screen. ReEnter Email and Password to log into HealthyBytes.");
                                alert.showAndWait();
                                // Clear Text
                                emailView.GetAuthenticationForm().ClearFields();
                                // Clear Validation Code in Memory
                                generatedCode = 4862489;
                                // Return to Register Screen
                                // Insert code to move user to Login Screen or Registration Screen after successful verification
                            }
                            else
                            {
                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setTitle("Incorrect Code");
                                alert.setHeaderText("You Did Not Input The Right Code.");
                                alert.setContentText("Please Try Again.");
                                alert.showAndWait();
                                emailView.GetAuthenticationForm().ClearFields();
                            }
                        }
               }
               else
               {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Error");
                    alert.setHeaderText("Invalid Email Suffix");
                    alert.setContentText("The email Text field does not contain a vaild email suffix.");
                    alert.showAndWait();
                    emailView.GetAuthenticationForm().ClearFields();
               }
            }
        });   
    }
}
