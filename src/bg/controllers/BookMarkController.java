package bg.controllers;

import app.entities.BookMark;
import app.entities.User;
import bg.managers.BookmarkManager;

public class BookMarkController {


	private static BookMarkController bookMarkController = new BookMarkController();
	private BookMarkController(){}
	public static BookMarkController getInstance(){
		return bookMarkController;
	}
	
	
	
	public static void saveUserBookMark (User user , BookMark bookMark) {
		BookmarkManager.getInstance ().saveUserBookmark(user,bookMark);
		
	}
	
	public void setKidFriendlyStatus ( User user , String kidFriendlyStatus, BookMark bookmark){
		BookmarkManager.getInstance ().setKidFriendlyStatus(user,
			kidFriendlyStatus ,bookmark);
	
	
	
	}
	
	
	
	public void share ( User user , BookMark bookMark ) {
		BookmarkManager.getInstance ().share(user,bookMark);
	}

}
