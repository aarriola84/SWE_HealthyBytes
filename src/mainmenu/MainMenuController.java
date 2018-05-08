package mainmenu;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import myrecipes.MyRecipesController;

/**
 * @author Alexis Arriola
 */
public class MainMenuController 
{
    //stage ref
    Stage mainStage;
    
    //scenes
    Scene loginScene;
    Scene searchScene;
    Scene myRecipesScene;

    //views
    private MainMenuView mainMenuView;
    
    //other controllers
    MyRecipesController myRecipesController;
    
    //constructor
    public MainMenuController(Stage mainStage, MainMenuView mainMenuView, Scene loginScene, Scene searchScene, Scene myRecipesScene, MyRecipesController myRecipesController)
    {
        this.mainStage = mainStage;
        this.mainMenuView = mainMenuView;
        this.loginScene = loginScene;
        this.searchScene = searchScene;
        this.myRecipesScene = myRecipesScene;
        this.myRecipesController = myRecipesController;
    }
    
    public void attachHandlers()
    {
        //main menu form buttons
        mainMenuView.GetMainMenuForm().GetLogoutBtn().setOnAction(
                new EventHandler<ActionEvent>()
                {
                     public void handle(ActionEvent event)
                     {
                         mainStage.setScene(loginScene);
                     }
                });
        mainMenuView.GetMainMenuForm().GetSearchBtn().setOnAction(
                new EventHandler<ActionEvent>()
                {
                     public void handle(ActionEvent event)
                     {
                         mainStage.setScene(searchScene);
                     }
                });
        mainMenuView.GetMainMenuForm().GetMyRecipesBtn().setOnAction(
                new EventHandler<ActionEvent>()
                {
                     public void handle(ActionEvent event)
                     {
                         myRecipesController.UpdateRecipeView();
                         mainStage.setScene(myRecipesScene);
                         myRecipesController.UpdateVisualization();
                     }
                });
    }
}
