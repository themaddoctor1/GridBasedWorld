/**
 * IOManager.java
 * 
 * Christopher Hittner (c) 2015
 */
package io;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;
import map.MapManager;

/**
 * A class that manages all of the IO for an Interface.
 * 
 * @author Christopher Hittner
 */
public class IOManager {
    
    private static IOPanel topPanel = null;
    
    /**
     * Adds an IOPanel to the IOManager.
     * @param io The panel.
     */
    public static void addIOPanel(IOPanel io) {
        if(topPanel == null)
            topPanel = io;
        else
            topPanel.sendToTop(io);
    }
    
    
    /**
     * Swaps the current top IOPanel with a new one.
     * @param io The new IOPanel.
     * @return  The old IOPanel.
     */
    public static IOPanel setIOPanel(IOPanel io) {
        IOPanel old = topPanel;
        topPanel = io;
        return old;
    }
    
    
    /**
     * Clicks on the IO, therefore requiring the IOPanel to be notified of the click.
     * @param x The position on x.
     * @param y The position on y.
     */
    public static void mouseClicked(int x, int y) {
        topPanel.mouseClicked(x, y);
    }
    
    /**
     * Executes a command within the game.
     * @param cmd THe command to execute.
     */
    public static void executeCommand(String cmd) {
        
        //Grabs the first part of the command because it is required for interpretation.
        String target = cmd.substring(0, cmd.indexOf("."));
        String function = cmd.substring(cmd.indexOf(".") + 1);
        
        if(target.startsWith("ERROR"))
            throw new RuntimeException("Error thrown by Button: " + target.substring(5));
        
        //Tries out different commands to find the right one
        switch (target) {
            //The command is for the IOManager.
            case "IO_MANAGER":
                String[] params = parseCommandParameters(function);
                
                switch(function) {
                    //In this case, the user wishes to change the display.
                    case "SET_DISPLAY":
                        switch(params[0].toLowerCase()) {
                            
                            //Blank panel
                            case "blank":
                                try {
                                    topPanel = new BlankPanel(
                                            "BLANK"
                                            , new Color(
                                                    Integer.parseInt(params[1]),
                                                    Integer.parseInt(params[2]),
                                                    Integer.parseInt(params[2])
                                            ));
                                } catch(Exception nfe) { 
                                    topPanel = new BlankPanel("BLANK");
                                }
                                break;
                                
                            //Inventory panel
                            case "inventory":
                                throw new UnsupportedOperationException("The 'inventory' panel type for IO_MANAGER.SET_DISPLAY is not fully implemented.");
                            default:
                                throw new IllegalArgumentException("'" + params[0] + "' was not recognized as a display type.");
                        }
                        
                        break;
                    default:
                        throw new IllegalArgumentException("Function '" + function + "' is not defined in IO_MANAGER.");
                }
                break;
                
            //The command is for the MapManager.
            case "MAP_MANAGER":
                MapManager.executeCommand(function);
                break;
            //If nothing can be called, throw an Exception.
            default:
                throw new IllegalArgumentException("Target '" + target + "' is not valid.");
        }
    }
    
    
    /**
     * Pulls the parameters out of a function's parameter set.
     * @param function The function, including the properly formatted parameters.
     * @return An ordered list of all of the parameters.
     */
    public static String[] parseCommandParameters(String function) {
        //Pulls out the contained parameters. The vertical line helps with parsing.
        String paramSet = function.substring(function.indexOf("[")+1, function.indexOf("]")) + "|";
        
        //Parses the String into an array of parameters.
        String[] params = new String[0];
        
        //Pulls all of the parameters out. paramSet is shortened each time a parameter is found.
        while(paramSet.contains("|")) {
            params = Arrays.copyOf(params, params.length+1);
            params[params.length-1] = paramSet.substring(0, paramSet.indexOf("|"));
            paramSet = paramSet.substring(paramSet.indexOf("|") + 1);
        }
        
        return params;
    }
    
    /**
     * Draws the IO.
     * @param g A Graphics object.
     */
    public static void draw(Graphics g) {
        try {
            topPanel.draw(g);
        } catch(NullPointerException npe) { }
    }
    
}
