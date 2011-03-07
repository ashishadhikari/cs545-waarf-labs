package business.customerSubsystem;

import business.subsystemExternalInterfaces.Address;

public class AddressImpl implements Address{
	private String city;
	private String name;
	private String state;
	private String zip;
	private String street;
	
	public AddressImpl(String name,String street, String city, String state, String zip ){
		this.city=city;
		this.name=name;
		this.state=state;
		this.zip=zip;
		this.street=street;
	}
	public String getCity(){
		return city;
	}
	public void setCity(String city){
		this.city= city;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
    public String getState(){
    	return state;
    }
    public void setState(String state){
    	this.state=state;
    }
    public String getZip(){
    	return zip;
    }
    public void setZip(String zip){
    	this.zip=zip;
    }
    public void setStreet(String street){
    	this.street=street;
    }
    public String getStreet(){
    	return street;
    }


}