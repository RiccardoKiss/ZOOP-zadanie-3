package treeFarm.people;

import java.util.ArrayList;
import java.util.Scanner;

public class ListForestManager {		// ZOZNAM SPRAVCOV LESA
	private static ArrayList<ForestManager> forestManagerList = new ArrayList<ForestManager>();
	private static int forestManagerOrder = 0;
	
	public ListForestManager(String firstName, String lastName, boolean sex, int age) {
		forestManagerList.add(new ForestManager(firstName, lastName, sex, age));
		
	}

	public static ArrayList<ForestManager> getForestManagerList() {
		return forestManagerList;
	}

	public static void showForestManagerList() {
		System.out.println("FOREST MANAGER List:");
		if (!forestManagerList.isEmpty()) {
			for (forestManagerOrder = 0; forestManagerOrder < forestManagerList.size(); forestManagerOrder++) {
				System.out.printf("[ %d ]: %s %s, %s, %d years\n", 
						forestManagerOrder + 1, 
						forestManagerList.get(forestManagerOrder).myFirstName(), 
						forestManagerList.get(forestManagerOrder).myLastName(), 
						forestManagerList.get(forestManagerOrder).mySex(), 
						forestManagerList.get(forestManagerOrder).myAge());
			}
		} else {
			System.out.println("(empty)");
		}
		
	}
	
	public static void dismissForestManager() {
		System.out.println("Dismiss FOREST MANAGER:");
		if (!forestManagerList.isEmpty()) {  // ak nie je pole prazdne
			for (forestManagerOrder = 0; forestManagerOrder < forestManagerList.size(); forestManagerOrder++) {
				System.out.printf("(%d) %s %s, %s, %d years\n", 
						forestManagerOrder + 1, 
						forestManagerList.get(forestManagerOrder).myFirstName(), 
						forestManagerList.get(forestManagerOrder).myLastName(), 
						forestManagerList.get(forestManagerOrder).mySex(), 
						forestManagerList.get(forestManagerOrder).myAge());
			}
			Scanner scannerDismissForestManager = new Scanner(System.in);
			int pickedForestManager;
			do {
				System.out.printf("> ");
				pickedForestManager = scannerDismissForestManager.nextInt() - 1;
			} while (pickedForestManager > forestManagerList.size());
			forestManagerList.remove(pickedForestManager);
			//scDissmiss.close();
		} else {  // ak je pole prazdne
			System.out.println("(empty)");
		}
	}
	
}
