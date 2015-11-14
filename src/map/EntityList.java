/**
 * EntityList.java
 * 
 * Christopher Hittner (c) 2015
 */
package map;

import entities.Entity;
import java.util.Arrays;

/**
 * EntityList stores a collection of Entities.
 *
 * @author Christopher
 */
public class EntityList {
    
    private Entity[] entities;
    
    public EntityList(Entity... entities) {
        this.entities = entities;
    }
    
    /**
     * Adds an Entity to this list.
     * @param e The Entity to add.
     * @param index The index to insert at.
     */
    public void add(Entity e, int index) {
        //Increases the length by one.
        entities = Arrays.copyOf(entities, entities.length+1);
        
        //Shifts Entities to the right by one.
        for(int i = size()-1; i > index; i--)
            entities[i] = entities[i-1];
        
        //Adds the Entity.
        entities[index] = e;
    }
    
    /**
     * Appends an Entity to the end of the list.
     * @param e The Entity to add.
     */
    public void add(Entity e) {
        add(e, size());
    }
    
    
    /**
     * Gets the Entity at a particular index.
     * @param index The index to check.
     * @return The Entity at the index.
     */
    public Entity get(int index) {
        return entities[index];
    }
    
    /**
     * Removes an Entity from the list.
     * @param e The Entity to remove.
     * @return The Entity to remove.
     */
    public Entity remove(Entity e) {
        
        int index = indexOf(e);
        
        if(index >= 0)
            return remove(index);
        return null;
    }
    
    
    /**
     * Removes an Entity from the list and gives it back.
     * @param index The index to target.
     * @return The removed Entity.
     */
    public Entity remove(int index) {
        //Makes a reference to the removed Entity.
        Entity removed = entities[index];
        
        //Shifts all of the Entities to the left by one.
        for(int i = index; i < size()-2; i++)
            entities[i] = entities[i+1];
        
        //Reduces the size by one.
        entities = Arrays.copyOf(entities, size()-1);
        
        return removed;
        
    }
    
    /**
     * Gets the index that contains the provided Entity.
     * @param e The Entity to search for.
     * @return The index of the Entity, or -1 if nothing is found.
     */
    public int indexOf(Entity e) {
        for(int i = 0; i < size(); i++)
            if(get(i).equals(e))
                return i;
        return -1;
    }
    
    
    /**
     * Gets the size of the list.
     * @return The number of Entities.
     */
    public int size() {
        return entities.length;
    }
    
}
