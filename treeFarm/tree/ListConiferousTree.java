package treeFarm.tree;

import java.util.ArrayList;
import java.util.Scanner;

import treeFarm.people.ListWoodcutter;
import treeFarm.people.Woodcutter;

public class ListConiferousTree {			// ZOZNAM IHLICNATYCH STROMOV
	private static ArrayList<ConiferousTree> coniferousTreeList = new ArrayList<ConiferousTree>();
	private static int confireousTreeOrder = 0;

	public ListConiferousTree(String species, String color, int age, double height) {
		coniferousTreeList.add(new ConiferousTree(species, color, age, height));

	}

	public ArrayList<ConiferousTree> getConiferousTreeList() {
		return coniferousTreeList;
	}
	
	public static void showConiferousTreeList() {
		System.out.println("CONIFEROUS TREES list:");
		if (!coniferousTreeList.isEmpty()) {
			for (confireousTreeOrder = 0; confireousTreeOrder < coniferousTreeList.size(); confireousTreeOrder++) {
				System.out.printf("%s, %s, %d years, %f metres\n", 
						coniferousTreeList.get(confireousTreeOrder).getSpecies(), 
						coniferousTreeList.get(confireousTreeOrder).getColor(), 
						coniferousTreeList.get(confireousTreeOrder).getAge(), 
						coniferousTreeList.get(confireousTreeOrder).getHeight());
			}
		} else {
			System.out.println("(empty)");
		}
	}

	public static void cutConiferousTree(ArrayList<Woodcutter> w) {
		if(!w.isEmpty()) {
			if(!coniferousTreeList.isEmpty()) {
				ListWoodcutter.showWoodcutterList();
				Scanner scannerPickWoodcutter = new Scanner(System.in);
				int pickedWoodcutter;
				do {
					System.out.printf(">> ");
					pickedWoodcutter = scannerPickWoodcutter.nextInt() - 1;
				} while (pickedWoodcutter > w.size());
				if (w.get(pickedWoodcutter).getAxe()) {
					for (confireousTreeOrder = 0; confireousTreeOrder < coniferousTreeList.size(); confireousTreeOrder++) {
						System.out.printf("(%d) %s, %s, %d years, %f metres\n", 
								confireousTreeOrder + 1, 
								coniferousTreeList.get(confireousTreeOrder).getSpecies(), 
								coniferousTreeList.get(confireousTreeOrder).getColor(), 
								coniferousTreeList.get(confireousTreeOrder).getAge(), 
								coniferousTreeList.get(confireousTreeOrder).getHeight());
					}
					Scanner scannerDismissConiferousTree = new Scanner(System.in);
					int dismissConiferousTree;
					do {
						System.out.printf(">> ");
						dismissConiferousTree = scannerDismissConiferousTree.nextInt() - 1;
					} while (dismissConiferousTree > coniferousTreeList.size());
					//scannerDismissDeciduous.close();
					coniferousTreeList.remove(dismissConiferousTree);
					w.get(pickedWoodcutter).earnConiferousTreeSalary();
					System.out.printf("~Deciduous Tree was successfully cut down by %s %s.\n", w.get(pickedWoodcutter).myLastName(), w.get(pickedWoodcutter).myFirstName());
				} else {
					System.out.println("~Selected woodcutter does not own an AXE!");
				}
			} else {
				System.out.println("~There are no trees to cut down!");
			}
		} else {
			System.out.println("~There are no woodcutters employed!");
		}
	}

	
}
