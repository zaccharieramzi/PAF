
package SPARQL;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.ResultSet;


public class Requetes{
	public static void main( String[] args ) {
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
		QueryExecution qexec = QueryExecutionFactory.sparqlService("http://dbpedia.org/snorql", query);

		try {
			ResultSet results = qexec.execSelect();
			for (; results.hasNext();) {

				System.out.println(results);
			}
		}
		finally {
			qexec.close();
		}
	}
}
            			  
            		