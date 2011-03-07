/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.mumde.cs545;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Raj
 */
//@Named
//@SessionScoped
public class Color implements Serializable {

    private String name;
    private @Inject Brand currentBrand;
    private String userBrand;
    private List<Brand> brands;

    public Color() {
        brands = new ArrayList<Brand>();
    }

    public Color(String name) {
        this();
        this.name = name;
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
     * @return the currentBrand
     */
    public Brand getCurrentBrand() {
        return currentBrand;
    }

    /**
     * @param currentBrand the currentBrand to set
     */
    public void setCurrentBrand(Brand currentBrand) {
        this.currentBrand = currentBrand;
    }

    public String getUserBrand() {
        return userBrand;
    }

    public void setUserBrand(String userBrand) {
        this.userBrand = userBrand;
        for (Brand b : brands) {
            if (b.getName().equals(userBrand)) {
                currentBrand = b;
                break;
            }
        }
    }



    public void addBrand(Brand brand) {
        this.brands.add(brand);
    }

    public List<String> getBrandNames() {
        List<String> returnList = new ArrayList<String>();
        for (Brand b : brands) {
            returnList.add(b.getName());
        }
        return returnList;
    }

    public List<Brand> getBrands() {
        
        return brands;
    }



//    public String doDescription() {
////        setCurrentBrand();
//    //    FacesContext context = FacesContext.getCurrentInstance();
//       // String value[] = context.getExternalContext().getRequestParameterValuesMap().get("brand");
//        //System.out.println(value[0]);
////       setUserBrand("White Brand 1");
//
//        return null;
//    }

    @Override
    public String toString() {
        return this.name;
    }
}
