
public class DoctorOffice {
	public static Note createNote(Student student, String desc, String date) {
		Note note = new Note(student, 
							 desc,
							 date);
		return note;
	}
	public static void faxNote(Note note) {
		Admissions.receiveNote(note);
	}
}
