
package SPARQL;

import java.util.ArrayList;
import java.util.List;

import com.hp.hpl.jena.query.*;
import com.hp.hpl.jena.rdf.model.RDFNode;

public class Requetes {

	private ArrayList<String> nomDesVariables;
	private ArrayList<String> valeurDesVariables;
	
	public Requetes(){
		nomDesVariables = new ArrayList<String>();
		valeurDesVariables = new ArrayList<String>();
	}
	
	
	public void executeQuery (String queryString,int mod){
		org.apache.log4j.Logger.getRootLogger().setLevel(org.apache.log4j.Level.OFF);

		Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.sparqlService("http://www.dbpedia.org/sparql", query);

		try {
			ResultSet results = qexec.execSelect();
			List<String> nomDeColonnes = results.getResultVars();
			while (results.hasNext()) {
				QuerySolution row= results.next();
				for(int i =0; i<nomDeColonnes.size(); i++){
					if(mod!=1){
						if(i%mod==0){
//						if(nomDeColonnes.get(i)=="titre_oeuvre"||nomDeColonnes.get(i)=="livre"||nomDeColonnes.get(i)=="titre_film"||nomDeColonnes.get(i)=="monument"){
							RDFNode thing= row.get(nomDeColonnes.get(i));
							//					 Literal label=row.getLiteral(nomDeColonnes.get(i));
							nomDesVariables.add(nomDeColonnes.get(i));
							valeurDesVariables.add(thing.toString().substring(28));
							System.out.println(thing.toString()+ " is " + " " +nomDeColonnes.get(i));
						}
					}
					else {
						RDFNode thing= row.get(nomDeColonnes.get(i));
						//					 Literal label=row.getLiteral(nomDeColonnes.get(i));
						nomDesVariables.add(nomDeColonnes.get(i));
						valeurDesVariables.add(thing.toString());
						System.out.println(thing.toString()+ " is " + " " +nomDeColonnes.get(i));
					}
				}

			}
		}
		finally {
			qexec.close();
		}
	}

	public ArrayList<String> getNomDesVariables() {
		for (int index = 0 ; index< nomDesVariables.size() ; index ++){
			System.out.println(nomDesVariables.get(index));
		}
		return nomDesVariables;
	}



	public ArrayList<String> getValeurDesVariables() {
		for (int index = 0 ; index< valeurDesVariables.size() ; index ++){
			System.out.println(valeurDesVariables.get(index));
		}
		return valeurDesVariables;
	}




}

         