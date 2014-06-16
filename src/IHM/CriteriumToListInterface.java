package IHM;

import java.util.ArrayList;

public interface CriteriumToListInterface {
	
	void addPeriod(String period);
	void addArtDomain(String domain);
	void addReference(String reference);
	void addLocation(String location);
	ArrayList<String> getSubjects();
	ArrayList<String> getPeriod();
	ArrayList<String> getArtDomain();
	ArrayList<String> getReference();
	ArrayList<String> getLocation();
	void addSubject(String subject);



}
