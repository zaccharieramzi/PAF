package IHM;

import java.util.ArrayList;

import SPARQL.Requetes;

public class RecepteurDeCriteres implements CriteriumToListInterface{
	
	private ArrayList<String> periodes;
	private ArrayList<String> domaines;
	private ArrayList<String> references;
	private ArrayList<String> locations;
	private ArrayList<String> subjects;
	boolean flag = true;

	public RecepteurDeCriteres(){
		this.periodes=new ArrayList<String>();
		this.domaines=new ArrayList<String>();
		this.references=new ArrayList<String>();
		this.locations=new ArrayList<String>();
		this.subjects=new ArrayList<String>();
	}
	
//	private String createURL(){
//		String result="PREFIX owl: <http://www.w3.org/2002/07/owl#>"+
//				"PREFIX dbpedia-owl: <http://dbpedia.org/ontology/>"+
//				"PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>"+
//				"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"+
//				"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
//				"PREFIX foaf: <http://xmlns.com/foaf/0.1/>" +
//				"PREFIX dc: <http://purl.org/dc/elements/1.1/>" +
//				"PREFIX : <http://dbpedia.org/resource/>" +
//				"PREFIX dbpedia2: <http://dbpedia.org/property/>" +
//				"PREFIX dbpedia: <http://dbpedia.org/>"+
//				"PREFIX skos: <http://www.w3.org/2004/02/skos/core#>";
//		switch(domaines.get(0)){
//			case "Monuments":
//				if(periodes.get(0)==null||periodes.get(1)==null){
//					if(locations.get(0)==null){
//						result+="SELECT DISTINCT ?monument ?description ?date ?lieu"+
//								"WHERE {"+
//
//								"?monument rdf:type <http://dbpedia.org/ontology/Building>."+
//								"?monument dbpedia-owl:abstract ?description."+
//								"OPTIONAL {?monument dbpprop:designation2Date ?date }"+
//								"OPTIONAL {?monument dbpprop:region ?lieu}"+
//								"FILTER(lang(?description) = 'fr' )."+
//								"}"+
//								"LIMIT 20";
//
//					}
//					else{
//						result+="SELECT DISTINCT ?monument ?description ?date ?lieu"+
//								"WHERE {"+
//
//								"?monument rdf:type <http://dbpedia.org/ontology/Building>."+
//								"?monument dbpedia-owl:abstract ?description."+
//								"OPTIONAL {?monument dbpprop:designation2Date ?date }"+
//								"?monument dbpprop:region ?lieu."+
//								"FILTER regex( ?lieu, "+locations.get(0)+")"+
//								"FILTER(lang(?description) = 'fr' )."+
//								"}"+
//								"LIMIT 20";
//					}
//				}
//				else{
//					if(locations.get(0)==null){
//						result+="SELECT DISTINCT ?monument ?description ?date ?lieu"+
//								"WHERE {"+
//
//								"?monument rdf:type <http://dbpedia.org/ontology/Building>."+
//								"?monument dbpedia-owl:abstract ?description."+
//								"?monument dbpprop:designation2Date ?date ."+
//								"OPTIONAL{ ?monument dbpprop:region ?lieu}"+
//								"FILTER(?date<"+periodes.get(1)+")"+
//								"FILTER (?date>"+periodes.get(0)+")"+
//								"FILTER(lang(?description) = 'fr' )."+
//								"}"+
//								"LIMIT 20";
//					}
//					else{
//						result+="SELECT DISTINCT ?monument ?description ?date ?lieu"+
//								"WHERE {"+
//
//								"?monument rdf:type <http://dbpedia.org/ontology/Building>."+
//								"?monument dbpedia-owl:abstract ?description."+
//								"?monument dbpprop:designation2Date ?date ."+
//								"?monument dbpprop:region ?lieu"+
//								"FILTER regex( ?lieu, "+locations.get(0)+")"+
//								"FILTER(?date<"+periodes.get(1)+")"+
//								"FILTER (?date>"+periodes.get(0)+")"+
//								"FILTER(lang(?description) = 'fr' )."+
//								"}"+
//								"LIMIT 20";
//					}
//						
//					
//				}; break;
//			case "Film":
//						result+="SELECT DISTINCT "+
//								"?titre_film ?description ?date"+  
//								"WHERE {"+
//								"?titre_film rdf:type <http://dbpedia.org/ontology/Film> ."+
//								"?titre_film rdfs:comment ?description ."+
//								"OPTIONAL {?titre_film prop-fr:année ?date }"+
//								"FILTER(lang(?description) = 'fr' )."+
//								"}"+
//								"LIMIT 20"; break;
//						
//						
//			case "Artwork":
//				if(periodes.get(0)==null||periodes.get(1)==null){
//					if(locations.get(0)==null||locations.get(0)==""){
//						result+="SELECT DISTINCT ?titreoeuvre ?description ?date ?localisation"+
//								"WHERE {"+
//								"?titreoeuvre rdf:type <http://dbpedia.org/ontology/Artwork>  ."+
//								"?titreoeuvre dbpedia-owl:abstract ?description."+
//								"OPTIONAL{?titreoeuvre dbpedia2:year ?date}"+
//								"OPTIONAL{?titreoeuvre dbpedia-owl:museum ?localisation}"+
//								"FILTER(lang(?description)='fr')"+
//								"}"+
//								"LIMIT 20";
//					}
//					else{
//						result+="SELECT DISTINCT ?titreoeuvre ?description ?date ?localisation"+
//								"WHERE {"+
//								"?titreoeuvre rdf:type <http://dbpedia.org/ontology/Artwork>  ."+
//								"?titreoeuvre dbpedia-owl:abstract ?description."+
//								"OPTIONAL{?titreoeuvre dbpedia2:year ?date}"+
//								"?titreoeuvre dbpedia-owl:museum ?localisation"+
//								"FILTER regex( ?lieu, "+locations.get(0)+")"+
//								"FILTER(lang(?description)='fr')"+
//								"}"+
//								"LIMIT 20";
//					}
//				}
//				else{
//					if(locations.get(0)==null||locations.get(0)==""||locations.size()==0||locations.get(0).length()==0){
//						result+="SELECT DISTINCT ?titreoeuvre ?description ?date ?localisation"+
//								"WHERE {"+
//								"?titreoeuvre rdf:type <http://dbpedia.org/ontology/Artwork>  ."+
//								"?titreoeuvre dbpedia-owl:abstract ?description."+
//								"?titreoeuvre dbpedia2:year ?date"+
//								"OPTIONAL{?titreoeuvre dbpedia-owl:museum ?localisation}"+
//								"FILTER(?date<"+periodes.get(1)+")"+
//								"FILTER (?date>"+periodes.get(0)+")"+
//								"FILTER(lang(?description)='fr')"+
//								"}"+
//								"LIMIT 20";
//					}
//					else{
//						result+="SELECT DISTINCT ?titreoeuvre ?description ?date ?localisation"+
//								"WHERE {"+
//								"?titreoeuvre rdf:type <http://dbpedia.org/ontology/Artwork>  ."+
//								"?titreoeuvre dbpedia-owl:abstract ?description."+
//								"?titreoeuvre dbpedia2:year ?date"+
//								"?titreoeuvre dbpedia-owl:museum ?localisation"+
//								"FILTER(?date<"+periodes.get(1)+")"+
//								"FILTER (?date>"+periodes.get(0)+")"+
//								"FILTER regex( ?lieu, "+locations.get(0)+")"+
//								"FILTER(lang(?description)='fr')"+
//								"}"+
//								"LIMIT 20";
//					}
//				};break;
//			case"Livre":
//						result+="SELECT DISTINCT ?livre ?description"+
//								"WHERE {"+
//
//							"?livre rdf:type <http://dbpedia.org/ontology/Book>."+
//							"?livre dbpedia-owl:abstract ?description."+
//							"FILTER(lang(?description)='fr')"+
//							"}"+
//							"LIMIT 20";break;
//			
//		}
//		return result;
//	} version de Seb
	
