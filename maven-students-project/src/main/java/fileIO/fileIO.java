package fileIO;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Result;

public class fileIO {

	// chuyển đổi đối tượng nào đó về file xml rồi lưu vô fileName
     public static void writeFileXML( Object object,String fileName)  {
    	 try {
    		// tạo đối tượng
        	 JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
         
        	 Marshaller marshaller = jaxbContext.createMarshaller();
        	 // hình thành marshaller
        	 marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
         
        	 // lưu vô file xml
             File fileXml = new File(fileName);
             
             marshaller.marshal(fileXml, (Result) object);
    	     System.out.println("Đã lưu file student.xml thành công.");
    	 }catch (JAXBException e) {
			e.printStackTrace();
		}
     }
     
     public static Object readFileXml (Class<?> class1,String filename) {
		 try {
			 File fileXML = new File(filename);
			 JAXBContext jaxbContext = JAXBContext.newInstance(class1);
			 Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			 return unmarshaller.unmarshal(fileXML);
		 } catch (Exception e) {
			  e.printStackTrace();
		 }
    	 
    	 return null ;
    	 
     }

	
}
