package treeFarm.people;

import java.util.ArrayList;
import java.util.Scanner;

public class ForestManager extends Worker implements MyInfo{		// SPRAVCA LESA
	private static Scanner scannerForestManager = new Scanner(System.in);
	
	public ForestManager(String firstName, String lastName, boolean sex, int age) {
		super(firstName, lastName, sex, age);

	}
	
	// prekonavanie abstract metod
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	/////////////////////////////
	
	// interface implementacia
	public String myFirstName() {
		return getFirstName();
	}

	public String myLastName() {
		return getLastName();
	}

	public int myAge() {
		return getAge();
	}
	
	public String mySex() {
		return getSex();
	}
	/////////////////////////////

	public static void hireForestManager() {
		final int adultAge = 18;
		System.out.printf("Enter [first name, last name, sex, age]:\n> ");
		String forestManagerFirstName = scannerForestManager.next();
		String forestManagerLastName = scannerForestManager.next();
		boolean forestManagerSex = scannerForestManager.nextBoolean();
		int forestManagerAge = scannerForestManager.nextInt();
		if (forestManagerAge >= adultAge) {
			ListForestManager forestManagerList = new ListForestManager(forestManagerFirstName, forestManagerLastName, forestManagerSex, forestManagerAge);
			System.out.printf("Added: %s %s, %s, %d years\n", 
					forestManagerLastName, 
					forestManagerFirstName, 
					forestManagerSex ? "male" : "female", 
					forestManagerAge);
		} else {
			System.out.println("ERROR: Invalid age! (not adult)");
		}
	}

	public static void hireWoodcutter(ArrayList<ForestManager> fm) {
		if (!fm.isEmpty()) {
			final int adultAge = 18;
			System.out.printf("Enter [first name, last name, sex, age]:\n> ");
			String woodcutterFirstName = scannerForestManager.next();
			String woodcutterLastName = scannerForestManager.next();
			boolean woodcutterSex = scannerForestManager.nextBoolean();
			int woodcutterAge = scannerForestManager.nextInt();
			if (woodcutterAge >= adultAge) {
				ListWoodcutter woodcutterList = new ListWoodcutter(woodcutterFirstName, woodcutterLastName, woodcutterSex, woodcutterAge);
				System.out.printf("Added: %s %s, %s, %d years\n", 
						woodcutterLastName, 
						woodcutterFirstName, 
						woodcutterSex ? "male" : "female", 
						woodcutterAge);
			} else {
				System.out.println("ERROR: Invalid age! (not adult)");
			}
		} else {
			System.out.println("~There are no Forest Managers to hire a Woodcutter!");
		}
	}

}
