package healthybytes;

import login.LoginController;

/**
 * @author Alexis Arriola
 */
public class MainController 
{
    //models
    MainModel mainModel;
    
    //views
    MainView mainView;
    
    //controllers
    LoginController loginController;
    
    public MainController(MainModel mainMdl, MainView mainView,LoginController loginController)
    {
        this.mainModel = mainMdl;
        this.mainView = mainView;
        this.loginController = loginController;
        mainView.SetCurrentView(loginController.GetLoginView());
        AttachHandlers();
    }
    
    public void AttachHandlers()
    {
        loginController.attachHandlers();
    }
}
