package com.corejsf;

import java.io.Serializable;
import javax.inject.Named; 
   // or import javax.faces.bean.ManagedBean;
import javax.enterprise.context.RequestScoped; 
   // or import javax.faces.bean.RequestScoped;

@Named // or @ManagedBean
@RequestScoped
public class Teavana implements Serializable {
  private String selectedTea;
  
  public String getSelectedTea() { return selectedTea; }
  
  public String changeTea(String newValue) {
     selectedTea = newValue;
     return selectedTea + "?faces-redirect=true";
  }
}
