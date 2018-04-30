package mainmenu;

import static java.awt.SystemColor.text;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

/**
 *
 * @author Luis G
 */
public class MainMenuForm extends GridPane
{
    // Main menu labels and others
    private Label title = new Label("Healthy Bytes");

    // Main menu TextFields and TextAreas
    //Main menu buttons
    private Button searchBtn = new Button("Search Recipes");
    private Button myRecipesBtn = new Button("My Recipes");
    private Button logoutBtn = new Button("Logout");

    //cosntructor
    public MainMenuForm()
    {
        //format title label 
        title.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));

        //set gap for h and v boxes
        this.setHgap(10);
        this.setVgap(10);

        //vbox variables
        VBox vbox1 = new VBox(50);

        //set sizes of buttons
        searchBtn.setPrefSize(400, 50);
        myRecipesBtn.setPrefSize(400, 50);
        logoutBtn.setPrefSize(400, 50);

        //add everything
        this.getChildren().clear();
        vbox1.getChildren().addAll(searchBtn, myRecipesBtn, logoutBtn);

        //outputting all GUIS here
        this.add(vbox1, 1, 0);

        this.setAlignment(Pos.CENTER);
    }

    //properties
    /**
     * @return the searchBtn
     */
    public Button GetSearchBtn()
    {
        return searchBtn;
    }

    /**
     * @param searchBtn the searchBtn to set
     */
    public void SetSearchBtn(Button searchBtn)
    {
        this.searchBtn = searchBtn;
    }

    /**
     * @return the myRecipesBtn
     */
    public Button GetMyRecipesBtn()
    {
        return myRecipesBtn;
    }

    /**
     * @param myRecipesBtn the myRecipesBtn to set
     */
    public void SetMyRecipesBtn(Button myRecipesBtn)
    {
        this.myRecipesBtn = myRecipesBtn;
    }

    /**
     * @return the logoutBtn
     */
    public Button GetLogoutBtn()
    {
        return logoutBtn;
    }

    /**
     * @param logoutBtn the logoutBtn to set
     */
    public void SetLogoutBtn(Button logoutBtn)
    {
        this.logoutBtn = logoutBtn;
    }
}
