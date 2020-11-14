import java.util.Arrays;

public class GameCharGenModel 
{
	static public int NUM_CHARS_BLOCK = 500;
	final public int STRENGTH=0; 
	final public int INTELLIGENCE=1; 
	final public int WISDOM=2;
	
	private int gameCharCount=0;
	private GameCharacter[] randomGameChars = new GameCharacter[NUM_CHARS_BLOCK];
	
	/**
	 * Returns the number of randomly-generated characters so far. 
	 * @return Number of randomly-generated characters.
	 */
	public int getNumCharacters()
	{
		return gameCharCount;
	}
	
	/**
	 * Adds a character to the array of characters
	 * @param c character to be added
	 */
	public void addGameCharacter(GameCharacter c)
	{
		if (gameCharCount>=randomGameChars.length)
		{
			GameCharacter[] newRandomChars = Arrays.copyOf(randomGameChars,randomGameChars.length+GameCharGenModel.NUM_CHARS_BLOCK);
			randomGameChars = newRandomChars;
		}
			
		randomGameChars[gameCharCount] = c;
		gameCharCount++;
	}
	
	/**
	 * Returns a character at a given index
	 * @param idx Provided index
	 * @return Character at a given index
	 */
	public GameCharacter gameCharacterAt(int idx)
	{
		if (idx<0 || idx>=randomGameChars.length)
			throw new IndexOutOfBoundsException();
		
		return randomGameChars[idx];
	}
	
	/**
	 * Finds a character with either maximum strength, intelligence or wisdom based on the parameter passed.
	 * @return Index of the character with lowest HP in the character array.
	 * @throws NoGameCharacterFoundException
	 */
	public int getLowestHPGameCharacter() throws NoGameCharacterFoundException
	{
		
		//TODO: (Question 2.1, please modify the body of this method as needed)
		//TODO: If no character found, throw NoCharacterFoundException

		// Took ideas from "https://www.javatpoint.com/java-program-to-find-smallest-number-in-an-array"


		int minimum,minIndex=0; // the minimum count is set to zero
		minimum =randomGameChars[0].hitPoints; // the first value
		for(int i=0;i<gameCharCount;i++){ //checks the entire loop
			if(minimum > randomGameChars[i].hitPoints){
				minimum =randomGameChars[i].hitPoints; // the minimum number
				minIndex=i; // its index
			}
			else if(gameCharCount<0) // unless no charecter is found
				throw new NoGameCharacterFoundException();

		}

		return minIndex; // the minimum index

		
	}
	
	
	public void sortGameCharacterWisdom(boolean ascending) throws NoGameCharacterFoundException
	{
		//TODO: (Question 2.2, please implement code in the body of this method)	
		//TODO: If no character found, throw NoCharacterFoundException

		if(ascending == true) {

			/// Took ideas from "https://www.javatpoint.com/java-program-to-sort-the-elements-of-an-array-in-ascending-order"
			int temp = 0;

			for(int i=0; i < gameCharCount; i++) {
				for(int j= i+1; j <gameCharCount; j++) {
					if(randomGameChars[i].wisdom > randomGameChars[j].wisdom) {

						temp = randomGameChars[i].wisdom;
						randomGameChars[i].wisdom = randomGameChars[j].wisdom;
						randomGameChars[j].wisdom = j; 

					}
				}
			}

			for(int i =0; i < gameCharCount; i++) {
				int result = randomGameChars[i].wisdom; // in ascending order
			}
		} else if(ascending == false) {

			// Took ideas from "https://www.javatpoint.com/java-program-to-sort-the-elements-of-an-array-in-descending-order"

			int temp = 0;

			 //Sort the array in descending order    
			 for (int i = 0; i < gameCharCount; i++) {     
				for (int j = i+1; j < gameCharCount; j++) {     
				   if(randomGameChars[i].wisdom < randomGameChars[j].wisdom) {    
					   temp = randomGameChars[i].wisdom;    
					   randomGameChars[i].wisdom = randomGameChars[j].wisdom;    
					   randomGameChars[j].wisdom = temp;    
				   }     
				}     
			}
			
			///displaying the array

			for (int i = 0; i < randomGameChars[i].wisdom; i++) {     
				int output = randomGameChars[i].wisdom; // in descending order  
			}    
			
		} else if(gameCharCount <0) { // if no character is found

			throw new NoGameCharacterFoundException();
		}

	}

}
