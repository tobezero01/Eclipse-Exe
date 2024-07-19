package Model;
// để luu thông tin sinh viên vào file XMl nào đó

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "students")
@XmlAccessorType(XmlAccessType.FIELD)
public class studentFileXml {
     private List<student> student;

	public List<student> getStudents() {
		return student;
	}

	public void setStudents(List<student> students) {
		this.student = students;
	}
     
     
}
