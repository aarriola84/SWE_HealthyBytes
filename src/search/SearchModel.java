package search;

import database.Database;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import utilities.Recipe;

/**
 * @author Alexis Arriola
 */
public class SearchModel 
{
    //data
    private Database hbDatabase = Database.GetSingletonOfdatabase();
    private ArrayList<Recipe> recipes = new ArrayList<>();
    private Recipe currentRecipe;
    
    //properties
    /**
     * @return the recipes
     */
    public ArrayList<Recipe> GetRecipes()
    {
        return recipes;
    }

    /**
     * @param recipes the recipes to set
     */
    public void SetRecipes(ArrayList<Recipe> recipes)
    {
        this.recipes = recipes;
    }

    /**
     * @return the currentRecipe
     */
    public Recipe GetCurrentRecipe()
    {
        return currentRecipe;
    }

    /**
     * @param currentRecipe the currentRecipe to set
     */
    public void SetCurrentRecipe(Recipe currentRecipe)
    {
        this.currentRecipe = currentRecipe;
    }
    
    //functions
    public void GetRecipesDB(int[] proteinList)
    {
        String ands = GetAnds(proteinList);
        int recipeId;
        int proteinId;
        int ownerId;
        int favCount;
        int difficulty;
        String name;
        Blob info;
        Blob desc;
        Blob img;
        
        recipes.clear();
        try
        {
            Statement stmnt = hbDatabase.GetStmnt();
            ResultSet result = stmnt.executeQuery("select * from recipes where " + ands + "order by name asc;");
            
            if (result.next() == false)
            {
                System.out.println("No Recipes Found");
            }
            else
            {
                System.out.println("Found Recipes");
                
                //get the info from resultset
                recipeId = result.getInt("recipe_id");
                proteinId = result.getInt("protein_id");
                ownerId = result.getInt("ownership_id");
                favCount = result.getInt("fave_count");
                difficulty = result.getInt("difficulty");
                name = result.getString("name");
                info = result.getBlob("step_info");
                desc = result.getBlob("rec_info");
                img = result.getBlob("rec_img");
                //create the new recipe
                Recipe newRecipe = new Recipe(recipeId, proteinId, ownerId, favCount, difficulty, name, img, info, desc);
                //add recipe to the recipe array
                recipes.add(newRecipe);
                
                System.out.println(name);
                
                //continue to see if there are more
                while (result.next())
                {
                    //get the info from resultset
                    recipeId = result.getInt("recipe_id");
                    proteinId = result.getInt("protein_id");
                    ownerId = result.getInt("ownership_id");
                    favCount = result.getInt("fave_count");
                    difficulty = result.getInt("difficulty");
                    name = result.getString("name");
                    info = result.getBlob("step_info");
                    desc = result.getBlob("rec_info");
                    img = result.getBlob("rec_img");
                    //create the new recipe
                    Recipe diffRecipe = new Recipe(recipeId, proteinId, ownerId, favCount, difficulty, name, img, info, desc);
                    //add recipe to the recipe array
                    recipes.add(diffRecipe);
                    
                    System.out.println(name);
                }
                
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    
    //figures out how many ands we will need
    public String GetAnds(int[] proteinList)
    {
        String ands = "";
        if (proteinList.length == 1)
        {
            ands = "protein_id = " + proteinList[0] + " ";
        }
        else
        {
            for (int i = 0; i < proteinList.length; i++)
            {
                if (i == 0)
                {
                    ands += "protein_id = " + proteinList[i] + " ";
                }
                /*
                else if (i == (proteinList.length - 1))
                {
                    ands += "and protein_id = " + proteinList[i] + ";";
                }
                */
                else
                {
                    ands += "and protein_id = " + proteinList[i] + " ";
                }
            }
        }
        System.out.println("ands = " + ands);
        return ands;
    }
    
}
