/*
 * Author:  Tyler Gutowski, Thomas Johnson, Trevor Schiff
 * Course:  CSE 3421, Section 01, Spring 2023
 * Project: Software Design Project
 * Charset: US-ASCII
 */
import java.util.Scanner;

import java.util.ArrayList;

public final class Main {
	public static String username = "";
	public static boolean loggedIn = false;
	public static ArrayList<Student> student_list = new ArrayList<Student>();
	public static void main(String[] args) {
		
		// Things that should happen without our software. We just make this code to replace potential APIs.
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
		trevors_professors.add(professor2);
		trevors_professors.add(professor3);
		Student tyler = new Student("Tyler",
				                    "Gutowski",
									"903643555",
				                    "tgutowski2020@fit.edu",
				                    tylers_professors);
		student_list.add(tyler);
		Note note1 = DoctorOffice.createNote(tyler, "He is so so sick!! So so sick!!", "7:36am 4/13/2023");
		Student trevor = new Student("Trevor",
									 "Schiff",
									 "903123456",
									 "tschiff2020@fit.edu",
									 trevors_professors);
		student_list.add(trevor);
		Note note2 = DoctorOffice.createNote(trevor, "He is so so sick!! So so sick!!", "7:36am 4/13/2023");
		Admissions admissions_office = new Admissions();
		DoctorOffice.faxNote(admissions_office, note1);
		DoctorOffice.faxNote(admissions_office, note2);
				
		// Input
		Scanner sc = new Scanner(System.in);

		int menuNumber = -1;
		Application myApp = new Application();
		
		do {
			while (!loggedIn) {
				myApp.displayLoginScreen();
				username = sc.nextLine();
				loggedIn = myApp.login(username);
			}
			myApp.displayMenu();
			menuNumber = sc.nextInt();
			myApp.createTab(menuNumber);
		} while (menuNumber != 0);
		
		System.out.println("Out");
		sc.close();
	}
}
