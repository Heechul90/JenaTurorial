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
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;

public class KerisQuery {
	public static void run(){
		
		OntModelSpec oms= new OntModelSpec(OntModelSpec.OWL_MEM_RULE_INF);
		
		
//		OntModel m =  ModelFactory.createOntologyModel( oms, null );
		Model m = ModelFactory.createDefaultModel();
		
        m.read("D:/databases/test1.ttl");
//        m.read("D:/github/SPARQL/LearningSPARQLExamples/ex012.ttl");
//        m.write(System.out, "RDF/XML");

        StringBuffer sb = new StringBuffer();
        sb.append("PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> ");
        sb.append("PREFIX example: <http://example.com/ontology/> ");
        
        //·¯´×¸Ê Äõ¸® 
        sb.append("SELECT ?s ?school ?grade ?semester ?subject ?part_num ?part ?keyword ");
        sb.append("WHERE{");
        sb.append("?s example:keyword ?keywordURI . ");
        sb.append("?keywordURI rdfs:label ?keyword .");
        sb.append("FILTER REGEX(?keyword, \"Áö±¸°è\") . ");
        sb.append("?s example:keyword ?keywordURI;");
        sb.append("example:school ?schoolURI;");
        sb.append("example:grade ?gradeURI;");
        sb.append("example:semester ?semesterURI;");
        sb.append("example:subject ?subjectURI;");
        sb.append("example:part_num ?part_numURI;");
        sb.append("example:part ?partURI . ");
        sb.append("?schoolURI rdfs:label ?school .");
        sb.append("?gradeURI rdfs:label ?grade .");
        sb.append("?semesterURI rdfs:label ?semester .");
        sb.append("?subjectURI rdfs:label ?subject .");
        sb.append("?part_numURI rdfs:label ?part_num .");
        sb.append("?partURI rdfs:label ?part .");
        sb.append("}ORDER BY ?s ");
        sb.append("LIMIT 30");
        
        StringBuffer sb1 = new StringBuffer();
        sb1.append("PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>");
        sb1.append("PREFIX example: <http://example.com/ontology/>");
        sb1.append("SELECT ?s ?school ?grade ?semester ?subject ?part_num ?part ?keyword ");
        sb1.append("WHERE { ");
        sb1.append("?s example:keyword ?keywordURI . ");
        sb1.append("?keywordURI rdfs:label ?keyword . ");
        sb1.append("FILTER REGEX(?keyword, \"°úÇÐ\") ");
        sb1.append("?s example:school ?schoolURI .");
        sb1.append("?s example:grade ?gradeURI .");
        sb1.append("?s example:semester ?semesterURI .");
        sb1.append("?s example:subject ?subjectURI .");
        sb1.append("?s example:part_num ?part_numURI .");
        sb1.append("?s example:part ?partURI .");
        sb1.append("?schoolURI rdfs:label ?school .");
        sb1.append("?gradeURI rdfs:label ?grade .");
        sb1.append("?semesterURI rdfs:label ?semester .");
        sb1.append("?subjectURI rdfs:label ?subject .");
        sb1.append("?part_numURI rdfs:label ?part_num .");
        sb1.append("?partURI rdfs:label ?part .");
        sb1.append("}");
        sb1.append("LIMIT 20");
        
        
        StringBuffer sb2 = new StringBuffer();
        sb2.append("PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>");
        sb2.append("PREFIX example: <http://example.com/ontology/>");
        sb2.append("SELECT ?s ?keyword ");
        sb2.append("WHERE { ?s example:keyword ?keywordURI . ");
        sb2.append("?keywordURI rdfs:label ?keyword . ");
        sb2.append("FILTER REGEX(?keyword, \"È­°­¾Ï\") ");
        sb2.append("}");
        sb2.append("LIMIT 30");
        
        StringBuffer sb3 = new StringBuffer();
        sb3.append("PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>");
        sb3.append("PREFIX example: <http://example.com/ontology/>");
        sb3.append("PREFIX id: <http://example.com/resource/id/>");
//        sb3.append("SELECT * ");
//        sb3.append("WHERE { <http://example.com/resource/id/1> ?p ?o ");
//        sb3.append("} ");
        
        
        StringBuffer sb4 = new StringBuffer();
        sb4.append("PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>");
        sb4.append("PREFIX example: <http://example.com/ontology/>");
        sb4.append("select ?id ?keywordURI ");
        sb4.append("WHERE { GRAPH <http://example.com> { ");
        sb4.append(" ?id example:keyword ?keywordURI . ");
        sb4.append(" } } ");
        
        


//		String queryString = sb.toString();
//        String queryString = sb1.toString();
//        String queryString = sb2.toString();
//        String queryString = sb3.toString();
        String queryString = sb4.toString();
        
        System.out.println(queryString);

        Query query = QueryFactory.create(queryString);
        QueryExecution qexec = QueryExecutionFactory.create(query, m);
        ResultSet results = qexec.execSelect();
        ResultSetFormatter.out(System.out, results, query);
        
        //////////////////////////////////
//        UpdateRequest update = UpdateFactory.create(sb2.toString());
//		UpdateProcessor qexec = UpdateExecutionFactory.createRemote(update, "http://localhost:3330/dataset");
//		qexec.execute();


        
        }
	
	public static void main(String[] args) {
		KerisQuery query = new KerisQuery();
		
		query.run();
		
    }
}