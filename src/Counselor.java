import java.util.ArrayList;

public class Counselor {
	public String name = "";
	public Counselor(String n) {
		name = n;
	}
	// View any current forms in the formList
	public void viewForms() {
		ArrayList<CrisisOutreachForm> forms_to_remove = new ArrayList<CrisisOutreachForm>();
		for (CrisisOutreachForm form : CrisisOutreachMenu.form_list) {
			beginCall(form.student);
			forms_to_remove.add(form);
		}
		for (CrisisOutreachForm form : forms_to_remove) {
			CrisisOutreachMenu.form_list.remove(form);
		}
	}
	// Enter a Zoom call (Pseudocode)
	public void beginCall(Student student) {
		return;
	}
}
