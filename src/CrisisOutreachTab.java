
public class CrisisOutreachTab {

	private static CrisisOutreachTab instance = null;	
	
	// Interface to instantiate global variable once
	public static synchronized CrisisOutreachTab getInstance () {
		if (instance == null) {
			instance = new CrisisOutreachTab();
		}
		return instance;
	}

	public void crisisOutreachTabInterface() {
		// TODO Auto-generated method stub
		
	}
}
