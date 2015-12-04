/**
 * ZombieHorde.java
 * 
 * Christopher Hittner (c) 2015
 */
package entities;

import map.MapLocation;

/**
 * Simulates a Zombie Horde.
 * 
 * @author Christopher Hittner
 */
public class ZombieHorde extends Creature implements Combinable {
    private int size;

    public ZombieHorde(MapLocation loc, int amount) {
        super(loc);
        size = amount;
    }
    
    @Override
    public boolean addOther(Combinable other) {
        if(other instanceof ZombieHorde) {
            return addOther((ZombieHorde) other);
        }
        return false;
    }
    
    /**
     * Combines another ZombieHorde with this one.
     * @param other The other ZombieHorde.
     * @return Whether or not the contents were transferred.
     */
    public boolean addOther(ZombieHorde other) {
        if(this.getLocation().equals(other.getLocation())) {
            increaseSize(other.getSize());
            other.removeAll();
            return true;
        }
        return false;
    }
    
    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void increaseSize(int amt) {
        size += amt;
    }

    @Override
    public int decreaseSize(int amt) {
        size -= amt;
        //If the amount is negative, there's an overflow.
        int overflow = Math.max(0, -size);
        size -= overflow;
        return overflow;
    }
    
    @Override
    public void removeAll() {
        size = 0;
    }
    
    
    
}
