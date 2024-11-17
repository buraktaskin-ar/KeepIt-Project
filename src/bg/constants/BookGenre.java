package bg.constants;

/**
 * BookGenre enum represents the various genres of books available.
 */
public enum BookGenre {
    ART ( "Art" ),
    BIOGRAPHY ( "Biography" ),
    CHILDREN ( "Children" ),
    FICTION ( "Fiction" ),
    HISTORY ( "History" ),
    MYSTERY ( "Mystery" ),
    PHILOSOPHY ( "Philosophy" ),
    RELIGION ( "Religion" ),
    ROMANCE ( "Romance" ),
    SELF_HELP ( "Self Help" ),
    TECHNICAL ( "Technical" );
    
    private String name;
    

    private BookGenre ( String name ) {
        this.name = name;
    }

    public String getDisplayName () {
        return name;
    }
    
}
