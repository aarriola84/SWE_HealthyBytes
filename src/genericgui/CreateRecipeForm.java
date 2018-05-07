package genericgui;

import database.Database;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import myrecipes.MyRecipesController;
import utilities.ActiveUser;

/**
 * @author Alexis Arriola
 */
public class CreateRecipeForm extends VBox
{
    //singleton references
    private Database hbDatabase = Database.GetSingletonOfdatabase();
    private ActiveUser activeUser = ActiveUser.GetSingletonUser();
    private Stage myStage;
    
    //strings for combo boxes
    private String beef = new String("Beef");
    private String chicken = new String("Chicken");
    private String fish = new String("Fish");
    private String lamb = new String("Lamb");
    private String pork = new String("Pork");
    private String vegan = new String("Vegan");
    private String vegetarian = new String("Vegetarian");
    private String other = new String("Other");
    //string to represent difficulty
    private String easy = new String("Easy");
    private String medium = new String("Intermediate");
    private String hard = new String("Hard");
    
    //image and imageview default, can be chaged later
    private Image image = new Image("images/hb.png");
    private Image defaultImage = new Image("images/hb.png");
    private ImageView iv = new ImageView(image);
    
    //string to hold path of file of image
    private String filePath = "src/images/hb.png";

    //Image and Submit buttons
    private Button imageBtn = new Button("Select Image");
    private Button submitBtn = new Button("Submit Recipe");

    //label varaibles
    private Label recipeName = new Label("Enter recipe name: ");
    private Label description = new Label("Description: ");
    private Label instructions = new Label("Ingredients and Instructions: ");

    //textfield
    private TextField recipeNameTF = new TextField();

    //textarea variable to type in recipe
    private TextArea descripTA = new TextArea();
    private TextArea instrucTA = new TextArea();

    //strings to store what is typed in the textareas 
    private String recipename = new String();
    private String descrip = new String();
    private String instruc = new String();
    private String proteinType = new String();
    private String difficultyType = new String();

    //vboxes and hboxes
    private HBox recipeHBox = new HBox();
    private HBox recipeInfoHBox = new HBox(5);
    private VBox vboxMenu = new VBox();

    //creatging a file of the recipe
    private String recipeDirectory = new String();
    
    //combo boxes
    private ObservableList<String> differentFoods = 
            FXCollections.observableArrayList(
            beef, chicken, fish, lamb, pork, vegan, vegetarian, other);
    private ObservableList<String> difficultyFoods = 
            FXCollections.observableArrayList(easy, medium, hard);
    
    private ComboBox foodsCB = new ComboBox(differentFoods);
    private ComboBox difficultyCB = new ComboBox(difficultyFoods);
    
    //constructor
    public CreateRecipeForm()
    {
        //set this forms settings
        this.setFillWidth(false);
        this.setStyle("-fx-background-color: #8e887d");
        
        //image settings
        iv.setFitHeight(300);
        iv.setFitWidth(300);
        
        //set the Text Area settings
        descripTA.setPrefWidth(400);
        instrucTA.setPrefWidth(400);
        descripTA.setText("Created by: \n\n"
                         +"Total: 40 min\n"
                         +"Prep: 20 min\n"
                         +"Cook: 20 min\n"
                         +"Yield: 4 servings\n"
                         +"Level: Easy\n\n"
                         +"Sample recipe description.");
        
        instrucTA.setText("Ingredients: \n\n\n"
                         +"Directions: \n");
        
        recipeInfoHBox.getChildren().clear();
        recipeInfoHBox.getChildren().addAll(imageBtn, foodsCB, difficultyCB);
        recipeInfoHBox.setAlignment(Pos.CENTER);
        
        vboxMenu.setSpacing(5);
        recipeHBox.getChildren().clear();
        recipeHBox.getChildren().addAll(recipeName, recipeNameTF);
        recipeHBox.setAlignment(Pos.CENTER);

        vboxMenu.getChildren().clear();
        vboxMenu.getChildren().addAll(
                iv, recipeInfoHBox,
                recipeHBox,
                description, descripTA,
                instructions, instrucTA,
                submitBtn);
        vboxMenu.setAlignment(Pos.CENTER);
        this.getChildren().add(vboxMenu);
        this.setAlignment(Pos.CENTER);
        AttachHandlers();
    }
    
