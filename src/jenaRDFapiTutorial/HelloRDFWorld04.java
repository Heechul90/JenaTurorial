package jenaRDFapiTutorial;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.vocabulary.VCARD;

public class HelloRDFWorld04 {
	
	// iterator ����ؼ� �� �����
	
	// ���Ǵ� ���ڿ� ����
	static String personURI    = "http://somewhere/JohnSmith";
    
    static String givenName    = "Smith";
    static String familyName   = "John";
    static String fullName     = familyName + " " + givenName;
    
	public static void main(String[] args) {
		
		// create an empty Model
        Model model = ModelFactory.createDefaultModel();
 
        // create the resources and the properties
        Resource johnSmith = model.createResource(personURI)
        		.addProperty(VCARD.FN, fullName)
        		.addProperty(VCARD.N, model.createResource()
        				.addProperty(VCARD.Given, givenName)
        				.addProperty(VCARD.Family, familyName));
        
        // iterator ����
        StmtIterator iter = model.listStatements();
 
        // print
        while (iter.hasNext()) {
        	Statement stmt     = iter.nextStatement();  // ���� ���¸� ����
        	Resource subject   =stmt.getSubject();      // subject�� ����
        	Property predicate = stmt.getPredicate();   // predicate�� ��
        	RDFNode object     = stmt.getObject();      // object�� ����
        	
        	System.out.print(subject.toString());
        	System.out.print(" " + predicate.toString() + " ");
        	if (object instanceof Resource) {
        		System.out.print(object.toString());
        	} else {
        		// object is a literal
        		System.out.print(" \"" + object.toString() + "\"");
        	}
        	
        	System.out.println(" .");
        	
        }
	}
}