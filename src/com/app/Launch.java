package com.app;

import app.entities.BookMark;
import app.entities.User;
import bg.bgjobs.WebpageDownloaderTask;
import bg.managers.BookmarkManager;
import bg.managers.UserManager;

import java.util.List;

public class Launch {
		
	
		private static List<User> users;
		private static List<List<BookMark>> bookMarks;
	
	
	public static  void loadData(){
		System.out.println ("1. loading data..");
		DataStore.loadData ();
		
		users = UserManager.getInstance ().getUsers ();
		bookMarks = BookmarkManager.getInstance ().getBookMarks ();
	
		System.out.println ("Printing data..");
		printUserData();
		printBookMarkData();
		
	}
	
	private static void printBookMarkData () {
		for(List<BookMark> bookMarkList : bookMarks ){
			for ( BookMark bookMark: bookMarkList ) {
				System.out.println (bookMark);
				
			}
			System.out.println ("\n");
		}
	}
	
	private static void printUserData () {
		for(User user: users){
			System.out.println (user);
		}
		System.out.println ("\n");
	}
	
	
	public static void main (String[] args) {
	
	loadData ();
	start();
	runDownloaderJob();
	
	
	}
	
	private static void runDownloaderJob () {
		
		WebpageDownloaderTask task = new WebpageDownloaderTask (true);
		(new Thread (task)).start ();
	
	}
	
	private static void start () {

		System.out.println ("\n2. Bookmarking..");
		for ( User user : users) {
			View.browse (user,bookMarks);

		}
	}
	
	
	
	
}
