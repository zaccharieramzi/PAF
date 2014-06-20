package IHM;

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
	
	private void loadFromURL(String URLToRead){
		MonConnecteur mc = new MonConnecteur();
		String page = mc.accederA(URLToRead);
	}
}
	