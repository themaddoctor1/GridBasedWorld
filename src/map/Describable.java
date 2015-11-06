/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

/**
 *
 * @author Christopher
 */
public interface Describable {
    
    /**
     * Provides a description of an item based on what it "looks like".
     * 
     * @param quality The quality of the information.
     * @return A description of the item.
     */
    public String getDescription(int quality);
}
