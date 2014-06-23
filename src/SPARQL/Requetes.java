
package SPARQL;

import java.util.ArrayList;
import java.util.List;

import org.apache.jena.atlas.io.IndentedWriter;
import org.apache.log4j.Logger;

import com.github.jsonldjava.core.RDFDataset.Literal;
import com.hp.hpl.jena.query.*;
import com.hp.hpl.jena.rdf.model.RDFNode;




public class Requetes{
	public static void main( String[] args ) {
		org.apache.log4j.Logger.getRootLogger().setLevel(org.apache.log4j.Level.OFF);
		String queryString=
				"PREFIX owl: <http://www.w3.org/2002/07/owl#>"+
						"PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>"+
						"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"+
						"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
						"PREFIX foaf: <http://xmlns.com/foaf/0.1/>" +
						"PREFIX dc: <http://purl.org/dc/elements/1.1/>" +
						"PREFIX : <http://dbpedia.org/resource/>" +
						"PREFIX dbpedia2: <http://dbpedia.org/property/>" +
						"PREFIX dbpedia: <http://dbpedia.org/>"+
						"PREFIX skos: <http://www.w3.org/2004/02/skos/core#>" +
						"select * where {"
						+ "<http://dbpedia.org/resource/Nighthawks> <http://dbpedia.org/ontology/author> ?auteur;"
						+ "<http://dbpedia.org/property/title> ?name;"
						+ "<http://dbpedia.org/property/type> ?type;"
						+ "<http://dbpedia.org/property/year> ?date"
						+ "}";

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
					 System.out.println(thing.toString()+" is "+nomDeColonnes.get(i));
			    }
			   
			}
		}
		finally {
			qexec.close();
		}
	}
}
            			  
         