package myrecipes;

import database.Database;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import utilities.ActiveUser;
import utilities.HBIO;
import utilities.Recipe;

/**
 * @author Alexis Arriola
 */
public class MyRecipesModel 
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
    public void GetFavoriteRecipes()
    {
        activeUser = ActiveUser.GetSingletonUser();
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
            ResultSet result = stmnt.executeQuery("select * from recipes inner join faves on faves._recID = recipes.recipe_id "
                                                 +"where faves._userId = " + activeUser.GetId() + " order by name asc;");
            
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
                info = HBIO.OpenToReadFromTextFile(HBIO.ConvertBlobToFile(name, ownerId, infoBlob, 2));
                desc = HBIO.OpenToReadFromTextFile(HBIO.ConvertBlobToFile(name, ownerId, descBlob, 3));
                path = HBIO.ConvertBlobToFile(name, ownerId, imgBlob, 1);
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
                    info = HBIO.OpenToReadFromTextFile(HBIO.ConvertBlobToFile(name, ownerId, infoBlob, 2));
                    desc = HBIO.OpenToReadFromTextFile(HBIO.ConvertBlobToFile(name, ownerId, descBlob, 3));
                    path = HBIO.ConvertBlobToFile(name, ownerId, imgBlob, 1);
                    //create the new recipe
                    Recipe diffRecipe = new Recipe(recipeId, proteinId, ownerId, favCount, difficulty, name, path, info, desc);
                    //add recipe to the recipe array
                    recipes.add(diffRecipe);
                    
                    System.out.println(name);
                }
                
            }
        }
        catch (SQLException e)
        {
            System.out.println("Exception at MyRecipesModel, Function GetFavoriteRecipes: " + e);
        }
    }
    
    public Recipe FindRecipe(int index)
    {
        Recipe viewRecipe = null;
 
        viewRecipe = recipes.get(index);

        return viewRecipe;
    }
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
}
