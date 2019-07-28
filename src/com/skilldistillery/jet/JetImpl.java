package com.skilldistillery.jet;

import java.util.List;
import java.util.Scanner;

public class JetImpl extends Jet {
	Airfield ai = new Airfield();

	public JetImpl() {

		super();
	}
	public JetImpl(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}
	
	public void removeJets() {
		
	}
}
