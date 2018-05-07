package genericgui;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import utilities.Recipe;

/**
 * @author Matthew Rodriguez
 * Date: April 26, 2018
 */
public class RecipeListForm extends GridPane
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
    // ArrayList to hold things
    private ListView<String> listView = new ListView<>(); 
    private TextArea listPane = new TextArea();

    private Button action1 = new Button("View Recipe");
    private Button action2 = new Button("Create Recipe");
    private Button action3 = new Button ("Share Button");
    private Button action4 = new Button("Back To Main Menu");
    
    HBox imagehbox = new HBox(10);
    HBox buttonbox = new HBox(30);
    
    private FilterBox filterBox = new FilterBox();
    
    //constructor
    public RecipeListForm()
    {
        listView.setPrefSize(300,400);
        listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        this.setAlignment(Pos.CENTER);
        listPane.setStyle("-fx-background-color: white");
        listPane.setOpacity(.80);
        listPane.setEditable(false);
        listPane.setWrapText(true);
        imagehbox.getChildren().addAll(filterBox,new ScrollPane(listView),listPane);
        buttonbox.getChildren().addAll(action1,action2,action3,action4);
        buttonbox.setAlignment(Pos.CENTER);
        this.add(imagehbox,2,1);
        this.add(buttonbox,2,2);       
        listView.getSelectionModel().selectedItemProperty().addListener(
        e -> {
             listPane.clear();
             for (Integer i : listView.getSelectionModel().getSelectedIndices())
                {
                    foodDescription2[i].setOpacity(1);
                    foodDescription2[i].setFont(Font.font("Book Antiqua", FontWeight.BOLD, FontPosture.REGULAR, 14));
                    listPane.appendText(foodDescription2[i].getText());
                }
             });
    }
    
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
    public TextArea GetListPane()
    {
        return listPane;
    }

    /**
     * @param listpane the listPane to set
     */
    public void SetListPane(TextArea listPane)
    {
        this.listPane = listPane;
    }

    /**
     * @return the viewrecipeBtn
     */
    public Button GetAction1()
    {
        return action1;
    }

    /**
     * @param viewrecipeBtn the viewrecipeBtn to set
     */
    public void SetAction1(Button button)
    {
        this.action1 = button;
    }

    /**
     * @return the createrecipeBtn
     */
    public Button GetAction2()
    {
        return action2;
    }

    /**
     * @param createrecipeBtn the createrecipeBtn to set
     */
    public void SetAction2(Button button)
    {
        this.action2 = button;
    }

    /**
     * @return the shareBtn
     */
    public Button GetAction3()
    {
        return action3;
    }

    /**
     * @param shareBtn the shareBtn to set
     */
    public void SetAction3(Button button)
    {
        this.action3 = button;
    }
    
    /**
     * @return the mainMenuBtn
     */
    public Button GetAction4()
    {
        return action4;
    }

    /**
     * @param mainMenuBtn the mainMenuBtn to set
     */
    public void SetAction4(Button button)
    {
        this.action4 = button;
    }
    
    /**
     * @return the filterBox
     */
    public FilterBox GetFilterBox()
    {
        return filterBox;
    }

    /**
     * @param filterBox the filterBox to set
     */
    public void SetFilterBox(FilterBox filterBox)
    {
        this.filterBox = filterBox;
    }
    
    //functions
    /**
     * Sets the recipe names array used in the list view given a recipe array list.
     * @param recipeList 
     */
    public void SetNewTitles(ArrayList<Recipe> recipeList)
    {
        String[] titles = new String[recipeList.size()];
        int i = 0;
        for (Recipe recipe: recipeList)
        {
            titles[i] = recipe.GetName();
            i++;
        }
        foodTitles = titles;
        listView.setItems(FXCollections.observableArrayList(foodTitles));
    }
    
    /**
     * Sets the description label array given an array list of recipes.
     * @param recipeList 
     */
    public void SetNewDescriptions(ArrayList<Recipe> recipeList)
    {
        Label[] desc = new Label[recipeList.size()];
        int i = 0;
        for (Recipe recipe: recipeList)
        {
            desc[i] = new Label(recipe.GetDescription());
            i++;
        }
        foodDescription2 = desc;
    }
    
    /**
     * Removes the FilterBox functionality of the RecipeListForm.
     */
    public void RemoveFilterBox()
    {
        imagehbox.getChildren().remove(filterBox);
    }
}
