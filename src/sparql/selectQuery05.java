package sparql;

import java.io.ByteArrayOutputStream;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.ModelFactory;

public class selectQuery05 {
	
	// sparql로 질의하고 json 형태로 받기
	
	public static void run(){
		
		OntModelSpec oms= new OntModelSpec(OntModelSpec.OWL_MEM_RULE_INF);
		
		
		OntModel m =  ModelFactory.createOntologyModel( oms, null );
		
        m.read("D:/workspace/JenaTutorial/Documents/rdf/vc-db-1.rdf");
        
        
        String queryString = "PREFIX vcard:<http://www.w3.org/2001/vcard-rdf/3.0#> "
        		+ "SELECT ?givenName "
        		+ "WHERE "
        		+ "{?y vcard:Family \"Smith\" . "
        		+ "?y vcard:Given  ?givenName .} ";
        
        Query query = QueryFactory.create(queryString);
        QueryExecution qexec = QueryExecutionFactory.create(query,m);
        
        ResultSet rs = null;
        try {
           rs = qexec.execSelect();
        } catch (Exception e) {
           e.printStackTrace();
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ResultSetFormatter.outputAsJSON(outputStream, rs);
        String json = new String(outputStream.toByteArray());
        System.out.println(json);
        
        }
	
	public static void main(String[] args) {
		selectQuery05 query = new selectQuery05();
		query.run();
		
    }
}