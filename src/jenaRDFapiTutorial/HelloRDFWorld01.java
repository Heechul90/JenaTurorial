package jenaRDFapiTutorial;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;

public class HelloRDFWorld01 {
	
	// ������� ���� ����ϱ�
	
	public static void main(String[] args) {
		
	Model m = ModelFactory.createDefaultModel();
    m.read("D:/workspace/JenaTutorial/Documents/ttl/keris_data_v10_rdf_v2.ttl");

    m.write(System.out, "RDF/XML");
    
	}
}
