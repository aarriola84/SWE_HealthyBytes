/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainmenu;

import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
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
public class SearchRecipeForm extends GridPane
{

    /**
     * @return the recipes
     */
    public String[] getRecipes()
    {
        return recipes;
    }

    /**
     * @param recipes the recipes to set
     */
    public void setRecipes(String[] recipes)
    {
        this.setRecipes(recipes);
    }

    /**
     * @return the listView
     */
    public ListView<String> getListView()
    {
        return listView;
    }

    /**
     * @param listView the listView to set
     */
    public void setListView(ListView<String> listView)
    {
        this.listView = listView;
    }

    //flowpane
    private FlowPane listPane = new FlowPane(10,10);
    
    //labels
    private Label title = new Label("Find your selection!");
    private Label[] foodDescrip = 
    {
        new Label("A veggie pizza with diet cheese"),
        new Label("Spaghetti with wheat noodles"),
        new Label("Fresh salad with healthy choice "),
        new Label("Chicken cut up with a side of salad"),
        new Label("Beef cut up with a side of salad")
    };

    //buttons
    private Button searchBtn = new Button("Search");
    private Button cancelBtn = new Button("Return to Main Menu");

    //check boxes
    private CheckBox cbChicken = new CheckBox("Chicken");
    private CheckBox cbBeef = new CheckBox("Beef");
    private CheckBox cbFish = new CheckBox("Fish");
    private CheckBox cbLamb = new CheckBox("Lamb");
    private CheckBox cbPork = new CheckBox("Pork");
    private CheckBox cbVege = new CheckBox("Vegetarian");
    private CheckBox cbVegan = new CheckBox("Vegan");

    //boolean values for checkboxes
    private Boolean boolChicken = false;
    private Boolean boolBeef = false;
    private Boolean boolFish = false;
    private Boolean boolLamb = false;
    private Boolean boolPork = false;
    private Boolean boolVege = false;
    private Boolean boolVegan = false;

    //text area for description of item
    //private Label foodDescrip = new Label();
    
    //listview variable and fill in food items for now
    private String[] recipes = {"Pizza", "Spaghetti", "Salad", "Chicken Salad", "Beef Salad"};
    private ListView<String> listView = new ListView<>(FXCollections.observableArrayList(recipes));
    
    
    

    public SearchRecipeForm()
    {
        listView.setPrefSize(400, 400);
        listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        
        //formatting title
        title.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
        
        //creating v and h boxes and setting distance
        VBox vbox1 = new VBox();
        VBox vbox2 = new VBox();
        VBox vbox3 = new VBox();
        HBox hbox1 = new HBox();
        
        this.setHgap(10);
        this.setVgap(10);
        
        this.getChildren().clear();
        vbox1.getChildren().addAll(cbChicken, cbBeef, cbFish, cbPork, cbLamb, cbVege, cbVegan);
        vbox2.getChildren().addAll(title, listView);
        vbox3.getChildren().addAll(foodDescrip);
        hbox1.getChildren().addAll(searchBtn, cancelBtn);
        vbox1.setAlignment(Pos.TOP_LEFT);
        vbox3.setAlignment(Pos.CENTER_RIGHT);
        hbox1.setAlignment(Pos.CENTER_LEFT);
        
        this.add(vbox1, 0, 0);
        this.add(hbox1, 0, 1);
        this.add(vbox2, 1, 0);
        this.add(vbox3, 2, 0);
        this.setAlignment(Pos.CENTER);

        listView.getSelectionModel().selectedItemProperty().addListener(
        e -> {
            listPane.getChildren().clear();
            for(Integer i: listView.getSelectionModel().getSelectedIndices())
            {
                listPane.getChildren().add(foodDescrip[i]);
            }
        });
        
    }

