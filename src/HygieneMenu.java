import java.util.HashMap;
import java.time.LocalTime;

public class HygieneMenu extends MenuBase{
	// Private global variable for the class to access
	
		private static HygieneMenu instance = null;
        private static LocalTime currentTime;
        private static int hour;
        private int brushNotifs = 0;
		
		// Interface to instantiate global variable once
		public static synchronized HygieneMenu getInstance () {
			if (instance == null) {
				instance = new HygieneMenu();
			}

			return instance;
		}

		public HygieneMenu() {

            addOption(this::setTime,                 // handler
					  "set",                       // name
					  "Set current time to begin loggin");

			addOption(this::checkReminder,                 // handler
					  "notifs",                       // name
					  "Check for any available hygiene notifs");

            addOption(this::brushTeeth,                 // handler
					  "brush",                       // name
					  "Clear brush notifs");

		}

		public Boolean checkReminder(final HashMap<String, String> args) {
			
            LocalTime newTime = LocalTime.now();
            int newHour = newTime.getHour();


            int hourDiff = Math.abs(newHour - hour);

            System.out.println(hourDiff);
            if (hourDiff >= 8) {
                brushNotifs++;
            }

            System.out.println("You are currently " +brushNotifs +" brush(es) behind!");

			return false;
		}

        public Boolean brushTeeth (final HashMap<String, String> args) {

            brushNotifs = 0;
            setTime(null);

            return false;
        }

        public Boolean setTime (final HashMap<String, String> args) {

            currentTime = LocalTime.now();
            hour = currentTime.getHour();

            return false;
        }

		public String getName() {
			return "Hygiene Tab";
		}
		
}
