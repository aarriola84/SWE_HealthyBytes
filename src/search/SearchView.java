package search;

import genericgui.Banner;
import genericgui.FilterBox;
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
public class SearchView extends BorderPane
{
    //background
    private Image backgroundImg = new Image("images/hbPurple.png");
    private BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
    private Background background = new Background(new BackgroundImage(backgroundImg, BackgroundRepeat.NO_REPEAT, 
                                                    BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, bSize));
    
    //forms
    private RecipeListForm recipeListForm = new RecipeListForm();
    private Banner hbBanner= new Banner();
    
    
    //constructor
    public SearchView()
    {
        //modify recipeListForm
        recipeListForm.GetAction1().setText("Search");
        recipeListForm.GetAction2().setText("View Recipe");
        recipeListForm.GetAction3().setText("Favorite");
        
        //modify the banner
        hbBanner.GetTitle().setText("Search Recipes");
        hbBanner.ChangeColor("#af85a2","#d19ec1");
        hbBanner.GetTitle().setFont(Font.font("Book Antiqua", FontWeight.BOLD, FontPosture.REGULAR, 36));
        
        //set objects to the borderpane
        this.setBackground(background);
        this.setCenter(recipeListForm);
        this.setTop(hbBanner);
    }
    
    //properties
    /**
     * @return the searchRecipeForm
     */
    public RecipeListForm GetRecipeListForm()
    {
        return recipeListForm;
    }

    /**
     * @param searchRecipeForm the searchRecipeForm to set
     */
    public void SetRecipeListForm(RecipeListForm recipeListForm)
    {
        this.recipeListForm = recipeListForm;
    }

    //functions
    public int[] GetProteinIds()
    {
        //variables
        int count = 0;
        boolean beef = false;
        boolean chicken = false;
        boolean fish = false;
        boolean lamb = false;
        boolean pork = false;
        boolean vegan = false;
        boolean vegie = false;
        boolean other = false;
        
        //check which proteins where selected
        if(recipeListForm.GetFilterBox().GetBeef().isSelected())
        {
            beef = true;
            count++;
        }
        if(recipeListForm.GetFilterBox().GetChicken().isSelected())
        {
            chicken = true;
            count++;
        }
        if(recipeListForm.GetFilterBox().GetFish().isSelected())
        {
            fish = true;
            count++;
        }
        if(recipeListForm.GetFilterBox().GetLamb().isSelected())
        {
            lamb = true;
            count++;
        }
        if(recipeListForm.GetFilterBox().GetPork().isSelected())
        {
            pork = true;
            count++;
        }
        if(recipeListForm.GetFilterBox().GetVegan().isSelected())
        {
            vegan = true;
            count++;
        }
        if(recipeListForm.GetFilterBox().GetVegie().isSelected())
        {
            vegie = true;
            count++;
        }
        if(recipeListForm.GetFilterBox().GetOther().isSelected())
        {
            other = true;
            count++;
        }
        
        if (count == 0)
            return null;
        
        int[] proteinList = new int[count];
        
        //set the array according
        int i = 0;
        if(beef)
        {
            proteinList[i] = 2;
            i++;
        }
        if(chicken)
        {
            proteinList[i] = 1;
            i++;
        }
        if(fish)
        {
            proteinList[i] = 3;
            i++;
        }
        if(lamb)
        {
            proteinList[i] = 4;
            i++;
        }
        if(pork)
        {
            proteinList[i] = 5;
            i++;
        }
        if(vegan)
        {
            proteinList[i] = 6;
            i++;
        }
        if(vegie)
        {
            proteinList[i] = 7;
            i++;
        }
        if(other)
        {
            proteinList[i] = 8;
            i++;
        }
        
        return proteinList;
    }
}
