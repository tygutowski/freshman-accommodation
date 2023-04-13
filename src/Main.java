/*
 * Author:  Tyler Gutowski, Thomas Johnson, Trevor Schiff
 * Course:  CSE 3421, Section 01, Spring 2023
 * Project: Software Design Project
 * Charset: US-ASCII
 */
import java.util.Scanner;

public final class Main {
	public static void main(String[] args) {

		/*
		Student trevor = new Student(
				                     "Tyler",
				                     "Gutowski",
									 "903643555",
				                     "tgutowski2020@fit.edu"
				                     );
		Note note = DoctorOffice.createNote("Tyler Gutowski",
								"sick sick boy!!", 
								"today at noon...");
		DoctorOffice.faxNote(note);
	
	*/
		Scanner sc = new Scanner(System.in);

		int menuNumber = -1;
		Application myApp = new Application();


		do {
			myApp.displayMenu();
			menuNumber = sc.nextInt();
			myApp.createTab(menuNumber);

		} while (menuNumber != 0);
		
		System.out.println("Out");
		sc.close();
	}
}
