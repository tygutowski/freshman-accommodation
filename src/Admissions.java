import java.util.ArrayList;
public class Admissions {
	static ArrayList<Note> note_list = new ArrayList<Note>();
	// Get the note from the doctors office
	public static void receiveNote(Note note) {
		note_list.add(note);
		uploadToPortal(note);
	}
	// Upload the doctors note to the portal
	public static void uploadToPortal(Note note) {
		DoctorsNoteMenu.receiveFromPortal(note);
	}
}
