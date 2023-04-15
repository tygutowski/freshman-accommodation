import java.util.HashMap;


public class HygieneMenu extends MenuBase{
	// Private global variable for the class to access
	
		private static HygieneMenu instance = null;
		
		// Interface to instantiate global variable once
		public static synchronized HygieneMenu getInstance () {
			if (instance == null) {
				instance = new HygieneMenu();
			}

			return instance;
		}
		
		// Constructor
		//private StudentLifeMenu() { }
		

		public HygieneMenu() {
			addOption(this::reminder,                 // handler
					  "new",                       // name
					  "Temp for now, idk what to do lol");

		}

		
		// Viewing & Adding Events
		public Boolean reminder(final HashMap<String, String> args) {
			
			

			return false;
		}




		public String getName() {
			return "Hygiene Tab";
		}
		
}
