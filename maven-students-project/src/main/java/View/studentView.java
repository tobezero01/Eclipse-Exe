package View;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Model.student;

// giao diện trình quản lý

public class studentView extends JFrame implements ActionListener,ListSelectionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton addBtn;
	private JButton editBtn;
	private JButton deleteBtn;
	private JButton clearBtn;
	private JButton sortNameBtn;
	private JButton sortGPABtn;
	
	private JTable studentTable;
	private JScrollPane JSStudentTable;
	
	private JLabel idLabel;
	private JTextField idField;
	
	private JLabel nameLabel;
	private JTextField nameField;
	
	private JLabel ageLabel;
	private JTextField ageField;
	
	private JLabel addressLabel;	    	    
	private JTextArea addressTextArea;
	
	private JLabel phoneNumberLabel;
	private JTextField phoneNumberField;
	
    private JLabel gpaLabel;
	private JTextField gpaField;
	
	// định nghĩa các cột bảng
	private String [] col = new String [] {
			"ID","Name Student" , "Age","Address", "Phone Number", "GPA"
	};
	
	// định nghĩa dữ liệu mặc định của bẳng student là rỗng
	private Object data = new Object [][] {};

	
	public studentView() {
		initializationComponents();
	}
	
	private void initializationComponents() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		addBtn = new JButton("Add");
		editBtn = new JButton("Edit");
		deleteBtn = new JButton("Delete");
        clearBtn = new JButton("Clear");
        sortGPABtn = new JButton("Sort GPA");
        sortNameBtn = new JButton("Sort Name");
		
		studentTable = new JTable();
		
        idLabel = new JLabel("ID");
        idField = new JTextField(10);
        idField.setEditable(false);
        
        nameField = new JTextField(15);
        nameLabel = new JLabel("Name");
        
        ageField = new JTextField(10);
        ageLabel = new JLabel("Age");
        
        addressLabel = new JLabel("Address");
        addressTextArea = new JTextArea();
        addressTextArea.setColumns(15);
        addressTextArea.setRows(6);
        
        phoneNumberLabel = new JLabel("Phone");
        phoneNumberField = new JTextField(15);
        
        gpaLabel = new JLabel("GPA");
        gpaField = new JTextField(6);
        
        // cài đặt các cột dữ liệu
        // dữ liệu ban đầu rỗng
        JSStudentTable = new JScrollPane();
        studentTable.setModel(new DefaultTableModel((Object[][]) data, col));
        JSStudentTable.setViewportView(studentTable);
        JSStudentTable.setPreferredSize(new Dimension (650, 500));
        
        // spring layout
        JPanel panel = new JPanel();
        panel.setSize(1000, 620); 
        SpringLayout layout = new SpringLayout();
        panel.setLayout(layout);
        
        // cai dat vi tri
        panel.add(JSStudentTable);
        panel.add(addBtn);
        panel.add(editBtn);
        panel.add(deleteBtn);
        panel.add(clearBtn);
        panel.add(sortGPABtn);
        panel.add(sortNameBtn);
        panel.add(idLabel);
        panel.add(idField);
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(ageLabel);
        panel.add(ageField);
        panel.add(addressLabel);
        panel.add(addressTextArea);
        panel.add(phoneNumberLabel);
        panel.add(phoneNumberField);
        panel.add(gpaLabel);
        panel.add(gpaField);
        
        layout.putConstraint(SpringLayout.WEST, JSStudentTable, 330, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, JSStudentTable, 10, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, addBtn, 15, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addBtn, 282, SpringLayout.NORTH, panel);
       
        layout.putConstraint(SpringLayout.WEST, editBtn, 85, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, editBtn, 282, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, deleteBtn, 155, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, deleteBtn, 282, SpringLayout.NORTH, panel);
       
        layout.putConstraint(SpringLayout.NORTH, clearBtn, 282, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, clearBtn, 240, SpringLayout.WEST, panel);
        
        layout.putConstraint(SpringLayout.WEST, sortGPABtn, 330, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, sortGPABtn, 530, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, sortNameBtn, 115, SpringLayout.WEST, sortGPABtn);
        layout.putConstraint(SpringLayout.NORTH, sortNameBtn, 530, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, idLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idLabel, 10, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, idField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idField, 10, SpringLayout.NORTH, panel);
        
        
        layout.putConstraint(SpringLayout.WEST, nameLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, nameLabel, 40, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, nameField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, nameField, 40, SpringLayout.NORTH, panel);
                   
        layout.putConstraint(SpringLayout.WEST, ageLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, ageLabel, 70, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, ageField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, ageField, 70, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, addressLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addressLabel, 100, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, addressTextArea, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addressTextArea, 100, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, phoneNumberLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, phoneNumberLabel, 210, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, phoneNumberField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, phoneNumberField, 210, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, gpaLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, gpaLabel, 240, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, gpaField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, gpaField, 240, SpringLayout.NORTH, panel);
        
        this.add(panel);
        this.pack();
        setSize(1000, 620);  
		setLocationRelativeTo(null);
		this.setVisible(true);
		this.setTitle("Student Manage");
		deleteBtn.setEnabled(false);
		editBtn.setEnabled(false);
		addBtn.setEnabled(true);
	}
	
	public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
	 /**
     * hiển thị danh sach student vào bảng studentTable
     * 
     * @param list
     */
	public void showListStudents(List<student> list) {
        int size = list.size();
        // với bảng studentTable có 5 cột, 
        // khởi tạo mảng 2 chiều students, trong đó:
        // số hàng: là kích thước của list student 
        // số cột: là 5
        Object [][] students = new Object[size][6];
        for (int i = 0; i < size; i++) {
            students[i][0] = list.get(i).getId();
            students[i][1] = list.get(i).getName();
            students[i][2] = list.get(i).getAge();
            students[i][3] = list.get(i).getAddress();
            students[i][4] = list.get(i).getPhoneNumber();
            students[i][5] = list.get(i).getGpa();
        }
        studentTable.setModel(new DefaultTableModel(students, col));
    }
     
    /**
     * điền thông tin của hàng được chọn từ bảng student 
     * vào các trường tương ứng của student.
     */
    public void fillStudentFromSelectedRow() {
        // lấy chỉ số của hàng được chọn 
        int row = studentTable.getSelectedRow();
        if (row >= 0) {
            idField.setText(studentTable.getModel().getValueAt(row, 0).toString());
            nameField.setText(studentTable.getModel().getValueAt(row, 1).toString());
            ageField.setText(studentTable.getModel().getValueAt(row, 2).toString());
            addressTextArea.setText(studentTable.getModel().getValueAt(row, 3).toString());
            phoneNumberField.setText(studentTable.getModel().getValueAt(row, 4).toString());
    		gpaField.setText(studentTable.getModel().getValueAt(row, 5).toString());
            // enable Edit and Delete buttons
            editBtn.setEnabled(true);
            deleteBtn.setEnabled(true);
            // disable Add button
            addBtn.setEnabled(false);
        }
    }
    // xóa thong tin
    
    public void clearStudentInfo() {
    	idField.setText("");
    	nameField.setText("");
    	ageField.setText("");
    	addressTextArea.setText("");
    	phoneNumberField.setText("");
    	gpaField.setText("");
    	
    	editBtn.setEnabled(false);
    	deleteBtn.setEnabled(false);
    	addBtn.setEnabled(true);
    }    
    /**
     * hiện thị thông tin student
     * 
     * @param student
     */
    public void showStudent(student student) {
        idField.setText("" + student.getId());
        nameField.setText(student.getName());
        ageField.setText("" + student.getAge());
        addressTextArea.setText(student.getAddress());
        phoneNumberField.setText(student.getPhoneNumber());
        gpaField.setText("" + student.getGpa());
        // enable Edit and Delete buttons
        editBtn.setEnabled(true);
        deleteBtn.setEnabled(true);
        // disable Add button
        addBtn.setEnabled(false);
    }
    /**
     * lấy thông tin student
     * 
     * @return
     */
    public student getStudentInfo() {
        // validate student
        if (!validateName() || !validatePhone() || !validateAge() || !validateAddress() || !validateGpa()) {
            return null;
        }
        try {
            student student = new student();
            if (idField.getText() != null && !"".equals(idField.getText())) {
                student.setId(Integer.parseInt(idField.getText()));
            }
            student.setName(nameField.getText().trim());
            student.setAge(Byte.parseByte(ageField.getText().trim()));
            student.setAddress(addressTextArea.getText().trim());
            student.setPhoneNumber(phoneNumberField.getText().trim());
            student.setGpa(Float.parseFloat(gpaField.getText().trim()));
            return student;
        } catch (Exception e) {
            showMessage(e.getMessage());
        }
        return null;
    }
      
	private boolean validateGpa() {
		try {
            Double gpa = Double.parseDouble(gpaField.getText().trim());
            if (gpa < 0 || gpa > 4) {
                gpaField.requestFocus();
                showMessage("GPA is not valid.");
                return false;
            }
        } catch (Exception e) {
            gpaField.requestFocus();
            showMessage("GPA is not valid!");
            return false;
        }
        return true;
	}

	private boolean validateAddress() {
		String address = addressTextArea.getText();
        if (address == null || "".equals(address.trim())) {
            addressTextArea.requestFocus();
            showMessage("Address cannot be empty.");
            return false;
        }
        return true;
	}

	private boolean validatePhone() {
		String phoneNumber = phoneNumberField.getText();
		String pattern = "^(0|\\+84)[0-9]d{10,20}$";
		if(phoneNumber.matches(pattern)) {
			return true;
		}
		return false;
	}

	private boolean validateAge() {
		try {
			Byte age = Byte.parseByte(ageField.getText().trim());
			if(age < 0 && age > 100) {
				ageField.requestFocus();
				showMessage("Age is not valid");
				return false;
			}
		}catch (Exception e) {
			ageField.requestFocus();
			showMessage("Age is not valid");
			return false;
		}
		return true;
	}

	private boolean validateName() {
		String name = nameField.getText();
		if(name == null || "".equals(name.trim())) {
			nameField.requestFocus();
			showMessage("Name cannot be empty!");
			return false;
		}
		return true;
	}
	
	 public void actionPerformed(ActionEvent e) {
	    }
	    
	   public void valueChanged(ListSelectionEvent e) {
	    }
	public void addAddBtnListener(ActionListener listener) {
		addBtn.addActionListener(listener);
	}
	
	public void addEditBtnListener(ActionListener listener) {
		editBtn.addActionListener(listener);
	}
	
	public void addDeleteBtnListener(ActionListener listener) {
		deleteBtn.addActionListener(listener);
	}
	
	public void addClearBtnListener(ActionListener listener) {
		clearBtn.addActionListener(listener);
	}
	
	public void addSortGpaListener(ActionListener listener) {
		sortGPABtn.addActionListener(listener);
	}
	
	public void addSortNameListener(ActionListener listener) {
		sortNameBtn.addActionListener(listener);
	}
	
	public void addListStudentSelectionListener(ListSelectionListener listener) {
        studentTable.getSelectionModel().addListSelectionListener(listener);
    }
}

