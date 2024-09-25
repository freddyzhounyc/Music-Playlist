/**
 * The Player Class contains the actual system that implements Song, SongNode, and SongLinkedList to prompt the user with a menu and takes in inputs to perform those inputs.
 *
 * @author Freddy Zhou
 */
import java.util.Scanner;

public class Player {
    /**
     * Runs the actual system of the playlist and allows for all of the playlist options to be implemented.
     * @param args - Not used.
     */
    public static void main(String[] args){
        Scanner cin = new Scanner(System.in); // creates instance of Scanner class.

        SongLinkedList playlist = new SongLinkedList();
        boolean quit = false;
        String menuInput = "";

        while (!quit){
            // Prints out the menu options.
            System.out.println("(A) Add Song to Playlist\n(F) Go to Next Song\n(B) Go to Previous Song\n(R) Remove Song from Playlist\n" +
                    "(L) Play a Song\n(C) Clear the Playlist\n(S) Shuffle Playlist\n(Z) Random Song\n(P) Print Playlist\n" +
                    "(T) Get the total amount of songs in the playlist\n(Q) Exit the playlist");
            System.out.print("\nEnter an option: ");
            menuInput = cin.nextLine();
            menuInput = menuInput.toLowerCase();

            // Menu option to add a song to the playlist.
            if (menuInput.equals("a")){
                String songTitle = "", artists = "", album = "";
                int length = 0;

                System.out.print("Enter song title: ");
                songTitle = cin.nextLine();
                System.out.print("Enter artist(s) of the song: ");
                artists = cin.nextLine();
                System.out.print("Enter album: ");
                album = cin.nextLine();
                System.out.print("Enter length (in seconds): ");
                length = cin.nextInt();
                cin.nextLine(); // Eats the next line.
                System.out.println();

                Song songAdd = new Song(songTitle, artists, album, length);
                if (playlist.getSize() == 0){
                    SongNode nodeSongAdd = new SongNode(null, null, songAdd);
                    playlist.setHead(nodeSongAdd);
                    playlist.setCursor(nodeSongAdd);
                    playlist.setTail(nodeSongAdd);
                    playlist.setSize(1);
                } else{
                    playlist.insertAfterCursor(songAdd);
                }

                System.out.println("'" + songTitle + "' by " + artists + " is added to your playlist.\n");
            }

            // Menu option to go to the next song in the playlist.
            if (menuInput.equals("f")){
                if (playlist.getCursor().getNext() != null) {
                    playlist.cursorForwards();
                    System.out.println("Cursor moved to the next song.\n");
                } else{
                    System.out.println("Already at the end of the playlist\n");
                }
            }

            // Menu option to go to the previous song in the playlist.
            if (menuInput.equals("b")){
                if (playlist.getCursor().getPrev() == null){
                    System.out.println("Already at the beginning of the playlist.\n");
                } else{
                    playlist.cursorBackwards();
                    System.out.println("Cursor moved to the previous song.\n");
                }
            }

            // Menu option to remove a certain song from the playlist.
            if (menuInput.equals("r")){
                if (playlist.getSize() > 0) {
                    String song = playlist.getCursor().getData().getName();
                    String artists = playlist.getCursor().getData().getArtist();

                    playlist.removeCursor();
                    System.out.println("'" + song + "'" + " by " + artists + " was removed from the playlist.\n");
                } else{
                    System.out.println("Your playlist is empty\n");
                }
            }

            // Menu option to play a song in the playlist.
            if (menuInput.equals("l")){
                SongNode initialCursor = playlist.getCursor();
                boolean found = false;
                System.out.println("Enter name of song to play: ");
                String song = cin.nextLine();

                playlist.setCursor(playlist.getHead()); // cursor = head
                for (int i = 0; i < playlist.getSize(); i++){
                    if (playlist.getCursor().getData().getName().equals(song))
                        found = true;
                    playlist.cursorForwards();
                }
                if (found) {
                    playlist.play(song);
                    System.out.println("'" + song + "'" + " by " + playlist.getCursor().getData().getArtist() + " is now playing.\n");
                } else{
                    System.out.println("'" + song + "' not found.\n");
                }
                playlist.setCursor(initialCursor);
            }

            // Menu option that clears the playlist.
            if (menuInput.equals("c")){
                playlist.deleteAll();
                System.out.println("Playlist cleared\n");
            }

            // Menu option that shuffles the playlist.
            if (menuInput.equals("s")){
                if (playlist.getSize() > 0) {
                    playlist.shuffle();
                    System.out.println("Playlist shuffled\n");
                } else{
                    System.out.println("Your playlist is empty\n");
                }
            }

            // Menu option that plays a random song in the playlist.
            if (menuInput.equals("z")){
                if (playlist.getSize() > 0) {
                    System.out.println("Playing a random song...");
                    Song randSong = playlist.random();
                    System.out.println("'" + randSong.getName() + "'" + " by " + randSong.getArtist() + " is now playing.\n");
                } else{
                    System.out.println("Your playlist is empty\n");
                }
            }

            // Menu option that prints the playlist in a table format.
            if (menuInput.equals("p")){
                playlist.printPlaylist();
                System.out.println();
            }

            // Menu option that prints the size of the playlist in the amount of songs.
            if (menuInput.equals("t")){
                if (playlist.getSize() > 0)
                    System.out.println("Your playlist contains " + playlist.getSize() + " songs.\n");
                else
                    System.out.println("Your playlist is empty\n");
            }

            // Menu option that quits the program.
            if (menuInput.equals("q")){
                quit = true;
            }
        }
    }
}
