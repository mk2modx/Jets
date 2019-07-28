package com.skilldistillery.jet;

import java.util.List;
import java.util.Scanner;

public class JetsApplication {
	Scanner kb = new Scanner(System.in);

	Airfield ai = new Airfield();

	public static void main(String[] args) {
		JetsApplication jt = new JetsApplication();
		jt.displayUserMenu();
	}// main

	public void displayUserMenu() {
		boolean isRunning = true;
		int orders = 0;
		while (isRunning) {
			System.out.println("|----------------------------------------------------------------------------|");
			System.out.println("|                      ~~WELCOME TO THE AIRFIELD~~                           |");
			System.out.println("|                          ~~Command Center~~                                |");
			System.out.println("|----------------------------------------------------------------------------|");
			System.out.println("|[1] List fleet      [2] Fly all jets         [3] View fastest jet           |");
			System.out.println("|----------------------------------------------------------------------------|");
			System.out.println("|[4] View jet with longest range              [5] Load all Cargo Jets        |");
			System.out.println("|----------------------------------------------------------------------------|");
			System.out.println("|[6] Dogfight!       [7] Add a jet to Fleet   [8] Remove a jet from Fleet    |");
			System.out.println("|----------------------------------------------------------------------------|");
			System.out.println("|[9] List Passenger Jets                      [10] Quit                      |");
			System.out.println("|----------------------------------------------------------------------------|");
			System.out.println("|            Awaiting orders, Sir. Choose an option :                        |");
			System.out.println("|----------------------------------------------------------------------------|");
			orders = kb.nextInt();
			switch (orders) {
			case 1:
				System.out.println("Total planes available for mobilization.");
				ai.displayPlanes();
				break;
			case 2:
				List<Jet> flying = ai.loadAircrafts();
				for (Jet jet : flying) {
					System.out.println();
					jet.fly();
				}
				break;
			case 3:
				List<Jet> speed = ai.loadAircrafts();
				int fast = 0;
				for (Jet jet : speed) {
					if (jet.getSpeed() > fast) {
						fast = (int) jet.getSpeed();
					}
				}
				for (Jet jet : speed) {
					if (jet.getSpeed() == fast) {
						System.out.println("The fastest Jet is : ");
						System.out.println(jet.toString());
					}
				}
				break;
			case 4:
				List<Jet> ranger = ai.loadAircrafts();
				int range = 0;
				for (Jet jet : ranger) {
					if (jet.getRange() > range) {
						range = (int) jet.getRange();
					}
				}
				for (Jet jet : ranger) {
					if (jet.getRange() == range) {
						System.out.println("The Jet with the longest range is : ");
						System.out.print(jet.toString());
					}
				}
				break;
			case 5:
				List<Jet> cargo = ai.loadAircrafts();
				for (Jet jet : cargo) {
					if (jet instanceof Cargo) {
						System.out.println(jet.toString());
						((Cargo) jet).loadCargo();
					}
				}
				break;
			case 6:
				List<Jet> fight = ai.loadAircrafts();
				for (Jet jet : fight) {
					if(jet instanceof Combat) {
						System.out.println(jet.toString());
						((Combat) jet).fight();
					}
				}
				break;
			case 7:
				addJets();
				System.out.println("Jet Added!");
				break;
			case 8:
				removeJets();
				break;
			case 9:
				List<Jet> pass = ai.loadAircrafts();
				for (Jet jet : pass) {
					if(jet instanceof Passenger) {
						System.out.println(jet.toString());
						((Passenger) jet).passage();
					}
				}
				break;
			case 10:
				System.out.println("Aim high!!");
				isRunning = false;
				break;
			default :
				System.out.println("Not a valid entry.");
				break;
			}
		} 
	}
	public void launch() {
	}
	public void addJets() {
		System.out.println("|---------------------------------------------------|");
		System.out.println("|      Adding Jet - Input Order parameters :        |");
		System.out.println("|                                                   |");
		System.out.println("| To create a Cargo Jet inialize model with \"C\"     |");
		System.out.println("|                                                   |");
		System.out.println("| To create a Fighter Jet inialize model with \"F\"   |");
		System.out.println("|                                                   |");
		System.out.println("| To create a Commercial Jet use any other Letter   |");
		System.out.println("|---------------------------------------------------|");
		
		System.out.println("Enter model :");
		String name = kb.next();
		System.out.println("Enter speed :");
		double speed = kb.nextDouble();
		System.out.println("Enter range :");
		int range = kb.nextInt();
		System.out.println("Enter price :");
		long price = kb.nextLong();
		name = name.toUpperCase();
		ai.displayPlanes();
		if (name.charAt(0) == 67) {
			Jet p = new CargoPlane(name, speed, range, price);
			ai.parkPlane(p);
		} else if (name.charAt(0) == 70) {
			FighterJet p = new FighterJet(name, speed, range, price);
			ai.parkPlane(p);
		} else {
			PassengerJet p = new PassengerJet(name, speed, range, price);
			System.out.println("add jets" + p);
			ai.parkPlane(p);
		}
	}
	public void removeJets() {
		int cur = 0;
		List<Jet> flying = ai.loadAircrafts();
		for (Jet jet : flying) {
			System.out.println("[" + cur + "] : ready for Removal.");
			jet.toRemove();
			cur++;
		}
		System.out.println("|-----------------------------------------------|");
		System.out.println("|    Removing Jet - Input Order parameters :    |");
		System.out.println("|-----------------------------------------------|");
		System.out.println("|         Choose which Jet to Remove  :         |");
		System.out.println("|       Enter Jet Number from " + " 0 to " + (cur - 1) + "           |");
		System.out.println("|-----------------------------------------------|");
		int r = kb.nextInt();
		flying.remove(r);

	}

}// class
