package comparators;

import data.Movie;

import java.util.Comparator;

/**
 * Comparator used to sort movies based on their profitability.
 * @author Patrick Lindsay
 * @version 1.0
 */
public class ProfitComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie movie1, Movie movie2) {
        double difference = movie1.getProfitability() - movie2.getProfitability();
        if (difference > 0) {
            return 1;
        }
        else if (difference < 0) {
            return -1;
        }
        return 0;
    }
}
