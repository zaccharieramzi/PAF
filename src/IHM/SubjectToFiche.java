package IHM;

import SPARQL.Requetes;
import internet.MonConnecteur;

public class SubjectToFiche implements SubjectToFicheInterface {
	private String subject, ficheType, authorName, nature, date, composer, edition, dimension, location, description, period, artDomain, conservationLocation, authorBiography, technique, impression, opening;

	
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getImpression() {
		return impression;
	}

	public void setImpression(String impression) {
		this.impression = impression;
	}

	public String getFicheType() {
		return ficheType;
	}

	public void setFicheType(String ficheType) {
		this.ficheType = ficheType;
	}

	public String getAuthorBiography() {
		return authorBiography;
	}

	public void setAuthorBiography(String authorBiography) {
		this.authorBiography = authorBiography;
	}

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public String getArtDomain() {
		return artDomain;
	}

	public void setArtDomain(String artDomain) {
		this.artDomain = artDomain;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getOpening() {
		return opening;
	}

	public void setOpening(String opening) {
		this.opening = opening;
	}

	public String getConservationLocation() {
		return conservationLocation;
	}

	public void setConservationLocation(String conservationLocation) {
		this.conservationLocation = conservationLocation;
	}

	public String getTechnique() {
		return technique;
	}

	public void setTechnique(String technique) {
		this.technique = technique;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public String getComposer() {
		return composer;
	}

	public void setComposer(String composer) {
		this.composer = composer;
	}

	@Override
	public String get(String info) {
		String result = "";
		switch(info){
		case "date" : result=date;break;
		case "composer" : result=composer;break;
		case "nature" : result=nature;break;
		case "period" : result=period;break;
		case "description" : result=description;break;
		case "technique" : result=technique;break;
		case "conservationLocation" : result=conservationLocation;break;
		case "opening" : result=opening;break;
		case "authorName" : result=authorName;break;
		case "artDomain" : result=artDomain;break;
		case "dimension" : result=dimension;break;
		case "authorBiography" : result=authorBiography;break;
		case "ficheType" : result=ficheType;break;
		case "impression" : result=impression;break;
		case "location" : result=location;break;
		case "edition" : result=edition;break;
		case "subject" : result=subject;break;
		
		}
		return result;
	}
	
	public void loadFromURL(String URLToRead){
		MonConnecteur mc = new MonConnecteur();
		mc.accederA(URLToRead);
		this.setDate(mc.getDate().substring(8,mc.getDate().length()-5));
		this.setAuthorName(mc.getAuthorName().substring(45,mc.getAuthorName().length()-9));
		this.setNature(mc.getType().substring(45,mc.getType().length()-9));
		this.setSubject(mc.getName().substring(9,mc.getName().length()-9));
	}
	
	private String createURL2(){
		String result="PREFIX owl: <http://www.w3.org/2002/07/owl#>"+
				"PREFIX dbpedia-owl: <http://dbpedia.org/ontology/>"+
				"PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>"+
				"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"+
				"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
				"PREFIX foaf: <http://xmlns.com/foaf/0.1/>" +
				"PREFIX dc: <http://purl.org/dc/elements/1.1/>" +
				"PREFIX : <http://dbpedia.org/resource/>" +
				"PREFIX dbpedia2: <http://dbpedia.org/property/>" +
				"PREFIX dbpedia: <http://dbpedia.org/>"+
				"PREFIX skos: <http://www.w3.org/2004/02/skos/core#>"+
				"PREFIX dbpprop: <http://dbpedia.org/property/>";
		switch(nature){
		case "Film":
			result+="SELECT DISTINCT ?author ?name ?description ?date "+
					"WHERE {"+
					"<http://dbpedia.org/resource/"+subject+"> rdfs:comment ?film_abstract ."+
					"OPTIONAL {<http://dbpedia.org/resource/"+subject+"> foaf:name ?name }"+
					"OPTIONAL {<http://dbpedia.org/resource/"+subject+"> dbpedia-owl:abstract ?description }"+
					"OPTIONAL {<http://dbpedia.org/resource/"+subject+"> dbpprop:released ?date }"+
					"OPTIONAL {<http://dbpedia.org/resource/"+subject+"> dbpprop:director ?author }"+
					
					
					"FILTER(lang(?film_abstract ) = 'fr' )."+
					"}";break;
			
		case "Monuments":
			result+="SELECT DISTINCT ?architect ?name ?description ?date  "+
					"WHERE {"+

					
					"<http://dbpedia.org/resource/"+subject+">  dbpedia-owl:abstract ?description."+
					"OPTIONAL {<http://dbpedia.org/resource/"+subject+">  foaf:name ?name }"+
					"OPTIONAL {<http://dbpedia.org/resource/"+subject+"> dbpprop:completionDate ?date }"+
					"OPTIONAL {<http://dbpedia.org/resource/"+subject+"> dbpedia-owl:architect ?architect}"+
					"FILTER(lang(?description) = 'fr' )."+
					"}"+
					"LIMIT 20";break;
			
		case "Artwork":
			result+=		"SELECT DISTINCT ?author ?name ?description ?date "+
					"WHERE {"+
					"<http://dbpedia.org/resource/"+subject+"> dbpedia-owl:author ?author."+
					"OPTIONAL{<http://dbpedia.org/resource/"+subject+"> foaf:name ?name}"+
					"OPTIONAL{<http://dbpedia.org/resource/"+subject+"> dbpedia2:year ?date}"+
					"OPTIONAL{<http://dbpedia.org/resource/"+subject+"> dbpedia-owl:abstract ?description}" +
					"FILTER(lang(?description)='fr')."+		
					
				
					
					"}";break;
				
		case "Livre" :
			result+="SELECT DISTINCT ?auteur ?name ?description ?date "+
					"WHERE {"+

				"<http://dbpedia.org/resource/"+subject+"> rdf:type <http://dbpedia.org/ontology/Book>."+
				"OPTIONAL {<http://dbpedia.org/resource/"+subject+"> dbpprop:name ?name}"+
				"OPTIONAL {<http://dbpedia.org/resource/"+subject+"> dbpedia-owl:abstract ?description}"+
				"OPTIONAL {<http://dbpedia.org/resource/"+subject+"> dbpprop:author ?auteur}"+
				"OPTIONAL {<http://dbpedia.org/resource/"+subject+"> dbpprop:releaseDate ?date}"+
				"FILTER(lang(?description)='fr')"+
				"}"+
				"LIMIT 20";break;
		}
		return result;
	}
	
	public void loadFromQuery(){
		Requetes rqt = new Requetes();
		String queryString = this.createURL2();
		rqt.executeQuery(queryString,1);
		this.setDate(rqt.getValeurDesVariables().get(3).substring(0, 4));
		this.setAuthorName(rqt.getValeurDesVariables().get(0).substring(28));
		this.setDescription(rqt.getValeurDesVariables().get(2));
		this.setSubject(rqt.getValeurDesVariables().get(1));
		
	}
}
	