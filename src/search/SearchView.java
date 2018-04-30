package search;

import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;

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
    private SearchRecipeForm searchRecipeForm = new SearchRecipeForm();
    
    //constructor
    public SearchView()
    {
        this.setBackground(background);
        this.setCenter(searchRecipeForm);
    }
    
    //properties
    /**
     * @return the searchRecipeForm
     */
    public SearchRecipeForm GetSearchRecipeForm()
    {
        return searchRecipeForm;
    }

    /**
     * @param searchRecipeForm the searchRecipeForm to set
     */
    public void SetSearchRecipeForm(SearchRecipeForm searchRecipeForm)
    {
        this.searchRecipeForm = searchRecipeForm;
    }
    
    //functions
}
