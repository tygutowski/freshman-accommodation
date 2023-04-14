import java.util.ArrayList;

public class DoctorsNoteForm {
	Student student = null;
	ArrayList<Professor> professor_list = new ArrayList<Professor>();
	boolean accepted = true;
	public void giveDecision() {
		for(Professor professor : professor_list) {
			if(professor.getDecision() == false) {
				accepted = false;
			}
		}
	}
}