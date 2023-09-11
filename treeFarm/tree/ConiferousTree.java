package treeFarm.tree;

import java.util.ArrayList;
import java.util.Scanner;

public class ConiferousTree extends Tree {  // IHLICNATE STROMY
	private static Scanner scannerConiferous = new Scanner(System.in);
	private ArrayList<String> coniferousSpeciesList = new ArrayList<String>() {	// zatial nerobi nic, chcem dorobit, aby vstupy z klavesnice boli stromy z tohto pola a ked je iny vstup tak vypise "nespravny vstup"
		{
			add("spruce");	// smrek
			add("pine");	// borovica
			add("fir");		// jedla
			add("larch");	// smrekovec
			add("sequoia");	// sekvoja
			add("thuja");	// tuja
		}
	};
	
	public ConiferousTree(String species, String color, int age, double height) {
		super(species, color, age, height);
	
	}
	
	public static void addConiferousTree() {
		System.out.printf("Enter [species, color, age, height]:\n> ");  // neskor zmenit len na input species, ostatne sa vygeneruju random na zaklade toho
		String coniferousSpecies = scannerConiferous.next();
		String coniferousColor = scannerConiferous.next();
		int coniferousAge = scannerConiferous.nextInt();
		double coniferousHeight = scannerConiferous.nextDouble();
		ListConiferousTree coniferousList = new ListConiferousTree(coniferousSpecies, coniferousColor, coniferousAge, coniferousHeight);
		System.out.printf("Added: %s, %s, %d years, %f metres\n", 
				coniferousSpecies, 
				coniferousColor, 
				coniferousAge, 
				coniferousHeight);
	}
}
