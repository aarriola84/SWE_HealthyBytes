package genericgui;

import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;

/**
 * @author Alexis Arriola
 */
public class FilterBox extends VBox
{
    //Checkboxes
    private CheckBox beef = new CheckBox("Beef");
    private CheckBox chicken = new CheckBox("Chicken");
    private CheckBox fish = new CheckBox("Fish");
    private CheckBox lamb = new CheckBox("Lamb");
    private CheckBox pork = new CheckBox("Pork");
    private CheckBox vegan = new CheckBox("Vegan");
    private CheckBox vegie = new CheckBox("Vegetarian");
    private CheckBox other = new CheckBox("Other");
    
    //constructor
    public FilterBox()
    {
        this.setPrefSize(400,100);
        this.setStyle("-fx-background-color: white");
        this.setOpacity(.80);
        this.getChildren().addAll(beef, chicken, fish, lamb, pork, vegan, vegie, other);
        //this.setAlignment(Pos.);
    }
    
    //properties
    /**
     * @return the beef
     */
    public CheckBox GetBeef()
    {
        return beef;
    }

    /**
     * @param beef the beef to set
     */
    public void SetBeef(CheckBox beef)
    {
        this.beef = beef;
    }

    /**
     * @return the chicken
     */
    public CheckBox GetChicken()
    {
        return chicken;
    }

    /**
     * @param chicken the chicken to set
     */
    public void SetChicken(CheckBox chicken)
    {
        this.chicken = chicken;
    }

    /**
     * @return the fish
     */
    public CheckBox GetFish()
    {
        return fish;
    }

    /**
     * @param fish the fish to set
     */
    public void SetFish(CheckBox fish)
    {
        this.fish = fish;
    }

    /**
     * @return the lamb
     */
    public CheckBox GetLamb()
    {
        return lamb;
    }

    /**
     * @param lamb the lamb to set
     */
    public void SetLamb(CheckBox lamb)
    {
        this.lamb = lamb;
    }

    /**
     * @return the pork
     */
    public CheckBox GetPork()
    {
        return pork;
    }

    /**
     * @param pork the pork to set
     */
    public void SetPork(CheckBox pork)
    {
        this.pork = pork;
    }

    /**
     * @return the vegan
     */
    public CheckBox GetVegan()
    {
        return vegan;
    }

    /**
     * @param vegan the vegan to set
     */
    public void SetVegan(CheckBox vegan)
    {
        this.vegan = vegan;
    }

    /**
     * @return the vegie
     */
    public CheckBox GetVegie()
    {
        return vegie;
    }

    /**
     * @param vegie the vegie to set
     */
    public void SetVegie(CheckBox vegie)
    {
        this.vegie = vegie;
    }

    /**
     * @return the other
     */
    public CheckBox GetOther()
    {
        return other;
    }

    /**
     * @param other the other to set
     */
    public void SetOther(CheckBox other)
    {
        this.other = other;
    }
}
