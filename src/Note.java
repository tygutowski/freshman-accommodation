
public class Note {
	
	String noteName = "";
	String noteDesc = "";
	String noteDate = "";
	
	public Note(String name, String desc, String date) {
		noteName = name;
		noteDesc = desc;
		noteDate = date;
	}
	
	public String getName() {
		return this.noteName;
	}
	
	public String getDesc() {
		return this.noteDesc;
	}
	
	public String getDate() {
		return this.noteDate;
	}

}
