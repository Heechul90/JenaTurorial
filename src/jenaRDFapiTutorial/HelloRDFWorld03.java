package jenaRDFapiTutorial;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.VCARD;

public class HelloRDFWorld03 {
	
	// 모델 만들기
	// 속성에 모델 만들기
	// Model, Resource, Property
	
	// 사용되는 문자열 정의
    static String personURI    = "http://somewhere/JohnSmith";
    static String fullName     = "John Smith";
    static String givenName    = "Smith";
    static String familyName   = "John";
    
    public static void main(String[] args){
        
 
        // 빈 모델 생성
        Model model = ModelFactory.createDefaultModel();
 
        // 리소스 생성 및 속성 추가
        Resource johnSmith = model.createResource(personURI)
                .addProperty(VCARD.FN, fullName)
                .addProperty(VCARD.N, model.createResource()
                        .addProperty(VCARD.Given, givenName)
                        .addProperty(VCARD.Family, familyName));
 
         // 출력
         model.write(System.out, "RDF/XML");
         
    }
}
