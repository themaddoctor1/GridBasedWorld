/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import io.BlankPanel;
import io.IOManager;
import io.Interface;
import java.awt.Color;

/**
 *
 * @author Christopher
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        BlankPanel panel = new BlankPanel("PANEL", Color.RED);
        IOManager.setIOPanel(panel);
        
        Interface.initialize("Title");
        
        while(true) {
            Interface.getInterface().redraw();
        }
        
    }
    
}
