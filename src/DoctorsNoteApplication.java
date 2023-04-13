import java.util.ArrayList;

public class DoctorsNoteApplication {
	Student student = null;
	ArrayList<Professor> professor_list = new ArrayList<Professor>();
	boolean accepted = true;
	public void giveDecision() {
		for(Professor professor : professor_list) {
			if(professor.getDecision() == false) {
				accepted = false;
			}
		}
		if(accepted) {
			acceptApplication();
		}
		else {
			denyApplication();
		}
	}
	public void acceptApplication() {
		System.out.println(student.first_name + "'s application has been accepted");
	}
	public void denyApplication() {
		System.out.println(student.first_name + "'s application has been denied");
	}