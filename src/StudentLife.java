
import java.util.Scanner;

public class StudentLife {
	// Private global variable for the class to access
	
		private static StudentLife instance = null;
		private static EventList currentEvents = new EventList();
		
		
		// Interface to instantiate global variable once
		public static synchronized StudentLife getInstance () {
			if (instance == null) {
				instance = new StudentLife();
			}
			else {
				System.out.println("Student Life already exists");
			}
			return instance;
		}
		
		// Constructor
		private StudentLife() { }
		
		public void studentTabInterface() {
			
			Scanner sc = new Scanner(System.in);
			int input = -1;
			System.out.println("---------- Social Hub ----------");
			do {
				System.out.println("1. Add Event");
				System.out.println("2. View Events");
				System.out.println("0. Go Back");

				System.out.print("Please select an action: ");
				input = sc.nextInt();

				if (input == 1) {
					newEvent("Donuts", "SGA", "4/14/2023", 
					"Donuts in crawford greens :)");
				}
				else if (input == 2) {
					displayCurrentEvents();
				}

			} while (input != 0);
		}
		
		// Viewing & Adding Events
		public void newEvent(String title, String eventType, String date, String desc) {
			Event newEvent = new Event(title, eventType, date, desc);
			currentEvents.addList(newEvent);
		}
		
		public void displayCurrentEvents() {
			currentEvents.printList();
		}
		
}
