
public class CrisisOutreachMenu {

	private static CrisisOutreachMenu instance = null;	
	
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
}
