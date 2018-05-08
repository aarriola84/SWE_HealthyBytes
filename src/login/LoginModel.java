package login;

import utilities.User;
import database.Database;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.ThreadLocalRandom;
import networking.EmailAttachmentSender;
import utilities.ActiveUser;
import utilities.Email;

/**
 * @author Alexis Arriola
 */
public class LoginModel 
{
    //data
    private Database hbDatabase = Database.GetSingletonOfdatabase();
    private User currentUser;
    private ActiveUser activeUser;
    
    /**
     * @return the currentUser
     */
    public User GetCurrentUser()
    {
        return currentUser;
    }

    /**
     * @param currentUser the currentUser to set
     */
    public void SetCurrentUser(User currentUser)
    {
        this.currentUser = currentUser;
    }
    
    public void RegisterUser(User currentUser)
    {
        try
        {
            String fName = currentUser.GetFname();
            String lName = currentUser.GetLname();
            String email = currentUser.GetEmail();
            String pass = currentUser.GetPass();
            String dob = currentUser.GetDob();
            
            Statement stmnt = hbDatabase.GetStmnt();
            String sql = "insert into users (email, password, fName, lName, dob, authenticate) "
                       + "values ('"+ email + "','"+ pass + "','"+ fName + "','"+ lName + "','"+ dob + "',"+ 0 +");";
            stmnt.executeUpdate(sql);
        }
        catch(Exception e)
        {
            System.out.println("Exception at LoginModel, Function RegisterUser: " + e);
        }
    }
    
    public boolean VerifyUser(String email, String pass)
    {
        boolean verified = false;
        try
        {
            Statement stmnt = hbDatabase.GetStmnt();
            ResultSet result = stmnt.executeQuery("select * from users where email = '"+email+"' and password = '"+pass+"';");
            
            if (result.next() == false)
            {
                System.out.println("User not verified");
                verified = false;
            }
            else
            {
                System.out.println("User Verified");
                verified = true;
            }
        }
        catch (Exception e)
        {
            System.out.println("Exception at LoginModel, Function VerifyUser: " + e);
        }
        
        return verified;
    }
    
    public boolean VerifyEmail(String email)
    {
        boolean verified = false;
        try
        {
            Statement stmnt = hbDatabase.GetStmnt();
            ResultSet result = stmnt.executeQuery("select * from users where email = '"+email+"';");
            
            if (result.next() == false)
            {
                System.out.println("User not verified");
                verified = false;
            }
            else
            {
                System.out.println("User Verified");
                verified = true;
            }
        }
        catch (Exception e)
        {
            System.out.println("Exception at LoginModel, Function VerifyUser: " + e);
        }
        
        return verified;
    }
    
    public int GenerateVerifcationCode()
    {
        //Random Verifcation Code Generator
        int codeNumber;
        codeNumber = ThreadLocalRandom.current().nextInt(100000,9999999);
        return codeNumber;
    }
    
    //Appearently I can only update stuff with the user_Id so I need to extract key
    public int GetUserIdFromDatabase(String emailAddress)
    {
        int userId = 0;
        try
        {
            Statement stmnt = hbDatabase.GetStmnt();
            ResultSet result = stmnt.executeQuery("select user_id from users where email = '"+emailAddress+"';");
            
             if (result.next() == false)
            {
                System.out.println("User Id does not exist with corresponding email address provided. Returning -1...");
                userId = -1;
            }
            else
            {
                System.out.println("User Id found. Returning ID.");
                userId = result.getInt("user_id");
            }
        }
        catch(Exception e)
        {
            System.out.println("Exception at LoginModel, Function GetUserIdFromDatabase: " + e);
        }
        return userId;
    }
    
    public void SendVerificationCode(String emailAddress, Email currentEmail, int code)
    {
        currentEmail.setHost("smtp.gmail.com");
        String host = currentEmail.getHost();
        currentEmail.setPort("465");
        String port = currentEmail.getPort();
        currentEmail.setMailFrom("swe.healthybytes@gmail.com");
        String mailFrom = currentEmail.getMailFrom();
        currentEmail.setPassword("night_hb18");
        String password = currentEmail.getPassword();
        currentEmail.setToAddress(emailAddress);
        String toAddress = currentEmail.getToAddress();
        currentEmail.setSubject("Email Verification Code.");
        String subject = currentEmail.getSubject();
        currentEmail.setMessage("Please enter this verification code then press OK\n Code: " + code);
        String message = currentEmail.getMessage();
        String attachFiles[] = currentEmail.getAttachFiles();
        try
        {
            EmailAttachmentSender.sendEmailWithAttachments(host, port, mailFrom, password, toAddress, subject, message, attachFiles);
            System.out.println("Email Sent.");
        }
        catch(Exception e)
        {
            System.out.println("Exception at LoginModel, Function SendVerificationCode: " + e);
        }
    }
    
    // Most likely User oriented function
    public boolean ToggleAuthenticate(int userId, int userInput, int generatedCode)
    {
        boolean toggled = false;
        if(userInput == generatedCode)
        {
            try
            {
                Statement statement = hbDatabase.GetStmnt();
                String sql = "update users set authenticate = authenticate + 1 where user_id = " + userId +";";
                statement.executeUpdate(sql);
                toggled = true;
            }
            catch(Exception e)
            {
                System.out.println("Exception at LoginModel, Function ToggleAuthenticate: " + e);
            }
        }
        else
        {
            toggled = false;
        }
        return toggled;
    }
    
    public boolean AuthenticateUser(String email, String pass)
    {
        boolean isAuthenticated = false;
        
        try
        {
            Statement stmnt = hbDatabase.GetStmnt();
            ResultSet result = stmnt.executeQuery("select * from users where email = '"+email+"' and password = '"+pass+"';");
            result.next();
            if( result.getInt("authenticate") > 0)
            {
                System.out.println("Is authenticated");
                isAuthenticated = true;
                int id = result.getInt("user_id");
                String fName = result.getString("fName");
                String lName = result.getString("lName");
                String em = result.getString("email");
                String pas = result.getString("password");
                String dob = result.getString("dob");
                User tempUser = new User(id, fName, lName, em, pas, dob);
                activeUser = ActiveUser.GetSingletonUser();
                activeUser.SetActiveUser(tempUser);
            }
            else
            {
                System.out.println("Is not authenticated");
                isAuthenticated = false;
            }
        }
        catch(Exception e)
        {
            System.out.println("Exception at LoginModel, Function AuthenticateUser: " + e);
        }
        return isAuthenticated;
    }
}
