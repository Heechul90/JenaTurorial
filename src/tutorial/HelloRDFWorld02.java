package tutorial;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.VCARD;

public class HelloRDFWorld02 {
	
	// ¸ðµ¨ ¸¸µé±â
	// Model, Resource, Property
	
	static String personURI    = "http://somewhere/JohnSmith";
    static String fullName     = "John Smith";
    public static void main(String[] args){
        
 
        // create an empty Model
        Model model = ModelFactory.createDefaultModel();
 
        // create the resource
        Resource johnSmith = model.createResource(personURI);
 
        // add the property
         johnSmith.addProperty(VCARD.FN, fullName);
         
         model.write(System.out, "RDF/XML");
         
    }
}
