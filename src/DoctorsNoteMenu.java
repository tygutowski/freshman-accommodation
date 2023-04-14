import java.util.ArrayList;
import java.util.HashMap;

public class DoctorsNoteMenu extends MenuBase {

	static ArrayList<DoctorsNoteForm> form_list = new ArrayList<DoctorsNoteForm>();
	static ArrayList<Note> note_list = new ArrayList<Note>();
	private static DoctorsNoteMenu instance = null;
	
	// Interface to instantiate global variable once
	public static synchronized DoctorsNoteMenu getInstance() {
		if (instance == null) {
			instance = new DoctorsNoteMenu();
		}
		return instance;
	}
	// Create a form to request an excused absence
	public Boolean createForm(final HashMap<String, String> args) {
		ArrayList<Note> notes_to_remove = new ArrayList<Note>();
		boolean notesFound = false;
		for (Note note : note_list) {
			if(note.getStudent().equals(LoginMenu.student)) {
				System.out.println("Doctor's note form created. Check in later to see if its been approved.");
		 		DoctorsNoteForm form = new DoctorsNoteForm();
				form.student = LoginMenu.student;
				form.giveDecision();
				form_list.add(form);
				notes_to_remove.add(note);
				notesFound = true;
			}
		}
		for (Note note : notes_to_remove) {
			note_list.remove(note);
		}
		if (!notesFound) {
			System.out.println("You have no doctor's notes to submit!");
		}
		return false;
	}
	//  View the results on the students form
	public Boolean viewResults(final HashMap<String, String> args) {
		boolean form_found = false;
		for(DoctorsNoteForm form : form_list) {
			if(form.student == LoginMenu.student) {
				form_found = true;
				System.out.println("Form accepted: " + Boolean.toString(form.accepted));
			}
		}
		if (!form_found) {
			System.out.println("You have no forms submitted.");
		}
		return false;
	}
	// Receive the doctors note from the portal
	public static void receiveFromPortal(Note note) {
		note_list.add(note);
	}

	public DoctorsNoteMenu() {
		addOption(this::createForm,                 // handler
				  "new",                       // name
				  "Create a new form");
		addOption(this::viewResults,
				  "view",
				  "View your previously submitted form");
	}
	
	public String getName() {
		return "Doctors Note Tab";
	}
}
