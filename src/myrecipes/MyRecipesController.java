package myrecipes;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Alexis Arriola
 */
public class MyRecipesController 
{
    //stage ref
    Stage mainStage;
    
    //scenes
    Scene mainMenuScene;

    //views
    private MyRecipesView myRecipesView;
    
    //model
    private MyRecipesModel myRecipesModel;
    
    //constructor
    public MyRecipesController(Stage mainStage, MyRecipesView myRecipesView, MyRecipesModel myRecipesModel, Scene mainMenuScene)
    {
        this.mainStage = mainStage;
        this.myRecipesView = myRecipesView;
        this.mainMenuScene = mainMenuScene;
        this.myRecipesModel = myRecipesModel;
    }
    
    public void attachHandlers()
    {
        //main menu form buttons
        myRecipesView.GetRecipeListForm().GetAction4().setOnAction(
                new EventHandler<ActionEvent>()
                {
                     public void handle(ActionEvent event)
                     {
                             mainStage.setScene(mainMenuScene);
                     }
                });
    }
}
