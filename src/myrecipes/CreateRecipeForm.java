/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myrecipes;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;

/**
 *
 * @author Luis G
 */
public class CreateRecipeForm extends GridPane
{
    //labels
    private Label title = new Label("Create Your Recipe!");
    private Label imageLabel = new Label("Select your image: ");
    private Label recipeSteps = new Label("Steps to your recipe: ");
    private Label recipeIngredients = new Label("Ingredients needed: ");
    
    //text areas
    private TextArea stepsTA = new TextArea();
    private TextArea ingredientsTA = new TextArea();
    
    //buttons
    private Button selectImageBtn = new Button("Select Image...");
    private Button createBtn = new Button("Create");
    private Button cancelBtn = new Button("Cancel");
    
    //image variables
    private Image defaultImage;
    
    private ImageView imageView = new ImageView();
    
    //boolean to check for default image and initialized to false
    private Boolean imageCheck = false;
    
    //file chooser variables
    private FileChooser fileChooser = new FileChooser();
    
    
    public CreateRecipeForm()
    {
        System.out.println("In create recipe form function");
        //format title label 
        title.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
        
        //initialize image to be default at start
        defaultImage = new Image("images/hb.jpg");
        
        //setting image size through the image view
        imageView.setFitHeight(128);
        imageView.setFitWidth(128);
        
        //setting gaps between hboxes and vboxes
        this.setHgap(20);
        
        //vboxes or hboxes
        VBox vbox1 = new VBox();
        HBox hbox1 = new HBox();
        
        //setup for image check for default
        if(imageCheck == false)
            imageView.setImage(defaultImage);
        
        //setup on all labels, textfields, textareas, etc. 
        this.getChildren().clear();
        vbox1.getChildren().addAll(title, imageView, imageLabel, selectImageBtn,
                                   recipeSteps, stepsTA, recipeIngredients, ingredientsTA);
        hbox1.getChildren().addAll(createBtn, cancelBtn);
        this.add(vbox1, 0, 0);
        this.add(hbox1, 0, 1);
        this.setAlignment(Pos.CENTER);
        
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
     * @return the imageLabel
     */
    public Label getImageLabel()
    {
        return imageLabel;
    }

    /**
     * @param imageLabel the imageLabel to set
     */
    public void setImageLabel(Label imageLabel)
    {
        this.imageLabel = imageLabel;
    }

    /**
     * @return the recipeSteps
     */
    public Label getRecipeSteps()
    {
        return recipeSteps;
    }

    /**
     * @param recipeSteps the recipeSteps to set
     */
    public void setRecipeSteps(Label recipeSteps)
    {
        this.recipeSteps = recipeSteps;
    }

    /**
     * @return the recipeIngredients
     */
    public Label getRecipeIngredients()
    {
        return recipeIngredients;
    }

    /**
     * @param recipeIngredients the recipeIngredients to set
     */
    public void setRecipeIngredients(Label recipeIngredients)
    {
        this.recipeIngredients = recipeIngredients;
    }

    /**
     * @return the stepsTA
     */
    public TextArea getStepsTA()
    {
        return stepsTA;
    }

    /**
     * @param stepsTA the stepsTA to set
     */
    public void setStepsTA(TextArea stepsTA)
    {
        this.stepsTA = stepsTA;
    }

    /**
     * @return the ingredientsTA
     */
    public TextArea getIngredientsTA()
    {
        return ingredientsTA;
    }

    /**
     * @param ingredientsTA the ingredientsTA to set
     */
    public void setIngredientsTA(TextArea ingredientsTA)
    {
        this.ingredientsTA = ingredientsTA;
    }

    /**
     * @return the selectImageBtn
     */
    public Button getSelectImageBtn()
    {
        return selectImageBtn;
    }

    /**
     * @param selectImageBtn the selectImageBtn to set
     */
    public void setSelectImageBtn(Button selectImageBtn)
    {
        this.selectImageBtn = selectImageBtn;
    }

    /**
     * @return the createBtn
     */
    public Button getCreateBtn()
    {
        return createBtn;
    }

    /**
     * @param createBtn the createBtn to set
     */
    public void setCreateBtn(Button createBtn)
    {
        this.createBtn = createBtn;
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
     * @return the defaultImage
     */
    public Image getDefaultImage()
    {
        return defaultImage;
    }

    /**
     * @param defaultImage the defaultImage to set
     */
    public void setDefaultImage(Image defaultImage)
    {
        this.defaultImage = defaultImage;
    }

    /**
     * @return the imageView
     */
    public ImageView getImageView()
    {
        return imageView;
    }

    /**
     * @param imageView the imageView to set
     */
    public void setImageView(ImageView imageView)
    {
        this.imageView = imageView;
    }

    /**
     * @return the imageCheck
     */
    public Boolean getImageCheck()
    {
        return imageCheck;
    }

    /**
     * @param imageCheck the imageCheck to set
     */
    public void setImageCheck(Boolean imageCheck)
    {
        this.imageCheck = imageCheck;
    }

    /**
     * @return the fileChooser
     */
    public FileChooser getFileChooser()
    {
        return fileChooser;
    }

    /**
     * @param fileChooser the fileChooser to set
     */
    public void setFileChooser(FileChooser fileChooser)
    {
        this.fileChooser = fileChooser;
    }
}
