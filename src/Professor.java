
public class Professor implements Person {
	String first_name = "Siddhartha";
	String last_name = "Bhattacharyya";
	String email = "professor@fit.edu";
	String student_id = "900000000";
	boolean decision = true;
	public Professor (String first, String last, String professor_email, boolean mean) {
		this.first_name = first;
		this.last_name = last;
		this.email = professor_email;
		if (mean) {
			this.decision = false;
		}
	}
	public boolean getDecision() {
		return this.decision;
	}
}
