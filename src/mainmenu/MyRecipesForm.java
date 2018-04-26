/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainmenu;

import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

/**
 *
 * @author Matthew Rodriguez
 */
public class MyRecipesForm extends BorderPane
{
    private String[] foodTitles = 
    {
     "Chicken", "Beef", "Fish","Spaghetti", "Chicken Salad", "Regular Salad", "Lamb", "Tortellini", "Lasagna"
    };
    
    private Label[] foodDescription2 =
    {
       new Label("This is a recipe about savory chicken."),
       new Label("This is a recipe about smoked beef."),
       new Label("This is a recipe about grilled fish."),
       new Label("This is a recipe about wheat spaghetti with fresh herbs and spices."),
       new Label("This is a recipe about fresh chicken salad."),
       new Label("This is a recipe about simple fresh prepared salad."),
       new Label("This is a recipe about savory cooked lamb."),
       new Label("This is a recipe about tortellini."),
       new Label("This is a recipe about lasagna."),
    };
    
    ListView<String> listview = new ListView<>(FXCollections.observableArrayList(foodTitles)); // ArrayList to hold things
    FlowPane listpane = new FlowPane (10,10);

    private Label titleLabel = new Label("My Recipes");
    private Button viewrecipeBtn = new Button("View Recipe");
    private Button createrecipeBtn = new Button("Create Recipe");
    private Button shareBtn = new Button ("Share Button");
    
    public MyRecipesForm()
    {
        listview.setPrefSize(400,400);
        listview.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        this.setLeft(new ScrollPane(listpane));
        this.setCenter(listpane);
        
        listview.getSelectionModel().selectedItemProperty().addListener(
        e -> {
             listpane.getChildren().clear();
             for (Integer i : listview.getSelectionModel().getSelectedIndices())
                {
                    listpane.getChildren().add(foodDescription2[i]);
                }
             });
        this.setBottom(createrecipeBtn);
        this.setBottom(shareBtn);
    }
}
