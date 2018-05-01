package mainmenu;

import genericgui.Banner;
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
public class MainMenuView extends BorderPane
{
    //background
    private Image backgroundImg = new Image("images/hbGreen.png");
    private BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
    private Background background = new Background(new BackgroundImage(backgroundImg, BackgroundRepeat.NO_REPEAT, 
                                                    BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, bSize));
    
    //forms
    private MainMenuForm mainMenuForm = new MainMenuForm();
    private Banner hbBanner= new Banner();
    
    //constructor
    public MainMenuView()
    {
        //modify the banner
        hbBanner.GetTitle().setText("Main Menu");
        hbBanner.ChangeColor("#44c499", "#50d8aa");
        hbBanner.GetTitle().setFont(Font.font("Book Antiqua", FontWeight.BOLD, FontPosture.REGULAR, 36));
        
        //set objects to the borderpane
        this.setBackground(background);
        this.setCenter(mainMenuForm);
        this.setTop(hbBanner);
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
