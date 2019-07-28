package com.skilldistillery.jet;



public class PassengerJet extends Jet implements Passenger{

	public PassengerJet() {
		super();
	}

	public PassengerJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}
	public void passage() {
		System.out.println("Passenger Jet.");
	}
}
