package login;

import utilities.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utilities.Email;
import utilities.HBError;

/**
 * @author Alexis Arriola
 */
public class LoginController 
{
    //stage ref
    Stage mainStage;
    
    //scenes
    Scene mainMenuScene;

    //views
    private LoginView loginView;
    
    //model
    private LoginModel loginModel;
    
    //data
    private int generatedCode;
    
    //constructor
    public LoginController(Stage mainStage, LoginView loginView, LoginModel loginModel, Scene mainMenuScene)
    {
        this.mainStage = mainStage;
        this.loginView = loginView;
        this.mainMenuScene = mainMenuScene;
        this.loginModel = loginModel;
    }
    
    public void attachHandlers()
    {
        //login form buttons
        loginView.GetLoginForm().GetLoginBtn().setOnAction(
                new EventHandler<ActionEvent>()
                {
                     public void handle(ActionEvent event)
                     {
                         String email = loginView.GetLoginForm().GetEmailTF().getText();
                         String pass = loginView.GetLoginForm().GetPassTF().getText();
                         
                         if (email.trim().length() == 0 || pass.trim().length() == 0)
                         {
                             //blank login fields error
                             HBError.ErrorAlert("Error", "Empty text fields",
                                     "Cannot enter empty text fields please relogin.");
                         }
                         else
                         {
                             boolean isValid = loginModel.VerifyUser(email, pass);
                         
                            if(isValid)
                            {
                                boolean isAuth = loginModel.AuthenticateUser(email, pass);
                                if (isAuth)
                                {
                                    loginView.GetLoginForm().ClearTF();
                                    mainStage.setScene(mainMenuScene);
                                }
                                else
                                {
                                    //authentication error
                                    HBError.ErrorAlert("Error", "Unauthenticated User",
                                            "Please verify your account via email");
                                }
                                
                            }
                            else
                            {
                                //invalid user error
                                HBError.ErrorAlert("Error", "Invalid user",
                                        "User not found within our records please register.");
                            }
                         }
                         
                         
                         
                     }
                });
        
        loginView.GetLoginForm().GetRegisterBtn().setOnAction(
                new EventHandler<ActionEvent>()
                {
                     public void handle(ActionEvent event)
                     {
                         loginView.GetLoginForm().ClearTF();
                         loginView.SetRegisterForm();
                     }
                });
        
        //register form buttons
        loginView.GetRegisterForm().GetRegisterBtn().setOnAction(
                new EventHandler<ActionEvent>()
                {
                     public void handle(ActionEvent event)
                     {
                         String fName = loginView.GetRegisterForm().GetfNameTF().getText();
                         String lName = loginView.GetRegisterForm().GetlNameTF().getText();
                         String email = loginView.GetRegisterForm().GetUsernameTF().getText();
                         String pass = loginView.GetRegisterForm().GetPasswordTF().getText();
                         String dob = loginView.GetRegisterForm().GetDobTF().getText();
                         
                         if (fName.trim().length() == 0 || lName.trim().length() == 0 || email.trim().length() == 0 ||
                             pass.trim().length() == 0 || dob.trim().length() == 0)
                         {
                             //blank login fields error
                             HBError.ErrorAlert("Error", "Empty text fields",
                                     "Cannot enter empty text fields please fill out all fields.");
                         }
                         else
                         {
                             User newUser = new User(0,fName, lName, email, pass, dob);
                             boolean exists = loginModel.VerifyEmail(email);
                             
                             if (exists)
                             {
                                 //blank login fields error
                                 HBError.ErrorAlert("Error", "Email Exists",
                                     "This email is already in use please type a different email");
                             }
                             else
                             {
                                 //do database work here
                                 loginModel.RegisterUser(newUser);
                                 Email currentEmail = new Email();
                                 generatedCode = loginModel.GenerateVerifcationCode();
                                 loginModel.SendVerificationCode(email, currentEmail, generatedCode);
                                 loginView.GetRegisterForm().ClearTF();
                                 loginView.SetAuthenticationForm();
                             } 
                         } 
                     }
                });
         loginView.GetRegisterForm().GetCancelBtn().setOnAction(
                new EventHandler<ActionEvent>()
                {
                     public void handle(ActionEvent event)
                     {
                         loginView.GetRegisterForm().ClearTF();
                         loginView.SetLoginForm();
                     }
                });
         
         
         //authentication form buttons
         loginView.GetAuthenticationForm().GetAction1().setOnAction(new EventHandler <ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                String email = loginView.GetAuthenticationForm().GetEmailTF().getText();
                String code = loginView.GetAuthenticationForm().GetVerificationTF().getText();
                
                if (email.trim().length() == 0 || code.trim().length() == 0)
                {
                    //blank fields
                    HBError.ErrorAlert("Error", "Empty text fields",
                                     "Cannot enter empty text fields please fill out all fields.");
                }
                else
                {
                    int userInputCode = 0;
                    try
                    {
                        userInputCode = Integer.parseInt(code);
                    }
                    catch(Exception e)
                    {
                        System.out.println("Exception at LoginController, Function ParsingIntCode: " + e);
                    }
                    
                    //Check if email suffix is valid or not
                    if (email.endsWith("@gmail.com") || email.endsWith("@yahoo.com") || email.endsWith("@utrgv.edu"))
                    {
                        int userId = loginModel.GetUserIdFromDatabase(email);
                        // If user does not exist
                        if (userId == -1)
                        {
                            HBError.ErrorAlert("Error", "User ID Does not Exist",
                                    "The email provided does not have a user ID recorded within the Database.");
                            loginView.GetAuthenticationForm().ClearFields();
                        } 
                        else
                        {
                            boolean toggled = loginModel.ToggleAuthenticate(userId, userInputCode, generatedCode);
                            if (toggled)
                            {
                                HBError.ErrorAlert("Email Validation Complete", "The Email Has Been Verified.",
                                         "Now Returning to Login Screen. ReEnter Email and Password to log into HealthyBytes.");
                                // Clear Text
                                loginView.GetAuthenticationForm().ClearFields();
                                // Clear Validation Code in Memory
                                generatedCode = 4862489;
                                // Return to Register Screen
                                loginView.SetLoginForm();
                            } 
                            else
                            {
                                HBError.ErrorAlert("Incorrect Code", "You Did Not Input The Right Code.",
                                        "Please Try Again.");
                                loginView.GetAuthenticationForm().ClearFields();
                            }
                        }
                    } 
                    else
                    {
                        HBError.ErrorAlert("Error", "Invalid Email Suffix",
                                "The email Text field does not contain a vaild email suffix.");
                        loginView.GetAuthenticationForm().ClearFields();
                    }
                }
            }
        });   
    }
    /**
     * @return the loginView
     */
    public LoginView GetLoginView()
    {
        return loginView;
    }

    /**
     * @param loginView the loginView to set
     */
    public void SetLoginView(LoginView loginView)
    {
        this.loginView = loginView;
    }
     /**
     * @return the loginModel
     */
    public LoginModel GetLoginModel()
    {
        return loginModel;
    }

    /**
     * @param loginModel the loginModel to set
     */
    public void SetLoginModel(LoginModel loginModel)
    {
        this.loginModel = loginModel;
    }
}