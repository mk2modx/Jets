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
		// +JetsApplication() ???

	public void displayUserMenu() {
		boolean isRunning = true;
		int orders = 0;
		do {
			System.out.println("               ~~WELCOME TO THE AIRFIELD~~");
			System.out.println("                  ~~Command Center~~");
			System.out.println();
			System.out.println(" [1] List fleet       [2] Fly all jets         [3] View fastest jet");
			System.out.println();
			System.out.println(" [4] View jet with longest range               [5] Load all Cargo Jets     ");
			System.out.println();
			System.out.println(" [[6] Dogfight!       [7] Add a jet to Fleet   [8] Remove a jet from Fleet  ");
			System.out.println();
			System.out.println("                            [9] Quit");
			System.out.println();
			System.out.println("Awaiting orders, Sir. Choose a number : ");
			orders = kb.nextInt();
			switch (orders) {
			case 1:
				ai.displayPlanes();

				break;
			case 2:
				List<Jet> flying = ai.loadAircrafts();
				System.out.println(flying.size());
				for (Jet jet : flying) {
					jet.fly();
				}

				break;
			case 3:
				// View fastest jet
				break;
			case 4:
				// View jet with longest range
				break;
			case 5:
				// load all cargo jets
				break;
			case 6:
				// dogfight!
				break;
			case 7:
				addJets();
				break;
			case 8:
//				for (Jet jet : flying) {
//					jet.toRemove();
//				}

				removeJets();
				break;
			case 9:
				System.out.println("Aim high!!");
				isRunning = false;
				break;

			}
		} while (isRunning);
	}

	public void launch() {

	}

	public void addJets() {
		System.out.println("Adding Jet - Input Order parameters : ");
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
		System.out.println("Removing Jet - Input Order parameters : ");
		List<Jet> rem = ai.loadAircrafts();
	}
	
}// class
