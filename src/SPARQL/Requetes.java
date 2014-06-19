
package SPARQL;

import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.sparql.util.IndentedWriter;
import com.hp.hpl.jena.util.FileManager;
import com.hp.hpl.jena.vocabulary.RDF;


public class JenaTest{
        public static final String owlFile = "resource/famille.owl";
        public static final String NL      = System.getProperty("line.separator") ;
        public static void main( String[] args ) {
                
                // Creation d'un modele d'ontologie pour une ontologie OWL-DL avec un resonneur RDFS
                Model m = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM_RDFS_INF);
                
                // Lecture du fichier OWL. Le Namespace de notre ontologie doit etre specifié
                FileManager.get().readModel( m, owlFile );
                String myOntologyName = "famille";
                String myOntologyNS   = "http://univ-tln.fr/m2sis/owl/famille#";
                
                // Définition de prefixe pour simplifier l'utilisation de SPARQL
                String rdfPrefix        = "PREFIX rdf: <"+RDF.getURI()+">" ;
                String myOntologyPrefix = "PREFIX "+myOntologyName+": <"+myOntologyNS+">" ;
                
                
                // Construction de la requete
                String queryString =   myOntologyPrefix + NL 
                                     + rdfPrefix + NL +
                                       "SELECT ?individu WHERE {?individu rdf:type famille:Homme }" ;
                
                Query query = QueryFactory.create(queryString) ;
                
                // Affichage de la requete sur la sortie standard.
                query.serialize(new IndentedWriter(System.out,true)) ;
                System.out.println() ;
                
                // Create a single execution of this query, apply to a model
                // which is wrapped up as a Dataset
                QueryExecution qexec = QueryExecutionFactory.create(query, m) ;
                
                // Execution de la requete
                try {
                        // Pour l'instant nous nous limitons a des requetes de type SELECT
                        ResultSet rs = qexec.execSelect() ;
                        
                        // Affichage des resultats
                        for ( ; rs.hasNext() ; ){
                                QuerySolution rb = rs.nextSolution() ;
                                RDFNode y = rb.get("individu");
                                System.out.print("uri : "+y+"--- ");
                                Resource z = (Resource) rb.getResource("individu");
                                System.out.println("plus simplement "+z.getLocalName());
                        }
                }
                finally{
                  qexec.close() ;
                }
        }
}