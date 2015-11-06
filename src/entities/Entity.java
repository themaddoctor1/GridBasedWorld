/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import map.Cell;

/**
 *
 * @author Christopher
 */
public abstract class Entity {
    private Cell location = null;
    
    /**
     * Creates an Entity that has a position.
     * @param loc The initial location of the Entity.
     */
    public Entity(Cell loc) {
        location = loc;
    }
    
}
