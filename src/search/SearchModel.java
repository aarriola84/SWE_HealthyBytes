package search;

import database.Database;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import utilities.ActiveUser;
import utilities.HBIO;
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
    private ActiveUser activeUser;
    
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
    //Gets all recipes from DB based on proteins selected.
    public void GetRecipesDB(int[] proteinList)
    {
        String ands = GetAnds(proteinList);
        int recipeId;
        int proteinId;
        int ownerId;
        int favCount;
        int difficulty;
        String name;
        String info;
        String path;
        String desc;
        Blob infoBlob;
        Blob descBlob;
        Blob imgBlob;
        
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
                infoBlob = result.getBlob("step_info");
                descBlob = result.getBlob("rec_info");
                imgBlob = result.getBlob("rec_img");
                info = HBIO.OpenToReadFromTextFile(HBIO.ConvertBlobToFile(name, infoBlob, 2));
                desc = HBIO.OpenToReadFromTextFile(HBIO.ConvertBlobToFile(name, descBlob, 3));
                path = HBIO.ConvertBlobToFile(name, imgBlob, 1);
                //create the new recipe
                Recipe newRecipe = new Recipe(recipeId, proteinId, ownerId, favCount, difficulty, name, path, info, desc);
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
                    infoBlob = result.getBlob("step_info");
                    descBlob = result.getBlob("rec_info");
                    imgBlob = result.getBlob("rec_img");
                    info = HBIO.OpenToReadFromTextFile(HBIO.ConvertBlobToFile(name, infoBlob, 2));
                    desc = HBIO.OpenToReadFromTextFile(HBIO.ConvertBlobToFile(name, descBlob, 3));
                    path = HBIO.ConvertBlobToFile(name, imgBlob, 1);
                    //create the new recipe
                    Recipe diffRecipe = new Recipe(recipeId, proteinId, ownerId, favCount, difficulty, name, path, info, desc);
                    //add recipe to the recipe array
                    recipes.add(diffRecipe);
                    
                    System.out.println(name);
                }
                
            }
        }
        catch (Exception e)
        {
            System.out.println("Exception at SearchModel, Function GetRecipeDB: " + e);
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
                    ands += "or protein_id = " + proteinList[i] + " ";
                }
            }
        }
        System.out.println("ands = " + ands);
        return ands;
    }
    
    /**
     * Finds the recipe in the local array list and returns it given a to search by.
     * @param name
     * @return 
     */
    public Recipe FindRecipe(String name)
    {
        Recipe viewRecipe = null;
        for (Recipe recipe: recipes)
        {
            if (recipe.GetName().equalsIgnoreCase(name))
                viewRecipe = recipe;
        }
        return viewRecipe;
    }
    
    public void FavoriteRecipe(Recipe currentRecipe)
    {
        activeUser = ActiveUser.GetSingletonUser();
        try
        {
            //get the info we need for favorite table
            int rec_id = currentRecipe.GetRecipeID();
            int user_id = activeUser.GetId();
            
            //insert the favorite into the database
            Statement stmnt = hbDatabase.GetStmnt();
            String sql = "insert into faves (_recID, _userID) values (" + rec_id + "," + user_id + ");";
            stmnt.executeUpdate(sql);
        }
        catch(Exception e)
        {
            System.out.println("Exception at SearchModel, Function FavoriteRecipe: " + e);
        }
    }
}
