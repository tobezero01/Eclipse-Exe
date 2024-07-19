package Controller;

// xử lý dữ liệu từ loginView
import Model.userCheckInformation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.user;
import View.loginView;
import View.studentView;

public class loginControll {
    private userCheckInformation urerCheck;
    private loginView loginview;
    private studentView stview;

	public loginControll( loginView view) {
		
		this.urerCheck = new userCheckInformation();
		this.loginview = view;
		view.addLoginActionListener(new LoginListener() );
	}
	public userCheckInformation getUrerCheck() {
		return urerCheck;
	}
	public void showLoginView() {
        loginview.setVisible(true);
    }
	class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            user user = loginview.getUser();
            if (urerCheck.checkUserInformation(user)) {
                stview = new studentView();
                studentControll studentController = new studentControll(stview);
                studentController.showStudentView();
                loginview.setVisible(false);
            } else {
                loginview.messageShow("username or password is incorrect!");
            }
        }

    }
    
}
