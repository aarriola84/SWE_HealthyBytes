package utilities;

import java.util.Comparator;

/**
 * @author Alexis Arriola
 */
public class FavoriteComparator implements Comparator<Favorite>
{
    @Override
	public int compare(Favorite fav1, Favorite fav2) 
        {
		int employee1Age = fav1.GetCount();
		int employee2Age = fav2.GetCount();
 
		if (employee1Age > employee2Age) {
			return 1;
		} else if (employee1Age < employee2Age) {
			return -1;
		} else {
			return 0;
		}
	}
}
