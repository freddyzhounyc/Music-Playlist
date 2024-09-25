/**
 * The SongLinkedList Class is the ADT of a doubly linked list that acts as a playlist for Songs.
 *
 * @author Freddy Zhou
 *      Email: freddy.zhou@stonybrook.edu
 *      Stony Brook ID: 116580337
 *      HW #2 - Playlist
 *      CSE 214
 *      Recitation Number: R04 | TA Names: Veronica Oreshko, Anuj Sureshbhai, Alex Zuzow
 */
// imports for javax to be able to play the wav files.
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SongLinkedList{
    private SongNode head; // reference to the head of the doubly linked list.
    private SongNode tail; // reference to the tail of the doubly linked list.
    private SongNode cursor; // reference to the current node the cursor is on in the doubly linked list.
    private int size; // total number of songs in the playlist.

    // Constructor

    /**
     * Creates an instance of the SongLinkedList class with no parameters by setting the references to null and size to 0.
     */
    public SongLinkedList(){
        head = null;
        tail = null;
        cursor = null;
        size = 0;
    }

    // Setters

    /**
     * Sets the head of the doubly linked list.
     * @param head
     *  The head of the list.
     * @custom.precondition
     *  Head is a SongNode.
     * @custom.postcondition
     *  The instance variable head will be properly updated.
     */
    public void setHead(SongNode head){
        this.head = head;
    }

    /**
     * Sets the tail of the list.
     * @param tail
     *  The tail of the list.
     * @custom.precondition
     *  Tail is a SongNode.
     * @custom.postcondition
     *  The instance variable tail will be properly updated.
     */
    public void setTail(SongNode tail){
        this.tail = tail;
    }

    /**
     * Sets the cursor of the list.
     * @param cursor
     *  The cursor that points to the current Node in the list.
     * @custom.precondition
     *  Cursor is a SongNode.
     * @custom.postcondition
     *  The instance variable cursor will be properly updated.
     */
    public void setCursor(SongNode cursor){
        this.cursor = cursor;
    }

    /**
     * Sets the size of the list.
     * @param size
     *  The size of the list in the number of songs.
     * @custom.precondition
     *  Size is an integer.
     * @custom.postcondition
     *  The instance variable size will be properly updated.
     */
    public void setSize(int size){
        this.size = size;
    }

    // Getters

    /**
     * Gets the head of the list.
     * @return
     *  Returns the head of the list.
     * @custom.precondition
     *  Head is a SongNode.
     * @custom.postcondition
     *  The head of the list is returned.
     */
    public SongNode getHead(){
        return head;
    }

    /**
     * Gets the tail of the list.
     * @return
     *  Returns the tail of the list.
     * @custom.precondition
     *  Tail is a SongNode.
     * @custom.postcondition
     *  The tail of the list is returned.
     */
    public SongNode getTail(){
        return tail;
    }

    /**
     * Gets the cursor of the list.
     * @return
     *  Returns the cursor of the list.
     * @custom.precondition
     *  Cursor is a SongNode.
     * @custom.postcondition
     *  The cursor of the list is returned.
     */
    public SongNode getCursor(){
        return cursor;
    }

    /**
     * Gets the size of the list.
     * @return
     *  Returns the size of the list.
     * @custom.precondition
     *  Size is an integer.
     * @custom.postcondition
     *  The size of the list is returned.
     */
    public int getSize(){
        return size;
    }

    /**
     * Plays the song that is in the parameters.
     * @param name
     *  The song that is to be played.
     * @throws IllegalArgumentException
     *  Indicates that the song was not found.
     * @custom.precondition
     *  Name should be a String.
     *  Name must match an actual song in the files.
     * @custom.postcondition
     *  The song specified in the parameter will be played.
     */
    public void play(String name) throws IllegalArgumentException{
        try{
            AudioInputStream AIS = AudioSystem.getAudioInputStream(new File(name + ".wav"));

            Clip c = AudioSystem.getClip();
            c.open(AIS);
            c.start();
        } catch (IllegalArgumentException | UnsupportedAudioFileException | IOException | LineUnavailableException ignored){}
    }

    /**
     * Moves the cursor forwards.
     * @custom.precondition
     *  List is not empty.
     * @custom.postcondition
     *  Cursor has been moved forwards.
     */
    public void cursorForwards(){
        if (cursor != null && cursor.getNext() != null)
            cursor = cursor.getNext();
    }

    /**
     * Moves the cursor backwards.
     * @custom.precondition
     *  List is not empty
     * @custom.postcondition
     *  Cursor has been moved backwards.
     */
    public void cursorBackwards(){
        if (cursor != null && cursor.getPrev() != null)
            cursor = cursor.getPrev();
    }

    /**
     * The newSong will be inserted after the cursor.
     * @param newSong
     *  The new song that will be inserted after the cursor.
     * @custom.precondition
     *  The newSong is instantiated.
     * @custom.postcondition
     *  The newSong has been inserted after the cursor.
     */
    public void insertAfterCursor(Song newSong){
        if (newSong == null)
            throw new IllegalArgumentException();
        if (cursor != tail) {
            SongNode newNode = new SongNode(cursor, cursor.getNext(), newSong);
            cursor.getNext().setPrev(newNode);
            cursor.setNext(newNode);
            size++;
            cursorForwards();
        } else{
            SongNode newNode = new SongNode(newSong, cursor);
            cursor.setNext(newNode);
            tail = newNode;
            size++;
            cursorForwards();
        }
    }

    /**
     * The SongNode at the cursor will be removed and the cursor will be relocated depending on where it is in the list.
     * @return
     *  Returns the Song of the SongNode that has been removed from the list.
     * @custom.precondition
     *  Cursor is not null.
     * @custom.postcondition
     *  The SongNode at the cursor will be removed and the cursor will be properly relocated.
     */
    public Song removeCursor(){
        Song result;
        if (cursor != null) {
            if (cursor == head) {
                result = head.getData();
                if (head.getNext() != null) {
                    cursor = head.getNext();
                    cursor.setPrev(null);
                    head = cursor;
                } else{
                    cursor = null;
                }
                size--;
            } else if (cursor == tail) {
                result = tail.getData();
                if (cursor.getPrev() != null) {
                    cursor = cursor.getPrev();
                    cursor.setNext(null);
                    tail = cursor;
                } else{
                    cursor = null;
                }
                size--;
            } else {
                result = cursor.getData();
                cursor = cursor.getNext();
                cursor.getPrev().getPrev().setNext(cursor);
                cursor.setPrev(cursor.getPrev().getPrev());
                size--;
            }
        } else {
            throw new IllegalArgumentException();
        }

        return result;
    }

    // same as removeCursor, but returns the SongNode rather than the Song
    /**
     * The SongNode at the cursor will be removed and the cursor will be relocated depending on where it is in the list.
     * @return
     *  Returns the SongNode that has been removed from the list.
     * @custom.precondition
     *  Cursor is not null.
     * @custom.postcondition
     *  The SongNode at the cursor will be removed and the cursor will be properly relocated.
     */
    public SongNode removeCursorNode(){
        SongNode result;

        if (cursor != null) {
            if (cursor == head) {
                result = head;
                if (head.getNext() != null) {
                    cursor = head.getNext();
                    cursor.setPrev(null);
                    head = cursor;
                } else{
                    cursor = null;
                }
                size--;
            } else if (cursor == tail) {
                result = tail;
                if (cursor.getPrev() != null) {
                    cursor = cursor.getPrev();
                    cursor.setNext(null);
                    tail = cursor;
                } else{
                    cursor = null;
                }
                size--;
            } else {
                result = cursor;
                cursor = cursor.getNext();
                cursor.getPrev().getPrev().setNext(cursor);
                cursor.setPrev(cursor.getPrev().getPrev());
                size--;
            }
        } else{
            throw new IllegalArgumentException();
        }

        return result;
    }

    /**
     * Gets a random song in the list and plays the song.
     * @return
     *  Returns the Song that has been chosen randomly.
     * @custom.postcondition
     *  The random song plays and the Song is returned.
     */
    public Song random(){
        // (H - L + 1 ) + L for a rand int from L to H
        int randInt = (int)(Math.random() * size);
        SongNode initialCursor = cursor;


        cursor = head;
        for (int i = 0; i < randInt-1; i++){
            cursorForwards();
        }
        Song selectedSong = cursor.getData();


        play(selectedSong.getName());
        cursor = initialCursor;
        return selectedSong;
    }

    /**
     * Shuffles the list.
     * @custom.postcondition
     *  The list is randomly shuffled and the cursor will reference the same song as before the shuffle.
     */
    public void shuffle(){
        int initialSize = size;
        int tempSize = size;

        if (initialSize > 1) {
            SongNode initialCursor = cursor;
            SongNode shuffledHead = new SongNode();
            SongNode shuffledTail = new SongNode();
            int counter = 0;

            while (initialSize > 0){
                cursor = head;
                int randInt = (int)(Math.random() * initialSize);
                for (int i = 0; i < randInt; i++){
                    cursorForwards();
                }

                SongNode removedNode = removeCursorNode();

                if (counter == 0){
                    shuffledHead = removedNode;
                    shuffledTail = removedNode;
                } else{
                    shuffledTail.setNext(removedNode);
                    removedNode.setPrev(shuffledTail);
                    shuffledTail = removedNode;
                }

                counter++;
                initialSize--;
            }

            head = shuffledHead;
            tail = shuffledTail;

            // setting the new cursor of the shuffled list
            cursor = head;
            while (!cursor.getData().equals(initialCursor.getData())){
                cursorForwards();
            }

            size = tempSize;
        }
    }

    /**
     * Prints out the current playlist in a tabular format.
     */
    public void printPlaylist(){
        System.out.printf("%-25s%-27s%-27s%-11s", "Song", "| Artist", "| Album ", "| Length (s)");
        System.out.println();
        for (int i = 0; i < 91; i++){
            System.out.print("-");
        }
        System.out.println();


        SongNode initialCursor = cursor;
        if (size > 0){
            cursor = head;
            for (int i = 0; i < size; i++) {
                if (cursor.equals(initialCursor)){
                    System.out.printf("%-26s%-27s%-30s%-5s", cursor.getData().getName(), cursor.getData().getArtist(), cursor.getData().getAlbum(), cursor.getData().getLength());
                    System.out.print("<-");
                } else{
                    System.out.printf("%-26s%-27s%-30s%-5s", cursor.getData().getName(), cursor.getData().getArtist(), cursor.getData().getAlbum(), cursor.getData().getLength());
                }
                System.out.println();
                if (cursor.getNext() != null) {
                    cursorForwards();
                }
            }
        }
        cursor = initialCursor;
    }

    /**
     * Deletes all of the songs in the playlist.
     * @custom.postcondition
     *  All SongNodes in the list have been removed.
     */
    public void deleteAll(){
        head = null;
        tail = null;
        cursor = null;
        size = 0;
    }

    /**
     * The string version of all the variables will be returned.
     * @return
     *  Returns the string version of all the instance variables.
     */
    public String toString(){
        String result = "";
        SongNode initialCursor = new SongNode(cursor.getPrev(), cursor.getNext(), cursor.getData());


        cursor = head;
        int counter = 1;
        for (int i = 0; i < size; i++){
            result += counter + ". " + cursor.getData().getName() + "\n";
            if (cursor.getNext() != null)
                cursorForwards();
            counter++;
        }
        cursor = initialCursor;
        return result;
    }
    // Used as test.
    public static void main(String[] args){
        SongLinkedList test = new SongLinkedList();
        test.printPlaylist();
    }
}