	private String createURL(){
		String result="PREFIX owl: <http://www.w3.org/2002/07/owl#>"+
			"PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>"+
			"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"+
			"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"+
				"PREFIX foaf: <http://xmlns.com/foaf/0.1/>"+
				"PREFIX dc: <http://purl.org/dc/elements/1.1/>"+
				"PREFIX : <http://dbpedia.org/resource/>"+
				"PREFIX dbpedia2: <http://dbpedia.org/property/>"+
				"PREFIX dbpedia: <http://dbpedia.org/>"+
				"PREFIX skos: <http://www.w3.org/2004/02/skos/core#>"+
				"PREFIX dbpedia-owl: <http://dbpedia.org/ontology/>"+
				"PREFIX dbpprop: <http://dbpedia.org/property/>"+
				"PREFIX prop-fr: <http://fr.dbpedia.org/property/>";
		switch(domaines.get(0)){
			case "Monuments":
				if(periodes.get(0)==null||periodes.get(1)==null){
					if(locations.get(0)==null){
						result+="SELECT DISTINCT ?monument ?name ?description ?date ?lieu"+
								"WHERE {"+

								"?monument rdf:type <http://dbpedia.org/ontology/Building>."+
								"?monument dbpedia-owl:abstract ?description."+
								"OPTIONAL {?monument foaf:name ?name }"+
								"OPTIONAL {?monument dbpprop:completionDate ?date }"+
								"OPTIONAL {?monument dbpedia-owl:location  ?lieu}"+
								"FILTER(lang(?description) = 'fr' )."+
								"}"+
								"LIMIT 20";

					}
					else{
						result+="SELECT DISTINCT ?monument ?name ?description ?date ?lieu"+
								"WHERE {"+

								"?monument rdf:type <http://dbpedia.org/ontology/Building>."+
								"?monument dbpedia-owl:abstract ?description."+
								"OPTIONAL {?monument foaf:name ?name }"+
								"OPTIONAL {?monument dbpprop:completionDate ?date }"+
								"OPTIONAL {?monument dbpedia-owl:location  ?lieu}"+
								"FILTER regex( ?lieu, "+locations.get(0)+")."+
								"FILTER(lang(?description) = 'fr' )."+
								"}"+
								"LIMIT 20";
					}
				}
				else{
					if(locations.get(0)==null){
						result+="SELECT DISTINCT ?monument ?name ?description ?date ?lieu"+
								"WHERE {"+

								"?monument rdf:type <http://dbpedia.org/ontology/Building>."+
								"?monument dbpedia-owl:abstract ?description."+
								"OPTIONAL {?monument foaf:name ?name }"+
								"OPTIONAL {?monument dbpprop:completionDate ?date }"+
								"OPTIONAL {?monument dbpedia-owl:location  ?lieu}"+
								"FILTER(?date<"+periodes.get(1)+")."+
								"FILTER (?date>"+periodes.get(0)+")."+
								"FILTER(lang(?description) = 'fr' )."+
								"}"+
								"LIMIT 20";
					}
					else{
						result+="SELECT DISTINCT ?monument ?name ?description ?date ?lieu"+
								"WHERE {"+

								"?monument rdf:type <http://dbpedia.org/ontology/Building>."+
								"?monument dbpedia-owl:abstract ?description."+
								"OPTIONAL {?monument foaf:name ?name }"+
								"OPTIONAL {?monument dbpprop:completionDate ?date }"+
								"OPTIONAL {?monument dbpedia-owl:location  ?lieu}"+
								"FILTER regex( ?lieu, "+locations.get(0)+")."+
								"FILTER(?date<"+periodes.get(1)+")."+
								"FILTER (?date>"+periodes.get(0)+")."+
								"FILTER(lang(?description) = 'fr' )."+
								"}"+
								"LIMIT 20";
					}
						
					
				};break;
			case "Film":
				if(periodes.get(0)==null||periodes.get(1)==null){
						result+="SELECT DISTINCT "+
								"?titre_film ?name ?description ?date"+  
								"WHERE {"+
								"?titre_film rdf:type <http://dbpedia.org/ontology/Film> ."+
								"OPTIONAL {?titre_film foaf:name ?name}"+
								"OPTIONAL {?titre_film rdfs:comment ?description }"+
								"OPTIONAL {?titre_film dbpprop:released  ?date }"+ 
								
								"FILTER(lang(?description) = 'fr' )."+
								"}"+
								"LIMIT 20";
				}
				else {
					result+="SELECT DISTINCT "+
							"?titre_film ?name ?description ?date"+  
							"WHERE {"+
							"?titre_film rdf:type <http://dbpedia.org/ontology/Film> ."+
							"OPTIONAL {?titre_film foaf:name ?name}"+
							"OPTIONAL {?titre_film rdfs:comment ?description }"+
							"OPTIONAL {?titre_film dbpprop:released  ?date }"+
							"FILTER(?date<\""+periodes.get(1)+"-01-01\"^^xsd:date)."+
							"FILTER (?date>\""+periodes.get(0)+"-01-01\"^^xsd:date)."+
							"FILTER(lang(?description) = 'fr' )."+
							"}"+
							"LIMIT 20";
					
				};break;
						
						
			case "Artwork":
				if(periodes.get(0)==null||periodes.get(1)==null){
					if(locations.get(0)==null||locations.get(0).length()==0){
						result+="SELECT DISTINCT ?titre_oeuvre ?name?description ?date ?localisation ?city"+
								"WHERE {"+
								"?titre_oeuvre rdf:type <http://dbpedia.org/ontology/Artwork>  ."+
								"?titre_oeuvre dbpedia-owl:abstract ?description."+
								"OPTIONAL{?titre_oeuvre foaf:name ?name}"+
								"OPTIONAL{?titre_oeuvre dbpedia2:year ?date}"+
								"OPTIONAL{?titre_oeuvre dbpedia-owl:museum ?localisation}"+
								"OPTIONAL{?titre_oeuvre dbpprop:city ?city}"+
								"FILTER(lang(?description)='fr')"+
								"}"+
								"LIMIT 20";
					}
					else{
						result+="SELECT DISTINCT ?titre_oeuvre ?name?description ?date ?localisation ?city"+
								"WHERE {"+
								"?titre_oeuvre rdf:type <http://dbpedia.org/ontology/Artwork>  ."+
								"?titre_oeuvre dbpedia-owl:abstract ?description."+
								"OPTIONAL{?titre_oeuvre foaf:name ?name}"+
								"OPTIONAL{?titre_oeuvre dbpedia2:year ?date}"+
								"OPTIONAL{?titre_oeuvre dbpedia-owl:museum ?localisation}"+
								"OPTIONAL{?titre_oeuvre dbpprop:city ?city}"+
								"FILTER regex( ?city, "+locations.get(0)+")."+
								"FILTER(lang(?description)='fr')"+
								"}"+
								"LIMIT 20";
					}
				}
				else{
					if(locations.get(0)==null||locations.get(0).length()==0){
						result+="SELECT DISTINCT ?titre_oeuvre ?name?description ?date ?localisation ?city"+
								"WHERE {"+
								"?titre_oeuvre rdf:type <http://dbpedia.org/ontology/Artwork>  ."+
								"?titre_oeuvre dbpedia-owl:abstract ?description."+
								"OPTIONAL{?titre_oeuvre foaf:name ?name}"+
								"OPTIONAL{?titre_oeuvre dbpedia2:year ?date}"+
								"OPTIONAL{?titre_oeuvre dbpedia-owl:museum ?localisation}"+
								"OPTIONAL{?titre_oeuvre dbpprop:city ?city}"+
								"FILTER(?date<\""+periodes.get(1)+"\"xsd:integer)."+
								"FILTER (?date>"+periodes.get(0)+"\"xsd:integer)."+
								"FILTER(lang(?description)='fr')"+
								"}"+
								"LIMIT 20";
					}
					else{
						result+="SELECT DISTINCT ?titre_oeuvre ?name?description ?date ?localisation ?city"+
								"WHERE {"+
								"?titre_oeuvre rdf:type <http://dbpedia.org/ontology/Artwork>  ."+
								"?titre_oeuvre dbpedia-owl:abstract ?description."+
								"OPTIONAL{?titre_oeuvre foaf:name ?name}"+
								"OPTIONAL{?titre_oeuvre dbpedia2:year ?date}"+
								"OPTIONAL{?titre_oeuvre dbpedia-owl:museum ?localisation}"+
								"OPTIONAL{?titre_oeuvre dbpprop:city ?city}"+
								
								"FILTER(?date<\""+periodes.get(1)+"\"xsd:integer)."+
								"FILTER (?date>"+periodes.get(0)+"\"xsd:integer)."+
								"FILTER regex( ?city, "+locations.get(0)+")."+
								"FILTER(lang(?description)='fr')"+
								"}"+
								"LIMIT 20";
					}
				};break;
			case"Livre":
				if(periodes.get(0)==null||periodes.get(1)==null){
					
						result+="SELECT DISTINCT ?livre ?name ?description ?auteur ?date"+
								"WHERE {"+

							"?livre rdf:type <http://dbpedia.org/ontology/Book>."+
							"OPTIONAL {?livre dbpprop:name ?name}"+
							"OPTIONAL {?livre dbpedia-owl:abstract ?description}"+
							"OPTIONAL {?livre dbpprop:author ?auteur}"+
							"OPTIONAL {?livre dbpprop:releaseDate ?date}"+
							"FILTER(lang(?description)='fr')"+
							"}"+
							"LIMIT 20";
					
					
				}
				else{
					result+="SELECT DISTINCT ?livre ?name ?description ?auteur ?date"+
							"WHERE {"+

						"?livre rdf:type <http://dbpedia.org/ontology/Book>."+
						"OPTIONAL {?livre dbpprop:name ?name}"+
						"OPTIONAL {?livre dbpedia-owl:abstract ?description}"+
						"OPTIONAL {?livre dbpprop:author ?auteur}"+
						"OPTIONAL {?livre dbpprop:releaseDate ?date}"+
									"FILTER(?date<\""+periodes.get(1)+"-01-01T00:00:00Z\"^^xsd:dateTime)."+
									"FILTER (?date>\""+periodes.get(0)+"-01-01T00:00:00Z\"^^xsd:dateTime)."+
									"FILTER(lang(?description)='fr')"+
									"}"+
									"LIMIT 20";
					};break;
					
				
						

                                                        
			
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
				Requetes rqt = new Requetes();
				String queryString = this.createURL();
				rqt.executeQuery(queryString);
				this.subjects= rqt.getValeurDesVariables();

//		if (flag){
//			subjects.add("Le déjeuner sur l'herbe");
//			subjects.add("Guernica");
//			subjects.add("Nighthawks");
//			subjects.add("The_Birth_of_Venus_(Bouguereau)");
//			flag=false;
//		}
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
