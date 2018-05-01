package search;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Alexis Arriola
 */
public class SearchController 
{
    //stage ref
    Stage mainStage;
    
    //scenes
    Scene mainMenuScene;

    //views
    private SearchView searchView;
    
    //model
    private SearchModel searchModel;
    
    //constructor
    public SearchController(Stage mainStage, SearchView searchView, SearchModel searchModel, Scene mainMenuScene)
    {
        this.mainStage = mainStage;
        this.searchView = searchView;
        this.mainMenuScene = mainMenuScene;
        this.searchModel = searchModel;
    }
    
    public void attachHandlers()
    {
        //main menu form buttons
        //search
        searchView.GetRecipeListForm().GetAction1().setOnAction(
                new EventHandler<ActionEvent>()
                {
                     public void handle(ActionEvent event)
                     {
                         int[] proteinList = searchView.GetProteinIds();
                         searchModel.GetRecipesDB(proteinList);
                         searchView.GetRecipeListForm().SetNewTitles(searchModel.GetRecipes());
                     }
                });
        //return to main menu
        searchView.GetRecipeListForm().GetAction4().setOnAction(
                new EventHandler<ActionEvent>()
                {
                     public void handle(ActionEvent event)
                     {
                             mainStage.setScene(mainMenuScene);
                     }
                });
    }
}
