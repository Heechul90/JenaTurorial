package jenaRDFapiTutorial;

import java.io.InputStream;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.ResIterator;
import org.apache.jena.util.FileManager;
import org.apache.jena.vocabulary.VCARD;

public class HelloRDFWorld07 {
	
	// Querying a model
	
    static final String inputFileName = "d:/workspace/JenaTutorial/Documents/rdf/vc-db-1.rdf";
    
    public static void main (String args[]) {
       
        Model model = ModelFactory.createDefaultModel();
       
        
        InputStream in = FileManager.get().open(inputFileName);
        if (in == null) {
        	
            throw new IllegalArgumentException( "File: " + inputFileName + " not found");
            
        }
        
  
        model.read( in, "");
        
        ResIterator iter = model.listResourcesWithProperty(VCARD.FN);
        
        if (iter.hasNext()) {
            System.out.println("The database contains vcards for:");
            while (iter.hasNext()) {
                System.out.println("  " + iter.nextResource()
                                              .getRequiredProperty(VCARD.FN)
                                              .getString() );
            }
        } else {
            System.out.println("No vcards were found in the database");
            
        }            
    }
}
