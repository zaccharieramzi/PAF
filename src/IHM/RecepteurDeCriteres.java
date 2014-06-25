package IHM;

import java.util.ArrayList;

import SPARQL.Requetes;

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
	
	private String createURL(){
		String result=null;
		switch(domaines.get(0)){
			case "Monuments":
				if(periodes.get(0)==null||periodes.get(1)==null){
					if(locations.get(0)==null){
						result="SELECT DISTINCT ?monument ?description ?date ?lieu"+
								"WHERE {"+

								"?monument rdf:type <http://dbpedia.org/ontology/Building>."+
								"?monument dbpedia-owl:abstract ?description."+
								"OPTIONAL {?monument dbpprop:designation2Date ?date }"+
								"OPTIONAL {?monument dbpprop:region ?lieu}"+
								"FILTER(lang(?description) = \"fr\" )."+
								"}"+
								"LIMIT 20";

					}
					else{
						result="SELECT DISTINCT ?monument ?description ?date ?lieu"+
								"WHERE {"+

								"?monument rdf:type <http://dbpedia.org/ontology/Building>."+
								"?monument dbpedia-owl:abstract ?description."+
								"OPTIONAL {?monument dbpprop:designation2Date ?date }"+
								"?monument dbpprop:region ?lieu."+
								"FILTER regex( ?lieu, "+locations.get(0)+")"+
								"FILTER(lang(?description) = \"fr\" )."+
								"}"+
								"LIMIT 20";
					}
				}
				else{
					if(locations.get(0)==null){
						result="SELECT DISTINCT ?monument ?description ?date ?lieu"+
								"WHERE {"+

								"?monument rdf:type <http://dbpedia.org/ontology/Building>."+
								"?monument dbpedia-owl:abstract ?description."+
								"?monument dbpprop:designation2Date ?date ."+
								"OPTIONAL{ ?monument dbpprop:region ?lieu}"+
								"FILTER(?date<"+periodes.get(1)+")"+
								"FILTER (?date>"+periodes.get(0)+")"+
								"FILTER(lang(?description) = \"fr\" )."+
								"}"+
								"LIMIT 20";
					}
					else{
						result="SELECT DISTINCT ?monument ?description ?date ?lieu"+
								"WHERE {"+

								"?monument rdf:type <http://dbpedia.org/ontology/Building>."+
								"?monument dbpedia-owl:abstract ?description."+
								"?monument dbpprop:designation2Date ?date ."+
								"?monument dbpprop:region ?lieu"+
								"FILTER regex( ?lieu, "+locations.get(0)+")"+
								"FILTER(?date<"+periodes.get(1)+")"+
								"FILTER (?date>"+periodes.get(0)+")"+
								"FILTER(lang(?description) = \"fr\" )."+
								"}"+
								"LIMIT 20";
					}
						
					
				}
			case "Film":
						result="SELECT DISTINCT "+
								"?titre_film ?description ?date"+  
								"WHERE {"+
								"?titre_film rdf:type <http://dbpedia.org/ontology/Film> ."+
								"?titre_film rdfs:comment ?description ."+
								"OPTIONAL {?titre_film prop-fr:année ?date }"+
								"FILTER(lang(?description) = \"fr\" )."+
								"}"+
								"LIMIT 20";
						
						
			case "Artworks":
				if(periodes.get(0)==null||periodes.get(1)==null){
					if(locations.get(0)==null){
						result="SELECT DISTINCT ?titre_oeuvre ?description ?date ?localisation"+
								"WHERE {"+
								"?titre_oeuvre rdf:type <http://dbpedia.org/ontology/Artwork>  ."+
								"?titre_oeuvre dbpedia-owl:abstract ?description."+
								"OPTIONAL{?titre_oeuvre dbpedia2:year ?date}"+
								"OPTIONAL{?titre_oeuvre dbpedia-owl:museum ?localisation}"+
								"FILTER(lang(?description)=\"fr\")"+
								"}"+
								"LIMIT 20";
					}
					else{
						result="SELECT DISTINCT ?titre_oeuvre ?description ?date ?localisation"+
								"WHERE {"+
								"?titre_oeuvre rdf:type <http://dbpedia.org/ontology/Artwork>  ."+
								"?titre_oeuvre dbpedia-owl:abstract ?description."+
								"OPTIONAL{?titre_oeuvre dbpedia2:year ?date}"+
								"?titre_oeuvre dbpedia-owl:museum ?localisation"+
								"FILTER regex( ?lieu, "+locations.get(0)+")"+
								"FILTER(lang(?description)=\"fr\")"+
								"}"+
								"LIMIT 20";
					}
				}
				else{
					if(locations.get(0)==null){
						result="SELECT DISTINCT ?titre_oeuvre ?description ?date ?localisation"+
								"WHERE {"+
								"?titre_oeuvre rdf:type <http://dbpedia.org/ontology/Artwork>  ."+
								"?titre_oeuvre dbpedia-owl:abstract ?description."+
								"?titre_oeuvre dbpedia2:year ?date"+
								"OPTIONAL{?titre_oeuvre dbpedia-owl:museum ?localisation}"+
								"FILTER(?date<"+periodes.get(1)+")"+
								"FILTER (?date>"+periodes.get(0)+")"+
								"FILTER(lang(?description)=\"fr\")"+
								"}"+
								"LIMIT 20";
					}
					else{
						result="SELECT DISTINCT ?titre_oeuvre ?description ?date ?localisation"+
								"WHERE {"+
								"?titre_oeuvre rdf:type <http://dbpedia.org/ontology/Artwork>  ."+
								"?titre_oeuvre dbpedia-owl:abstract ?description."+
								"?titre_oeuvre dbpedia2:year ?date"+
								"?titre_oeuvre dbpedia-owl:museum ?localisation"+
								"FILTER(?date<"+periodes.get(1)+")"+
								"FILTER (?date>"+periodes.get(0)+")"+
								"FILTER regex( ?lieu, "+locations.get(0)+")"+
								"FILTER(lang(?description)=\"fr\")"+
								"}"+
								"LIMIT 20";
					}
				}
			case"Livre":
						result="SELECT DISTINCT ?livre ?description"+
								"WHERE {"+

							"?livre rdf:type <http://dbpedia.org/ontology/Book>."+
							"?livre dbpedia-owl:abstract ?description."+
							"FILTER(lang(?description)=\"fr\")"+
							"}"+
							"LIMIT 20";
			
		}
		return result;
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
//		Requetes rqt = new Requetes();
//		String queryString = this.createURL();
//		rqt.executeQuery(queryString);
//		this.subjects= rqt.getValeurDesVariables();
	
		subjects.add("Le déjeuner sur l'herbe");
		subjects.add("Guernica");
		subjects.add("Nighthawks");
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
		return this.domaines;
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
