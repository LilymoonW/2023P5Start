import java.util.Scanner;

/**
 * Plays a game of Madlibs
 * 
 * @author s-LWHALEN
 *
 */
public class MadLibs {

	public static void main(String[] args) {
		// intro text
		System.out.println("Welcome to the game of Mad Libs.");
		System.out.println("I will ask you to provide various words");
		System.out.println("and phrases to fill in a story.");
		System.out.println("The result will be inputed to an output file.");
		System.out.println("");

		// creates scanner to read from the console
		Scanner console = new Scanner(System.in);

		// main game loop until user quits
		boolean done = false;
		do {
			System.out.print("(C)reate a mad-lib, (V)iew mad-lib, (Q)uit?");
			String command = console.nextLine();
			switch (command.toUpperCase()) {
			case "C":
				break;
			case "V":
				break;
			case "Q":
				done = true;
				break;
			default:
				System.out.println("Command" + command + " is not valid!");
				break;

			}
		} while (!done);

	}

}
