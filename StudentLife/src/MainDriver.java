
public class MainDriver {
	public static void main (String args[]) {
		
		Application myApp = new Application();
		
		myApp.displayMenu();
		
		StudentLife studentTab = myApp.createStudentTab();
		studentTab.newEvent("Donuts", "SGA", "4/14/2023", "Donuts in crawford greens :)");
		studentTab.newEvent("Crawford jump", "Mental Health", "4/15/2023", "Annual pre exam suicide jump");
		
		studentTab.displayCurrentEvents();
	}
}
