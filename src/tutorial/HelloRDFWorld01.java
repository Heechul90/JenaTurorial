package tutorial;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;

public class HelloRDFWorld01 {
	
	// ������� ���� ����ϱ�
	
	public static void main(String[] args) {
		
	Model m = ModelFactory.createDefaultModel();
    m.read("file:C:/Users/Cho/Documents/owl/1.owl");

    m.write(System.out, "RDF/XML");
    
	}
}
