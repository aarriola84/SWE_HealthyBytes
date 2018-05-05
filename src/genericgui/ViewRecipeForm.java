package genericgui;

import javafx.geometry.Pos;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 * @author Alexis Arriola
 */
public class ViewRecipeForm extends VBox
{
    //data
    private ImageView recipeIV;
    private TextArea recipeInfo = new TextArea();
    
    //constructor
    public ViewRecipeForm(Image img, String info)
    {
        //this box settings
        this.setSpacing(10);
        this.setStyle("-fx-background-color: #af85a2");
        //set image
        recipeIV = new ImageView(img);
        //set textarea
        recipeInfo.setPrefHeight(500);
        recipeInfo.setEditable(false);
        recipeInfo.setWrapText(true);
        recipeInfo.appendText(info);
        //add objects to this Form
        this.getChildren().addAll(recipeIV, recipeInfo);
        this.setAlignment(Pos.TOP_CENTER);
    }
}
