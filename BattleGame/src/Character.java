import java.util.*;
public class Character {

	private String name;
	private double attackVal;
	private double maxHealthVal;
	private double currHealthVal;
	private int wins;
	private static ArrayList<Spell> spellList; 
	
	public Character(String name,double attackVal,double maxHealthVal,int wins) {
		
		this.name = name;
		this.attackVal = attackVal;
		this.maxHealthVal = maxHealthVal;
		this.wins = wins;
		this.currHealthVal = maxHealthVal;
		this.spellList = new ArrayList<>();
	}
	
	public void setSpell(ArrayList<Spell> spellList) {
		
		this.spellList = spellList;
	}
	
	public ArrayList<Spell> getSpell() {
		
		return this.spellList;
	}
	
	public double castSpell(String spellName) {
		
		double damage = 0;
		
		for (int i=0; i<this.spellList.size(); i++) {
			
			if (this.spellList.get(i).getName().equals(spellName)){
				
				System.out.println("The spell was found");
				damage = this.spellList.get(i).getDamage();
				return damage;
			}
		
		}
		System.out.println("the spell was not found");
		return 0;
	}
	
	public String getName() {
		
		return this.name;
	}
	
	public double getCurrHealthVal() {
		
		return this.currHealthVal;
	}
	
	public double getAttackVal() {
		
		return this.attackVal;
	}
	
	public int getNoWins() {
		
		return this.wins;
	}
	
	public String toString() {
		
		return "Name: " + this.name + " Current Health: " + this.currHealthVal;
	}
	
	public double calcAttack() {
		
		Random rand = new Random();
		double rando = rand.nextDouble()*0.4 + 0.3;
		
		double finalRando = rando * getAttackVal();
		return finalRando;
	}
	
	public void takeDamage(double damage) {
		
		this.currHealthVal = this.currHealthVal - damage;
	}
	
	public void increaseWins() {
		
		this.wins++;
	}
	
	public void printInfo() {
		
		System.out.println("Name : " + this.name + " Health : " + this.currHealthVal + " Attack Value : " + this.attackVal + " Number of wins : " + this.wins);
	}
}