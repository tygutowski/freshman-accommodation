
public class MeditationTab {

	private static MeditationTab instance = null;	
	
	// Interface to instantiate global variable once
	public static synchronized MeditationTab getInstance () {
		if (instance == null) {
			instance = new MeditationTab();
		}
		return instance;
	}
}
