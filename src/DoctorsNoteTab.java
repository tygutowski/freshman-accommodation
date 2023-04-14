import java.util.ArrayList;
import java.util.Scanner;

public class DoctorsNoteTab {

	static ArrayList<DoctorsNoteForm> form_list = new ArrayList<DoctorsNoteForm>();
	static ArrayList<Note> note_list = new ArrayList<Note>();
	private static DoctorsNoteTab instance = null;
	
	// Interface to instantiate global variable once
	public static synchronized DoctorsNoteTab getInstance() {
		if (instance == null) {
			instance = new DoctorsNoteTab();
		}
		return instance;
	}
		
	public void studentTabInterface() {
		
		Scanner sc = new Scanner(System.in);
		int input = -1;
		System.out.println("---------- Doctors Note Tab ----------");
		do {
			System.out.println("1. Create Form");
			System.out.println("2. View Form Results");
			System.out.println("0. Go Back");

			System.out.print("Please select an action: ");
			input = sc.nextInt();

			if (input == 1) {
				createForm();
			}
			else if (input == 2) {
				viewResults();
			}

		} while (input != 0);
	}
	
	public void createForm() {
		DoctorsNoteForm app = new DoctorsNoteForm();
		app.student = Application.student;
		app.giveDecision();
	}
	
	public void viewResults() {
		for(DoctorsNoteForm form : form_list) {
			if(form.student.equals(Application.username)) {
				System.out.println("Form accepted: " + Boolean.toString(form.accepted));
			}
		}
	}
	
	public static void receiveFromPortal(Note note) {
		note_list.add(note);
	}
}
