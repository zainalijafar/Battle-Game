import java.util.Random;
public class Spell {

	private String name; 
	private double minDamage; 
	private double maxDamage; 
	private double chanceOfSuccess;
	
	public Spell(String name,double minDamage,double maxDamage,double chanceOfSuccess) {
		
		this.name = name; 
		this.minDamage = minDamage;
		this.maxDamage = maxDamage; 
		this.chanceOfSuccess = chanceOfSuccess;
		
		if (minDamage<0 || minDamage>maxDamage || chanceOfSuccess<0 || chanceOfSuccess>1) {
			
			throw new IllegalArgumentException("Illegal input Arguments");
		}
	}
	
	public String getName() {
		
		return this.name;
	}
	
	public double getDamage() {
		
		Random rand = new Random();
		double rando = rand.nextDouble();
		
		if (rando>this.chanceOfSuccess) {
			
			return 0;
			
		}else {
			
			double damage = rand.nextDouble() * (this.maxDamage-this.minDamage) + this.minDamage;
			return damage;
		}
	}
	
	public String toString() {
		
		return "Name : " + this.name + " Minimum " + this.minDamage + " Maximum " + this.maxDamage + " Chance of Success " + this.chanceOfSuccess*100 + " %";
	}
}