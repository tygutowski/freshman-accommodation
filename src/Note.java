
public class Note {
	
	Student noteStudent = null;
	String noteDesc = "";
	String noteDate = "";
	
	public Note(Student student, String desc, String date) {
		noteStudent = student;
		noteDesc = desc;
		noteDate = date;
	}
	
	public Student getStudent() {
		return this.noteStudent;
	}
	
	public String getDesc() {
		return this.noteDesc;
	}
	
	public String getDate() {
		return this.noteDate;
	}

}
