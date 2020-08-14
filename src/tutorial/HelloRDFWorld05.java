package tutorial;

import java.io.InputStream;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.FileManager;

public class HelloRDFWorld05 extends Object {
	
	// RDF 파일 읽기
	
	public static void main (String args[]) {
		
		Model model = ModelFactory.createDefaultModel();
		
		InputStream in = FileManager.get().open( "file:D:/workspace/JenaTutorial/Documents/owl/test.owl");
		if (in == null) {
			
			throw new IllegalArgumentException( "File not found" );
			
		}
	}
}
