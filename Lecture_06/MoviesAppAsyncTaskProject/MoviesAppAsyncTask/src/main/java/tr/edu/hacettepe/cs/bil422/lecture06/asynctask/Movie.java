package tr.edu.hacettepe.cs.bil422.lecture06.asynctask;

/**
 * User: accavdar
 * Date: 27/11/13
 */

public class Movie {

    private String name;

    private int year;

    private String thumbnail;

    private boolean isWatched;

    public Movie(String name, int year, String thumbnail) {
        this.name = name;
        this.year = year;
        this.thumbnail = thumbnail;
        this.isWatched = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isWatched() {
        return isWatched;
    }

    public void setWatched(boolean isWatched) {
        this.isWatched = isWatched;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
