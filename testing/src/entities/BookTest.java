package entities;

import org.junit.Test;
import bg.constants.BookGenre;
import bg.managers.BookmarkManager;
import app.entities.Book;

import static org.junit.Assert.assertFalse;

public class BookTest {
	
	@Test
	public void testIsKidFriendlyEligible(){
		
		//Test1
		
		Book book = BookmarkManager.getInstance ().createBook (
			4000,"Walden",1854,	"Wilder Publications", new String[]{"Henry David Thoreau"}
			, BookGenre.PHILOSOPHY , 	4.3);
		
		boolean isKidFriendlyEligible= book.iskidFriendlyEligible ();
		
		assertFalse("For philosophy book not isKidFriendlyEligible should return false--",
			isKidFriendlyEligible);
		
		
		
		
		//Test2
		
		 book = BookmarkManager.getInstance ().createBook (
			4000,"Walden",1854,	"Wilder Publications", new String[]{"Henry David Thoreau"}
			, BookGenre.SELF_HELP , 	4.3);
		
		 isKidFriendlyEligible= book.iskidFriendlyEligible ();
		
		assertFalse("For self_help book not isKidFriendlyEligible should return false--",
			isKidFriendlyEligible);
		
		
		
		
	}









}