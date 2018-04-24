package healthybytes;

import login.LoginController;

/**
 * @author Alexis Arriola
 */
public class MainController 
{
    //controllers
    LoginController loginController;
    
    public MainController(LoginController loginController)
    {
        //set controllers
        this.loginController = loginController;
        
        //attach handlers
        AttachHandlers();
    }
    
    /***
     * Attaches handlers for all of the different controllers.
     */
    public void AttachHandlers()
    {
        loginController.attachHandlers();
    }
}
