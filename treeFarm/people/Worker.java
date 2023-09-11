package treeFarm.people;

public abstract class Worker {		// PRACOVNIK/ZAMESTNANEC
	protected String firstName, lastName;
	protected boolean sex;  // 0 - female, 1 - male
	protected int age;
	
	public Worker(String firstName, String lastName, boolean sex, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.sex = sex;
		this.age = age;
	}
	
	public abstract String getFirstName();
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public abstract String getLastName();
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getSex() {
		return isSex() ? "male" : "female";
	}
	
	public boolean isSex() {
		return sex;
	}
	
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
}
