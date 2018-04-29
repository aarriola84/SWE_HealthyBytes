package mainmenu;

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
public class MainMenuView extends BorderPane
{
    //background
    private Image backgroundImg = new Image("images/hbGreen.png");
    private BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
    private Background background = new Background(new BackgroundImage(backgroundImg, BackgroundRepeat.NO_REPEAT, 
                                                    BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, bSize));
    
    //forms
    private MainMenuForm mainMenuForm = new MainMenuForm();
    
    //constructor
    public MainMenuView()
    {
        this.setBackground(background);
        this.setCenter(mainMenuForm);
    }
    
    //properties
    /**
     * @return the mainMenuForm
     */
    public MainMenuForm GetMainMenuForm()
    {
        return mainMenuForm;
    }

    /**
     * @param mainMenuForm the mainMenuForm to set
     */
    public void SetMainMenuForm(MainMenuForm mainMenuForm)
    {
        this.mainMenuForm = mainMenuForm;
    }
    
    //functions
    public void SetMainMenuForm()
    {
        this.getChildren().clear();
        this.setCenter(mainMenuForm);
    }
}
