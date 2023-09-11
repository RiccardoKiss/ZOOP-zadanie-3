package treeFarm.people;

import java.util.ArrayList;
import java.util.Scanner;

public class ListWoodcutter {			// ZOZNAM DREVORUBACOV
	private static ArrayList<Woodcutter> woodcutterList = new ArrayList<Woodcutter>();
	private static int woodcutterOrder = 0;
	
	public ListWoodcutter(String firstName, String lastName, boolean sex, int age) {
		woodcutterList.add(new Woodcutter(firstName, lastName, sex, age));
		
	}
	
	public static ArrayList<Woodcutter> getWoodcutterList() {
		return woodcutterList;
	}

	public static void showWoodcutterList() {
		System.out.println("WOODCUTTER list:");
		if (!woodcutterList.isEmpty()) {
			for (woodcutterOrder = 0; woodcutterOrder < woodcutterList.size(); woodcutterOrder++) {
				System.out.printf("[ %d ]: %s %s, %s, %d years, %d €\n", 
						woodcutterOrder + 1, 
						woodcutterList.get(woodcutterOrder).myFirstName(), 
						woodcutterList.get(woodcutterOrder).myLastName(), 
						woodcutterList.get(woodcutterOrder).mySex(), 
						woodcutterList.get(woodcutterOrder).myAge(),
						woodcutterList.get(woodcutterOrder).getSalary());
			}
		} else {
			System.out.println("(empty)");
		}
	}
	
	public static void dismissWoodcutter() {
		System.out.println("Dismiss WOODCUTTER:");
		if (!woodcutterList.isEmpty()) {
			for (woodcutterOrder = 0; woodcutterOrder < woodcutterList.size(); woodcutterOrder++) {
				System.out.printf("(%d) %s %s, %s, %d years, %d €\n", 
						woodcutterOrder + 1, 
						woodcutterList.get(woodcutterOrder).myFirstName(), 
						woodcutterList.get(woodcutterOrder).myLastName(), 
						woodcutterList.get(woodcutterOrder).mySex(), 
						woodcutterList.get(woodcutterOrder).myAge(),
						woodcutterList.get(woodcutterOrder).getSalary());
			}
			Scanner scannerDismissWoodcutter = new Scanner(System.in);
			int pickedWoodcutter;
			do {
				System.out.printf("> ");
				pickedWoodcutter = scannerDismissWoodcutter.nextInt() - 1;
			} while (pickedWoodcutter > woodcutterList.size());
			woodcutterList.remove(pickedWoodcutter);
			//scDissmiss.close();
		} else {
			System.out.println("(empty)");
		}
		
	}
	
	public static void giveAxe() {
		Scanner scannerPickAxe = new Scanner(System.in);
		int pickedWoodcutter;
		do {
			System.out.printf(">> ");
			pickedWoodcutter = scannerPickAxe.nextInt() - 1;
		} while (pickedWoodcutter > woodcutterList.size());
		if (woodcutterList.get(pickedWoodcutter).getAxe()) {
			System.out.println("Woodcutter already has an AXE!");
		} else {
			woodcutterList.get(pickedWoodcutter).setAxe(true);
			System.out.println("Woodcutter now owns an axe.");
		}
	}
	
	public static void giveBucket() {
		Scanner scannerPickAxe = new Scanner(System.in);
		int pickedWoodcutter;
		do {
			System.out.printf(">> ");
			pickedWoodcutter = scannerPickAxe.nextInt() - 1;
		} while (pickedWoodcutter > woodcutterList.size());
		if (woodcutterList.get(pickedWoodcutter).getBucket()) {
			System.out.println("Woodcutter already has a BUCKET!");
		} else {
			woodcutterList.get(pickedWoodcutter).setBucket(true);
			System.out.println("Woodcutter now owns a bucket.");
		}
	}
}
