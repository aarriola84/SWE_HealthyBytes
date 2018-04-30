package utilities;

/**
 * @author Ruben Olivares
 */
public class User 
{
    //data
    private int id;
    private String fName;
    private String lName;
    private String email;
    private String pass;
    private String dob;
    
    //constructor
    //default
    public User(){}
    
    //param constructor
    public User(int id, String fName, String lName, String email, String pass, String dob)
    {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.pass = pass;
        this.dob = dob;
    }
    
    //properties
    /**
     * @return the id
     */
    public int GetId()
    {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void SetId(int id)
    {
        this.id = id;
    }

    /**
     * @return the fname
     */
    public String GetFname()
    {
        return fName;
    }

    /**
     * @param fname the fname to set
     */
    public void SetFname(String fName)
    {
        this.fName = fName;
    }

    /**
     * @return the lname
     */
    public String GetLname()
    {
        return lName;
    }

    /**
     * @param lname the lname to set
     */
    public void SetLname(String lName)
    {
        this.lName = lName;
    }

    /**
     * @return the email
     */
    public String GetEmail()
    {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void SetEmail(String email)
    {
        this.email = email;
    }

    /**
     * @return the pass
     */
    public String GetPass()
    {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void SetPass(String pass)
    {
        this.pass = pass;
    }

    /**
     * @return the dob
     */
    public String GetDob()
    {
        return dob;
    }

    /**
     * @param dob the dob to set
     */
    public void SetDob(String dob)
    {
        this.dob = dob;
    }
}
