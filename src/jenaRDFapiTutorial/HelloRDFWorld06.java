package jenaRDFapiTutorial;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;

public class HelloRDFWorld06 extends Object {
	
	// Controlling prefix
	// prefix 사용하기
	
	public static void main (String args[]) {
		
		Model model = ModelFactory.createDefaultModel();
		
		String nsA = "http://somewhere/else#";
		String nsB = "http://nowhere/else#";
		Resource root = model.createResource( nsA + "root");
		Property P = model.createProperty( nsA + "P" );
		Property Q = model.createProperty( nsB + "Q" );
		Resource x = model.createResource( nsA + "x" );
		Resource y = model.createResource( nsA + "y" );
		Resource z = model.createResource( nsA + "z" );
		model.add( root, P, x ).add( root, P, y ).add( y, Q, z);
		System.out.println( "# -- no special prefixes defined" );
		model.write( System.out );
		System.out.println( "# -- nsA defined ");
		model.setNsPrefix( "nsA", nsA );
		model.write( System.out );
		System.out.println( "# -- nsA and cat defined" );
		model.setNsPrefix( "cat", nsB );
		model.write( System.out );
		
	}
}
