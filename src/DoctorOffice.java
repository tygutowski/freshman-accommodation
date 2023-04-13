
public class DoctorOffice {
	public static Note createNote(String name, String desc, String date) {
		Note note = new Note(name, 
							 desc,
							 date);
		return note;
	}
	public static void faxNote(Note note) {
		Admissions.receiveNote(note);
	}
}
