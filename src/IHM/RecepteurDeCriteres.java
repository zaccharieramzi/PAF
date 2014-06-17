package IHM;

import java.util.ArrayList;

public class RecepteurDeCriteres implements CriteriumToListInterface{
	
	private ArrayList<String> periodes;
	private ArrayList<String> domaines;
	private ArrayList<String> references;
	private ArrayList<String> locations;
	private ArrayList<String> subjects;

	@Override
	public void addPeriod(String period) {
		this.periodes.add(period);
		
	}

	@Override
	public void addArtDomain(String domain) {
		this.domaines.add(domain);
		
	}

	@Override
	public void addReference(String reference) {
		this.references.add(reference);
		
	}

	@Override
	public void addLocation(String location) {
		this.locations.add(location);
		
	}

	@Override
	public ArrayList<String> getSubjects() {
	
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
		// TODO Auto-generated method stub
		
	}

}
