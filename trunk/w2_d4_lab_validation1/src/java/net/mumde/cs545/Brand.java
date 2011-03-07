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
    private boolean beingOrdered;
    private double rate;
    private int quantity;
    private static final double DEFAULT_RATE = 15;

    public Brand() {
    }

    public Brand(String name, String description) {
        this(name, description, DEFAULT_RATE);
    }

    public Brand(String name, String description, double rate) {
        this.name = name;
        this.description = description;
        this.rate = rate;
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

    public boolean isBeingOrdered() {
        return beingOrdered;
    }

    public void setBeingOrdered(boolean ordered) {
        this.beingOrdered = ordered;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getTotal() {
        return rate * quantity;
    }

}
