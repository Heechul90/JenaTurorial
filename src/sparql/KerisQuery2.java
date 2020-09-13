package sparql;

import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;

public class KerisQuery2 {
	public static void run(){
		
		OntModelSpec oms= new OntModelSpec(OntModelSpec.OWL_MEM_RULE_INF);
		
		
		OntModel m =  ModelFactory.createOntologyModel( oms, null );
		
        m.read("D:/databases/keris_data_v11_rdf_v3.ttl");

        StringBuffer sb = new StringBuffer();
        sb.append("PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> ");
        sb.append("PREFIX example: <http://example.com/ontology/> ");
        
        // 전체 확인
//        sb.append("SELECT ?s ?o ");
//        sb.append("WHERE{ ");
//        sb.append(" ?s example:school ?o .");
//        sb.append("} ");
//        sb.append("LIMIT 10");

        
        // INSERT
        sb.append("INSERT DATA");
        sb.append("{ <http://example.com/resource/id/7189> example:school \"중학교\" .}");

		String queryString = sb.toString();


        Query query = QueryFactory.create(queryString);
        QueryExecution qexec = QueryExecutionFactory.create(query,m);
        
        ResultSet results = qexec.execSelect();
        ResultSetFormatter.out(System.out,results,query);
        
        System.out.println("------------------------------------------------------------");


        
        }
	
	public static void main(String[] args) {
		KerisQuery2 query = new KerisQuery2();
		
		query.run();
		
    }
}