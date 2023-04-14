import java.util.HashMap;
import java.util.Scanner;

public class StudentLifeMenu extends MenuBase{
	// Private global variable for the class to access
	
		private static StudentLifeMenu instance = null;
		private static EventList currentEvents = new EventList();
		
		
		// Interface to instantiate global variable once
		public static synchronized StudentLifeMenu getInstance () {
			if (instance == null) {
				instance = new StudentLifeMenu();
			}
			/*
			else {
				System.out.println("Student Life already exists");
			}
			*/
			return instance;
		}
		
		// Constructor
		//private StudentLifeMenu() { }
		

		public StudentLifeMenu() {
			addOption(this::newEvent,                 // handler
					  "new",                       // name
					  "Create a new event");
			addOption(this::displayCurrentEvents,
					  "view",
					  "View current events");
		}

		/*
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
					newEvent();
				}
				else if (input == 2) {
					displayCurrentEvents();
				}

			} while (input != 0);
		}
		*/
		
		// Viewing & Adding Events
		public Boolean newEvent(final HashMap<String, String> args) {
			
			Scanner sc = new Scanner(System.in);
			String title, eventType, date, desc;

			System.out.print("Title: ");
			title = sc.nextLine();

			System.out.print("Event Type: ");
			eventType = sc.nextLine();

			System.out.print("Date: ");
			date = sc.nextLine();

			System.out.print("Description: ");
			desc = sc.nextLine();

			Event newEvent = new Event(title, eventType, date, desc);
			currentEvents.addList(newEvent);

			return false;
		}
		
		public Boolean displayCurrentEvents(final HashMap<String, String> args) {
			currentEvents.printList();
			return false;
		}



		public String getName() {
			return "Student Life Tab";
		}
		
}
