package IHM;

import java.util.ArrayList;

public class RecepteurDeCriteres implements CriteriumToListInterface{
	
	private ArrayList<String> periodes;
	private ArrayList<String> domaines;
	private ArrayList<String> references;
	private ArrayList<String> locations;
	private ArrayList<String> subjects;

	public RecepteurDeCriteres(){
		this.periodes=new ArrayList<String>();
		this.domaines=new ArrayList<String>();
		this.references=new ArrayList<String>();
		this.locations=new ArrayList<String>();
		this.subjects=new ArrayList<String>();
	}
	@Override
	public void setPeriod(ArrayList<String> period) {
		this.periodes=period;
		
	}

	@Override
	public void setArtDomain(ArrayList<String> domain) {
		this.domaines=domain;
		
	}

	@Override
	public void setReference(ArrayList<String> reference) {
		this.references=reference;
		
	}

	@Override
	public void setLocation(ArrayList<String> location) {
		this.locations=location;
		
	}

	@Override
	public ArrayList<String> getSubjects() {
	
		subjects.add("La Joconde");
		subjects.add("Le Parthénon");
		return subjects;
	}

	@Override
	public ArrayList<String> getPeriod() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> getArtDomain() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> getReference() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> getLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addSubject(String subject) {
		subjects.add(subject);
		
	}

}
