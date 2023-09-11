package treeFarm.main;

import java.util.Scanner;

import treeFarm.people.ForestManager;
import treeFarm.people.ListForestManager;
import treeFarm.people.ListWoodcutter;
import treeFarm.tree.ConiferousTree;
import treeFarm.tree.DeciduousTree;
import treeFarm.tree.ListConiferousTree;
import treeFarm.tree.ListDeciduousTree;
import treeFarm.tree.Weather;

/** KODOVANIE STAVOV MENU:
 * @author Riccardo Kiss
 * 0 - main menu
 * 01 - forest manager menu
 * 	011 - add FM
 * 	012 - remove FM
 * 	013 - show all FM
 *		0131 - back
 * 	014 - add WC
 * 	015 - remove WC
 * 	016 - back
 * 02 - woodcutter menu
 * 	021 - show all WC
 *		0211 - back
 * 	022 - pick axe
 * 	023 - pick bucket
 * 	024 - back
 * 03 - tree menu
 * 	031 - deciduous menu
 *		0311 - add deciduous
 *		0312 - show all deciduous
 *			03121 - back
 *		0313 - back
 *	032 - coniferous menu
 *		0321 - add coniferous
 *		0322 - show all coniferous
 *			03221 - back
 *		0323 - back
 *	033 - back
 * 04 - next day
 */
public abstract class Menu {			// MENU
	private static int counterDay = 0;
	private static int firstDay = 1;
	private static String currentMenu = "" + 0;
	private static Weather weather = new Weather("calm");	// defaultne pocasie prvy den
	
	public static  String getCurrentMenu() {
		return currentMenu;
	}

	public static void setCurrentMenu(String currentMenu) {
		Menu.currentMenu = currentMenu;
	}

	public static void switchMenu(String currentMenu) {
		switch (currentMenu) {
		case "0":
			menuMain();
			break;

		case "01":
			menuForestManager();
			break;

		case "011":
			ForestManager.hireForestManager();
			menuBack(currentMenu);
			break;

		case "012":
			ListForestManager.dismissForestManager();  // zoznam FM pod sebou, po zvoleni poradia sa dotycny vymaze
			menuBack(currentMenu);
			break;

		case "013":
			ListForestManager.showForestManagerList();
			menuBack(currentMenu);
			break;

		case "014":
			ForestManager.hireWoodcutter(ListForestManager.getForestManagerList());
			menuBack(currentMenu);
			break;

		case "015":
			ListWoodcutter.dismissWoodcutter();  // zoznam WC pod sebou, po zvoleni poradia sa dotycny vymaze
			menuBack(currentMenu);
			break;

		case "016":
			menuBack(currentMenu, 2);
			break;

		case "02":
			menuWoodcutter();
			break;

		case "021":
			ListWoodcutter.showWoodcutterList();
			menuBack(currentMenu);
			break;

		case "022":
			menuPickAxe();
			menuBack(currentMenu);
			break;

		case "023":
			menuPickBucket();
			menuBack(currentMenu);
			break;

		case "024":
			menuBack(currentMenu, 2);
			break;

		case "03":
			menuTree();
			break;

		case "031":
			menuDeciduousTree();
			break;

		case "0311":
			DeciduousTree.addDeciduousTree();
			menuBack(currentMenu);
			break;

		case "0312":
			ListDeciduousTree.showDeciduousTreeList();
			menuBack(currentMenu);
			break;

		case "0313":
			menuCutDeciduousTree();
			menuBack(currentMenu);
			break;

		case "0314":
			menuBack(currentMenu, 2);
			break;

		case "032":
			menuConiferousTree();
			break;

		case "0321":
			ConiferousTree.addConiferousTree();
			menuBack(currentMenu);
			break;

		case "0322":
			ListConiferousTree.showConiferousTreeList();
			menuBack(currentMenu);
			break;

		case "0323":
			menuCutConiferousTree();
			menuBack(currentMenu);
			break;

		case "0324":
			menuBack(currentMenu, 2);
			break;

		case "033":
			menuBack(currentMenu, 2);
			break;

		case "04":
			nextDay(weather);
			menuBack(currentMenu);
			break;

		default:
			return;  //break;
		}
		currentMenu = getCurrentMenu();
	}
	
