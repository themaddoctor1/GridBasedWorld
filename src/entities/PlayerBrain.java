/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import io.IOManager;
import java.util.HashMap;
import map.EntityList;
import map.MapLocation;
import map.MapManager;

/**
 *
 * @author Christopher
 */
public class PlayerBrain extends CreatureBrain {

    @Override
    public void act(HashMap<String, Object> params) {
        //Gets the full command
        String command = (String) params.get("cmd");
        
        String function = command.substring(0, command.indexOf("["));
        
        //Checks for the prefix, which will indicate the command type.
        if(command != null) {
            String[] parameters = IOManager.parseCommandParameters(command);
            switch(function) {
                case "ATTACK":
                    //Pulls the target's ID out of the String.
                    long targetID = Long.parseLong(parameters[0]);
                    //Attacks
                    attack((Creature) MapManager.getEntitiyList().get(targetID));
                    break;
                case "MOVE":
                    //Gets each of the three coords.
                    int movX = Integer.parseInt(parameters[0]);
                    int movY = Integer.parseInt(parameters[1]);
                    int movZ = Integer.parseInt(parameters[2]);
                    //Moves if possible.
                    if(canEscape())
                        move((int) Math.signum(movX), (int) Math.signum(movY), (int) Math.signum(movZ));
                    break;
                case "EQUIP":
                    int equipSlot = Integer.parseInt(parameters[0]);
                    getCreature().inventory.equipItem(equipSlot);
                    break;
                case "DROP":
                    //Drops an Item from the Player's inventory. Or, it will take whatever the player is holding if nothing is held.

                    //Gets the index of the Item.
                    int dropSlot;
                    try {
                        //If a number is given, it is assigned.
                        dropSlot = Integer.parseInt(parameters[0]);
                    } catch(Exception e) {
                        //If no number is given, set it to -1 so that the program parses it as a hand item drop.
                        dropSlot = -1;
                    }
                    
                    //If the item is in the inventory, drop the inventory item.
                    if(dropSlot >= 0)
                        getCreature().inventory.getInventory().remove(dropSlot);
                    else
                        //Otherwise, drop what's in the hand.
                        getCreature().inventory.takeHeldItem();
                    break;
                case "SEARCH":
                    throw new UnsupportedOperationException("Search action for PlayerBrain is planned, but not yet implemented.");
                default:
                    throw new IllegalArgumentException("Function '" + function + "' has not been written yet.");
            }
        }
        
    }
    
    @Override
    protected void attack(Creature target) {
        throw new UnsupportedOperationException("entities.PlayerBrain.attack() has not been written."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method tests to make sure that an escape can be made. Random number generation
     * is made each time this method is called.
     * @return Whether or not escape is permitted.
     */
    private boolean canEscape() {
        //By ensuring that the largest possible value is exactly 1.0, if escapeOdds()
        //returns 0.0, 1 - Math.random() will never be less than or equal to it, since
        //Math.random() is always <= 1, meaning than 1 minus it can't equal zero.
        return 1 - Math.random() <= escapeOdds();
    }
    
    /**
     * Calculates how easily the Player will be able to leave the cell.
     * @return The odds of being able to escape. 1.0 is 100% certain, 0.0 is 0% (impossible).
     */
    private double escapeOdds() {
        
        double odds = 1.0;
        
        EntityList entities = MapManager.getEntitiyList();
        for(int i = 0; i < entities.size(); i++) {
            //Grabs the Entity
            Entity e = entities.get(i);
            
            //If it is a zombie, multiply the odds by a certain amount.
            if(e instanceof ZombieHorde) {
                ZombieHorde horde = (ZombieHorde) e;
                
                odds *= Math.min(1,
                            Math.max(((ZombieBrain) horde.getBrain()).timeToTarget() / 25, 0)
                            / Math.cbrt(1 + Math.pow(horde.getSize(), 2))
                        );
                
            }
            
        }
        
        //I will tell you the odds. Suck it, Han.
        return odds;
    }
    
}
