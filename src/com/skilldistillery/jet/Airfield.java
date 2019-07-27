package com.skilldistillery.jet;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Airfield<Jets> {
//	String fileName = "names.txt";

	List<Jet> jets = new ArrayList<>();
	public Airfield() {
		getAircrafts();
	}
	public List<Jet> loadAircrafts() {
		List<Jet> tJets = jets;
		return tJets;
	}

	public List<Jet> getAircrafts() {

		try (BufferedReader bufIn = new BufferedReader(new FileReader("names.txt"))) {
			String line;
			while ((line = bufIn.readLine()) != null) {
				String[] jetRecord = line.split(", ");
				String name = jetRecord[0];
				double speed = Double.parseDouble(jetRecord[1]);
				int range = Integer.parseInt(jetRecord[2]);
				long price = Long.parseLong(jetRecord[3]);
				int index = name.charAt(0);
				if (index ==  67) {
					CargoPlane p = new CargoPlane(name,speed,range,price);
					jets.add( p);
				}else if (index == 70) {
					FighterJet p = new FighterJet(name,speed,range,price);
					jets.add( p);
				}else {
					PassengerJet p = new PassengerJet(name,speed,range,price);
					jets.add(p);
				}

			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return jets;
	}
	
	public void parkPlane(Jet j) {
		jets.add(j);
	}
	public void removePlane(Jet k) {
		jets.remove(k);
	}
	public void displayPlanes() {
		for (Jet jet :jets) {
			System.out.println(jet);
			}
	}
	
}
