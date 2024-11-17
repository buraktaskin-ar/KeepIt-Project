package app.entities;

import bg.constants.MovieGenre;

import java.util.Arrays;

public class Movie extends BookMark {

	private int releaseYear;
	private String[] cast;
	private String[] directors;
	private MovieGenre genre;
	private double imdbRating;

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String[] getCast() {
		return cast;
	}

	public void setCast(String[] cast) {
		this.cast = cast;
	}

	public String[] getDirectors() {
		return directors;
	}

	public void setDirectors(String[] directors) {
		this.directors = directors;
	}

	public MovieGenre getGenre() {
		return genre;
	}

	public void setGenre(MovieGenre genre) {
		this.genre = genre;
	}

	public double getImdbRating() {
		return imdbRating;
	}

	public void setImdbRating(double imdbRating) {
		this.imdbRating = imdbRating;
	}

	public Movie() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean iskidFriendlyEligible () {
		if(genre.equals (MovieGenre.THRILLERS   )  ||  genre .equals ( MovieGenre.HORROR )  ){
			return false;
		}
		
		return true;
	}
	
	@Override
	public String toString () {
		return "Movie{" +
			"releaseYear=" + releaseYear +
			", cast=" + Arrays.toString (cast) +
			", directors=" + Arrays.toString (directors) +
			", genre='" + genre + '\'' +
			", imdbRating=" + imdbRating +
			'}';
	}
}
