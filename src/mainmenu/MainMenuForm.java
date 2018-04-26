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

    //main menu images
    public MainMenuForm()
    {
        
        
        //format title label 
        title.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));

        //set gap for h and v boxes
        this.setHgap(10);
        this.setVgap(10);

        //vbox variables
        VBox vbox1 = new VBox(50);

        searchBtn.setPrefSize(400, 50);
        myRecipesBtn.setPrefSize(400, 50);
        logoutBtn.setPrefSize(400, 50);

        searchBtn.setStyle("-fx-background-color:\n"
                + "        linear-gradient(#f0ff35, #a9ff00),\n"
                + "        radial-gradient(center 50% -40%, radius 200%, #b8ee36 45%, #80c800 50%);\n"
                + "    -fx-background-radius: 30;\n"
                + "    -fx-background-insets: 0,1,2,3,0;\n"
                + "    -fx-text-fill: #654b00;\n"
                + "    -fx-font-weight: bold;\n"
                + "    -fx-font-size: 20px;\n"
                + "    -fx-padding: 10 20 10 20;");
        myRecipesBtn.setStyle("-fx-background-color:\n"
                + "        linear-gradient(#f0ff35, #a9ff00),\n"
                + "        radial-gradient(center 50% -40%, radius 200%, #b8ee36 45%, #80c800 50%);\n"
                + "    -fx-background-radius: 30;\n"
                + "    -fx-background-insets: 0,1,2,3,0;\n"
                + "    -fx-text-fill: #654b00;\n"
                + "    -fx-font-weight: bold;\n"
                + "    -fx-font-size: 20px;\n"
                + "    -fx-padding: 10 20 10 20;");
        logoutBtn.setStyle("-fx-background-color:\n"
                + "        linear-gradient(#f0ff35, #a9ff00),\n"
                + "        radial-gradient(center 50% -40%, radius 200%, #b8ee36 45%, #80c800 50%);\n"
                + "    -fx-background-radius: 30;\n"
                + "    -fx-background-insets: 0,1,2,3,0;\n"
                + "    -fx-text-fill: #654b00;\n"
                + "    -fx-font-weight: bold;\n"
                + "    -fx-font-size: 20px;\n"
                + "    -fx-padding: 10 20 10 20;");

        this.getChildren().clear();
        vbox1.getChildren().addAll(searchBtn, myRecipesBtn, logoutBtn);

        //outputting all GUIS here
        this.add(vbox1, 1, 0);

        this.setAlignment(Pos.CENTER);

    }

}
