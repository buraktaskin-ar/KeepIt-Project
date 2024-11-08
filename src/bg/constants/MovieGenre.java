package bg.constants;

/**
 * MovieGenre enum represents the various genres of movies available.
 */
public enum MovieGenre {
	CLASSICS("Classics"),
	DRAMA("Drama"),
	SCIFI_AND_FANTASY("Sci-Fi & Fantasy"),
	COMEDY("Comedy"),
	CHILDREN_AND_FAMILY("Children & Family"),
	ACTION_AND_ADVENTURE("Action & Adventure"),
	THRILLERS("Thrillers"),
	MUSIC_AND_MUSICALS("Music & Musicals"),
	TELEVISION("Television"),
	HORROR("Horror"),
	SPECIAL_INTEREST("Special Interest"),
	INDEPENDENT("Independent"),
	SPORTS_AND_FITNESS("Sports & Fitness"),
	ANIME_AND_ANIMATION("Anime & Animation"),
	GAY_AND_LESBIAN("Gay & Lesbian"),
	CLASSIC_MOVIE_MUSICALS("Classic Movie Musicals"),
	FAITH_AND_SPIRITUALITY("Faith & Spirituality"),
	FOREIGN_DRAMAS("Foreign Dramas"),
	FOREIGN_ACTION_AND_ADVENTURE("Foreign Action & Adventure"), // Düzeltildi: FOREGIN -> FOREIGN
	FOREIGN_THRILLERS("Foreign Thrillers"),                     // Düzeltildi: FOREGIN -> FOREIGN
	TV_SHOWS("TV Shows"),
	DRAMAS("Dramas"),
	ROMANTIC_MOVIES("Romantic Movies"),
	COMEDIES("Comedies"),
	DOCUMENTARIES("Documentaries"),
	FOREIGN_MOVIES("Foreign Movies");
	
	private final String displayName;
	
	/**
	 * Constructor to initialize the display name of the genre.
	 *
	 * @param displayName The display name of the genre.
	 */
	MovieGenre(String displayName) {
		this.displayName = displayName;
	}
	
	/**
	 * Gets the display name of the genre.
	 *
	 * @return The display name of the genre.
	 */
	public String getDisplayName() {
		return displayName;
	}
	
	/**
	 * Returns the MovieGenre enum corresponding to the given display name.
	 *
	 * @param displayName The display name of the genre.
	 * @return The corresponding MovieGenre enum, or null if not found.
	 */
	public static MovieGenre fromDisplayName(String displayName) {
		for (MovieGenre genre : MovieGenre.values()) {
			if (genre.getDisplayName().equalsIgnoreCase(displayName)) {
				return genre;
			}
		}
		return null;
	}
}
