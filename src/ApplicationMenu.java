/*
 * Author:  Tyler Gutowski, Thomas Johnson, Trevor Schiff
 * Course:  CSE 3421, Section 01, Spring 2023
 * Project: Software Design Project
 * Charset: US-ASCII
 */


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public final class ApplicationMenu extends MenuBase {
	private static StudentLifeMenu studentTab;
	private static DoctorsNoteMenu doctorsNoteTab;
	private static CrisisOutreachMenu crisisOutreachTab;
	private static MeditationTab meditationTab;	
	public ApplicationMenu() {
		addOption(this::findEvent, // handler
				 "1",        // name
				 "Find an event");
		addOption(this::createEvent, // handler
				 "2",        // name
				 "Create an event");  
		addOption(this::openDoctorsNote, // handler
				 "6",        // name
				 "Doctors Note Application");  
		addOption(this::openCrisisOutreach, // handler
				 "7",        // name
				 "Crisis Outreach");  
		addOption(this::openMeditation, // handler
				 "8",        // name
				 "Meditate");  
	}

	public String getName() {
		return "Login Menu";
	}
	
	private Boolean findEvent(final HashMap<String, String> args) {
		
		return true;
	}
	private Boolean createEvent(final HashMap<String, String> args) {
		
		return true;
	}
	private Boolean openDoctorsNote(final HashMap<String, String> args) {
		MenuManager.enterMenu(new DoctorsNoteMenu());
		return true;
	}
	private Boolean openCrisisOutreach(final HashMap<String, String> args) {
		//MenuManager.enterMenu(new CrisisOutreachMenu());
		return true;
	}
	private Boolean openMeditation(final HashMap<String, String> args) {
		//MenuManager.enterMenu(new MeditationTab());
		return true;
	}
}
