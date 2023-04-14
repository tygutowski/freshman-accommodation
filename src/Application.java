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
		System.out.println("1. Finding Events");
		System.out.println("2. Creating Events");
		System.out.println("3. ");
		System.out.println("4. ");
		System.out.println("5. ");
		System.out.println("6. Doctors Note");
		System.out.println("7. Crisis Outreach");
		System.out.println("8. Meditation");	
		System.out.println("0. Exit");

		System.out.print("Please select a tab: ");
	}
	

	public void createTab(int n) {
		switch (n) {
			case 1:
				studentTab = createStudentTab();
				studentTab.studentTabInterface();
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				doctorsNoteTab = createDoctorsNoteTab();
				doctorsNoteTab.doctorsNoteTabInterface();
				break;
			case 7:
				crisisOutreachTab = createCrisisOutreachTab();
				crisisOutreachTab.crisisOutreachTabInterface();
				break;
			case 8:
				meditationTab = createMeditationTab();
				meditationTab.meditationTabInterface();
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
