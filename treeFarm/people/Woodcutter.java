package treeFarm.people;

public class Woodcutter extends Worker implements MyInfo{			// DREVORUBAC
	private boolean hasAxe = false, hasBucket = false;
	private Paycheck paycheck;
	private int deciduousTreeSalary = 55, coniferousTreeSalary = 35;
	
	public Woodcutter(String firstName, String lastName, boolean sex, int age) {
		super(firstName, lastName, sex, age);
		this.paycheck = new Paycheck(0);

	}
	
	// prekonavanie abstract metod
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	
	/////////////////////////////
	// interface implementacia
	public String myFirstName() {
		return getFirstName();
	}
	
	public String myLastName() {
		return getLastName();
	}
	
	public int myAge() {
		return getAge();
	}
	public String mySex() {
		return getSex();
	}
	/////////////////////////////
	
	public int getSalary() {
		return this.paycheck.getMoney();
	}

	public void earnTreeSalary() {		// TBD
		paycheck.addMoney(50);
	}
	
	public void earnDeciduousTreeSalary() {
		paycheck.addMoney(deciduousTreeSalary);
	}
	
	public void earnConiferousTreeSalary() {
		paycheck.addMoney(coniferousTreeSalary);
	}

	public void setBucket(boolean bucket) {
		this.hasBucket = bucket;
	}

	public boolean getBucket() {
		return hasBucket;
	}
	
	public void setAxe(boolean axe) {
		this.hasAxe = axe;
	}

	public boolean getAxe() {
		return hasAxe;
	}

}