    //properties
    /**
     * @return the beef
     */
    public String GetBeef()
    {
        return beef;
    }

    /**
     * @param beef the beef to set
     */
    public void SetBeef(String beef)
    {
        this.beef = beef;
    }

    /**
     * @return the chicken
     */
    public String GetChicken()
    {
        return chicken;
    }

    /**
     * @param chicken the chicken to set
     */
    public void SetChicken(String chicken)
    {
        this.chicken = chicken;
    }

    /**
     * @return the fish
     */
    public String GetFish()
    {
        return fish;
    }

    /**
     * @param fish the fish to set
     */
    public void SetFish(String fish)
    {
        this.fish = fish;
    }

    /**
     * @return the lamb
     */
    public String GetLamb()
    {
        return lamb;
    }

    /**
     * @param lamb the lamb to set
     */
    public void SetLamb(String lamb)
    {
        this.lamb = lamb;
    }

    /**
     * @return the pork
     */
    public String GetPork()
    {
        return pork;
    }

    /**
     * @param pork the pork to set
     */
    public void SetPork(String pork)
    {
        this.pork = pork;
    }

    /**
     * @return the vegan
     */
    public String GetVegan()
    {
        return vegan;
    }

    /**
     * @param vegan the vegan to set
     */
    public void SetVegan(String vegan)
    {
        this.vegan = vegan;
    }

    /**
     * @return the vegetarian
     */
    public String GetVegetarian()
    {
        return vegetarian;
    }

    /**
     * @param vegetarian the vegetarian to set
     */
    public void SetVegetarian(String vegetarian)
    {
        this.vegetarian = vegetarian;
    }

    /**
     * @return the other
     */
    public String GetOther()
    {
        return other;
    }

    /**
     * @param other the other to set
     */
    public void SetOther(String other)
    {
        this.other = other;
    }

    /**
     * @return the easy
     */
    public String GetEasy()
    {
        return easy;
    }

    /**
     * @param easy the easy to set
     */
    public void SetEasy(String easy)
    {
        this.easy = easy;
    }

    /**
     * @return the medium
     */
    public String GetMedium()
    {
        return medium;
    }

    /**
     * @param medium the medium to set
     */
    public void SetMedium(String medium)
    {
        this.medium = medium;
    }

    /**
     * @return the hard
     */
    public String GetHard()
    {
        return hard;
    }

    /**
     * @param hard the hard to set
     */
    public void SetHard(String hard)
    {
        this.hard = hard;
    }

