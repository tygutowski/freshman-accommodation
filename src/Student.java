import java.util.ArrayList;
public class Student implements Person {
	String first_name = "John";
	String last_name = "Doe";
	String email = "jdoe0000@fit.edu";
	String student_id = "900000000";
	String username = "";
	ArrayList<Professor> professors = null;
	public Student (String first, String last, String id, String student_email, ArrayList<Professor> professor_list) {
		first_name = first;
		last_name = last;
		student_id = id;
		email = student_email;
		professors = professor_list;
		username = email.substring(0, email.length()-8);
	}
}