package data;

/**
 * This Movie Object class stores info pertaining to an individual movie.
 * @author Patrick Lindsay
 * @version 1.0
 */
public class Movie {

    // Fields
    private String title;
    private String genre;
    private String studio;
    private int audienceScore;
    private double profitability;
    private int rtScore;
    private double worldGross;
    private int year;

    /**
     * Constructor for a movie object. Stores given movie data.
     * @param title of the movie
     * @param genre of Movie
     * @param studio where the movie was produced
     * @param audienceScore of the movie
     * @param profit how profitable the movie was
     * @param rtScore Movie's score on Rotten Tomatoes
     * @param worldGross Worldwide gross profit
     * @param year movie was released
     */
    public Movie(String title, String genre, String studio, int audienceScore, double profit, int rtScore,
                 double worldGross, int year) {
        this.title = title;
        this.genre = genre;
        this.studio = studio;
        this.audienceScore = audienceScore;
        this.profitability = profit;
        this.rtScore = rtScore;
        this.worldGross = worldGross;
        this.year = year;
    }

    ////   GETTER METHODS   ////

    /**
     * Title getter method
     * @return title of the movie
     */
    public String getTitle() {
        return title;
    }

    /**
     * Genre getter method
     * @return genre of movie
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Studio getter method
     * @return The primary studio where the movie was produced
     */
    public String getStudio() {
        return studio;
    }

    /**
     * Audience Score getter method
     * @return Audience Score of the movie (percentage)
     */
    public int getAudienceScore() {
        return audienceScore;
    }

    /**
     * Profitability getter method
     * @return profitability rating of the movie
     */
    public double getProfitability() {
        return profitability;
    }

    /**
     * Rotten Tomatoes getter method
     * @return Rotten Tomatoes Score of the movie (percentage)
     */
    public int getRTScore() {
        return rtScore;
    }

    /**
     * Worldwide Gross profit getter method
     * @return worldwide gross profit of the movie
     */
    public double getWorldGross() {
        return worldGross;
    }

    /**
     * Release year getter method
     * @return release year of the movie
     */
    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", studio='" + studio + '\'' +
                ", audienceScore=" + audienceScore +
                ", profitability=" + profitability +
                ", rtScore=" + rtScore +
                ", worldGross=" + worldGross +
                ", year=" + year +
                '}';
    }
}
