
public class Event {
	private String title;
	private String eventType;
	private String date;
	private String desc;
	
	public Event (String title, String eventType, String date, String desc) {
		this.title = title;
		this.eventType = eventType;
		this.date = date;
		this.desc = desc;
	}
	
	public void printEvent () {
		System.out.println("---------\n");
		System.out.println(title + "\n" + eventType + " " +date + "\n" + desc + "\n");
		System.out.println("---------");
	}
}
