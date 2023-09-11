package treeFarm.tree;

import java.util.ArrayList;
import java.util.Scanner;

public class DeciduousTree extends Tree {   // LISTNATE STROMY
	private static Scanner scannerDeciduous = new Scanner(System.in);
	private ArrayList<String> deciduousSpeciesList = new ArrayList<String>() {
		{
			add("oak");		// dub
			add("birch");	// breza
			add("maple");	// javor
			add("beech");	// buk
			add("tilia");	// lipa
			add("poplar");	// topol
			add("ash");		// jasen
		}
	};
	
	public DeciduousTree(String species, String color, int age, double height) {
		super(species, color, age, height);

	}
	
	public static void addDeciduousTree() {
		System.out.printf("Enter [species, color, age, height]:\n> ");  // neskor zmenit len na input species, ostatne sa vygeneruju random na zaklade toho
		String deciduousSpecies = scannerDeciduous.next();
		String deciduousColor = scannerDeciduous.next();
		int deciduousAge = scannerDeciduous.nextInt();
		double deciduousHeight = scannerDeciduous.nextDouble();
		ListDeciduousTree deciduousList = new ListDeciduousTree(deciduousSpecies, deciduousColor, deciduousAge, deciduousHeight);
		System.out.printf("Added : %s, %s, %d years, %f metres\n", 
				deciduousSpecies, 
				deciduousColor, 
				deciduousAge, 
				deciduousHeight);
	}
}
