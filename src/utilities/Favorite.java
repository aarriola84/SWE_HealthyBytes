package utilities;

import java.util.Comparator;

/**
 * @author Alexis Arriola
 */
public class Favorite
{
    //data
    private String name;
    private int count;
    
    //constructor
    public Favorite(String name, int count)
    {
        this.name = name;
        this.count = count;
    }
    
    //properties
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
     * @return the count
     */
    public int GetCount()
    {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void SetCount(int count)
    {
        this.count = count;
    }
}
