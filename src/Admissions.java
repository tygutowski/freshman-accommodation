import java.util.ArrayList;
public class Admissions {
	static ArrayList<Note> note_list = new ArrayList<Note>();

	public void receiveNote(Note note) {
		note_list.add(note);
		uploadToPortal(note);
	}
	public void uploadToPortal(Note note) {
		DoctorsNoteTab.receiveFromPortal(note);
	}
}