    /**
     * @return the title
     */
    public Label getTitle()
    {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(Label title)
    {
        this.title = title;
    }

    /**
     * @return the searchBtn
     */
    public Button getSearchBtn()
    {
        return searchBtn;
    }

    /**
     * @param searchBtn the searchBtn to set
     */
    public void setSearchBtn(Button searchBtn)
    {
        this.searchBtn = searchBtn;
    }

    /**
     * @return the cancelBtn
     */
    public Button getCancelBtn()
    {
        return cancelBtn;
    }

    /**
     * @param cancelBtn the cancelBtn to set
     */
    public void setCancelBtn(Button cancelBtn)
    {
        this.cancelBtn = cancelBtn;
    }

    /**
     * @return the cbChicken
     */
    public CheckBox getCbChicken()
    {
        return cbChicken;
    }

    /**
     * @param cbChicken the cbChicken to set
     */
    public void setCbChicken(CheckBox cbChicken)
    {
        this.cbChicken = cbChicken;
    }

    /**
     * @return the cbBeef
     */
    public CheckBox getCbBeef()
    {
        return cbBeef;
    }

    /**
     * @param cbBeef the cbBeef to set
     */
    public void setCbBeef(CheckBox cbBeef)
    {
        this.cbBeef = cbBeef;
    }

    /**
     * @return the cbFish
     */
    public CheckBox getCbFish()
    {
        return cbFish;
    }

    /**
     * @param cbFish the cbFish to set
     */
    public void setCbFish(CheckBox cbFish)
    {
        this.cbFish = cbFish;
    }

    /**
     * @return the cbLamb
     */
    public CheckBox getCbLamb()
    {
        return cbLamb;
    }

    /**
     * @param cbLamb the cbLamb to set
     */
    public void setCbLamb(CheckBox cbLamb)
    {
        this.cbLamb = cbLamb;
    }

    /**
     * @return the cbPork
     */
    public CheckBox getCbPork()
    {
        return cbPork;
    }

    /**
     * @param cbPork the cbPork to set
     */
    public void setCbPork(CheckBox cbPork)
    {
        this.cbPork = cbPork;
    }

    /**
     * @return the cbVege
     */
    public CheckBox getCbVege()
    {
        return cbVege;
    }

    /**
     * @param cbVege the cbVege to set
     */
    public void setCbVege(CheckBox cbVege)
    {
        this.cbVege = cbVege;
    }

    /**
     * @return the cbVegan
     */
    public CheckBox getCbVegan()
    {
        return cbVegan;
    }

    /**
     * @param cbVegan the cbVegan to set
     */
    public void setCbVegan(CheckBox cbVegan)
    {
        this.cbVegan = cbVegan;
    }

    /**
     * @return the boolChicken
     */
    public Boolean getBoolChicken()
    {
        return boolChicken;
    }

    /**
     * @param boolChicken the boolChicken to set
     */
    public void setBoolChicken(Boolean boolChicken)
    {
        this.boolChicken = boolChicken;
    }

    /**
     * @return the boolBeef
     */
    public Boolean getBoolBeef()
    {
        return boolBeef;
    }

    /**
     * @param boolBeef the boolBeef to set
     */
    public void setBoolBeef(Boolean boolBeef)
    {
        this.boolBeef = boolBeef;
    }

    /**
     * @return the boolFish
     */
    public Boolean getBoolFish()
    {
        return boolFish;
    }

    /**
     * @param boolFish the boolFish to set
     */
    public void setBoolFish(Boolean boolFish)
    {
        this.boolFish = boolFish;
    }

    /**
     * @return the boolLamb
     */
    public Boolean getBoolLamb()
    {
        return boolLamb;
    }

    /**
     * @param boolLamb the boolLamb to set
     */
    public void setBoolLamb(Boolean boolLamb)
    {
        this.boolLamb = boolLamb;
    }

    /**
     * @return the boolPork
     */
    public Boolean getBoolPork()
    {
        return boolPork;
    }

    /**
     * @param boolPork the boolPork to set
     */
    public void setBoolPork(Boolean boolPork)
    {
        this.boolPork = boolPork;
    }

    /**
     * @return the boolVege
     */
    public Boolean getBoolVege()
    {
        return boolVege;
    }

    /**
     * @param boolVege the boolVege to set
     */
    public void setBoolVege(Boolean boolVege)
    {
        this.boolVege = boolVege;
    }

    /**
     * @return the boolVegan
     */
    public Boolean getBoolVegan()
    {
        return boolVegan;
    }

    /**
     * @param boolVegan the boolVegan to set
     */
    public void setBoolVegan(Boolean boolVegan)
    {
        this.boolVegan = boolVegan;
    }


    /**
     * @return the foodDescrip
     */
    public Label[] getFoodDescrip()
    {
        return foodDescrip;
    }

    /**
     * @param foodDescrip the foodDescrip to set
     */
    public void setFoodDescrip(Label[] foodDescrip)
    {
        this.foodDescrip = foodDescrip;
    }

}
