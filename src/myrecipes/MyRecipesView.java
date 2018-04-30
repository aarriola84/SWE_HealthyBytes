package myrecipes;

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
public class MyRecipesView extends BorderPane
{
    //background
    private Image backgroundImg = new Image("images/hbOrange.png");
    private BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
    private Background background = new Background(new BackgroundImage(backgroundImg, BackgroundRepeat.NO_REPEAT, 
                                                    BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, bSize));
    
    //forms
    private MyRecipesForm myRecipesForm = new MyRecipesForm();
    
    //constructor
    public MyRecipesView()
    {
        this.setBackground(background);
        this.setCenter(myRecipesForm);
    }
    
    /**
     * @return the myRecipesForm
     */
    public MyRecipesForm GetMyRecipesForm()
    {
        return myRecipesForm;
    }

    /**
     * @param myRecipesForm the myRecipesForm to set
     */
    public void SetMyRecipesForm(MyRecipesForm myRecipesForm)
    {
        this.myRecipesForm = myRecipesForm;
    }
}
