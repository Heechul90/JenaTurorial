package jenaRDFapiTutorial;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.VCARD;

public class HelloRDFWorld03 {
	
	// �� �����
	// �Ӽ��� �� �����
	// Model, Resource, Property
	
	// ���Ǵ� ���ڿ� ����
    static String personURI    = "http://somewhere/JohnSmith";
    static String fullName     = "John Smith";
    static String givenName    = "Smith";
    static String familyName   = "John";
    
    public static void main(String[] args){
        
 
        // �� �� ����
        Model model = ModelFactory.createDefaultModel();
 
        // ���ҽ� ���� �� �Ӽ� �߰�
        Resource johnSmith = model.createResource(personURI)
                .addProperty(VCARD.FN, fullName)
                .addProperty(VCARD.N, model.createResource()
                        .addProperty(VCARD.Given, givenName)
                        .addProperty(VCARD.Family, familyName));
 
         // ���
         model.write(System.out, "RDF/XML");
         
    }
}
