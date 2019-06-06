import java.util.*;

public class BattleGame {

	private Scanner reader; 
	
	public BattleGame() {
		this.reader = new Scanner(System.in);
	}
	
	public void playGame() {
		
		double damage = 0;
		
		Character player = FileIO.readCharacter("C:\\Users\\Zain Ali\\Documents\\BattleGame\\src\\Player.txt");
		player.printInfo();

		Character monster = FileIO.readCharacter("C:\\Users\\Zain Ali\\Documents\\BattleGame\\src\\Monster.txt");
		monster.printInfo();

		ArrayList<Spell> spellList = new ArrayList<>(); 
		spellList = FileIO.readSpells("C:\\Users\\Zain Ali\\Documents\\BattleGame\\src\\SpellList.txt");
		System.out.println("Spell List : ");
		System.out.println(spellList);
		
		player.setSpell(spellList);
		
		while (player.getCurrHealthVal()>0 && monster.getCurrHealthVal()>0) {
			
			System.out.println("Enter a command : Attack or Quit");
			String input = this.reader.nextLine();
			
			if (input.equals("Attack")) {
				
				if (player.getCurrHealthVal()>0) {
					
					doAttack(player,monster);
					System.out.println();
				}
				
				if (monster.getCurrHealthVal()>0) {
					
					doAttack(monster,player);
				}
				
			}else if (input.equals("Quit")) {
				
				System.out.println("Thank you for playing");
				return;
				
			}else {
				
				if (player.getCurrHealthVal()>0) 
					
				damage = player.castSpell(input);
				monster.takeDamage(damage);
				
				if (damage>0) {
					System.out.println(player.getName() + " casted a spell " + input + " with damage " + damage);
					System.out.println(monster.getName() + " takes " + damage + " damage");
				}
				
				else if (damage==0) {
					
					System.out.println(player.getName() + " tried casting a spell but failed");
				}
				
				System.out.println("Name : " + monster.getName() + " Health : " + monster.getCurrHealthVal());
			}
			
			if (monster.getCurrHealthVal()>0) {
				
				doAttack(monster,player);
			}
		}
		
		if (player.getCurrHealthVal()<=0) {
			
			System.out.println("Congratulations, the monster has won the game");
			monster.increaseWins();
			System.out.println("Number of wins for " + monster.getName() + " are " + monster.getNoWins());
			
//			FileIO.writeCharacter(monster,"C:\\Users\\Zain Ali\\Documents\\BattleGame\\src\\Monster.txt");
			
		}else if (monster.getCurrHealthVal()<=0) {
			
			System.out.println("Congratulations, the player has won the game");
			player.increaseWins();
			System.out.println("Number of wins for " + player.getName() + " are " + player.getNoWins());
//			FileIO.writeCharacter(player,"C:\\Users\\Zain Ali\\Documents\\BattleGame\\src\\Player.txt");
		}
	}
	
	public void doAttack(Character firstPlayer, Character secondPlayer){
		
		double attack = firstPlayer.calcAttack();
		System.out.println(firstPlayer.getName() + " attacks for " + attack + " damage ");
		System.out.println(secondPlayer.getName() + " takes " + attack + " damage");
		secondPlayer.takeDamage(attack);
		System.out.println("Name : " + secondPlayer.getName() + " Current Health : " + secondPlayer.getCurrHealthVal());
		
		if (secondPlayer.getCurrHealthVal()>0) {
			
			System.out.println(secondPlayer.getName() + " current health " + secondPlayer.getCurrHealthVal());
		}else {
			
			System.out.println(secondPlayer.getName() + " was knocked out");
		}
	}
}