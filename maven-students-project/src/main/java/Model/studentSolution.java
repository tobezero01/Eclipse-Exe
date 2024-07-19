package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import fileIO.fileIO;

// chứa những phương thức quản lý di sinh viên

public class studentSolution {
	private static final String STUDENT_FILE_NAME = "StudentsData.xml";
    private List<student> lStudent;
       
	/**
	 * @param lStudent
	 */
	public studentSolution() {	
		this.lStudent = readLStudent();
		if(lStudent == null) {
			lStudent = new ArrayList<student>();
		}
	}

    // lưu đối tượng student vào file xml
	public void writeLStudents(List<student> students)   {
        studentFileXml studentXML = new studentFileXml();
        studentXML.setStudents(students);
        fileIO.writeFileXML(studentXML ,STUDENT_FILE_NAME);
    }
	
	// đọc các đối tượng student từ file xml
	public List<student> readLStudent() {
		List<student> listStudent = new ArrayList<student>();
	    studentFileXml studentXML = (studentFileXml) fileIO.readFileXml(studentFileXml.class, STUDENT_FILE_NAME);
		if(studentXML != null) {
			listStudent = studentXML.getStudents();
		}
	    
	    return listStudent;		
	}
    // sort by gpa
	

		
	public void sortStudentGpa () {
		Collections.sort(lStudent, new Comparator<student>() {

			public int compare(student o1, student o2) {
				if(o1.getGpa() > o2.getGpa()) {
					return 1;
				}
				return -1;
			}
		});
	}
	// sort  by name
	Comparator<student> cmpName = new  Comparator<student> () {
		public int compare(student s1, student s2) {
            return s1.getName().compareTo(s2.getName());
        }
		
	};
			
	public void sortStudentName() {
		Collections.sort(lStudent, cmpName);
	}
	
	/**
     * cập nhật student vào listStudents và lưu listStudents vào file
     * 
     * @param student
     */
	public void editStudent(student student)  {
		int size = lStudent.size();
		for(int i = 0 ; i < size ; i++) {
			if(lStudent.get(i).getId() == student.getId()) {
				lStudent.get(i).setName(student.getName());
				lStudent.get(i).setAge(student.getAge());
				lStudent.get(i).setAddress(student.getAddress());
				lStudent.get(i).setPhoneNumber(student.getPhoneNumber());
				lStudent.get(i).setGpa(student.getGpa());
				writeLStudents(lStudent);
				break;
			}
		}
	}
	
	/**
     * thêm student vào listStudents và lưu listStudents vào file
     * 
     * @param student
     */
	
	public void addStudent(student student) {
		int id = 1;
		int size = lStudent.size();
		if(lStudent != null && size > 0) {
			id = size + 1;
 		}
		student.setId(id);
        lStudent.add(student);
		writeLStudents(lStudent);		
	}
	
	/**
     * xóa student từ listStudents và lưu listStudents vào file
     * 
     * @param student
     */
	public boolean deleteStudent(student student) {
		boolean checkFound = false;
		int size = lStudent.size();
		for(int i = 0; i < size ; i++) {
			if(lStudent.get(i).getId() == student.getId()) {
                student = lStudent.get(i);
				checkFound = true;
				break;
			}
		}
		if(checkFound) {
			lStudent.remove(student);			
			writeLStudents(lStudent);								
			return true;
		}
		return false;
	}
	
	/// getter setter
	public List<student> getlStudent() {
		return lStudent;
	}

	public void setlStudent(List<student> lStudent) {
		this.lStudent = lStudent;
	}

	
}

