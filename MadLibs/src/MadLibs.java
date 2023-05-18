import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Plays a game of Madlibs
 * 
 * @author s-LWHALEN
 *
 */
public class MadLibs {

	public static void main(String[] args) throws FileNotFoundException {
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
			Scanner input;
			PrintStream output;
			switch (command.toUpperCase()) {
			case "C":
				input = getInputScanner(console);
				output = getOutputPrintStream(console);
				createMadLib(input, output, console);
				input.close();
				output.close();
				break;
			case "V":
				input = getInputScanner(console);
				viewFile(input);
				input.close();
				break;
			case "Q":
				done = true;
				break;
			default:
				System.out.println("Command " + command + " is not valid!");
				break;

			}
		} while (!done);

	}

	/**
	 * Prompts the user for a file name and tries to open it, if it fails, keeps on
	 * prompting
	 * 
	 * @param console
	 * @return
	 * @throws FileNotFoundException
	 */
	public static Scanner getInputScanner(Scanner console) throws FileNotFoundException {
		boolean validFile = false;
		System.out.print("Input file name: ");
		File f = null;
		do {
			f = new File(console.nextLine());
			if (f.exists()) {
				validFile = true;
			} else {
				System.out.println("File not found. Try again:");
			}
		} while (!validFile);

		Scanner input = new Scanner(f);
		return input;
	}

	/**
	 * reads a file line by ine and prints to the console
	 * 
	 * @param input
	 *            -- a scanner to the file
	 */
	public static void viewFile(Scanner input) {
		System.out.println();
		while (input.hasNextLine()) {
			System.out.println(input.nextLine());
		}
		System.out.println();
	}

	/**
	 * Reads a madlib from input and writes to an output
	 * 
	 * @param in
	 * @param out
	 * @param console
	 */
	public static void createMadLib(Scanner in, PrintStream out, Scanner console) {
		out.println("Create File: To Do!");
		while(in.hasNextLine()) {
			String line = in.nextLine();
			Scanner is = new Scanner(line);
			while (is.hasNext()) {
				String token = is.next();
				char first = token.charAt(0);
				char last = token.charAt(token.length()-1);
				if(first == '<' && last == '>') {
					String question = token.substring(1, token.length()-1);
					System.out.print("give me a/an " + question + ": ");
					token = console.nextLine();
				}
				out.print(token + " ");
			}
			out.println();
		}
	}
	public static PrintStream getOutputPrintStream(Scanner console) {
			boolean validF = false;
			PrintStream ps = null;
			do {
					try {
						System.out.print("Output file name: ");
						File f = new File(console.nextLine());
						ps = new PrintStream(f);
						validF = true;
					}
					catch(FileNotFoundException e) {
						System.out.println("File Exception "+ e);
					}
					
			} while (!validF);
			return ps;
	}
	
}
