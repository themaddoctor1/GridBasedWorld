/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.HashMap;
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
        
        //Checks for the prefix, which will indicate the command type.
        if(command != null) switch(command.substring(0, command.indexOf(" "))) {
            case "attack":
                //Pulls the target's ID out of the String.
                long targetID = Long.parseLong(command.substring(command.indexOf(" ") + 1));
                //Attacks
                attack((Creature) MapManager.getEntitiyList().get(targetID));
                break;
            case "move":
                //Gets the movement parameters
                String movement = command.substring(command.indexOf(" ") + 1);
                //Gets each of the three coords.
                int movX = Integer.parseInt(movement.substring(0, movement.indexOf(" ")));
                movement = movement.substring(movement.indexOf(" ")+1);
                int movY = Integer.parseInt(movement.substring(0, movement.indexOf(" ")));
                movement = movement.substring(movement.indexOf(" ")+1);
                int movZ = Integer.parseInt(movement);
                //Moves if possible.
                move((int) Math.signum(movX), (int) Math.signum(movY), (int) Math.signum(movZ));
                break;
            case "equip":
                int equipSlot = Integer.parseInt(command.substring(command.indexOf(" ") + 1));
                getCreature().inventory.equipItem(equipSlot);
                break;
            case "drop":
                //Drops an Item from the Player's inventory. Or, it will take whatever the player is holding if nothing is held.
                
                //Gets the index of the Item.
                int dropSlot;
                try {
                    //If a number is given, it is assigned.
                    dropSlot = Integer.parseInt(command.substring(command.indexOf(" ") + 1));
                } catch(Exception e) {
                    //If no number is given, set it to -1 so that the program parses it as a hand item drop.
                    dropSlot = -1;
                }
                
                //If the item is in the inventory, drop the inventory item.
                if(dropSlot >= 0)
                    getCreature().inventory.getInventory().remove(dropSlot);
                else if(dropSlot == -1)
                    //Otherwise, drop what's in the hand.
                    getCreature().inventory.takeHeldItem();
                break;
            case "search":
                throw new UnsupportedOperationException("Search action for PlayerBrain has not been written.");
        }
        
    }
    
    @Override
    protected void attack(Creature target) {
        throw new UnsupportedOperationException("entities.PlayerBrain.attack() has not been written."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