	public static void nextDay() {  // defaultne pocasie pre prvy den ("calm")
		nextDay(weather);
		weather.newDay(weather.getCurrentWeather());
	}
	
	public static void nextDay(Weather weather) {
		counterDay++;
		System.out.printf(">>>>> DAY #%d <<<<<", counterDay);
		if(counterDay != firstDay) weather.newDay();
	}

	private static void menuPickBucket() {
		System.out.printf("\n~~~~~~~ Pick Bucket Menu ~~~~~~~\n");
		ListWoodcutter.showWoodcutterList();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		ListWoodcutter.giveBucket();
		
	}

	private static void menuPickAxe() {
		System.out.printf("\n~~~~~~~~ Pick Axe Menu ~~~~~~~~\n");
		ListWoodcutter.showWoodcutterList();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		ListWoodcutter.giveAxe();
	}
	
	private static void menuCutDeciduousTree() {
		System.out.printf("\n~~~~~ Cut Deciduous Tree Menu ~~~~~\n");
		ListDeciduousTree.cutDeciduousTree(ListWoodcutter.getWoodcutterList());
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
	
	private static void menuCutConiferousTree() {
		System.out.printf("\n~~~~~ Cut Coniferous Tree Menu ~~~~~\n");
		ListConiferousTree.cutConiferousTree(ListWoodcutter.getWoodcutterList());
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}

	private static void menuBack(String currentMenu) {
		currentMenu = currentMenu.substring(0, currentMenu.length()-1);  // vymazat poslednu cifru, endIndex je exclusive
		setCurrentMenu(currentMenu);
		switchMenu(getCurrentMenu());
	}
	
	private static void menuBack(String currentMenu, int key) {  // overload
		currentMenu = currentMenu.substring(0, currentMenu.length()-key);
		setCurrentMenu(currentMenu);
		switchMenu(getCurrentMenu());
	}

	private static void menuMain() {
		System.out.printf("\n##### Main Menu #####\n");
		System.out.println("(1) Forest Manager");
		System.out.println("(2) Woodcutter");
		System.out.println("(3) Tree");
		System.out.println("(4) NEXT DAY");
		System.out.println("(5) EXIT");
		System.out.println("#####################");
	}
	
	private static void menuForestManager() {
		System.out.printf("\n***** Forest Manager Menu *****\n");
		System.out.println("(1) Hire forest manager");
		System.out.println("(2) Dismiss forest manager");
		System.out.println("(3) Show all");
		System.out.println("(4) Hire woodcutter");
		System.out.println("(5) Dismiss woodcutter");
		System.out.println("(6) BACK");
		System.out.println("*******************************");
	}
	
	private static void menuWoodcutter() {
		System.out.printf("\n***** Woodcutter Menu *****\n");
		System.out.println("(1) Show all");
		System.out.println("(2) Pick axe");
		System.out.println("(3) Pick bucket");
		System.out.println("(4) BACK");
		System.out.println("***************************");
	}
	
	private static void menuTree() {
		System.out.printf("\n***** Tree Menu *****\n");
		System.out.println("(1) Deciduous trees");
		System.out.println("(2) Coniferous trees");
		System.out.println("(3) BACK");
		System.out.println("*********************");
	}
	
	private static void menuDeciduousTree() {
		System.out.printf("\n~~~~~ Deciduous Tree Menu ~~~~~\n");
		System.out.println("(1) Add deciduous tree");
		System.out.println("(2) Show all");
		System.out.println("(3) Cut deciduous tree");
		System.out.println("(4) BACK");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
	
	private static void menuConiferousTree() {
		System.out.printf("\n~~~~~ Coniferous Tree Menu ~~~~~\n");
		System.out.println("(1) Add coniferous tree");
		System.out.println("(2) Show all");
		System.out.println("(3) Cut coniferous tree");
		System.out.println("(4) BACK");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
}
