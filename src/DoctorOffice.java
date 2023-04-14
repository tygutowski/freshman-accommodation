
public class DoctorOffice {
	// Create a note for the student
	public static Note createNote(Student student, String desc, String date) {
		Note note = new Note(student, 
							 desc,
							 date);
		return note;
	}
	// Fax the note to school admissions
	public static void faxNote(Note note) {
		Admissions.receiveNote(note);
	}
}
