package jenaRDFapiTutorial;

import java.io.InputStream;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.SimpleSelector;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.util.FileManager;
import org.apache.jena.vocabulary.VCARD;

public class HelloRDFWorld08 {
	
	// Querying a model
	// public boolean selects(Statement s){조건}을 사용하여 참인것만 출력
	
	static final String inputFileName = "D:/workspace/JenaTutorial/Documents/rdf/vc-db-1.rdf";
	
	public static void main (String args[]) {
		
		Model model = ModelFactory.createDefaultModel();
		
		InputStream in = FileManager.get().open(inputFileName);
		if (in == null) {
			throw new IllegalArgumentException("File: " + inputFileName + " not found");
		}
		
		model.read(in, "");
		
		StmtIterator iter = model.listStatements(
				new SimpleSelector(null, VCARD.FN, (RDFNode) null) {
					@Override
					public boolean selects(Statement s) {
						return s.getString().endsWith("Smith");
					}
				});
		if (iter.hasNext()) {
			System.out.println("The database contains vcards for:");
			while (iter.hasNext()) {
				System.out.println("  " + iter.nextStatement().getString());
			}
		} else {
			System.out.println("No Smith's were found in the database");
			
		}
	}
}
