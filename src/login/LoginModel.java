package login;

import utilities.User;
import database.Database;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author Alexis Arriola
 */
public class LoginModel 
{
    //data
    private Database hbDatabase = Database.GetSingletonOfdatabase();
    private User currentUser;
    
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
            
        }
    }
    
    public boolean VerifyUser(String email, String pass)
    {
        boolean verified = false;
        try
        {
            Statement stmnt = hbDatabase.GetStmnt();
            ResultSet result = stmnt.executeQuery("select email, password from users where email = '"+email+"' and password = '"+pass+"';");
            
            if (result.next() == false)
            {
                //String em = result.getString("email");
                //String ps = result.getString("password");
                //System.out.println("em + ps: " + em + " " + ps);
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
            System.out.println(e);
        }
        
        return verified;
    }
}
