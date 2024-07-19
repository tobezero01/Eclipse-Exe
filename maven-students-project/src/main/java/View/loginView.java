package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

// giao diện trình đăng nhập
import Model.user;

@SuppressWarnings("unused")
public class loginView extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private JLabel loginNameLabel;
    private JLabel passwordLabel;
    private JTextField nameLoginField;
    private JPasswordField passwordField;
    private JButton loginBtn;
    
    public loginView() {
    	initializationComponents();
    }
    private void initializationComponents() {
    	  loginNameLabel = new JLabel("UserName");
    	  passwordLabel = new JLabel("Password");
    	  nameLoginField = new JTextField(20);
    	  passwordField = new JPasswordField(20);
    	  
    	  loginBtn = new JButton("Login");	  
    	  
    	  
    	  JPanel panel = new JPanel();
    	  // sử dụng Spring layout để tạo sắp xếp giao diện
    	  
    	  SpringLayout springLayout = new SpringLayout();
          
    	  // sap xep cac vi tri
    	  panel.add(loginNameLabel);
          springLayout.putConstraint(SpringLayout.WEST,loginNameLabel,30,SpringLayout.WEST,panel);
          springLayout.putConstraint(SpringLayout.NORTH,loginNameLabel ,80,SpringLayout.NORTH,panel);
          panel.add(nameLoginField);
          springLayout.putConstraint(SpringLayout.WEST,nameLoginField ,25,SpringLayout.EAST,loginNameLabel);
          springLayout.putConstraint(SpringLayout.NORTH,nameLoginField ,80,SpringLayout.NORTH,panel);
          panel.add(passwordLabel);
          springLayout.putConstraint(SpringLayout.WEST, passwordLabel, 30, SpringLayout.WEST, panel);
          springLayout.putConstraint(SpringLayout.NORTH, passwordLabel, 105, SpringLayout.NORTH, panel);
          panel.add(passwordField);
          springLayout.putConstraint(SpringLayout.WEST, passwordField, 27, SpringLayout.EAST, passwordLabel);
          springLayout.putConstraint(SpringLayout.NORTH, passwordField, 105, SpringLayout.NORTH, panel);
          panel.add(loginBtn);
          springLayout.putConstraint(SpringLayout.WEST, loginBtn, 86, SpringLayout.WEST, passwordLabel);
          springLayout.putConstraint(SpringLayout.NORTH, loginBtn, 130, SpringLayout.NORTH, panel);
                   
          panel.setSize(400,300);
          panel.setLayout(springLayout);
          add(panel);
          setTitle("Login");
          
    	  setSize(400, 300);
	   	  setLocationRelativeTo(null);
	   	  setVisible(true);
	   	  setResizable(false);
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void addLoginActionListener(ActionListener listener) {
		loginBtn.addActionListener(listener);
	}
	public user getUser() {
		return new user(nameLoginField.getText(), String.copyValueOf(passwordField.getPassword()));
	}
	public void messageShow(String message) {
		JOptionPane.showMessageDialog(this.loginBtn, message);
	}
}
