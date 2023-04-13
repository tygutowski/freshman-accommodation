
public class Student {
	String first_name = "John";
	String last_name = "Doe";
	String student_id = "900000000";
	String student_email = "jdoe0000@fit.edu";
	public Student (String first, String last, String id, String email) {
		first_name = first;
		last_name = last;
		student_id = id;
		student_email = email;
		System.out.println(first_name + " " + last_name + " registered.");
	}
}
