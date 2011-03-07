package business.subsystemExternalInterfaces;

public interface Address {
	
//	public String getCity();
//	public void setCity(String city);
//	public String getName();
//	public void setName(String name);
//    public String getState();
//    public void setState(String state);
//    public String getZip();
//    public void setZip(String zip);
//    public void setStreet(String street);
//    public String getStreet();
    
    public String getStreet();
    public String getCity();
    public String getState();
    public String getZip();
    public void setStreet(String s);
    public void setCity(String s);
    public void setState(String s);
    public void setZip(String s);

}
