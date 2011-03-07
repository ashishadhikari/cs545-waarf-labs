/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.mumde.cs545;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Raj
 */
@Named
@SessionScoped
public class Tea implements Serializable {

    private String userColor;
    private Color currentColor;
    private List<Color> colors;

    public Tea() {
        colors = new ArrayList<Color>();
        populateColorsWithBrands();
    }

    public String getUserColor() {
        return userColor;
    }

    public void setUserColor(String userColor) {
        this.userColor = userColor;
        for (Color c : colors) {
            if (c.getName().equals(userColor)) {
                currentColor = c;
                break;
            }
        }
    }

    public Color getCurrentColor() {
        return currentColor;
    }

    

    public List<String> getColorItems() {
        List<String> returnList = new ArrayList<String>();
        for(Color c : colors) {
            returnList.add(c.getName());
        }
        return returnList;
    }

    public String doAdvice() {
        return "adviceTeaBrands";
    }

    private void populateColorsWithBrands() {
        Color whiteColor = new Color("white");
        Color redColor = new Color("red");
        Color greenColor = new Color("green");
        Color darkColor = new Color("dark");

        colors.add(whiteColor);
        colors.add(redColor);
        colors.add(greenColor);
        colors.add(darkColor);

        whiteColor.addBrand(new Brand("White Brand 1", "whiteColor is White Brand 1."));
        whiteColor.addBrand(new Brand("White Brand 2", "whiteColor is White Brand 2."));
        whiteColor.addBrand(new Brand("White Brand 3", "whiteColor is White Brand 3."));

        redColor.addBrand(new Brand("Red Brand 1", "redColor is Red Brand 1."));
        redColor.addBrand(new Brand("Red Brand 2", "redColor is Red Brand 2."));
        redColor.addBrand(new Brand("Red Brand 3", "redColor is Red Brand 3."));

        greenColor.addBrand(new Brand("Green Brand 1", "greenColor is Green Brand 1."));
        greenColor.addBrand(new Brand("Green Brand 2", "greenColor is Green Brand 2."));
        greenColor.addBrand(new Brand("Green Brand 3", "greenColor is Green Brand 3."));
        
        darkColor.addBrand(new Brand("Dark Brand 1", "darkColor is Dark Brand 1."));
        darkColor.addBrand(new Brand("Dark Brand 2", "darkColor is Dark Brand 2."));
        darkColor.addBrand(new Brand("Dark Brand 3", "darkColor is Dark Brand 3."));
    }
}
