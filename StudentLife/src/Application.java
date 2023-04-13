
public class Application {
	
	public void displayMenu() {
		System.out.println("Academic");
		System.out.println("Health");
		System.out.println("Social");
		System.out.println("Cultural");
		System.out.println("Mental Health");
		System.out.println("Hygiene");
	}
	
	public StudentLife createStudentTab() {
		return StudentLife.getInstance();
	}
	
}
