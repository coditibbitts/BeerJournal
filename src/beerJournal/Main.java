// 	Name		: Codi Tibbitts
// 	Program		: Beer Journal
/** Description : User will input a beers information.
 * 				  The program will store the user's beers' information onto
 * 				  a file to be read once started again. Then will also
 *         		  beer information to the console.
 */


package beerJournal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {	
		
		// Variables //
		ArrayList<Beer> userBeer = new ArrayList<Beer>(); // Beer array that holds Beer classes
		
		int amntBeer = 0; // Counts the amount of beers user has entered
		
		File userFile = new File("UserText.txt");
		
		Scanner in = new Scanner(System.in); // Scanner item for inputs
		
		// Start Main part of program
		//
		// Input
		// Brings in file if file currently exists
		if (openUserData(userFile)) {
			
			// If file opens, imports data to Beer ArrayList
			try {
				
				Scanner input = new Scanner(userFile);
				
				while (input.hasNext()) {
									
					inputFileData(userBeer, amntBeer, userFile, input);
					amntBeer = countIncrease(amntBeer);
				}
				
				input.close();
			
			} catch (FileNotFoundException ex) {
				
				System.out.printf("ERROR: %s\n", ex);
				
			}
			
			// Asks if user would like to add more beers to their list
			while (verification("Would you like to add another beer? (Y/N): ", in)) {
				
				userInput(userBeer, amntBeer, in);
				amntBeer = countIncrease(amntBeer);
				
			};
			
		} else {
				
			// If file doesn't exist, asks the user to enter their first beer.
	        // Loop will continue if user wants to continue to add beers;
			do {
				
				userInput(userBeer, amntBeer, in);
				amntBeer = countIncrease(amntBeer);	
				
			} while (verification("Would you like to add another beer? (Y/N): ", in));
		
		}
		
		in.close(); // Closes Scanner
		
		// Output
		// Output Header
		System.out.println("-----------------");
		System.out.println("Your Beers");
		System.out.println("-----------------");
		
		// Output user arraylist to file
		outputToFile(userBeer, amntBeer, userFile);
		
		// Output user arraylist to console
		outputToConsole(userBeer, amntBeer);
		
		//
		// End Main Program
		
	}
	
	
	// Methods
	
	// Asks questions, stores information for strings 
	//
	public static String inputQuestions (String question, String info, Scanner in) {
		
		System.out.print(question);
		info = in.nextLine();
		
		return info;
		
	}
	
	
	// Overloaded Asks questions, stores information for numerics
	//
	public static double inputQuestions(String question, double info, Scanner in) { 
		
		System.out.print(question);
		info = in.nextDouble();
		in.nextLine();
		
		return info;
		
	}
	
	// Grab user inputted info and sets it to the object
	//
	public static void setInfo (ArrayList<Beer> name, String n, String c, String s, 
						 double a, double i, int count) {
			
		name.add(new Beer());
		name.get(count).setName(n);
		name.get(count).setColor(c);
		name.get(count).setStyle(s);
		name.get(count).setABV(a);
		name.get(count).setIBU(i);

	}
	
	// Collects all of user data
	//
	public static void userInput (ArrayList<Beer> name, int count, Scanner in) {
		
		double userABV = -1;	// Holds user entered ABV
		double userIBU = -1;    // Holds user entered IBU
		
		String userColor = "none";  // Holds user entered color
		String userStyle = "none";  // Holds user entered style
		String userName  = "none";  // Holds user entered name		
		
		// User inputs the information for the beer
		userName = inputQuestions("What is the beer's NAME  : ", userName, in);
		userColor = inputQuestions("What is the beer's COLOR : ", userColor, in);
		userStyle = inputQuestions("What is the beer's STYLE : ", userStyle, in);
		userABV = inputQuestions("What is the beer's ABV   : ", userABV, in);
		userIBU = inputQuestions("What is the beer's IBU   : ", userIBU, in);		

		// Sets Users information to the object
		setInfo(name, userName, userColor, userStyle, userABV, userIBU, count);
		
	}
	
	/** Checks if user already has data. If they do, opens file then
	* returns a boolean. File will be closed in another function if
	* successfully opened.
	*/ 
	public static Boolean openUserData(File file) {
		
	    /** If this program has never been run, it'll see that no file exists
	    * at the end of the program it'll create a file, so on start up,
	    * this will flag the program to read the data from the file,
	    * and store it into an arraylist	
	    */
		if (file.exists()) {
			
			System.out.println("You already have beers! Importing data!");
			return true;
			
		} else {
			
			return false;
			
		}
		
	}
	
	// Inputs data from opened file into ArrayList
	//
	public static void inputFileData(ArrayList<Beer> name, int count, File file, Scanner in) {
		
		double userABV = -1;	// Holds user entered ABV
		double userIBU = -1;    // Holds user entered IBU
		
		String userColor = "none";  // Holds user entered color
		String userStyle = "none";  // Holds user entered style
		String userName  = "none";  // Holds user entered name		
		
		// Reads file line by line for object data
		userName = in.nextLine();
		userStyle = in.nextLine();
		userColor = in.nextLine();
		userABV = in.nextDouble();
		userIBU = in.nextDouble();
		
		// Checks if file has next line, if it does
		// clears out \n so it'll continue to be read
		if (in.hasNext()) {
			in.nextLine();
			
		}
		
		// Sets Users information to the object
		setInfo(name, userName, userColor, userStyle, userABV, userIBU, count);
			
	}
	
	// Adds +1 to the amount of beer counter
	//
	public static int countIncrease(int count) {
		
		count++;
		return count;
		
	}
	
	// Checks if a user input is valid, changes answer to caps if it is,
	// asks user to re-enter their answer if answer is not valid
	//
	public static char yesnoValid (char input, Scanner in) {
		
		boolean verified = false; // Flag for validation
		
		// Will repeat loop as long user input returns false
		do {
			
			// If answer is acceptable here, will return true
			if (input == 'y' || input == 'Y' 
		            || input == 'n' || input == 'N') {
				
				if (input == 'y') {
	                input = 'Y';
	 
	            }
				
				if (input == 'n') {
	                input = 'N';
	 
	            }
				
				verified = true;
				
			} else if (input != 'y' && input != 'Y' 
	                   && input != 'n' && input != 'N') {
				
				// If answer is unacceptable, will ask user to re-enter answer
				System.out.println("'" + input +"'" + " is not a valid input.");
				System.out.println("Please enter 'Y' for yes, or 'N' for no: ");
				in.next().charAt(0);
				
			}
			
		} while (verified == false);
		
		return input;
		
	}
	
	// Verification question with an input validation function inside
	//
	public static Boolean verification(String question, Scanner in) {
		
		char answer; // User answer to verification question
		
		System.out.print(question);
		answer = in.next().charAt(0);
		in.nextLine();
		System.out.println();
		
		// Checks if answer is valid and returns bool
		if (yesnoValid(answer, in) == 'Y') {
			
			return true;
			
		} else {
			
			return false;
			
		}
				
	}
	
	// Outputs information to console for user to see
	//
	public static void outputToConsole (ArrayList<Beer> name, int count) {
		// Loops through Beer::name vector and calls an object method
	    // to output all of the objects information
		for (int i = 0; i < count; i++) {
			name.get(i).outputBeer();
			
			// Won't add an extra std::endl if on the last
	    	// user inputted beer
			if (i < (count - 1)) {
				System.out.println();
			
			}
			
		}
	
	}
	
	// Output the user's beers to file to be saved and read when program
	// is ran once more
	public static void outputToFile (ArrayList<Beer>name, int count, File file) {	
		
		// Writes User Beer info to a file
		try {
			PrintWriter output = new PrintWriter(file);
			for (int i = 0; i < count; i++) {
				
				output.println(name.get(i).getName());
				output.println(name.get(i).getColor());
				output.println(name.get(i).getStyle());
				output.println(name.get(i).getABV());
				output.print(name.get(i).getIBU());
				
				if (i < (count - 1)) {
					
					output.println();	
					
				}
			}
			
			output.close();
			
		} catch (IOException ex) {
			
			System.out.printf("ERROR: %s\n", ex);
			
		}
		
	}

}
