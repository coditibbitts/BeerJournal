package beerJournal;

public class Beer {
	
	// Variables
	private double abv; 	// Beer's "Alcohol by Volume"
	private double ibu; 	// Beer's "International Bittering Unit"
	
	private String color;	// Color of the beer (Red, pale, orange etc..)
	private String style;	// Beer's style (IPA, stoute, etc..)
	private String name;	// Name of the beer
	
	
	// Constructors	
	public Beer () {
		
		abv = 0.0;
		ibu = 0.0;
		color = "None";
		style = "None";
		name = "None";
		
	}
	
	public Beer (double abv, double ibu, String color, String style, String name) {
		
		this.abv = abv;
		this.ibu = ibu;
		this.color = color;
		this.style = style;
		this.name = name;
		
	}
	
	// Setters
	public void setABV (double abv) {
		this.abv = abv;
		
	}
	
	public void setIBU (double ibu) {
		this.ibu = ibu;
		
	}

	public void setColor (String color) {
		this.color = color;
	
	}
	
	public void setStyle (String style) {
		this.style = style;
	
	}
	
	public void setName (String name) {
		this.name = name;
		
	}
	
	// Getters
	public double getABV () {
		return this.abv;
		
	}
	
	
	public double getIBU () {
		return this.ibu;
		
	}
	
	public String getColor () {
		return this.color;
		
	}
	
	public String getStyle () {
		return this.style;
		
	}
	
	public String getName () {
		return this.name;
		
	}
	
	// Outputs Beer
	public void outputBeer () {
		
		System.out.println("Name  : " + getName()); 
		System.out.println("Color : " + getColor());
		System.out.println("Style : " + getStyle());
		System.out.println("ABV   : " + getABV());
		System.out.println("IBU   : " + getIBU());
		
	}

}
