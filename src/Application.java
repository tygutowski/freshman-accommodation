public class Application {

	public static String username = "";
	public static Student student = null;
	private static StudentLifeTab studentTab;
	private static DoctorsNoteTab doctorsNoteTab;
	private static CrisisOutreachTab crisisOutreachTab;
	private static MeditationTab meditationTab;	
	
	public void displayLoginScreen() {
		System.out.println("---------- Login Menu ----------");
		System.out.println("Enter username: ");
	}
	
	public boolean login(String user) {
		Application.username = user;
		for(Student stu : Main.student_list) {
			if (user.equals(stu.username)) {
				student = stu;
				System.out.println("Logged in as " + student.first_name + " " + student.last_name);
				return true;
			}
		}
		System.out.println("You are not in the system. Try again.");
		return false;
	}
	
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
			case 5:
			
				break;
			case 6:
				doctorsNoteTab = createDoctorsNoteTab();
				//doctorsNoteTab.doctorsNoteTabInterface();
				break;
			case 7:
				crisisOutreachTab = createCrisisOutreachTab();
				//crisisOutreachTab.crisisOutreachTabInterface();
				break;
			case 8:
				meditationTab = createMeditationTab();
				//meditationTab.meditationTabInterface();
				break;
			default:
				break;
		}
	}

	private StudentLifeTab createStudentTab() {
		return StudentLifeTab.getInstance();
	}
	private DoctorsNoteTab createDoctorsNoteTab() {
		return DoctorsNoteTab.getInstance();
	}
	private CrisisOutreachTab createCrisisOutreachTab() {
		return CrisisOutreachTab.getInstance();
	}
	private MeditationTab createMeditationTab() {
		return MeditationTab.getInstance();
	}
}
