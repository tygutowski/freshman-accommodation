import java.util.ArrayList;
import java.util.HashMap;

public class CrisisOutreachMenu extends MenuBase {

	private static CrisisOutreachMenu instance = null;	
	public static ArrayList<CrisisOutreachForm> form_list = new ArrayList<CrisisOutreachForm>();
	// Interface to instantiate global variable once
	public static synchronized CrisisOutreachMenu getInstance () {
		if (instance == null) {
			instance = new CrisisOutreachMenu();
		}
		return instance;
	}

	public void crisisOutreachTabInterface() {
		return;
	}

	public CrisisOutreachMenu() {
		addOption(this::createQuestionnaire,                 // handler
				  "new",                       // name
				  "Fill out a questionnaire about your mental health");
		addOption(this::beginCall,
				  "call",
				  "Begin a phone call with any available counselors");
	}
	// Go to Questionnaire menu
	public Boolean createQuestionnaire(final HashMap<String, String> args) {
		MenuManager.enterMenu(new CrisisOutreachQuestionnaire());
		return true;
	}
	// Enter a Zoom call (Pseudocode)
	public Boolean beginCall(final HashMap<String, String> args) {
		System.out.println("No Zoom API. Sorry!");
		// If student is being called by counselor
		// Student can answer via Zoom
		return true;
	}
	
	public String getName() {
		return "Crisis Outreach Tab";
	}
}
