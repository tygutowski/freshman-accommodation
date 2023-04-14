import java.util.ArrayList;
import java.util.List;
public class Student implements Person {
	String first_name = "John";
	String last_name = "Doe";
	String email = "jdoe0000@fit.edu";
	String student_id = "900000000";
	String username = "";
	boolean sick = false;
	List<Professor> professors = null;
	public Student (String first, String last, String id, String student_email, List<Professor> list, boolean feeling_sick) {
		first_name = first;
		last_name = last;
		student_id = id;
		email = student_email;
		professors = list;
		sick = feeling_sick;
		username = email.substring(0, email.length()-8);
		if (sick) {
			makeDoctorsNote(this);
		}
	}
	public void makeDoctorsNote(Student student) {
		Note note1 = DoctorOffice.createNote(student, "He is so so sick. Very sick.", "7:36am 4/13/2023");
		DoctorOffice.faxNote(note1);
	}
}