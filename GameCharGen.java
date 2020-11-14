import java.util.Scanner;

public class GameCharGen 
{
	
	public static void main(String[] args)  throws NoGameCharacterFoundException
	{
		GameCharGenModel myCharGen = new GameCharGenModel();
		Scanner menuInput = new Scanner(System.in);

		while (true) { //to ensure that the program doesn't end after taking the command

			// TODO: Implement menu output to user (Questions 1.1, 2.3)	

			try { // try the method
				// The Menu
				System.out.println("*** WoK GameCharGen Menu***");
				System.out.println("Create Wizard WZ");
				System.out.println("Create Fighter FZ");
				System.out.println("Create Cleric CL");
				System.out.println("Get Lowest Hit Points LHC");
				System.out.println("Sort Characters Asc. SCA");
				System.out.println("Sort Characters Desc. SCD");
				System.out.println("Display Characters DC");
				System.out.println("Exit Program EX");
				// The Menu //
				
				
			// TODO: Process user input (Questions 1.1, 2.3)

				String output = menuInput.nextLine(); // the input from the user

				/// Handling User Input and Calling various methods

				if(output.toUpperCase().equals("WZ")) { // wizardObj

					Wizard wz = new Wizard();
					wz.randGen(true);
					wz.display(); //displays its properties
					myCharGen.addGameCharacter(wz); // added to the array
					
					
				} else if(output.toUpperCase().equals("EX")) { // if the user tries to exit

					menuInput.close();
					System.out.println("***************");
					System.out.println("Quitting now...");
					System.out.println("***************");
					System.exit(0);
					break; //breaks from the loop and the program terminates

				} else if(output.toUpperCase().equals("FZ")) { //fighterObj

					Fighter fg = new Fighter();
					fg.randGen(false);
					fg.display(); // displays its atributes
					myCharGen.addGameCharacter(fg); //added to the array
					
				} else if(output.toUpperCase().equals("CL")) { //clerObj

					Cleric cl = new Cleric();
					cl.randGen(false);
					cl.display(); // displays its atributes
					myCharGen.addGameCharacter(cl); //added to the array

				} else if (output.toUpperCase().equals("LHC")) { // lowest hit points

					int idx = myCharGen.getLowestHPGameCharacter();
					System.out.println("Game Character " + idx + " has lowest HP");
					myCharGen.gameCharacterAt(idx).display();

				} else if(output.toUpperCase().equals("DC")) { //display characters

					int ctotal = myCharGen.getNumCharacters(); // gets the number of character
					for(int i=0; i< ctotal; i++) {

						myCharGen.gameCharacterAt(i).display(); //invokes the diplay method

					}
					
				} else if(output.toUpperCase().equals("SCA")) { // ascending order

					myCharGen.sortGameCharacterWisdom(true);

				} else if(output.toUpperCase().equals("SCD")) { // descending order

					myCharGen.sortGameCharacterWisdom(false);

				} else { //any other commands

					System.out.println("Unrecognised command.");
				}

			} catch (NoGameCharacterFoundException e) { // catch the method


			}
		}
	}
}