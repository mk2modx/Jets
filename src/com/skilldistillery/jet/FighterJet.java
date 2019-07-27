package com.skilldistillery.jet;


public class FighterJet extends Jet implements Combat{

	
	
	public void fight() {
		System.out.println("Bogeys!! , launching fighters!!!");
	}
	
	public FighterJet() {
		super();
	}

	public FighterJet(String model, double speed, int range, double price) {
		super(model, speed, range, price);
	}

	
	
}
