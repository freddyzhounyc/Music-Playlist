/**
 * The SongNode Class represents nodes that are going to be a part of the linked list. Each node will include pointers to the previous node,
 * next node, and its data as it is a doubly linked list.
 *
 * @author Freddy Zhou
 *      Email: freddy.zhou@stonybrook.edu
 *      Stony Brook ID: 116580337
 *      HW #2 - Playlist
 *      CSE 214
 *      Recitation Number: R04 | TA Names: Veronica Oreshko, Anuj Sureshbhai, Alex Zuzow
 */

public class SongNode{
    private SongNode prev; // the previous SongNode with respect to the current SongNode.
    private SongNode next; // the next SongNode with respect to the current SngNode.
    private Song data; // the data that is a part of the current SongNode.

    // Constructors

    /**
     * Creates an instance of the SongNode class with no parameters.
     */
    public SongNode(){
    }

    /**
     * Creates an instance of the SongNode class with only one parameter: data.
     * @param data
     *  The data a part of the current SongNode.
     * @custom.precondition
     *  Data should be a Song.
     * @custom.postcondition
     *  Instance of SongNode will have been created with the instance variable data updated.
     */
    public SongNode(Song data){
        this.data = data;
    }

    /**
     * Creates an instance of the SongNode class with two parameters: data and prev.
     * @param data
     *  The data a part of the current SongNode.
     * @param prev
     *  The previous SongNode with respect to the current SongNode.
     * @custom.precondition
     *  Data is a song.
     *  Prev is a SongNode.
     * @custom.postcondition
     *  Instance of SongNode will have been created with the instance variables data and prev updated.
     */
    public SongNode(Song data, SongNode prev){
        this.data = data;
        this.prev = prev;
    }

    /**
     * Creates an instance of the SongNode class with two parameters: next and data.
     * @param next
     *  The next SongNode with respect to the current SongNode.
     * @param data
     *  The data a part of the current SongNode.
     * @custom.precondition
     *  Next is a SongNode.
     *  Data is a song.
     * @custom.postcondition
     *  Instance of SongNode will have been created with the instance variables next and data updated.
     */
    public SongNode(SongNode next, Song data){
        this.next = next;
        this.data = data;
    }

    /**
     * Creates an instance of the SongNode class with three parameters: prev, next, and data.
     * @param prev
     *  The previous SongNode with respect to the current SongNode.
     * @param next
     *  The next SongNode with respect to the current SongNode.
     * @param data
     *  The data a part of the current SongNode.
     * @custom.precondition
     *  Prev is a SongNode.
     *  Next is a SongNode.
     *  Data is a song.
     * @custom.postcondition
     *  Instance of SongNode will have been created with the instance variables prev, next, and data updated.
     */
    public SongNode(SongNode prev, SongNode next, Song data){
        this.prev = prev;
        this.next = next;
        this.data = data;
    }

    // Setters

    /**
     * Sets the previous SongNode with respect to the current SongNode.
     * @param prev
     *  The previous SongNode with respect to the current SongNode.
     * @custom.precondition
     *  Prev is a SongNode.
     * @custom.postcondition
     *  The instance variable prev will be updated to the parameter prev.
     */
    public void setPrev(SongNode prev){
        this.prev = prev;
    }

    /**
     * Sets the next SongNode with respect to the current SongNode.
     * @param next
     *  The next SongNode with respect to the current SongNode.
     * @custom.precondition
     *  Next is a SongNode.
     * @custom.postcondition
     *  The instance variable next will be updated to the parameter next.
     */
    public void setNext(SongNode next){
        this.next = next;
    }

    /**
     * Sets the data of the current SongNode.
     * @param data
     *  The song that is a part of the current SongNode.
     * @custom.precondition
     *  Data is a song.
     * @custom.postcondition
     *  The instance variable data will be updated to the parameter data.
     */
    public void setData(Song data){
        this.data = data;
    }

    // Getters

    /**
     * Gets the previous SongNode with respect to the current SongNode.
     * @return
     *  Returns the previous SongNode with respect to the current SongNode.
     * @custom.precondition
     *  Prev is a SongNode.
     * @custom.postcondition
     *  The prev instance variable will be returned.
     */
    public SongNode getPrev(){
        return prev;
    }

    /**
     * Gets the next SongNode with respect to the current SongNode.
     * @return
     *  Returns the next SongNode with respect to the current SongNode.
     * @custom.precondition
     *  Next is a SongNode.
     * @custom.postcondition
     *  The next instance variable will be returned.
     */
    public SongNode getNext(){
        return next;
    }

    /**
     * Gets the data of the current SongNode.
     * @return
     *  Returns the data of the current SongNode.
     * @custom.precondition
     *  Data is a song.
     * @custom.postcondition
     *  The data instance variable will be returned.
     */
    public Song getData(){
        return data;
    }

    /**
     * Finds whether the Object obj is the same as the object SongNode.
     * @param obj
     *  The object that is being compared to.
     * @return
     *  Returns whether the two objects are the same.
     * @custom.precondition
     *  The obj Object will have the necessary SongNode instance variables filled.
     * @custom.postcondition
     *  The two objects remain unchanged.
     *  The result of whether the two objects are equal in content is returned.
     */
    public boolean equals(Object obj){
        if (obj instanceof SongNode){
            SongNode tester = (SongNode) obj;

            boolean dataEqual = data.equals(tester.getData());
            boolean prevEqual = false;
            if (prev != null && tester.prev != null){
                prevEqual = prev == tester.prev;
            } else if (prev == null && tester.prev == null) {
                prevEqual = true;
            } else{
                prevEqual = false;
            }
            boolean nextEqual = false;
            if (next != null && tester.next != null){
                nextEqual = next == tester.next;
            } else if (next == null && tester.next == null) {
                nextEqual = true;
            } else{
                nextEqual = false;
            }

            if (dataEqual && prevEqual && nextEqual)
                return true;
        }
        return false;
    }

    // Used to test.
    public static void main(String[] args) {
        Song testSong = new Song("Ransom", "Lil Tecca", "We Love You Tecca", 171);
        SongNode test1 = new SongNode(testSong);
        SongNode test2 = new SongNode(testSong);

        System.out.println(test1.equals(test2));
    }
}