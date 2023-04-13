import java.util.ArrayList;


public class EventList {
	
	private static ArrayList<Event> list;

	
	public EventList () {
		list = new ArrayList<Event>();
	}
	
	public void printList() {
		 for (Event event : list) {
			 event.printEvent();
		 }
	}
	
	public void addList(Event newEvent) {
		list.add(newEvent);
	}
}
