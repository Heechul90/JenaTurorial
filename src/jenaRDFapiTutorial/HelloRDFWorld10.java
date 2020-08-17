package jenaRDFapiTutorial;

import org.apache.jena.rdf.model.Bag;
import org.apache.jena.rdf.model.StmtIterator;

public class HelloRDFWorld10 {
	
	// Containers
	
	// create a bag
	Bag smiths = model.createBag();
	 
	// select all the resources with a VCARD.FN property
	// whose value ends with "Smith"
	StmtIterator iter = model.listStatements(
	    new SimpleSelector(null, VCARD.FN, (RDFNode) null) {
	        public boolean selects(Statement s) {
	                return s.getString().endsWith("Smith");
	        }
	    });
	// add the Smith's to the bag
	while (iter.hasNext()) {
	    smiths.add(iter.nextStatement().getSubject());
	}
}
