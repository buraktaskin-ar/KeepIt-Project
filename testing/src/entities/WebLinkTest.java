package entities;


import org.testng.annotations.Test;
import static org.junit.Assert.*;
import app.entities.WebLink;
import bg.managers.BookmarkManager;

public class WebLinkTest {
	
	@Test
	public void testIsKidFriendlyEligible(){
		
		// Test 1 : porn in url -- false
		
		
		WebLink weblink =  BookmarkManager.getInstance().createWebLink
			(2000,"Taming Tiger, Part 0",
				"http://www.javaworld.com/article/2072759/core-java/taming-porn--part-2.html"
				,"http://www.javaworld.com");
		
		boolean iskidFriendlyEligible = weblink.iskidFriendlyEligible ();
		
		
		
		
		assertFalse ("for porn in url  - isKidFriendyEligible() must return false!",
			iskidFriendlyEligible );
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		// Test 2 : porn in title -- false
		
		
		
		 weblink =  BookmarkManager.getInstance().createWebLink
			(2000,"Taming porn, Part 0",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html"
				,"http://www.javaworld.com");
		
		 iskidFriendlyEligible = weblink.iskidFriendlyEligible ();
		
		
		
		
		assertFalse ("for porn in title  - isKidFriendyEligible() must return false!",
			iskidFriendlyEligible );
		
		
		
		
		
		
		
		
		
		
		// Test 3 : adult in host -- false
		
		
		 weblink =  BookmarkManager.getInstance().createWebLink
			(2000,"Taming Tiger, Part 0",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger-part-2.html"
				,"http://www.adult.com");
		
		 iskidFriendlyEligible = weblink.iskidFriendlyEligible ();
		
		
		
		
		assertFalse ("for adult in host  - isKidFriendyEligible() must return false!",
			iskidFriendlyEligible );
		
		
		
		
		
		
		// Test 4 : adult in url, but not in host -- true
		
		 weblink =  BookmarkManager.getInstance().createWebLink
			(2000,"Taming Tiger, Part 0",
				"http://www.javaworld.com/article/2072759/core-java/taming-adult-part-2.html"
				,"http://www.javaworld.com");
		
		 iskidFriendlyEligible = weblink.iskidFriendlyEligible ();
		
		
	
		assertTrue ("for adult in url, but not in host  - isKidFriendyEligible()" +
				" must return true!",
			iskidFriendlyEligible );
		
		
		
		
		
		
		
		
		
		
		
		// Test 5 : adult in title only -- true
		
		
		 weblink =  BookmarkManager.getInstance().createWebLink
			(2000,"Taming adult, Part 0",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html"
				,"http://www.javaworld.com");
		
		 iskidFriendlyEligible = weblink.iskidFriendlyEligible ();
		
		
		assertTrue ("for adult in title only  - isKidFriendyEligible() must return true!",
			iskidFriendlyEligible );
		
		
		
		
		
		
		
	//	Assert.fail ("Not yet implemented");
	
	
	
	
	}
}
