import java.io.*;
import java.util.*;

public class FileIO {

	public FileIO() {
	}
	
	public static Character readCharacter(String fileName) {
		
		try {
			
			FileReader file = new FileReader(fileName);
			BufferedReader reader = new BufferedReader(file);
			
			String name = reader.readLine();
			String attackVal = reader.readLine();
			String maxHealthVal = reader.readLine();
			String numberOfWins = reader.readLine();
			
			double attackValue = Double.parseDouble(attackVal);
			double maxHealthValue = Double.parseDouble(maxHealthVal);
			int wins = Integer.parseInt(numberOfWins);
			
			Character character = new Character(name,attackValue,maxHealthValue,wins); 
			
			reader.close();
			
			return character;
			
		}catch (FileNotFoundException e) {
			
			throw new IllegalArgumentException(fileName + " : file not found");	
		
		}catch (IOException e) {
			
			throw new IllegalArgumentException(fileName + " has IOException");
		}
	}
	
	public static ArrayList<Spell> readSpells(String fileName){
		
		try {
			
			FileReader file = new FileReader(fileName);
			BufferedReader reader = new BufferedReader(file);
			
			ArrayList<Spell> spellList = new ArrayList<>();
			
			String line = reader.readLine();
			
			while (line!= null){
				
				String [] spellCharac = line.split(" ");
				String name = spellCharac[0];
				String minDamage = spellCharac[1]; 
				String maxDamage = spellCharac[2];
				String chanceOfSuccess = spellCharac[3];
			
				Double minDamage1 = Double.parseDouble(minDamage);
				Double maxDamage1 = Double.parseDouble(maxDamage);
				Double chanceOfSuccess1 = Double.parseDouble(chanceOfSuccess);
				
				Spell spell = new Spell(name,minDamage1,maxDamage1,chanceOfSuccess1);
				
				spellList.add(spell);
				
				line = reader.readLine();
			}
			
			reader.close();
			
			return spellList;
			
		}catch (FileNotFoundException e) {
			
			throw new IllegalArgumentException(fileName + " file not found");
			
		}catch (IOException e ) {
			
			throw new IllegalArgumentException(fileName + " has IOException");
		}
	}
	
	public static void writeCharacter(Character character,String fileName) {
		
		try {
			
			FileWriter writer = new FileWriter(fileName);
			BufferedWriter br = new BufferedWriter(writer);
			
			String name = character.getName();
			Double attackValue = character.getAttackVal();
			String attackVal = Double.toString(attackValue);
			Double maxHealth = character.getCurrHealthVal();
			String maxHeath = Double.toString(maxHealth);
			int wins = character.getNoWins();
			String win = Double.toString(wins);
			
			br.write(name);
			br.write(attackVal);
			br.write(maxHeath);
			br.write(win);
			
			br.close();
			
		}catch (FileNotFoundException e) {
			
			throw new IllegalArgumentException(fileName + " file not found");
			
		}catch(IOException e) {
			
			throw new IllegalArgumentException(fileName + " has IOException ");
		}
	}
}