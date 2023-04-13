/*
 * Author:  Tyler Gutowski, Thomas Johnson, Trevor Schiff
 * Course:  CSE 3421, Section 01, Spring 2023
 * Project: Software Design Project
 * Charset: US-ASCII
 */
import java.util.Scanner;

import java.util.ArrayList;

public final class Main {
	public static void main(String[] args) {
		
		Professor professor1 = new Professor("Marius",
										     "Silaghi",
										     "msilaghi@fit.edu",
										     false);
		Professor professor2 = new Professor("Phillip",
										     "Chan",
											 "pkchan@fit.edu",
											 true);
		Professor professor3 = new Professor("William",
										     "Shoaff",
											 "wds@fit.edu",
											 false);
		ArrayList<Professor> tylers_professors = new ArrayList<Professor>();
		tylers_professors.add(professor3);
		tylers_professors.add(professor3);
		
		ArrayList<Professor> trevors_professors = new ArrayList<Professor>();
		trevors_professors.add(professor1);
		trevors_professors.add(professor1);
		trevors_professors.add(professor1);
		Student tyler = new Student(

		Student trevor = new Student(
				                     "Tyler",
				                     "Gutowski",
									 "903643555",
				                     "tgutowski2020@fit.edu",
				                     tylers_professors
				                     );
		Student trevor = new Student(
                "trev",
                "orschiff",
				 "1030192313",
                "mr schiff@fit.edu",
                trevors_professors
                );
		tyler.makeApplication();
		trevor.makeApplication();
		Note note = DoctorOffice.createNote("Tyler Gutowski",
								"sick sick boy!!", 
								"today at noon...");
		DoctorOffice.faxNote(note);
	
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
