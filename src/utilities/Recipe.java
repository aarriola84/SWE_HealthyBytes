package utilities;

import java.io.File;
import javafx.scene.image.Image;

/**
 * @author Ruben Olivares
 */
public class Recipe
{

    //data
    private int recipeID;
    private int proteinID;
    private int ownerID;
    private int faveCount;
    private int difficulty;
    private String name;
    private String info;
    private String description;
    private String path;
    private Image img;

    //constructors
    //default constructor
    public Recipe()
    {
    }

    //param constructor
    public Recipe(int recipeID, int proteinID, int ownerID, int faveCount, int difficulty, String name, String path, String info, String desc)
    {
        this.recipeID = recipeID;
        this.proteinID = proteinID;
        this.ownerID = ownerID;
        this.faveCount = faveCount;
        this.difficulty = difficulty;
        this.name = name;
        this.path = path;
        this.info = info;
        this.description = desc;
        System.out.println(path);
    }

    //properties
    /**
     * @return the recipeID
     */
    public int GetRecipeID()
    {
        return recipeID;
    }

    /**
     * @param recipeID the recipeID to set
     */
    public void SetRecipeID(int recipeID)
    {
        this.recipeID = recipeID;
    }

    /**
     * @return the proteinID
     */
    public int GetProteinID()
    {
        return proteinID;
    }

    /**
     * @param proteinID the proteinID to set
     */
    public void SetProteinID(int proteinID)
    {
        this.proteinID = proteinID;
    }

    /**
     * @return the ownerID
     */
    public int GetOwnerID()
    {
        return ownerID;
    }

    /**
     * @param ownerID the ownerID to set
     */
    public void SetOwnerID(int ownerID)
    {
        this.ownerID = ownerID;
    }

    /**
     * @return the faveCount
     */
    public int GetFaveCount()
    {
        return faveCount;
    }

    /**
     * @param faveCount the faveCount to set
     */
    public void SetFaveCount(int faveCount)
    {
        this.faveCount = faveCount;
    }

    /**
     * @return the difficulty
     */
    public int GetDifficulty()
    {
        return difficulty;
    }

    /**
     * @param difficulty the difficulty to set
     */
    public void SetDifficulty(int difficulty)
    {
        this.difficulty = difficulty;
    }

    /**
     * @return the name
     */
    public String GetName()
    {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void SetName(String name)
    {
        this.name = name;
    }

    /**
     * @return the info
     */
    public String GetInfo()
    {
        return info;
    }

    /**
     * @param info the info to set
     */
    public void SetInfo(String info)
    {
        this.info = info;
    }

    /**
     * @return the description
     */
    public String GetDescription()
    {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void SetDescription(String description)
    {
        this.description = description;
    }

    /**
     * @return the img
     */
    public Image GetImg()
    {
        return img;
    }

    /**
     * @param img the img to set
     */
    public void SetImg(Image img)
    {
        this.img = img;
    }

    /**
     * @return the path
     */
    public String GetPath()
    {
        return path;
    }

    /**
     * @param path the path to set
     */
    public void SetPath(String path)
    {
        this.path = path;
    }

    //functions
    public void CreateImage()
    {
        try
        {
            File f = new File("src/" + path);
            if (f.exists() && !f.isDirectory())
            {
                img = new Image(path);
            } else
            {
                System.out.println(f.canRead());
                System.out.println(f.exists());
                System.out.println(f.isDirectory());
                System.out.println(path + " File does not exist!");
            }
        } catch (Exception e)
        {
            System.out.println("Exception: " + e);
        }
    }
}