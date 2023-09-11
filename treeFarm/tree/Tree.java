package treeFarm.tree;

public abstract class Tree {			// STROM
	protected String species, color;
	protected int age;
	protected double height;

	public Tree(String species, String color, int age, double height) {
		this.species = species;
		this.color = color;
		this.age = age;
		this.height = height;
	}
	
	public String isBurning(boolean fire) {  // WIP
		return fire ? "is burning" : "isn't burning";
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	
	
}
