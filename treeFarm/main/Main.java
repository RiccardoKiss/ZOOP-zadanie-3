package treeFarm.main;

import java.util.Scanner;

import treeFarm.casting.WoodcutterCasting;
import treeFarm.casting.WorkerCasting;

public class Main {

	public static void main(String[] args) {
		
		WorkerCasting testWorker = new WorkerCasting();
		WorkerCasting testWoodcutter = new WoodcutterCasting();  // upcasting
		testWorker.print();
		testWoodcutter.print();
		//testWoodcutter.casting();  // compile error
		((WoodcutterCasting)testWoodcutter).casting();  // downcasting
		//((WoodcutterCasting)testWorker).casting();  // runtime error
		
		String currentMenu = "" + 0;  // aby som mohol lahko menit na stavy (vid. Menu.java), napr. 03+1=031 stav 
		Scanner scannerMain = new Scanner(System.in);
		Menu.nextDay();
		while(true) {
			currentMenu = Menu.getCurrentMenu();  // potrebujem returnovat hodnotu currentMenu z Menu.java do Mainu
			Menu.switchMenu(currentMenu);
			System.out.printf("Main>> ");
			currentMenu = Menu.getCurrentMenu();  // !!!musim ho znova getnut lebo vo switchMenu() sa menil currentMenu v Menu.java
			currentMenu += scannerMain.nextInt();
			if (currentMenu.equals("05")) {		// ked zadam na vstupe kod pre stav "EXIT" programu
				break;
			} else {
				Menu.setCurrentMenu(currentMenu);
			}
		}
		scannerMain.close();
	}
}
