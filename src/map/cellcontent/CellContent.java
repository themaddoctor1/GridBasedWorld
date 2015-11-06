/**
 * CellContent.java
 * 
 * Christopher Hittner (c) 2015
 */
package map.cellcontent;

import map.Describable;

/**
 * Represents an Object that can be placed inside of a Cell.
 * 
 * @author Christopher Hittner
 */
public abstract class CellContent implements Describable {
    
    public final String NAME;
    
    /**
     * Creates an Object that can be put inside of a Cell.
     */
    public CellContent() {
        this("Unknown");
    }
    
    /**
     * Creates a named Object that can be put inside of a Cell
     * @param name The name of the CellContent.
     */
    public CellContent(String name) {
        NAME = name;
    }
    
}
