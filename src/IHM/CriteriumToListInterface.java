package IHM;

import java.util.ArrayList;

public interface CriteriumToListInterface {
	
	void setPeriod(ArrayList<String> period);
	void setArtDomain(ArrayList<String> domain);
	void setReference(ArrayList<String> reference);
	void setLocation(ArrayList<String> location);
	ArrayList<String> getSubjects();
	ArrayList<String> getPeriod();
	ArrayList<String> getArtDomain();
	ArrayList<String> getReference();
	ArrayList<String> getLocation();
	void addSubject(String subject);



}
