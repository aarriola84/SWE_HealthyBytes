package myrecipes;

import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

/**
 *
 * @author Matthew Rodriguez
 * Date: April 26, 2018
 */
public class MyRecipesForm extends GridPane
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
    
    private ListView<String> listView = new ListView<>(FXCollections.observableArrayList(foodTitles)); // ArrayList to hold things
    private FlowPane listPane = new FlowPane (10,10);

    private Label titleLabel = new Label("My Recipes");
    private Button viewrecipeBtn = new Button("View Recipe");
    private Button createrecipeBtn = new Button("Create Recipe");
    private Button shareBtn = new Button ("Share Button");
    private Button mainMenuBtn = new Button("Back To Main Menu");
    
    HBox imagehbox = new HBox(10);
    HBox buttonbox = new HBox(30);
    /**
     * @return the foodTitles
     */
    public String[] GetFoodTitles()
    {
        return foodTitles;
    }

    /**
     * @param foodTitles the foodTitles to set
     */
    public void SetFoodTitles(String[] foodTitles)
    {
        this.foodTitles = foodTitles;
    }

    /**
     * @return the foodDescription2
     */
    public Label[] GetFoodDescription2()
    {
        return foodDescription2;
    }

    /**
     * @param foodDescription2 the foodDescription2 to set
     */
    public void SetFoodDescription2(Label[] foodDescription2)
    {
        this.foodDescription2 = foodDescription2;
    }

    /**
     * @return the listView
     */
    public ListView<String> GetListView()
    {
        return listView;
    }

    /**
     * @param listView the listView to set
     */
    public void SetListView(ListView<String> listView)
    {
        this.listView = listView;
    }

    /**
     * @return the listPane
     */
    public FlowPane GetListPane()
    {
        return listPane;
    }

    /**
     * @param listpane the listPane to set
     */
    public void SetListPane(FlowPane listPane)
    {
        this.listPane = listPane;
    }

    /**
     * @return the titleLabel
     */
    public Label GetTitleLabel()
    {
        return titleLabel;
    }

    /**
     * @param titleLabel the titleLabel to set
     */
    public void SetTitleLabel(Label titleLabel)
    {
        this.titleLabel = titleLabel;
    }

    /**
     * @return the viewrecipeBtn
     */
    public Button GetViewRecipeBtn()
    {
        return viewrecipeBtn;
    }

    /**
     * @param viewrecipeBtn the viewrecipeBtn to set
     */
    public void SetViewRecipeBtn(Button viewrecipeBtn)
    {
        this.viewrecipeBtn = viewrecipeBtn;
    }

    /**
     * @return the createrecipeBtn
     */
    public Button GetCreateRecipeBtn()
    {
        return createrecipeBtn;
    }

    /**
     * @param createrecipeBtn the createrecipeBtn to set
     */
    public void SetCreateRecipeBtn(Button createrecipeBtn)
    {
        this.createrecipeBtn = createrecipeBtn;
    }

    /**
     * @return the shareBtn
     */
    public Button GetShareBtn()
    {
        return shareBtn;
    }

    /**
     * @param shareBtn the shareBtn to set
     */
    public void SetShareBtn(Button shareBtn)
    {
        this.shareBtn = shareBtn;
    }
    
    /**
     * @return the mainMenuBtn
     */
    public Button GetMainMenuBtn()
    {
        return mainMenuBtn;
    }

    /**
     * @param mainMenuBtn the mainMenuBtn to set
     */
    public void SetMainMenuBtn(Button mainMenuBtn)
    {
        this.mainMenuBtn = mainMenuBtn;
    }
    
    public MyRecipesForm()
    {
        listView.setPrefSize(400,400);
        listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        this.setAlignment(Pos.CENTER);
        titleLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 50));
        this.add(titleLabel,2,0);
        imagehbox.getChildren().addAll(new ScrollPane(listView),listPane);
        buttonbox.getChildren().addAll(viewrecipeBtn,createrecipeBtn,shareBtn,mainMenuBtn);
        this.add(imagehbox,2,1);
        this.add(buttonbox,2,2);       
        listView.getSelectionModel().selectedItemProperty().addListener(
        e -> {
             listPane.getChildren().clear();
             for (Integer i : listView.getSelectionModel().getSelectedIndices())
                {
                    listPane.getChildren().add(foodDescription2[i]);
                }
             });
    }
}
