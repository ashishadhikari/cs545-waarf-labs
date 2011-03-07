/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.mumde.cs545;

import java.io.Serializable;



/**
 *
 * @author Raj
 */

public class Brand implements Serializable {

    private String name;
    private String description;

    public Brand() {
    }

    public Brand(String name, String description) {
        this.name = name;
        this.description = description;
    }

   
    @Override
    public String toString() {
        return this.getName();
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
