/**
 * The Song class includes what is a part of each song that will be added. Each song includes the name of the song, artist, album, and length in seconds.
 *
 * @author Freddy Zhou
 *      Email: freddy.zhou@stonybrook.edu
 *      Stony Brook ID: 116580337
 *      HW #2 - Playlist
 *      CSE 214
 *      Recitation Number: R04 | TA Names: Veronica Oreshko, Anuj Sureshbhai, Alex Zuzow
 */
public class Song{
    private String name; // name of the song.
    private String artist; // name of the artist(s).
    private String album; // name of the album the song is in.
    private int length; // the length of the song in seconds.

    // Constructors

    /**
     * Creates an instance of the Song class with no parameters to fill in the instance variables.
     */
    public Song(){
    }

    /**
     * Creates an instance of the Song class with four parameters: name, artist, album, and length.
     * @param name
     *  The name of the song being created.
     * @param artist
     *  The name of the artist(s) in the song.
     * @param album
     *  The name of the album the song is a part of.
     * @param length
     *  The length of the song in seconds.
     *
     * @custom.precondition
     *  The name, artist, and album have to be of the String data type.
     *  The length must be an integer that is positive.
     * @custom.postcondition
     *  An object that is an instance of the Song class will have been created.
     */
    public Song(String name, String artist, String album, int length){
        this.name = name; // name of wav file
        this.artist = artist;
        this.album = album;
        this.length = length; // length of song in seconds.
    }

    // Setters

    /**
     * Sets the name instance variable to the parameter name.
     * @param name
     *  The name of the song you are setting the current song equal to.
     * @custom.precondition
     *  The name parameter has to be a String.
     * @custom.postcondition
     *  The name instance variable will be properly updated to the name parameter.
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Sets the artist of the Song.
     * @param artist
     *  The artist that created the song.
     * @custom.precondition
     *  The artist parameter must be a String.
     * @custom.postcondition
     *  The instance variable will be properly updated to the artist parameter.
     */
    public void setArtist(String artist){
        this.artist = artist;
    }

    /**
     * Sets the album of the song.
     * @param album
     *  The album that the song is a part of.
     * @custom.precondition
     *  The album parameter must be a String
     * @custom.postcondition
     *  The instance variable will be properly updated to the album parameter.
     */
    public void setAlbum(String album){
        this.album = album;
    }

    /**
     * Sets the length of the song in seconds.
     * @param length
     *  The length of the song in seconds.
     * @custom.precondition
     *  The length parameter must be an integer and positive.
     * @custom.postcondition
     *  The instance variable will be properly updated to the length parameter.
     */
    public void setLength(int length){
        this.length = length;
    }

    // Getters

    /**
     * Gets the name of the song.
     * @return
     *  Returns the current name instance variable for the song.
     * @custom.precondition
     *  Name is a String.
     * @custom.postcondition
     *  The current name instance variable will be returned.
     */
    public String getName(){
        return name;
    }

    /**
     * Gets the artist of the song.
     * @return
     *  Returns the current artist instance variable for the song.
     * @custom.precondition
     *  Artist is a String.
     * @custom.postcondition
     *  The current artist instance variable will be returned.
     */
    public String getArtist(){
        return artist;
    }

    /**
     * Gets the album of the song.
     * @return
     *  Returns the current album instance variable for the song.
     * @custom.precondition
     *  Album is a String.
     * @custom.postcondition
     *  The current album instance variable will be returned.
     */
    public String getAlbum(){
        return album;
    }

    /**
     * Gets the length of the song in seconds.
     * @return
     *  Returns the length of the song in seconds.
     * @custom.precondition
     *  Length is an integer that is positive.
     * @custom.postcondition
     *  The current length instance variable will be returned.
     */
    public int getLength(){
        return length;
    }

    /**
     * Finds whether two objects of the Song class are equal to one another.
     * @param obj
     *  The object that is being compared to the original Song object.
     * @return
     *  Returns whether two objects of the Song class are equal.
     * @custom.precondition
     *  The obj Object needs to have values that are in each instance variable of Song.
     * @custom.postcondition
     *  The two objects are unchanged and the result of whether the two objects are equal in content will be returned.
     */
    public boolean equals(Object obj){
        if (obj instanceof Song){
            Song tester = (Song) obj;
            if (name.equals(tester.getName()) && artist.equals(tester.getArtist()) && album.equals(tester.getAlbum()) && length == tester.getLength())
                return true;
        }
        return false;
    }
}
