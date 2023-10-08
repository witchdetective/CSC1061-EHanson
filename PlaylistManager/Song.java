public class Song {
    // Private variables.
    private String artist;
    private String title;

    // Empty constructor.
    public Song() {

    }

    // Getters and setters.
    public String getArtist() {
        return this.artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // toString method for printing and files.
    @Override
    public String toString() {
        return getArtist() + " - " + getTitle();
    }

}