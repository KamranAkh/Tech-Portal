package rest;

public class Card {
	private String id;
	private String name;
	private String number;
    private String expiration;
    private String cvv;
    
    public Card(){
    }
    
    public Card(String id, String name, String number, String expiration, String cvv) {
    	super();
    	this.id = id;
    	this.name = name;
    	this.number = number;
    	this.expiration = expiration;
    	this.cvv = cvv;
    }
    
    
    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
    
    
    
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    
    
    public void setNumber(String number) {
        this.number = number;
    }
    public String getNumber() {
        return number;
    }
    
    
    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }
    public String getExpiration() {
        return expiration;
    }
    
    
    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
    public String getCvv() {
        return cvv;
    }
    
}
