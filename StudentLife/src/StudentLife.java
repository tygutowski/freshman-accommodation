
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
		
		
		// Viewing & Adding Events
		public void newEvent(String title, String eventType, String date, String desc) {
			Event newEvent = new Event(title, eventType, date, desc);
			currentEvents.addList(newEvent);
		}
		
		public void displayCurrentEvents() {
			currentEvents.printList();
		}
		
}
