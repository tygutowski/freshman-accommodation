
public class Application {

	private StudentLife studentTab;

	public void displayMenu() {
		System.out.println("---------- Application Menu ----------");
		System.out.println("1. Academic");
		System.out.println("2. Health");
		System.out.println("3. Social");
		System.out.println("4. Cultural");
		System.out.println("5. Mental Health");
		System.out.println("6. Hygiene");
		System.out.println("0. Exit");

		System.out.print("Please select a tab: ");
	}
	

	public void createTab(int n) {
		switch (n) {
			case 1:
				System.out.println("1. Academic");
				break;
			case 2:
				System.out.println("2. Health");
				break;
			case 3:
				studentTab = createStudentTab();
				studentTab.studentTabInterface();
				break;
			case 4:
				System.out.println("4. Cultural");
				break;
			default:
				break;
		}
	}

	private StudentLife createStudentTab() {
		return StudentLife.getInstance();
	}
	
	

}
