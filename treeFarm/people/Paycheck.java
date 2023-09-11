package treeFarm.people;

public class Paycheck {		// VYPLATA
	private int money;
	
	public Paycheck(int money) {
		this.money = money;
	}
	
	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public void addMoney(int amount) {
		this.money += amount;
	}
	
}
