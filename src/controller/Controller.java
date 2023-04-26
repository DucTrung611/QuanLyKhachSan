package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import model.Main;
import model.Reader;
import view.View;

public class Controller implements ActionListener{
	public View view;
	
	public Controller(View view) {
        this.view = view;
    }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String getStringAction = e.getActionCommand();
		System.out.println(getStringAction);
		Reader reader = new Reader();
		if(getStringAction.equals("Đăng nhập")) {
			reader.logIn(view.getJTextField_UserName(), view.getJTextField_PassWork());
		}
		if(getStringAction.equals("Tìm sách")) {
			view.interfaceFoundBook();
		}
		if(getStringAction.equals("Tìm")) {
			reader.foundBookOfReader(view.getJTextField_FoundBook());
		}
		if(getStringAction.equals("Mượn sách")) {
			view.interfaceBorrowBook();
		}
		if(getStringAction.equals("Mượn")) {
			reader.borrowBookReader(Main.logInCurrentReader.get(0), view.getJTextField_BorrowBook());
		}
		if(getStringAction.equals("Trả sách")) {
			view.interfacePayBook();
		}
		if(getStringAction.equals("Trả")) {
			reader.returnBookReaderBorrowed(Main.logInCurrentReader.get(0).getIdUser() , view.getJTextField_PayBook());
		}
		if(getStringAction.equals("Sách đã mượn")) {
			view.interfaceReaderBorrowedBook();
		}
		if(getStringAction.equals("Thông tin cá nhân")) {
			view.interfaceImfReader();
		}
	}
	
}

