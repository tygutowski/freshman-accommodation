import java.util.ArrayList;
public class Student implements Person {
	String first_name = "John";
	String last_name = "Doe";
	String email = "jdoe0000@fit.edu";
	String student_id = "900000000";
	ArrayList<Professor> professors = null;
	public Student (String first, String last, String id, String student_email, ArrayList<Professor> professor_list) {
		first_name = first;
		last_name = last;
		student_id = id;
		email = student_email;
		professors = professor_list;
		System.out.println(first_name + " " + last_name + " registered.");
	}
	public void makeApplication() {
		System.out.println("making new app for " + this.first_name);
		DoctorsNoteApplication app = new DoctorsNoteApplication();
		app.student = this;
		app.professor_list = this.professors;
		app.giveDecision();
	}
}