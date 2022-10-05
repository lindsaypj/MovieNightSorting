package comparators;

import data.Movie;

import java.util.Comparator;

/**
 * Comparator used to sort movies based on the year they were released.
 * @author Patrick Lindsay
 * @version 1.0
 */
public class YearComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie movie1, Movie movie2) {
        return movie1.getYear() - movie2.getYear();
    }
}
