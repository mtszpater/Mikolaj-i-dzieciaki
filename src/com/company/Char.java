package com.company;

import javax.swing.*;

/**
 * author @pater
 */
abstract class Char {
    
    protected String image;

    private ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
    
    public ImageIcon getIcon(){
        ImageIcon icon = createImageIcon(image);
        return icon;
    }
}
