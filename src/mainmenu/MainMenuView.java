package mainmenu;

import javafx.scene.layout.BorderPane;

/**
 * @author Alexis Arriola
 */
public class MainMenuView extends BorderPane
{
    //forms
    private MainMenuForm mainMenuForm = new MainMenuForm();
    
    //constructor
    public MainMenuView()
    {
        this.setStyle("-fx-background-color: #ff8800;");
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
