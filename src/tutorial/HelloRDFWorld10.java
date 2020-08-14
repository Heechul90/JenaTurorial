package tutorial;

import org.apache.jena.rdf.model.StmtIterator;

public class HelloRDFWorld10 {
	
	// Querying a model
	// public boolean selects(Statement s){조건}을 사용하여 참인것만 출력
	
	StmtIterator iter = model.listStatements(
			  new
			      SimpleSelector(null, null, (RDFNode) null) {
			          public boolean selects(Statement s) {
			              return (subject == null   || s.getSubject().equals(subject))
			                  && (predicate == null || s.getPredicate().equals(predicate))
			                  && (object == null    || s.getObject().equals(object))
			          }
			     }
			 });
}
