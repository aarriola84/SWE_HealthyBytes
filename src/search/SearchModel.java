package search;

import database.Database;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import utilities.ActiveUser;
import utilities.HBError;
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
    public Recipe FindRecipe(int index)
    {
        Recipe viewRecipe = null;
 
        viewRecipe = recipes.get(index);

        return viewRecipe;
    }
    
    /**
     * Favorites the recipe given using the current recipe.
     * @param currentRecipe 
     */
    public void FavoriteRecipe(Recipe currentRecipe)
    {
        activeUser = ActiveUser.GetSingletonUser();
        try
        {
            //get the info we need for favorite table
            int recId = currentRecipe.GetRecipeID();
            int userId = activeUser.GetId();
            
            //insert the favorite into the database
            if (VerifyFavorite(recId, userId))
            {
                //alert user telling them they already have this recipe favorited
                HBError.ErrorAlert("Information Dialog", "Duplicate Favorite", "This recipe is already favorited");
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
                //alert stating that the recipe has been favorited
                HBError.ErrorAlert("Information Dialog", "Favorited Recipe",
                        "You have favorited the recipe " + currentRecipe.GetName());
            }
            
        }
        catch(Exception e)
        {
            System.out.println("Exception at SearchModel, Function FavoriteRecipe: " + e);
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
        catch (Exception e)
        {
            System.out.println("Exception at SearchModel, Function VerifyFavorite: " + e);
        }
        
        return exists;
    }
}
