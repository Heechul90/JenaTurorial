package tutorial;

import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.VCARD;

public class HelloRDFWorld07 {
	
	// Navigation a Model
	// ¸ðµ¨ Ã£±â
	
	Resource name = (Resource) VCARD.getProperty(VCARD.N)
			.getObject();

}

