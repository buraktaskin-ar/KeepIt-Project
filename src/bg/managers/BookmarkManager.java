package bg.managers;

import app.entities.*;
import bg.constants.BookGenre;
import bg.constants.MovieGenre;
import bg.dao.BookMarkDao;

import java.util.List;

public class BookmarkManager {
    
    private static BookmarkManager instance = new BookmarkManager();
    private static BookMarkDao bookMarkDao = new BookMarkDao ();

    
    private BookmarkManager() {
    }

   
    public static BookmarkManager getInstance() {
        return instance;
    }

    
    public Book createBook(long id, String title, int publicationYear,
                           String publisher, String[] authors, BookGenre genre,
                           double amazonRating) {
        Book book = new Book();
        book.setId(id);
        book.setTitle(title);
        book.setPublicationYear(publicationYear);
        book.setPublisher(publisher);
        book.setAuthors(authors);
        book.setGenre(genre);
        book.setAmazonRating(amazonRating);
        return book;
    }


    public Movie createMovie( long id, String title, int releaseYear,
                              String[] cast, String[] directors, MovieGenre genre,
                              double imdbRating) {
        Movie movie = new Movie();
      
        movie.setReleaseYear(releaseYear);
        movie.setCast(cast);
        movie.setDirectors(directors);
        movie.setGenre(genre);
        movie.setImdbRating(imdbRating);
        movie.setId(id);
        movie.setTitle(title);
        return movie;
        
    }

    
    public WebLink createWebLink( long id, String title, String url, String host) {
        WebLink webLink = new WebLink();
        webLink.setId(id);
        webLink.setTitle(title);
        webLink.setUrl(url);
        webLink.setHost(host);
        return webLink;
    }



    public List<List<BookMark>> getBookMarks(){
        return bookMarkDao.getBookMarks ();
    }
    
    
    
    
    public void saveUserBookmark ( User user , BookMark bookMark) {
        
        UserBookmark userBookmark = new UserBookmark ();
        userBookmark.setUser (user);
        userBookmark.setBookmark (bookMark);
     /*
        if (bookMark instanceof WebLink) {
            try {
                String url = (  (WebLink) bookMark).getUrl();
                if (!url.endsWith(".pdf")) {
                    String webpage = HttpConnect.download(((WebLink)bookMark).getUrl());
                    if (webpage != null) {
                        IOUtil.write(webpage, bookMark.getId());
                    }
                }
            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (URISyntaxException e) {
                // TODO Auto-generated catch block
                e.printStackTrace ();
            }
        }*/
    
 
        bookMarkDao.saveUserBookMark(userBookmark);
 
 
 
 
 
 
 
 
 
 
    }
    
    
    
    
    
    
    
    
    

    
    public void setKidFriendlyStatus ( User user , String kidFriendlyStatus , BookMark bookMark ) {
    
        bookMark.setKidFriendlyStatus (kidFriendlyStatus);
        bookMark.setKidFriendlyMarkedBy ( user );
        System.out.println ("Kid-friendly status: "+ kidFriendlyStatus + ", "+ "Marked by: " +
             user.getEmail () + ", "+bookMark);
    
    
    
    
    
    
    
    }
    
    public void share ( User user , BookMark bookMark ) {
        bookMark.setSharedBy ( user );
        System.out.println ("Data to be shared: ");
        if(bookMark instanceof Book){
            System.out.println ( ((Book) bookMark).getITemData ());
        }
        else if ( bookMark instanceof WebLink ) {
            System.out.println (((WebLink) bookMark). getITemData ());
        
        }
    
    
    }
}