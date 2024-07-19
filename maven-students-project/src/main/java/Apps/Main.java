package Apps;

import java.awt.EventQueue;
import java.lang.reflect.InvocationTargetException;

import Controller.loginControll;
import View.loginView;

public class Main {

	public static void main(String[] args) throws InvocationTargetException, InterruptedException {
		EventQueue.invokeLater(new Runnable() {        
			public void run() {
				loginView loginview = new loginView();
				loginControll LController = new loginControll(loginview);
				LController.showLoginView();
			}
		});

	}


}
