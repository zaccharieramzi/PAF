
package SPARQL;

import java.util.ArrayList;
import java.util.List;

import com.hp.hpl.jena.query.*;
import com.hp.hpl.jena.rdf.model.RDFNode;

public class Requetes {

	private ArrayList<String> nomDesVariables;
	private ArrayList<String> valeurDesVariables;
	
	public void executeQuery (String queryString){
		org.apache.log4j.Logger.getRootLogger().setLevel(org.apache.log4j.Level.OFF);
		
		Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.sparqlService("http://www.dbpedia.org/sparql", query);

		try {
			ResultSet results = qexec.execSelect();
			List<String> nomDeColonnes = results.getResultVars();
				while (results.hasNext()) {
			    QuerySolution row= results.next();
			    for(int i =0; i<nomDeColonnes.size(); i++){
			    	 RDFNode thing= row.get(nomDeColonnes.get(i));
//					 Literal label=row.getLiteral(nomDeColonnes.get(i));
			    	 nomDesVariables.add(nomDeColonnes.get(i));
			    	 valeurDesVariables.add(thing.toString());
					 System.out.println(thing.toString()+ " is " + " " +nomDeColonnes.get(i));
			    }
			   
			}
		}
		finally {
			qexec.close();
		}
	}

	public ArrayList<String> getNomDesVariables() {
		return nomDesVariables;
	}

	

	public ArrayList<String> getValeurDesVariables() {
		return valeurDesVariables;
	}

	
	
	
}
            			  
         