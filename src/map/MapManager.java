/**
 * MapManager.java
 * 
 * Christopher Hittner (c) 2015
 */
package map;

import entities.Entity;
import io.IOManager;
import java.util.Arrays;

/**
 * MapManager manages all of the operations specifically designed to ensure the
 * proper function of a Map object.
 *
 * @author Christopher Hittner
 */
public class MapManager {
    private static Map map = null;
    
    private static EntityList entities = new EntityList();
    
    
    /**
     * Simulates the passage of a certain amount of time in seconds.
     * @param t The amount of time to pass.
     */
    public static void passTime(double t) {
        throw new UnsupportedOperationException("map.MapManager.passTime() has not been written yet.");
    }
    
    /**
     * Sets a new map to use.
     * @param m The Map to use.
     */
    public static void setMap(Map m) {
        map = m;
    }
    
    /**
     * Sets a new Map and Entity list to use.
     * @param m The new map.
     * @param e The new set of entities.
     */
    public static void setMap(Map m, EntityList e) {
        setMap(m);
        setEntityList(e);
    }
    
    /**
     * Sets the current Entity list to a new one.
     * @param e The new list.
     */
    public static void setEntityList(EntityList e) {
        entities = e;
    }
    
    
    /**
     * Gets the current Map.
     * @return The map.
     */
    public static Map getMap() {
        return map;
    }
    
    
    /**
     * Gets the current list of Entities.
     * @return The Entities.
     */
    public static EntityList getEntitiyList() {
        return entities;
    }
    
    /**
     * Adds a 3D set of coordinates to the Map.
     * @param grid The MapLocations to add.
     * @param x The Western, lowest x-coordinate.
     * @param y The Southern, lowest y-coordinate.
     * @param z The lowest z-coordinate.
     */
    public static void addMapLocation(MapLocation[][][] grid, int x, int y, int z) {
        //First, ensure that the MapLocations will be in bounds.
        if(x < 0) {
            map.addLayerWest();
            addMapLocation(grid, x+1, y, z);
        } else if(y < 0) {
            map.addLayerWest();
            addMapLocation(grid, x+1, y, z);
        } else if(z < 0) 
            throw new IllegalArgumentException("The z-coordinate must be non-negative!");
        else 
            //Once it is ensured, add the Cell.
            for(int i = 0; i < grid.length; i++)
                for(int j = 0; j < grid[i].length; j++)
                    for(int k = 0; k < grid[i][j].length; k++)
                        map.setPosition(x+i, y+j, z+k, grid[i][j][k]);
    }
    
    /**
     * Executes a MapManager-specific command.
     * Commands are formatted as FUNCTION_NAME[<PARAM>|<PARAM>|...|<PARAM>]
     * @param function The command to execute.
     */
    public static void executeCommand(String function) {
        //Gets the function name
        String funcName = function.substring(0, function.indexOf("["));
        
        String[] params = IOManager.parseCommandParameters(function);
        
        switch(funcName) {
            case "PASS_TIME":
                //Time will be passed. First, calculate the time passed, which is the first argument.
                try {
                    double timePassed = Double.parseDouble(params[0]);
                    passTime(timePassed);
                } catch(NumberFormatException nfe) {
                    throw new IllegalArgumentException("Parameter " + params[0] + " for 'PASS_TIME' is not valid.");
                }
                break;
            default:
                throw new IllegalArgumentException("Function '" + funcName + "' is not defined for MapManager.");
        }
        
        //throw new UnsupportedOperationException("map.MapManager.executeCommand() has not been written yet.");
    }
    
}
