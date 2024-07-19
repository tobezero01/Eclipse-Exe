package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import Model.student;
// sử lý dữ liện từ student view 
// lắng nghe sự kiện click
import Model.studentSolution;
import View.studentView;

public class studentControll {
	private studentSolution stSolution;
	private studentView stView;
	
	public studentControll(studentView stview) {
		this.stView = stview;
		stSolution = new studentSolution();
		
		stview.addAddBtnListener(new addStudentListener());
	    stview.addEditBtnListener(new editStudentListener());
	    stview.addDeleteBtnListener(new deleteStudentListener());
        stview.addClearBtnListener(new clearStudentListener());
        stview.addSortGpaListener(new sortStudentGPAListener());
        stview.addSortNameListener(new sortStudentNameListener());
        stview.addListStudentSelectionListener(new listStudentSelectionListener());
	}
	
	public void showStudentView() {
		List<student> stList = stSolution.getlStudent();
		stView.setVisible(true);
		stView.showListStudents(stList);
	}
	
	
	// su kien click button addstudent
	class addStudentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            student student = stView.getStudentInfo();
            if (student != null) {              
					stSolution.addStudent(student);
					stView.showStudent(student);
	                stView.showListStudents(stSolution.getlStudent());
	                stView.showMessage("Add successful!");								          
            }
        }	
    }
	
	class editStudentListener implements ActionListener  {

		public void actionPerformed(ActionEvent e) {
			student student = stView.getStudentInfo();
			if(student != null) {
					stSolution.editStudent(student);
				    stView.showStudent(student);
				    stView.showListStudents(stSolution.getlStudent());
				    stView.showMessage("Edit successful!");				
			}
			
		}
		
	}
	
	class clearStudentListener implements ActionListener  {

		public void actionPerformed(ActionEvent e) {
			stView.clearStudentInfo();
		}					
	}
	
	public class deleteStudentListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			student student = stView.getStudentInfo();
			if (student != null) {
				stSolution.deleteStudent(student);
			    stView.showStudent(student);
			    stView.showListStudents(stSolution.getlStudent());
			    stView.showMessage("Edit successful!");         
            }		
		}	
	}
	
	class sortStudentGPAListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			stSolution.sortStudentGpa();
			stView.showListStudents(stSolution.getlStudent());			
		}	
	}
	class sortStudentNameListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			stSolution.sortStudentName();
			stView.showListStudents(stSolution.getlStudent());			
		}	
	}
	class listStudentSelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            stView.fillStudentFromSelectedRow();
        }	
    }
}
