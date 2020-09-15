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

public class KerisQueryJson {
	
public static void run(){
		
		OntModelSpec oms= new OntModelSpec(OntModelSpec.OWL_MEM_RULE_INF);
		
		
		OntModel m =  ModelFactory.createOntologyModel( oms, null );
		
		m.read("D:/databases/test1.ttl");
        
        // 연관검색어 API
        StringBuffer sb1 = new StringBuffer();
        sb1.append("PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>");
        sb1.append("PREFIX example: <http://example.com/ontology/>");
        sb1.append("SELECT ?id ?keyword ");
        sb1.append("WHERE { GRAPH <http://example.com> { ");
        sb1.append("?id rdfs:label ?keyword . ");
        sb1.append("FILTER REGEX(?keyword, \"화강암\") ");
        sb1.append(" }}");
        
        String queryString = sb1.toString();
        
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
		KerisQueryJson query = new KerisQueryJson();
		query.run();
		
    }
}