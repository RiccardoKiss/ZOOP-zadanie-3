package treeFarm.tree;

import java.util.concurrent.ThreadLocalRandom;

public class Weather {
	private String[] weatherScenarios = {"calm", "hot", "raining", "snowing", "windy"};	// typy pocasia
	private int minScenarios = 0, maxScenarios = 4, randomInt;
	private String currentWeather;
	
	public Weather(String currentWeather) {
		this.currentWeather = currentWeather;
	}
	
	public String getCurrentWeather() {
		return currentWeather;
	}

	public void setCurrentWeather(String currentWeather) {
		this.currentWeather = currentWeather;
	}
	
	public String toString() {	// override java.lang.Object.toString()
		return "\nCurrent weather is " + getCurrentWeather();
	}
	
	public void newDay() {	// pocasie sa nahodne meni kazdy den z dostupnych typov
		randomInt = ThreadLocalRandom.current().nextInt(minScenarios, maxScenarios + 1);
		String setWeather = weatherScenarios[randomInt];
		setCurrentWeather(setWeather);
		System.out.println(toString());
	}
	
	public void newDay(String setWeather) {	// overload
		setCurrentWeather(setWeather);
		System.out.println(toString());
	}
	
}
