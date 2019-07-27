package com.skilldistillery.jet;


public abstract class Jet {
private String model;
private double speed;
private int range;
private double price;


public void fly() {
	
	System.out.println(this.model + " is flying");
	
	
}
public void toRemove() {

	System.out.println( " " + this.model );
	
	
}


public double getSpeedInMach() {
	
	return 0.0;
}

public Jet () {
	
}
public Jet(String model, double speed, int range, double price) {
	super();
	this.model = model;
	this.speed = speed;
	this.range = range;
	this.price = price;
}
public String getModel() {
	return model;
}
public void setModel(String model) {
	this.model = model;
}
public double getSpeed() {
	return speed;
}
public void setSpeed(double speed) {
	this.speed = speed;
}
public int getRange() {
	return range;
}
public void setRange(int range) {
	this.range = range;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((model == null) ? 0 : model.hashCode());
	long temp;
	temp = Double.doubleToLongBits(price);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	result = prime * result + range;
	temp = Double.doubleToLongBits(speed);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Jet other = (Jet) obj;
	if (model == null) {
		if (other.model != null)
			return false;
	} else if (!model.equals(other.model))
		return false;
	if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
		return false;
	if (range != other.range)
		return false;
	if (Double.doubleToLongBits(speed) != Double.doubleToLongBits(other.speed))
		return false;
	return true;
}
@Override
public String toString() {
	return "Jet [model=" + model + ", speed=" + speed + ", range=" + range + ", price=" + price + "]";
}



}
