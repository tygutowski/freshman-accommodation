import java.util.ArrayList;
public class Admissions {
	static ArrayList<Note> note_list = new ArrayList<Note>();

	public static void receiveNote(Note note) {
		note_list.add(note);
		uploadToPortal(note);
	}
	public static void uploadToPortal(Note note) {
		DoctorsNoteMenu.receiveFromPortal(note);
	}
}
