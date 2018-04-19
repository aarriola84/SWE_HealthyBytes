package login;


import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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
    private Label search = new Label("Search: ");
    private Label dishInfo = new Label("Dish Info: ");
    private Label title = new Label("Healthy Bytes");

    // Main menu TextFields and TextAreas
    private TextField searchTF = new TextField();
    private TextArea dishInfoTA = new TextArea();

    //Main menu buttons
    private Button searchBtn = new Button("Seach");
    private Button myRecipeBtn = new Button("My Recipes");
    private Button sendBtn = new Button("Send");
    private Button printBtn = new Button("Print");
    
    //main menu images
    private Image dishImage = new Image("images/utb.jpg");
    private ImageView dishIV = new ImageView(dishImage);

    public MainMenuForm()
    {
        //format title label 
        title.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
        
        //set gap for h and v boxes
        this.setHgap(10);
        this.setVgap(10);

        //vbox variables
        VBox vbox1 = new VBox();
        VBox vbox2 = new VBox();

        //hbox variables
        HBox hbox1 = new HBox();
        HBox hbox2 = new HBox();

        //setup for all labes, text fields, etc.
        this.getChildren().clear();
        vbox1.getChildren().addAll(title, dishIV, search, searchTF);
        hbox1.getChildren().addAll(searchBtn, myRecipeBtn);
        vbox2.getChildren().addAll(dishInfo, dishInfoTA);
        hbox2.getChildren().addAll(sendBtn, printBtn);
        
        //outputting all GUIS here
        this.add(vbox1, 1, 0);
        this.add(hbox1, 1, 1);
        this.add(vbox2, 1, 2);
        this.add(hbox2, 1, 3);
        
        this.setAlignment(Pos.CENTER);

    }

}
