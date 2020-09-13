package sparql;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.DC;
import org.apache.jena.vocabulary.OWL;
import org.apache.jena.vocabulary.RDFS;
import org.apache.jena.vocabulary.VCARD;

public class KerisModeling {
	
	// �� �����
	// �Ӽ��� �� �����
	// Model, Resource, Property
	
	// ���Ǵ� ���ڿ� ����
    static String URI    = "http://example.com/resource/middleScience";
    static String fullName     = "���б�/����/YBM/�뼮��";
    
    static String gradeFirst   = "1";
    static String gradeSecond   = "2";
    static String gradeThird   = "3";
    static String semesterCommon   = "0";
    static String semesterFirst   = "1";
    static String semesterSecond   = "2";
    
    
    static String part_num     = "1";
    static String part     = "������ ��ȭ";
    static String part_name     = part_num+" "+part;
    
    static String keyword   = "ȭ����;ȭ����;������;����";

        
    public static void run(){
        
 
        // �� �� ����
        Model m = ModelFactory.createDefaultModel();
        
        // ���ҽ� ���� �� �Ӽ� �߰�
        Resource middleScience = m.createResource(URI)
        		.addProperty(VCARD.FN, fullName);

        		

         // ���
//         m.write(System.out, "RDF/XML");
         m.write(System.out, "ttl");
         
         String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
         		+ "PREFIX vcard: <http://www.w3.org/2001/vcard-rdf/3.0#>"
         		+ "SELECT ?s ?keyword ?school ?grade ?semeter ?subject ?part ?part_num "
         		+ "WHERE { ?s vcard:EMAIL ?keyword ."
         		+ "?s vcard:Country ?school ."
         		+ "?s vcard:CLASS ?grade ."
         		+ "?s vcard:CATEGORIES ?semeter ."
         		+ "?s vcard:BDAY ?subject ."
         		+ "?s vcard:AGENT ?part ."
         		+ "?s vcard:ADR ?part_num ."
         		+ "FILTER REGEX(?keyword,\"����ö\")}";

         		
         
         Query query = QueryFactory.create(queryString);
         QueryExecution qexec = QueryExecutionFactory.create(query,m);
         
         ResultSet results = qexec.execSelect();
         ResultSetFormatter.out(System.out,results,query);

         }
 	
 	public static void main(String[] args) {
 		KerisModeling query = new KerisModeling();
 		
 		query.run();
         
    }
}
