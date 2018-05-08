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
    private String color = "#af85a2";
    
    //constructor
    public ViewRecipeForm(Image img, String info)
    {
        //this box settings
        this.setSpacing(10);
        this.setStyle("-fx-background-color: " + color);
        //set image
        recipeIV = new ImageView(img);
        recipeIV.setFitHeight(300);
        recipeIV.setFitWidth(300);
        
        //set textarea
        recipeInfo.setPrefHeight(500);
        recipeInfo.setEditable(false);
        recipeInfo.setWrapText(true);
        recipeInfo.appendText(info);
        //add objects to this Form
        this.getChildren().addAll(recipeIV, recipeInfo);
        this.setAlignment(Pos.TOP_CENTER);
    }
    
    //properties
    /**
     * @return the color
     */
    public String GetColor()
    {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void SetColor(String color)
    {
        this.color = color;
        this.setStyle("-fx-background-color: " + color);
    }
}