    /**
     * @return the image
     */
    public Image GetImage()
    {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void SetImage(Image image)
    {
        this.image = image;
    }

    /**
     * @return the defaultImage
     */
    public Image GetDefaultImage()
    {
        return defaultImage;
    }

    /**
     * @param defaultImage the defaultImage to set
     */
    public void SetDefaultImage(Image defaultImage)
    {
        this.defaultImage = defaultImage;
    }

    /**
     * @return the iv
     */
    public ImageView GetIv()
    {
        return iv;
    }

    /**
     * @param iv the iv to set
     */
    public void SetIv(ImageView iv)
    {
        this.iv = iv;
    }

    /**
     * @return the filePath
     */
    public String GetFilePath()
    {
        return filePath;
    }

    /**
     * @param filePath the filePath to set
     */
    public void SetFilePath(String filePath)
    {
        this.filePath = filePath;
    }

    /**
     * @return the imageBtn
     */
    public Button GetImageBtn()
    {
        return imageBtn;
    }

    /**
     * @param imageBtn the imageBtn to set
     */
    public void SetImageBtn(Button imageBtn)
    {
        this.imageBtn = imageBtn;
    }

    /**
     * @return the submitBtn
     */
    public Button GetSubmitBtn()
    {
        return submitBtn;
    }

    /**
     * @param submitBtn the submitBtn to set
     */
    public void SetSubmitBtn(Button submitBtn)
    {
        this.submitBtn = submitBtn;
    }

    /**
     * @return the recipeName
     */
    public Label GetRecipeName()
    {
        return recipeName;
    }

    /**
     * @param recipeName the recipeName to set
     */
    public void SetRecipeName(Label recipeName)
    {
        this.recipeName = recipeName;
    }

    /**
     * @return the description
     */
    public Label GetDescription()
    {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void SetDescription(Label description)
    {
        this.description = description;
    }

    /**
     * @return the instructions
     */
    public Label GetInstructions()
    {
        return instructions;
    }

    /**
     * @param instructions the instructions to set
     */
    public void SetInstructions(Label instructions)
    {
        this.instructions = instructions;
    }

    /**
     * @return the recipeNameTF
     */
    public TextField GetRecipeNameTF()
    {
        return recipeNameTF;
    }

    /**
     * @param recipeNameTF the recipeNameTF to set
     */
    public void SetRecipeNameTF(TextField recipeNameTF)
    {
        this.recipeNameTF = recipeNameTF;
    }

    /**
     * @return the descripTA
     */
    public TextArea GetDescripTA()
    {
        return descripTA;
    }

    /**
     * @param descripTA the descripTA to set
     */
    public void SetDescripTA(TextArea descripTA)
    {
        this.descripTA = descripTA;
    }

    /**
     * @return the instrucTA
     */
    public TextArea GetInstrucTA()
    {
        return instrucTA;
    }

    /**
     * @param instrucTA the instrucTA to set
     */
    public void SetInstrucTA(TextArea instrucTA)
    {
        this.instrucTA = instrucTA;
    }

    /**
     * @return the recipename
     */
    public String GetRecipename()
    {
        return recipename;
    }

    /**
     * @param recipename the recipename to set
     */
    public void SetRecipename(String recipename)
    {
        this.recipename = recipename;
    }

    /**
     * @return the descrip
     */
    public String GetDescrip()
    {
        return descrip;
    }

    /**
     * @param descrip the descrip to set
     */
    public void SetDescrip(String descrip)
    {
        this.descrip = descrip;
    }

    /**
     * @return the instruc
     */
    public String GetInstruc()
    {
        return instruc;
    }

    /**
     * @param instruc the instruc to set
     */
    public void SetInstruc(String instruc)
    {
        this.instruc = instruc;
    }

    /**
     * @return the recipeHBox
     */
    public HBox GetRecipeHBox()
    {
        return recipeHBox;
    }

    /**
     * @param recipeHBox the recipeHBox to set
     */
    public void SetRecipeHBox(HBox recipeHBox)
    {
        this.recipeHBox = recipeHBox;
    }

    /**
     * @return the recipeInfoHBox
     */
    public HBox GetRecipeInfoHBox()
    {
        return recipeInfoHBox;
    }

    /**
     * @param recipeInfoHBox the recipeInfoHBox to set
     */
    public void SetRecipeInfoHBox(HBox recipeInfoHBox)
    {
        this.recipeInfoHBox = recipeInfoHBox;
    }

    /**
     * @return the vboxMenu
     */
    public VBox GetVboxMenu()
    {
        return vboxMenu;
    }

    /**
     * @param vboxMenu the vboxMenu to set
     */
    public void SetVboxMenu(VBox vboxMenu)
    {
        this.vboxMenu = vboxMenu;
    }

    /**
     * @return the recipeDirectory
     */
    public String GetRecipeDirectory()
    {
        return recipeDirectory;
    }

    /**
     * @param recipeDirectory the recipeDirectory to set
     */
    public void SetRecipeDirectory(String recipeDirectory)
    {
        this.recipeDirectory = recipeDirectory;
    }

    /**
     * @return the differentFoods
     */
    public ObservableList<String> GetDifferentFoods()
    {
        return differentFoods;
    }

    /**
     * @param differentFoods the differentFoods to set
     */
    public void SetDifferentFoods(ObservableList<String> differentFoods)
    {
        this.differentFoods = differentFoods;
    }

    /**
     * @return the difficultyFoods
     */
    public ObservableList<String> GetDifficultyFoods()
    {
        return difficultyFoods;
    }

    /**
     * @param difficultyFoods the difficultyFoods to set
     */
    public void SetDifficultyFoods(ObservableList<String> difficultyFoods)
    {
        this.difficultyFoods = difficultyFoods;
    }

    /**
     * @return the foodsCB
     */
    public ComboBox GetFoodsCB()
    {
        return foodsCB;
    }

    /**
     * @param foodsCB the foodsCB to set
     */
    public void SetFoodsCB(ComboBox foodsCB)
    {
        this.foodsCB = foodsCB;
    }

    /**
     * @return the difficultyCB
     */
    public ComboBox GetDifficultyCB()
    {
        return difficultyCB;
    }

    /**
     * @param difficultyCB the difficultyCB to set
     */
    public void SetDifficultyCB(ComboBox difficultyCB)
    {
        this.difficultyCB = difficultyCB;
    }
    /**
     * @return the proteinType
     */
    public String GetProteinType()
    {
        return proteinType;
    }

    /**
     * @param proteinType the proteinType to set
     */
    public void SetProteinType(String proteinType)
    {
        this.proteinType = proteinType;
    }

    /**
     * @return the difficultyType
     */
    public String GetDifficultyType()
    {
        return difficultyType;
    }

    /**
     * @param difficultyType the difficultyType to set
     */
    public void SetDifficultyType(String difficultyType)
    {
        this.difficultyType = difficultyType;
    }
    
    public void SetStage(Stage myStage)
    {
        this.myStage = myStage;
    }
    //functions
    /**
     * Stores the information from fields of the Create Recipe Form. Returns true if any field is blank.
     * @return 
     */
    public boolean StoreTA()
    {
        boolean blank = false;
        
        //get the info from the text fields
        //Recipe Name
        recipename = GetRecipeNameTF().getText();
        if(recipename.equals(""))
            blank = true;
        //RecipeDescription
        descrip = descripTA.getText();
        if(descrip.equals(""))
            blank = true;
        //RecipeDirections
        instruc = instrucTA.getText();
        if(instruc.equals(""))
            blank = true;
        //ProteinType
        if( foodsCB.getSelectionModel().getSelectedItem() == null)
            blank = true;
        else
            proteinType = foodsCB.getSelectionModel().getSelectedItem().toString();
        System.out.println(proteinType);
        //DifficultyType
        if( difficultyCB.getSelectionModel().getSelectedItem() == null)
            blank = true;
        else
            difficultyType = difficultyCB.getSelectionModel().getSelectedItem().toString();
        System.out.println(difficultyType);
        return blank;
    }
    
    /**
     * Compares given string and returns the corresponding protein id associated with it.
     * @param name
     * @return 
     */
    public int FindProteinId(String name)
    {
        int proteinId = 0;
        
        if (name.equals("Beef"))
            proteinId = 2;
        else if (name.equals("Chicken"))
            proteinId = 1;
        else if (name.equals("Fish"))
            proteinId = 3;
        else if (name.equals("Lamb"))
            proteinId = 4;
        else if (name.equals("Pork"))
            proteinId = 5;
        else if (name.equals("Vegan"))
            proteinId = 6;
        else if (name.equals("Vegetarian"))
            proteinId = 7;
        else if (name.equals("Other"))
            proteinId = 8;
        
        return proteinId;
    }
    
    /**
     * Compares given string and returns corresponding difficulty id associated with it.
     * @return 
     */
    public int FindDifficultyId(String name)
    {
        int difficultyId = 0;
        
        if (name.equals("Easy"))
            difficultyId = 1;
        else if(name.equals("Intermediate"))
            difficultyId = 2;
        else if(name.equals("Hard"))
            difficultyId = 3;
        
        return difficultyId;
    }
    
    /**
     * Writes the information from the Description and Directions text areas into a file.
     */
    public void WriteToFile()
    {
        char [] descripChar = new char[descrip.length()];
        char [] instrucChar = new char[instruc.length()];
        
        for (int i = 0; i < descrip.length(); i++)
        {
            descripChar[i] = descrip.charAt(i);
        }
        
        for (int i = 0; i < instruc.length(); i++)
        {
            instrucChar[i] = instruc.charAt(i);
        }
        
        try
        {
            BufferedWriter descripBW = new BufferedWriter(new FileWriter("src/userfiles/"+ recipename + "Description.txt"));
            BufferedWriter instrucBW = new BufferedWriter(new FileWriter("src/userfiles/"+ recipename + "Instructions.txt"));
            
            for (int i = 0; i < descrip.length(); i++)
            {
                if(descripChar[i] == '\n')
                {
                    descripBW.newLine();
                }
                else
                {
                    descripBW.write(descripChar[i]);
                }
            }
            descripBW.close();
            
            
            for (int i = 0; i < instruc.length(); i++)
            {
                if(instrucChar[i] == '\n')
                    instrucBW.newLine();
                else
                    instrucBW.write(instrucChar[i]);
            }
            instrucBW.close();
        }
        catch(IOException e)
        {
            System.out.println("Exception at CreateRecipeForm, Function WriteToFile: " + e);
        }
    }
    
    public void AttachHandlers()
    {
        //select image button
        imageBtn.setOnAction(
                new EventHandler<ActionEvent>()
                {
                     public void handle(ActionEvent event)
                     {
                         try
                         {
                            FileChooser fileChooser = new FileChooser();
                             //set extension filter
                            FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
                            FileChooser.ExtensionFilter extFilterJPEG = new FileChooser.ExtensionFilter("JPEG files (*.jpeg)", "*.JPEG");
                            FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
                            fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG, extFilterJPEG);
                            //Show open file dialog
                            File file = fileChooser.showOpenDialog(null);
                            if (file != null)
                            {
                                BufferedImage bufferedImage = ImageIO.read(file);
                                SetFilePath(file.getAbsolutePath());
                                System.out.println("This is the file path: ");
                                System.out.println(GetFilePath());
                                Image image = SwingFXUtils.toFXImage(bufferedImage, null);
                                GetIv().setImage(image);
                            }
                            else
                            {
                                System.out.println("No File found!");
                            }
                         }
                         catch(IOException e)
                         {
                             System.out.println("Exception at CreateRecipeForm, Function Select Image Button: " + e);
                         }
                     }
                });
        //submit recipe button
        submitBtn.setOnAction(
                new EventHandler<ActionEvent>()
                {
                     public void handle(ActionEvent event)
                     {
                         if(!StoreTA())
                         {
                             WriteToFile();
                             int protein = FindProteinId(proteinType);
                             int difficulty = FindDifficultyId(difficultyType);
                             String descPath = "src/userfiles/" + recipename + "Description.txt";
                             String instrucPath = "src/userfiles/" + recipename + "Instructions.txt";
                             try
                             {
                                 //create the files for blobs
                                 FileInputStream input = null;
                                 File imgFile = new File(filePath);
                                 File descFile = new File(descPath);
                                 File instrucFile = new File(instrucPath);
                                 //set the image one
                                 input = new FileInputStream(imgFile);
                                 
                                 //get the connections
                                 Connection conn = hbDatabase.GetConn();
                                 //check if it exists?
                                 Statement stmt = hbDatabase.GetStmnt();
                                 ResultSet rs = hbDatabase.GetResul();
                                 rs = stmt.executeQuery("select * from recipes where name = '" + recipename + "' and ownership_id = " + activeUser.GetId() + ";");
                                 if (!rs.next())
                                 {
                                     //prepare the statment
                                     PreparedStatement prepStmnt = conn.prepareStatement("INSERT into recipes VALUES(?,?,?,?,?,?,?,?,?)");
                                     //begin inserting to the prepared statement
                                     prepStmnt.setInt(1, 0);
                                     prepStmnt.setString(2, recipename);
                                     prepStmnt.setInt(3, 0);
                                     prepStmnt.setInt(4, difficulty);
                                     prepStmnt.setBlob(5, input);
                                     input = new FileInputStream(descFile);
                                     prepStmnt.setBlob(6, input);
                                     input = new FileInputStream(instrucFile);
                                     prepStmnt.setBlob(7, input);
                                     prepStmnt.setInt(8, protein);
                                     prepStmnt.setInt(9, activeUser.GetId());
                                     prepStmnt.executeUpdate();
                                     //favorite the recipe
                                     FavoriteRecipe(recipename);
                                     //close the recipe
                                     myStage.hide();
                                 }
                                 else
                                 {
                                     //alert for duplicate recipe
                                     System.out.println("Duplicate Recipe!!");
                                 }
                             }
                             catch(FileNotFoundException | SQLException e)
                             {
                                 System.out.println("Exception at CreateRecipeForm, Function Submit Recipe Button: " + e);
                             }
                         }
                         else
                         {
                             System.out.println("Do an alert for blank fields here!");
                         }
                     }
                });
    }
    
    public void FavoriteRecipe(String name)
    {
        try
        {
            //get the recipe id of the created recipe
            Statement stmt = hbDatabase.GetStmnt();
            ResultSet rs = hbDatabase.GetResul();
            rs = stmt.executeQuery("select recipe_id from recipes where name = '" + name + "' and ownership_id = " + activeUser.GetId() + ";");
            rs.next();
            //get the info we need for favorite table
            int recId = rs.getInt("recipe_id");
            int userId = activeUser.GetId();
            
            //insert the favorite into the database
            if (VerifyFavorite(recId, userId))
            {
                //alert user telling them they already have this recipe favorited
                System.out.println("Already Favorited!!!");
            }
            else
            {
                //add into the faves table
                Statement stmnt = hbDatabase.GetStmnt();
                String sql = "insert into faves (_recID, _userID) values (" + recId + "," + userId + ");";
                stmnt.executeUpdate(sql);
                //increment the recipe's favorite count
                sql = "update recipes set fave_count = fave_count + 1 where recipe_id = " + recId + ";";
                stmnt.executeUpdate(sql);
            }
            
        }
        catch(SQLException e)
        {
            System.out.println("Exception at CreateRecipeForm, Function FavoriteRecipe: " + e);
        }
    }
    
    /**
     * Verifies if the recipe is already on the user's favorite list.
     * @param recId
     * @param userId
     * @return 
     */
    private boolean VerifyFavorite(int recId, int userId)
    {
        boolean exists = false;
        try
        {
            Statement stmnt = hbDatabase.GetStmnt();
            ResultSet result = stmnt.executeQuery("select * from faves where _recID = "+recId+" and _userId = "+userId+";");
            if (result.next() == false)
            {
                System.out.println("Favorite does not exist");
                exists = false;
            }
            else
            {
                System.out.println("Favorite exists");
                exists = true;
            }
        }
        catch (SQLException e)
        {
            System.out.println("Exception at CreateRecipeForm, Function VerifyFavorite: " + e);
        }
        
        return exists;
    }
}
