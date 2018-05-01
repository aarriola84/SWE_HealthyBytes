package myrecipes;

import genericgui.Banner;
import genericgui.RecipeListForm;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;


/**
 * @author Alexis Arriola
 */
public class MyRecipesView extends BorderPane
{
    //background
    private Image backgroundImg = new Image("images/hbGray.png");
    private BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
    private Background background = new Background(new BackgroundImage(backgroundImg, BackgroundRepeat.NO_REPEAT, 
                                                    BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, bSize));
    
    //forms
    private RecipeListForm recipeListForm = new RecipeListForm();
    private Banner hbBanner= new Banner();
    
    //constructor
    public MyRecipesView()
    {
        //modify the banner
        hbBanner.GetTitle().setText("My Recipes");
        hbBanner.ChangeColor("#8e887d","#b2aa9b");
        hbBanner.GetTitle().setFont(Font.font("Book Antiqua", FontWeight.BOLD, FontPosture.REGULAR, 36));
        
        //set objects to borderpane
        this.setBackground(background);
        this.setCenter(recipeListForm);
        this.setTop(hbBanner);
    }
    
    /**
     * @return the myRecipesForm
     */
    public RecipeListForm GetRecipeListForm()
    {
        return recipeListForm;
    }

    /**
     * @param myRecipesForm the myRecipesForm to set
     */
    public void SetRecipeListForm(RecipeListForm myRecipesForm)
    {
        this.recipeListForm = myRecipesForm;
    }
}
