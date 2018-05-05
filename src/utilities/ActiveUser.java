package utilities;

/**
 * @author Alexis Arriola
 */
public class ActiveUser extends User
{
    //private constructor
    private ActiveUser(){}
    
    //private singleton instance
    private static ActiveUser singletonUser = null;
    
    /**
     * Returns the singleton instance of ActiveUser. If it does not exists yet it will create it before returning it.
     * @return 
     */
    public static ActiveUser GetSingletonUser()
    {
        if (singletonUser == null) 
        {
            singletonUser = new ActiveUser();
        }
        return singletonUser;
    }
    
    //function to set the user info
    public void SetActiveUser(User current)
    {
        //set the user information
        SetId(current.GetId());
        SetFname(current.GetFname());
        SetLname(current.GetLname());
        SetEmail(current.GetEmail());
        SetPass(current.GetPass());
        SetDob(current.GetDob());
    }
    
    public void PrintActiveUser()
    {
        System.out.println("Active User info:");
        System.out.println("Id: " + GetId());
        System.out.println("First Name: " + GetFname());
        System.out.println("Last Name: " + GetLname());
        System.out.println("Email: " + GetEmail());
        System.out.println("Pass: " + GetPass());
        System.out.println("DOB: " + GetDob());
    }
}
