package bg.dao;

import com.semsq.app.DataStore;
import app.entities.BookMark;
import app.entities.UserBookmark;
import app.entities.WebLink;

import java.util.ArrayList;
import java.util.List;

public class BookMarkDao {



	public List<List<BookMark>> getBookMarks(){
		return DataStore.getBookMarks ();
	}
	
	
	
	
	public void saveUserBookMark (UserBookmark userBookmark) {
		DataStore.add(userBookmark);
	}

	public List<WebLink> getAllWeblinks(){
		List<WebLink> result = new ArrayList<> ();
		
		List <List<BookMark>> bookmarks = DataStore.getBookMarks ();
		List<BookMark> allWebLinks = bookmarks.get ( 0 );
		for(BookMark bookMark : allWebLinks){
			result.add ( (WebLink) bookMark);
		}
		return result;
		
	}
	
	public List <WebLink> getWeblinks(WebLink.DownloadStatus downloadStatus){
		List <WebLink> result = new ArrayList<> ();
		List <WebLink> allWeblinks = getAllWeblinks ();
		
		for(WebLink webLink : allWeblinks){
			if(webLink.getDownloadStatus () .equals ( downloadStatus ) ){
				result.add ( webLink );
			}
		}
		
		
		return result;
	
	}
	
	
	
	
	

}
