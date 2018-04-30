package healthybytes;

import login.LoginController;
import mainmenu.MainMenuController;
import myrecipes.MyRecipesController;
import search.SearchController;

/**
 * @author Alexis Arriola
 */
public class MainController 
{
    //controllers
    LoginController loginController;
    MainMenuController mainMenuController;
    SearchController searchController;
    MyRecipesController myRecipesController;
    
    public MainController(LoginController loginController, MainMenuController mainMenuController, SearchController searchController, MyRecipesController myRecipesController)
    {
        //set controllers
        this.loginController = loginController;
        this.mainMenuController = mainMenuController;
        this.searchController = searchController;
        this.myRecipesController = myRecipesController;
        
        //attach handlers
        AttachHandlers();
    }
    
    /***
     * Attaches handlers for all of the different controllers.
     */
    public void AttachHandlers()
    {
        loginController.attachHandlers();
        mainMenuController.attachHandlers();
        searchController.attachHandlers();
        myRecipesController.attachHandlers();
    }
}
