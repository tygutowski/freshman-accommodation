import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class MeditationMenu extends MenuBase {

	private static MeditationMenu instance = null;	
	public static ArrayList<CrisisOutreachForm> form_list = new ArrayList<CrisisOutreachForm>();
	// Interface to instantiate global variable once
	public static synchronized MeditationMenu getInstance () {
		if (instance == null) {
			instance = new MeditationMenu();
		}
		return instance;
	}

	public void crisisOutreachTabInterface() {
		return;
	}

	public MeditationMenu() {
		addOption(this::setDuration,                 // handler
				  "setduration",                       // name
				  "Set the duration of your meditation session",
				  new Arg("time", "The time, in seconds, that you want to meditate for"));
		addOption(this::setTime,
				  "settime",
				  "Begin a phone call with any available counselors",
				  new Arg("time", "The time, in military time, that you want to schedule a meditation appointment for"));
	}
	// Sets the duration of the meditation session
	public Boolean setDuration(final HashMap<String, String> args) {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run() {
			    notify("\nYour meditation session for " + args.get("time") + "seconds is over!");
			}
		}, Integer.parseInt(args.get("time")) * 1000);
		return false;
	}
	// Sets the time a meditation session should start
	public Boolean setTime(final HashMap<String, String> args) {
		Timer timer = new Timer();
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(args.get("time").substring(0,2))); 
		calendar.set(Calendar.MINUTE, Integer.parseInt(args.get("time").substring(2,4))); 
		Date time = calendar.getTime(); // Get the time as a Date object
		timer.schedule(new TimerTask() {
		    public void run() {
		        notify("\nIt's time for your daily meditation!");
		    }
		}, time);
		return false;
	}
	
	// Sends a notification to the student
	public void notify(String notification) {
		System.out.println(notification);
	}
	
	public String getName() {
		return "Meditation Tab";
	}
}
