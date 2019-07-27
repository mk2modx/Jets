package com.skilldistillery.jet;



public class CargoPlane extends Jet implements Cargo{

	
	
	
	public void loadCargo() {
		System.out.println("Loading Cargo.");
		
	}
	public CargoPlane() {
		super();
	}

	public CargoPlane(String model, double speed, int range, double price) {
		super(model, speed, range, price);
		
	}

}
