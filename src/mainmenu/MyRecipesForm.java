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
    
    private ListView<String> listview = new ListView<>(FXCollections.observableArrayList(foodTitles)); // ArrayList to hold things
    private FlowPane listpane = new FlowPane (10,10);

    private Label titleLabel = new Label("My Recipes");
    private Button viewrecipeBtn = new Button("View Recipe");
    private Button createrecipeBtn = new Button("Create Recipe");
    private Button shareBtn = new Button ("Share Button");
    
    
    /**
     * @return the foodTitles
     */
    public String[] getFoodTitles()
    {
        return foodTitles;
    }

    /**
     * @param foodTitles the foodTitles to set
     */
    public void setFoodTitles(String[] foodTitles)
    {
        this.foodTitles = foodTitles;
    }

    /**
     * @return the foodDescription2
     */
    public Label[] getFoodDescription2()
    {
        return foodDescription2;
    }

    /**
     * @param foodDescription2 the foodDescription2 to set
     */
    public void setFoodDescription2(Label[] foodDescription2)
    {
        this.foodDescription2 = foodDescription2;
    }

    /**
     * @return the listview
     */
    public ListView<String> getListview()
    {
        return listview;
    }

    /**
     * @param listview the listview to set
     */
    public void setListview(ListView<String> listview)
    {
        this.listview = listview;
    }

    /**
     * @return the listpane
     */
    public FlowPane getListpane()
    {
        return listpane;
    }

    /**
     * @param listpane the listpane to set
     */
    public void setListpane(FlowPane listpane)
    {
        this.listpane = listpane;
    }

    /**
     * @return the titleLabel
     */
    public Label getTitleLabel()
    {
        return titleLabel;
    }

    /**
     * @param titleLabel the titleLabel to set
     */
    public void setTitleLabel(Label titleLabel)
    {
        this.titleLabel = titleLabel;
    }

    /**
     * @return the viewrecipeBtn
     */
    public Button getViewrecipeBtn()
    {
        return viewrecipeBtn;
    }

    /**
     * @param viewrecipeBtn the viewrecipeBtn to set
     */
    public void setViewrecipeBtn(Button viewrecipeBtn)
    {
        this.viewrecipeBtn = viewrecipeBtn;
    }

    /**
     * @return the createrecipeBtn
     */
    public Button getCreaterecipeBtn()
    {
        return createrecipeBtn;
    }

    /**
     * @param createrecipeBtn the createrecipeBtn to set
     */
    public void setCreaterecipeBtn(Button createrecipeBtn)
    {
        this.createrecipeBtn = createrecipeBtn;
    }

    /**
     * @return the shareBtn
     */
    public Button getShareBtn()
    {
        return shareBtn;
    }

    /**
     * @param shareBtn the shareBtn to set
     */
    public void setShareBtn(Button shareBtn)
    {
        this.shareBtn = shareBtn;
    }
    
    public MyRecipesForm()
    {
        listview.setPrefSize(400,400);
        listview.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        this.setTop(titleLabel);
        this.setLeft(new ScrollPane(getListpane()));
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
