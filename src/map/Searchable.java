/**
 * Searchable.java
 * 
 * Christopher Hittner (c) 2015
 */
package map;

/**
 * Allows for an Object to be searched.
 * 
 * @author Christopher Hittner
 */
public interface Searchable {
    
    /**
     * Searches an OBject with a certain amount of thoroughness.
     * @param throughness The amount of effort to put into the search.
     */
    public void search(int throughness);
    
    
}
