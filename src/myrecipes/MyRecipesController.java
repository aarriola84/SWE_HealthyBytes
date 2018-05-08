package myrecipes;

import genericgui.CreateRecipeForm;
import genericgui.ViewRecipeForm;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import networking.EmailForm;
import utilities.HBError;
import utilities.Recipe;

/**
 * @author Alexis Arriola
 */
public class MyRecipesController 
{
    //stage ref
    Stage mainStage;
    Stage recipeStage;
    Stage createStage;
    Stage emailStage;
    
    //scenes
    Scene mainMenuScene;

    //views
    private MyRecipesView myRecipesView;
    private ViewRecipeForm viewRecipeForm;
    private CreateRecipeForm createRecipeForm;
    private EmailForm emailForm;
    
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
        //view recipe button
        myRecipesView.GetRecipeListForm().GetAction1().setOnAction(
                new EventHandler<ActionEvent>()
                {
                     public void handle(ActionEvent event)
                     {
                         String name = myRecipesView.GetRecipeListForm().GetListView().getSelectionModel().getSelectedItem();
                         if (name != null)
                         {
                             int index = myRecipesView.GetRecipeListForm().GetListView().getSelectionModel().getSelectedIndex();
                             Recipe viewRecipe = myRecipesModel.FindRecipe(index);
                             viewRecipe.CreateImage();
                             viewRecipeForm = new ViewRecipeForm(viewRecipe.GetImg(), viewRecipe.GetInfo());
                             viewRecipeForm.SetColor("#8e887d");
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
        //create recipe button
        myRecipesView.GetRecipeListForm().GetAction2().setOnAction(
                new EventHandler<ActionEvent>()
                {
                     public void handle(ActionEvent event)
                     {
                         createRecipeForm = new CreateRecipeForm();
                         Scene createScene = new Scene(createRecipeForm, 550, 700);
                         createStage = new Stage();
                         createStage.setOnHidden(new EventHandler<WindowEvent>()
                         {
                             public void handle(WindowEvent we) 
                             {
                                 UpdateRecipeView();
                                 createStage.close();
                             }
                         });
                         createStage.setResizable(false);
                         createStage.setTitle("Create Recipe");
                         createStage.setScene(createScene);
                         createStage.show();
                         createRecipeForm.SetStage(createStage);
                     }
                });
        //share recipe button
        myRecipesView.GetRecipeListForm().GetAction3().setOnAction(
                new EventHandler<ActionEvent>()
                {
                     public void handle(ActionEvent event)
                     {
                         String name = myRecipesView.GetRecipeListForm().GetListView().getSelectionModel().getSelectedItem();
                         if (name != null)
                         {
                             int index = myRecipesView.GetRecipeListForm().GetListView().getSelectionModel().getSelectedIndex();
                             Recipe viewRecipe = myRecipesModel.FindRecipe(index);
                             viewRecipe.CreateImage();
                             emailForm = new EmailForm(viewRecipe);
                             Scene currentScene = new Scene(emailForm, 600, 550);
                             emailStage = new Stage();
                             emailStage.setResizable(false);
                             emailStage.setTitle("Share Recipe");
                             emailStage.setScene(currentScene);
                             emailStage.show();
                             emailForm.SetStage(emailStage);
                         }
                         else
                         {
                             //alert about no recipe selection
                             HBError.ErrorAlert("Information Dialog", "Empty Selection", "No recipe has been selected");
                         }
                     }
                });
        
        //return to main menu
        myRecipesView.GetRecipeListForm().GetAction4().setOnAction(
                new EventHandler<ActionEvent>()
                {
                     public void handle(ActionEvent event)
                     {
                         mainStage.setScene(mainMenuScene);
                     }
                });
    }
    
    public void UpdateRecipeView()
    {
        myRecipesModel.GetFavoriteRecipes();
        myRecipesView.GetRecipeListForm().SetNewTitles(myRecipesModel.GetRecipes());
        myRecipesView.GetRecipeListForm().SetNewDescriptions(myRecipesModel.GetRecipes());
    }
}
