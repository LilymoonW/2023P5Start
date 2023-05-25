import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Graphs a given names popularity by decade from 1890 to 2010
 * 
 * @author s-LWHALEN
 *
 */
public class BbyNamesP5 {
	public static void main(String[] args) throws FileNotFoundException {
		// prompts
		System.out.println("This program searches through the Social");
		System.out.println("Security Service Top name from 1890 to 2010");
		System.out.println("It then graphs the popularity of the name.");
		System.out.println();

		// access user input
		Scanner console = new Scanner(System.in);

		// main loop... keeps asking for names till user types quit
		boolean quit = false;
		while (!quit) {
			Scanner search = new Scanner(new File("names.txt"));
			Scanner meanings = new Scanner(new File("meanings.txt"));
			System.out.print("Enter a name: ");
			String name = console.next();

			name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
			if (name.equals("Quit")) {
				quit = true;
			} else {
				//read the meaning 
				String meaning = getMeaning(name, meanings);
				System.out.println("Name: " + name + " Meaning: " + meaning);
				if(meaning.equals("Not Found")) {
					continue;
				}
			}
		}

	}
	/**tries to find the meaning for a name... returns not found if not found
	 * 
	 * @param name
	 * @param meanings
	 * @return
	 */
	public static String getMeaning(String name, Scanner meanings) {
		name = name.toUpperCase();
		while(meanings.hasNextLine()) {
			Scanner Is = new Scanner(meanings.nextLine());
			if(name.equals(Is.next())) {
				Is.next();
				String meaning = "";
				while(Is.hasNext()) {
						meaning += Is.next() + " ";
						
				}
				return meaning;
			}
		}
		return "Not Found";
		
	}
}
