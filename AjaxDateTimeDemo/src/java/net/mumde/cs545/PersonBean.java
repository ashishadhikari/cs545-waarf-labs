/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.mumde.cs545;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author ashish
 */
@Named("pb")
@RequestScoped
public class PersonBean {

    private String firstName = "";
    private String lastName = "";

    public PersonBean() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return String.format("%s %s", firstName, lastName);
    }

    public String display() {
        return "person";
    }
}
