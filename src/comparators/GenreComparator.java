package comparators;

import data.Movie;

import java.util.Comparator;

/**
 * Comparator used to sort movies based on their Genres.
 * @author Patrick Lindsay
 * @version 1.0
 */
public class GenreComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie movie1, Movie movie2) {
        return movie1.getGenre().compareTo(movie2.getGenre());
    }
}
