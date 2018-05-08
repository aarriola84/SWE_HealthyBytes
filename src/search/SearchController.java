package search;

import genericgui.ViewRecipeForm;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utilities.HBError;
import utilities.Recipe;

/**
 * @author Alexis Arriola
 */
public class SearchController 
{
    //stage ref
    Stage mainStage;
    Stage recipeStage;
    
    //scenes
    Scene mainMenuScene;

    //views
    private SearchView searchView;
    private ViewRecipeForm viewRecipeForm;
    
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
                         if (proteinList != null)
                         {
                            searchModel.GetRecipesDB(proteinList);
                            searchView.GetRecipeListForm().SetNewTitles(searchModel.GetRecipes());
                            searchView.GetRecipeListForm().SetNewDescriptions(searchModel.GetRecipes());
                         }
                         else
                         {
                             //some alert goes here
                             HBError.ErrorAlert("Information Dialog", "Empty Selections", "Please select some search options");
                         }
                         
                     }
                });
        //view recipe
        searchView.GetRecipeListForm().GetAction2().setOnAction(
                new EventHandler<ActionEvent>()
                {
                     public void handle(ActionEvent event)
                     {
                         
                         String name = searchView.GetRecipeListForm().GetListView().getSelectionModel().getSelectedItem();
                         if (name != null)
                         {
                             int index = searchView.GetRecipeListForm().GetListView().getSelectionModel().getSelectedIndex();
                             Recipe viewRecipe = searchModel.FindRecipe(index);
                             viewRecipe.CreateImage();
                             viewRecipeForm = new ViewRecipeForm(viewRecipe.GetImg(), viewRecipe.GetInfo());
                             Scene currentScene = new Scene(viewRecipeForm, 550, 700);
                             recipeStage = new Stage();
                             recipeStage.setResizable(false);
                             recipeStage.setTitle(viewRecipe.GetName());
                             recipeStage.setScene(currentScene);
                             recipeStage.show();
                         }
                         else
                         {
                             //alert about no recipe selection
                             HBError.ErrorAlert("Information Dialog", "Empty Selection", "No recipe has been selected");
                         }
                     }
                });
        //favorite button
        searchView.GetRecipeListForm().GetAction3().setOnAction(
                new EventHandler<ActionEvent>()
                {
                     public void handle(ActionEvent event)
                     {
                         String name = searchView.GetRecipeListForm().GetListView().getSelectionModel().getSelectedItem();
                         if (name != null)
                         {
                             Recipe viewRecipe = searchModel.FindRecipe(name);
                             searchModel.FavoriteRecipe(viewRecipe);
                         }
                         else
                         {
                             //alert about no recipe selection
                             HBError.ErrorAlert("Information Dialog", "Empty Selection", "No recipe has been selected");
                         }
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
