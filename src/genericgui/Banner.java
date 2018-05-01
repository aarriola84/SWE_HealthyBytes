package genericgui;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;

/**
 * @author Alexis Arriola
 */
public class Banner extends HBox
{
    //data
    Image logo1 = new Image("images/hb.png");
    ImageView logoView1 = new ImageView(logo1);
    Image logo2 = new Image("images/hb.png");
    ImageView logoView2 = new ImageView(logo2);
    HBox titleBox = new HBox();
    String color1 = "#44c499";
    String color2 = "#50d8aa";
    
    //labels
    private Label title = new Label("Title");
    
    public Banner()
    {
        //set logo size
        logoView1.setFitHeight(100);
        logoView1.setFitWidth(200);
        logoView2.setFitHeight(100);
        logoView2.setFitWidth(200);
        
        
        this.getChildren().addAll(logoView1);
        this.setAlignment(Pos.CENTER_LEFT);
        
        titleBox.getChildren().addAll(title);
        titleBox.setAlignment(Pos.CENTER);
        
        
        this.getChildren().addAll(titleBox, logoView2);
        
        HBox.setHgrow(titleBox, Priority.ALWAYS);
    }
    
    //properties
    /**
     * @return the title
     */
    public Label GetTitle()
    {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void SetTitle(Label title)
    {
        this.title = title;
    }
    
    //functions
    public void ChangeColor(String color1, String color2)
    {
        this.color1 = color1;
        this.color2 = color2;
        this.setStyle("-fx-background-color: \n"
                + "        "+color1+",\n"
                + "        linear-gradient(#fafdfe, #e8f5fc),\n"
                + "        linear-gradient("+color2+" 0%, "+color2+" 49%, "+color2+" 50%, "+color1+" 100%);\n"
                + "    -fx-background-insets: 0,1,2;\n"
                + "    -fx-background-radius: 3,2,1;\n"
                + "    -fx-padding: 3 30 3 30;\n"
                + "    -fx-text-fill: black;\n"
                + "    -fx-font-weight: bold;"
                + "    -fx-font-size: 24px;");
    }
}
