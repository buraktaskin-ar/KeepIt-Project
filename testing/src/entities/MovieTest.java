package entities;

import org.junit.Test;
import app.entities.Movie;
import bg.constants.MovieGenre;
import bg.managers.BookmarkManager;

import static org.junit.Assert.assertFalse;

public class MovieTest {
	
	@Test
	public void testIsKidFriendlyEligible(){
		
		//Test1
		
		
		Movie movie =  BookmarkManager.getInstance().createMovie(
			300,"Citizen Kane",1941,
			new String[]{"Orson Welles","Joseph Cotten"},
			new String[]{"Orson Welles"}, MovieGenre.HORROR ,8.5);
		
		boolean isKidFriendlyEligible = movie.iskidFriendlyEligible ();
		
		assertFalse("For horror genre --  should return false!!",
			isKidFriendlyEligible);
	
	
		//Test2
		movie = BookmarkManager.getInstance ().createMovie (
			300,"Citizen Kane",1941,
			new String[]{"Orson Welles","Joseph Cotten"},
			new String[]{"Orson Welles"}, MovieGenre.THRILLERS,8.5);
		
		isKidFriendlyEligible = movie.iskidFriendlyEligible ();
		assertFalse("For thriller genre --  should return false!!",
			isKidFriendlyEligible);
		
		
		
		
	}
	
	
	
	
	
	
}
