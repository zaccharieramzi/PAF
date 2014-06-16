package IHM;

public interface SubjectToFicheInterface {

	void setSubject(String subject);
	String getSubject();
	String getFicheType(); //Cette méthode permet de ressortir le type de fiche. Selon le type de fiche on récupérera les éléments qui nous intéressent dans l’objet qui instancie une classe implémentant cette interface.
	String getAuthorName();
	String getNature(); 
	String getDate();
	String getComposer();
	String getEdition();
	String getDimension();
	String getLocation();
	String getDescription();
	String getPeriod();
	String getArtDomain();
	String getConservationLocation();
	String getAuthorBiography();;
	String getTechnique();
	String getImpression();
	String getOpening();
	void setFicheType(String ficheType); 
	void setAuthorName(String authorName);
	void setNature(String nature); 
	void setDate(String date);
	void setComposer(String composer);
	void setEdition(String edition);
	void setDimension(String dimension);
	void setLocation(String location);
	void setDescription(String description);
	void setPeriod(String period);
	void setArtDomain(String artDomain);
	void setConservationLocation(String conservationLocation);
	void setAuthorBiography(String authorBiography);
	void setTechnique(String technique);
	void setImpression(String impression);
	void setOpening(String opening);

}
