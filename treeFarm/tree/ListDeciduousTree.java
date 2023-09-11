package treeFarm.tree;

import java.util.ArrayList;
import java.util.Scanner;

import treeFarm.people.ListWoodcutter;
import treeFarm.people.Woodcutter;

public class ListDeciduousTree {			// ZOZNAM LISTNATYCH STROMOV
	private static ArrayList<DeciduousTree> deciduousTreeList = new ArrayList<DeciduousTree>();
	private static int deciduousTreeOrder = 0;

	public ListDeciduousTree(String species, String color, int age, double height) {
		deciduousTreeList.add(new DeciduousTree(species, color, age, height));

	}

	public ArrayList<DeciduousTree> getDeciduosTreeList() {
		return deciduousTreeList;
	}

	public static void showDeciduousTreeList() {
		System.out.println("DECIDUOUS TREES list:");
		if (!deciduousTreeList.isEmpty()) {
			for (deciduousTreeOrder = 0; deciduousTreeOrder < deciduousTreeList.size(); deciduousTreeOrder++) {
				System.out.printf("%s, %s, %d years, %f metres\n", 
						deciduousTreeList.get(deciduousTreeOrder).getSpecies(), 
						deciduousTreeList.get(deciduousTreeOrder).getColor(), 
						deciduousTreeList.get(deciduousTreeOrder).getAge(), 
						deciduousTreeList.get(deciduousTreeOrder).getHeight());
			}
		} else {
			System.out.println("(empty)");
		}

	}

	public static void cutDeciduousTree(ArrayList<Woodcutter> w) {
		if(!w.isEmpty()) {
			if(!deciduousTreeList.isEmpty()) {
				ListWoodcutter.showWoodcutterList();
				Scanner scannerPickWoodcutter = new Scanner(System.in);
				int pickedWoodcutter;
				do {
					System.out.printf(">> ");
					pickedWoodcutter = scannerPickWoodcutter.nextInt() - 1;
				} while (pickedWoodcutter > w.size());
				if(w.get(pickedWoodcutter).getAxe()) {
					for (deciduousTreeOrder = 0; deciduousTreeOrder < deciduousTreeList.size(); deciduousTreeOrder++) {
						System.out.printf("(%d) %s, %s, %d years, %f metres\n", 
								deciduousTreeOrder + 1, 
								deciduousTreeList.get(deciduousTreeOrder).getSpecies(), 
								deciduousTreeList.get(deciduousTreeOrder).getColor(), 
								deciduousTreeList.get(deciduousTreeOrder).getAge(), 
								deciduousTreeList.get(deciduousTreeOrder).getHeight());
					}
					Scanner scannerDismissDeciduousTree = new Scanner(System.in);
					int dismissDeciduousTree;
					do {
						System.out.printf(">> ");
						dismissDeciduousTree = scannerDismissDeciduousTree.nextInt() - 1;
					} while (dismissDeciduousTree > deciduousTreeList.size());
					//scannerDismissDeciduous.close();
					deciduousTreeList.remove(dismissDeciduousTree);
					w.get(pickedWoodcutter).earnDeciduousTreeSalary();
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
