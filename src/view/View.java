package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Book;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingContainer;
import javax.swing.BorderFactory;
import javax.swing.border.MatteBorder;

import controller.Controller;
import model.Books;
import model.Main;
import model.ReaderBorrow;

import java.awt.Color;


public class View{
	public JButton jButton_Login;
	public JButton jButton_FindBook;
	public JButton jButton_BorrowBook;
	public JButton jButton_PayBook;
	public JButton jButton_BookBorrowed;
	public JButton jButton_ImfReader;
	public JButton jButton_FoundBookInterFace;
	public ActionListener ac = new Controller(this);
	public JTextField jTextField_UserName;
	public JTextField jTextField_PassWork;
	public JTextField jTextField_FoundBook;
	private JTextField jTextField_BorrowBook;
	private JButton jButton_BorrowBookInterFace;
	private JTextField jTextField_PayBook;
	private JButton jButton_PayBookInterFace;
	
	
	public String getJTextField_UserName() {
		return jTextField_UserName.getText();
	}
	public String getJTextField_PassWork() {
		return jTextField_PassWork.getText();
	}
	public String getJTextField_FoundBook() {
		return jTextField_FoundBook.getText();
	}
	public int getJTextField_BorrowBook() {
	    return Integer.parseInt(jTextField_BorrowBook.getText());
	}
	public int getJTextField_PayBook() {
	    return Integer.parseInt(jTextField_PayBook.getText());
	}
	
	public View() {
		
	}

	public void Login() {
		
		JFrame jfame = new JFrame();
		jfame.setTitle("THU VIEN BORCELLE");
		jfame.setSize(800,280);
		jfame.setLocationRelativeTo(null);
		jfame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Font font = new Font("Arial",Font.BOLD, 60);
		
		JLabel jLabel_Login = new JLabel("Login");
		jLabel_Login.setFont(font);
		jButton_Login = new JButton("Đăng nhập");
		jButton_Login.addActionListener(ac);
		jButton_Login.setPreferredSize(new Dimension(40, 40));

		JLabel jLabel_UserName = new JLabel("Username : ");
		jLabel_UserName.setHorizontalAlignment(JLabel.CENTER);
		JLabel jLabel_PassWork = new JLabel("Passwork : ");
		jLabel_PassWork.setHorizontalAlignment(JLabel.CENTER);
		JLabel UserName = new JLabel();
		
		jTextField_UserName = new JTextField();
		jTextField_UserName.setPreferredSize(new Dimension(200, 40));
		JPanel jPanel_UserName = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jPanel_UserName.add(jTextField_UserName);
		jTextField_PassWork = new JTextField();
		jTextField_PassWork.setPreferredSize(new Dimension(200, 40));
		jTextField_PassWork.setHorizontalAlignment(JTextField.LEFT);
		JPanel jPanel_PassWork = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jPanel_PassWork.add(jTextField_PassWork);
		
		
		JLabel jLabel_PictureIcon = new JLabel();
		ImageIcon iconPicture = new ImageIcon("C:\\Users\\dodan\\eclipse-workspace\\LibraryManagement\\src\\picture\\Borcelle.png");
		Image image = iconPicture.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(image);
		jLabel_PictureIcon.setIcon(scaledIcon);
		jLabel_PictureIcon.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		
		JPanel jPanel_Login = new JPanel();
		jPanel_Login.setLayout(new BorderLayout());
		jPanel_Login.add(jLabel_Login, BorderLayout.NORTH);
		jLabel_Login.setHorizontalAlignment(JLabel.CENTER);
		JPanel jLabel_UserAndPass = new JPanel();
		jLabel_UserAndPass.setLayout(new GridLayout(2,2,20,20));
		jLabel_UserAndPass.add(jLabel_UserName);
		jLabel_UserAndPass.add(jPanel_UserName);
		jLabel_UserAndPass.add(jLabel_PassWork);
		jLabel_UserAndPass.add(jPanel_PassWork);
		jPanel_Login.add(jLabel_UserAndPass, BorderLayout.CENTER);
		jPanel_Login.add(jButton_Login, BorderLayout.SOUTH);
		jfame.setLayout(new BorderLayout());
		jfame.add(jPanel_Login, BorderLayout.CENTER);
		jfame.add(jLabel_PictureIcon, BorderLayout.WEST);
		
		jfame.setVisible(true);
	}
	
	public void userInterFace(String nameUser) {
		JFrame jFrame = new JFrame();
		jFrame.setTitle("THU VIEN BORCELLE");
		jFrame.setSize(1000,500);
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setPreferredSize(new Dimension(250, 500));
		leftPanel.setLayout(new BorderLayout());
		JPanel rightPanel = new JPanel();
		rightPanel.setPreferredSize(new Dimension(750, 500));
		rightPanel.setLayout(new BorderLayout());
		
		jButton_FindBook = new JButton("Tìm sách");
		jButton_FindBook.addActionListener(ac);
		jButton_BorrowBook = new JButton("Mượn sách");
		jButton_BorrowBook.addActionListener(ac);
		jButton_PayBook = new JButton("Trả sách");
		jButton_PayBook.addActionListener(ac);
		jButton_BookBorrowed = new JButton("Sách đã mượn");
		jButton_BookBorrowed.addActionListener(ac);
		jButton_ImfReader = new JButton("Thông tin cá nhân");
		jButton_ImfReader.addActionListener(ac);
		
		JLabel jLabel_PictureIcon = new JLabel();
		ImageIcon iconPicture = new ImageIcon("C:\\Users\\dodan\\eclipse-workspace\\LibraryManagement\\src\\picture\\Untitled design.png");
		Image image = iconPicture.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(image);
		jLabel_PictureIcon.setIcon(scaledIcon);
		jLabel_PictureIcon.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		JPanel userReader = new JPanel();
		JLabel jLabel_UserName = new JLabel(nameUser);
		userReader.setLayout(new FlowLayout(FlowLayout.LEFT));
		userReader.setAlignmentX(Component.LEFT_ALIGNMENT);
		userReader.setBorder(BorderFactory.createEmptyBorder(0, 35, 0, 0));
		userReader.add(jLabel_PictureIcon);
		userReader.add(jLabel_UserName);
		leftPanel.add(userReader, BorderLayout.NORTH);
		MatteBorder rightBorder = BorderFactory.createMatteBorder(0, 0, 0, 3, Color.GRAY);
		leftPanel.setBorder(rightBorder);
		MatteBorder bottomBorder = BorderFactory.createMatteBorder(0, 0, 3, 0, Color.GRAY);
		userReader.setBorder(bottomBorder);
		
		JPanel jPanel_Button = new JPanel(new GridLayout(5, 1,15,15));
		jPanel_Button.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		jPanel_Button.add(jButton_FindBook);
		jPanel_Button.add(jButton_BorrowBook);
		jPanel_Button.add(jButton_PayBook);
		jPanel_Button.add(jButton_BookBorrowed);
		jPanel_Button.add(jButton_ImfReader);
		leftPanel.add(jPanel_Button, BorderLayout.CENTER);
		jFrame.setLayout(new BorderLayout());
		jFrame.add(leftPanel, BorderLayout.WEST);
		jFrame.add(rightPanel, BorderLayout.CENTER);
		
	    rightPanel.setLayout(new GridLayout(0,6));
	    JLabel jLabel_CodeBook = new JLabel("CodeBook"); 
    	JLabel jLabel_NameBook = new JLabel("Tên sách");
    	JLabel jLabel_NameAuthor = new JLabel("Tên tác giả");
    	JLabel jLabel_PublishYear = new JLabel("Năm xuất bản");
    	JLabel jLabel_CateGory = new JLabel("Thể loại");
    	JLabel jLabel_Amount = new JLabel("Số lượng");
    	rightPanel.add(jLabel_CodeBook);
        rightPanel.add(jLabel_NameBook); 
        rightPanel.add(jLabel_NameAuthor);   
        rightPanel.add(jLabel_PublishYear);
        rightPanel.add(jLabel_CateGory);
        rightPanel.add(jLabel_Amount);
        
        for(Books book : Main.dataBook) {
        	JLabel codeBook = new JLabel(String.valueOf(book.getBookCode()));
            JLabel nameBook = new JLabel(book.getBookName());
            JLabel author = new JLabel(book.getAuthorName());
            JLabel publishYear = new JLabel(String.valueOf(book.getPublishYear()));
            JLabel category = new JLabel(book.getCateGory());
            JLabel amount = new JLabel(String.valueOf(book.getAmount()));
        	rightPanel.add(codeBook);
        	rightPanel.add(nameBook);
        	rightPanel.add(author);
        	rightPanel.add(publishYear);
        	rightPanel.add(category);
        	rightPanel.add(amount);
        }
        JScrollPane scrollPane = new JScrollPane(rightPanel);
        jFrame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		jFrame.setVisible(true);
	}
	
	public void interfaceFoundBook() {
		JFrame jFrame = new JFrame();
		jFrame.setTitle("THU VIEN BORCELLE");
		jFrame.setSize(600,420);
		jFrame.setLocation(600, 200);
		jFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		jFrame.setLayout(new BorderLayout());
		JPanel jPanel_FoundBook = new JPanel();
		JLabel jLabel_FoundBook = new JLabel("Tìm kiếm : ");
		jTextField_FoundBook = new JTextField(40);
		jButton_FoundBookInterFace = new JButton("Tìm");
		jButton_FoundBookInterFace.addActionListener(ac);
		
		jPanel_FoundBook.add(jLabel_FoundBook);
		jPanel_FoundBook.add(jTextField_FoundBook);
		jPanel_FoundBook.add(jButton_FoundBookInterFace, BorderLayout.NORTH);
	
		jFrame.add(jPanel_FoundBook, BorderLayout.NORTH);
		jFrame.setVisible(true);
	}
	
	public void interfaceBorrowBook() {
		JFrame jFrame = new JFrame();
		jFrame.setTitle("THU VIEN BORCELLE");
		jFrame.setSize(600,420);
		jFrame.setLocation(600, 200);
		jFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		jFrame.setLayout(new BorderLayout());
		JPanel jPanel_BorrowBook = new JPanel();
		JLabel jLabel_BorrowBook = new JLabel("Nhập mã sách bạn muốn mượn ");
		jTextField_BorrowBook = new JTextField(20);
		jButton_BorrowBookInterFace = new JButton("Mượn");
		jButton_BorrowBookInterFace.addActionListener(ac);
		
		jPanel_BorrowBook.add(jLabel_BorrowBook);
		jPanel_BorrowBook.add(jTextField_BorrowBook);
		jPanel_BorrowBook.add(jButton_BorrowBookInterFace, BorderLayout.NORTH);
		
		jFrame.add(jPanel_BorrowBook, BorderLayout.NORTH);
		jFrame.setVisible(true);
	}
	
	public void interfacePayBook() {
		JFrame jFrame = new JFrame();
		jFrame.setTitle("THU VIEN BORCELLE");
		jFrame.setSize(600,420);
		jFrame.setLocation(600, 200);
		jFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		jFrame.setLayout(new BorderLayout());
		JPanel jPanel_PayBook = new JPanel();
		JLabel jLabel_PayBook = new JLabel("Nhập mã sách bạn muốn trả : ");
		jTextField_PayBook = new JTextField(20);
		
		jButton_PayBookInterFace = new JButton("Trả");
		jButton_PayBookInterFace.addActionListener(ac);
		
		jPanel_PayBook.add(jLabel_PayBook);
		jPanel_PayBook.add(jTextField_PayBook);
		jPanel_PayBook.add(jButton_PayBookInterFace, BorderLayout.NORTH);
		
		jFrame.add(jPanel_PayBook, BorderLayout.NORTH);
		jFrame.setVisible(true);
	}
	
	public void interfaceReaderBorrowedBook() {
		JFrame jFrame = new JFrame();
		jFrame.setTitle("THU VIEN BORCELLE");
		jFrame.setSize(600,420);
		jFrame.setLocation(600, 200);
		jFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		jFrame.setLayout(new BorderLayout());
		JPanel jPanel_FoundBook = new JPanel();
		JLabel jLabel_FoundBook = new JLabel("Danh sách bạn đã mượn : ");
		
		JPanel jPanel_ImfBookBorrowed = new JPanel(new GridLayout(0,5,20,20));
		
		JLabel jLabel_CodeBook = new JLabel("CodeBook"); 
    	JLabel jLabel_NameBook = new JLabel("Tên sách");
    	JLabel jLabel_NameAuthor = new JLabel("Tên tác giả");
    	JLabel jLabel_PublishYear = new JLabel("Năm xuất bản");
    	JLabel jLabel_CateGory = new JLabel("Thể loại");

    	jPanel_ImfBookBorrowed.add(jLabel_CodeBook);
        jPanel_ImfBookBorrowed.add(jLabel_NameBook); 
        jPanel_ImfBookBorrowed.add(jLabel_NameAuthor);   
        jPanel_ImfBookBorrowed.add(jLabel_PublishYear);
        jPanel_ImfBookBorrowed.add(jLabel_CateGory);

				
        for(Books bookBorrowed : Main.dataBook) {
        	for(ReaderBorrow readerBorrow : Main.dataReaderBorrowed) {
        		if(readerBorrow.codeBook == bookBorrowed.getBookCode() && readerBorrow.getIdUser() == Main.logInCurrentReader.get(0).getIdUser()) {
        			JLabel codebookBorrowed = new JLabel(String.valueOf(bookBorrowed.getBookCode()));
                    JLabel namebookBorrowed = new JLabel(bookBorrowed.getBookName());
                    JLabel author = new JLabel(bookBorrowed.getAuthorName());
                    JLabel publishYear = new JLabel(String.valueOf(bookBorrowed.getPublishYear()));
                    JLabel category = new JLabel(bookBorrowed.getCateGory());

                	jPanel_ImfBookBorrowed.add(codebookBorrowed);
                	jPanel_ImfBookBorrowed.add(namebookBorrowed);
                	jPanel_ImfBookBorrowed.add(author);
                	jPanel_ImfBookBorrowed.add(publishYear);
                	jPanel_ImfBookBorrowed.add(category);

        		}
        	}
        }
        
		jPanel_FoundBook.add(jLabel_FoundBook);
		
		jFrame.add(jPanel_FoundBook, BorderLayout.NORTH);
		jFrame.add(jPanel_ImfBookBorrowed, BorderLayout.CENTER);
		jFrame.setVisible(true);
	}
	
	public void interfaceImfReader() {
		JFrame jFrame = new JFrame();
		jFrame.setTitle("THU VIEN BORCELLE");
		jFrame.setSize(300,250);
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		jFrame.setLayout(new BorderLayout());
		JPanel jPanel_FoundBook = new JPanel();
		JLabel jLabel_FoundBook = new JLabel("Thông tin cá nhân : ");
		
		jPanel_FoundBook.add(jLabel_FoundBook);
		
		JPanel jPanel_ImfUser = new JPanel(new GridLayout(0,2,20,20));
		
		JLabel jLabel_CodeUser = new JLabel("CodeUser : "); 
    	JLabel jLabel_Name = new JLabel("Tên : ");
    	JLabel jLabel_Age = new JLabel("Tuổi : ");
    	JLabel jLabel_Address = new JLabel("Address : ");
    	JLabel jLabel_SDT = new JLabel("Số điện thoại : ");
    	JLabel jLabel_CMND = new JLabel("Chứng minh nhân dân : ");
    	JLabel jLabel_CodeUserValue = new JLabel(Main.logInCurrentReader.get(0).getIdUser()+""); 
    	JLabel jLabel_NameValue = new JLabel(Main.logInCurrentReader.get(0).getNameReader());
    	JLabel jLabel_AgeValue= new JLabel(Main.logInCurrentReader.get(0).getAgeReader()+"");
    	JLabel jLabel_AddressValue = new JLabel(Main.logInCurrentReader.get(0).getAddress());
    	JLabel jLabel_SDTValue = new JLabel(Main.logInCurrentReader.get(0).getPhoneNumber()+"");
    	JLabel jLabel_CMNDValue = new JLabel(Main.logInCurrentReader.get(0).getCmnd()+"");
    	
    	
    	jPanel_ImfUser.add(jLabel_CodeUser);
    	jPanel_ImfUser.add(jLabel_CodeUserValue);
        jPanel_ImfUser.add(jLabel_Name); 
        jPanel_ImfUser.add(jLabel_NameValue);
        jPanel_ImfUser.add(jLabel_Age);   
        jPanel_ImfUser.add(jLabel_AgeValue);
        jPanel_ImfUser.add(jLabel_Address);
        jPanel_ImfUser.add(jLabel_AddressValue);
        jPanel_ImfUser.add(jLabel_SDT);
        jPanel_ImfUser.add(jLabel_SDTValue);
        jPanel_ImfUser.add(jLabel_CMND);
        jPanel_ImfUser.add(jLabel_CMNDValue);
       
        jFrame.add(jPanel_ImfUser, BorderLayout.CENTER);
		jFrame.add(jPanel_FoundBook, BorderLayout.NORTH);
		jFrame.setVisible(true);
	}
	
	
	public void errorLogin() {
		Font font = new Font("Arial",Font.BOLD, 15);
		JFrame jFrame = new JFrame();
		jFrame.setTitle("Error Login");
		jFrame.setSize(250,290);
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		jFrame.setLayout(new BorderLayout());
		JPanel jPanel_FoundBook = new JPanel();
		JLabel jLabel_FoundBook = new JLabel("Đăng nhập thất bại !");
		jLabel_FoundBook.setFont(font);
		jLabel_FoundBook.setHorizontalAlignment(SwingConstants.CENTER);
		jPanel_FoundBook.add(jLabel_FoundBook);
		
		JLabel jLabel_PictureIcon = new JLabel();
		ImageIcon iconPicture = new ImageIcon("C:\\Users\\dodan\\eclipse-workspace\\LibraryManagement\\src\\picture\\404.png");
		Image image = iconPicture.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(image);
		jLabel_PictureIcon.setIcon(scaledIcon);
		jLabel_PictureIcon.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));	
		jFrame.add(jLabel_PictureIcon, BorderLayout.SOUTH);
		jFrame.add(jPanel_FoundBook, BorderLayout.CENTER);	
		
		
		jFrame.setVisible(true);
	}
	
	public void listFoundBook() {
		JFrame jFrame = new JFrame();
		jFrame.setTitle("THU VIEN BORCELLE");
		jFrame.setSize(600,420);
		jFrame.setLocation(600, 200);
		jFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		jFrame.setLayout(new BorderLayout());
		JLabel jLabel_Title = new JLabel("Danh sách :");
		jFrame.add(jLabel_Title, BorderLayout.NORTH);
		
		JPanel jPanel_Data = new JPanel();
	    jPanel_Data.setLayout(new GridLayout(0,6));
	    JLabel jLabel_CodeBook = new JLabel("CodeBook"); 
    	JLabel jLabel_NameBook = new JLabel("Tên sách");
    	JLabel jLabel_NameAuthor = new JLabel("Tên tác giả");
    	JLabel jLabel_PublishYear = new JLabel("Năm xuất bản");
    	JLabel jLabel_CateGory = new JLabel("Thể loại");
    	JLabel jLabel_Amount = new JLabel("Số lượng");
    	jPanel_Data.add(jLabel_CodeBook);
        jPanel_Data.add(jLabel_NameBook); 
        jPanel_Data.add(jLabel_NameAuthor);   
        jPanel_Data.add(jLabel_PublishYear);
        jPanel_Data.add(jLabel_CateGory);
        jPanel_Data.add(jLabel_Amount);
        
        for(Books book : Main.result) {
        	JLabel codeBook = new JLabel(String.valueOf(book.getBookCode()));
            JLabel nameBook = new JLabel(book.getBookName());
            JLabel author = new JLabel(book.getAuthorName());
            JLabel publishYear = new JLabel(String.valueOf(book.getPublishYear()));
            JLabel category = new JLabel(book.getCateGory());
            JLabel amount = new JLabel(String.valueOf(book.getAmount()));
        	jPanel_Data.add(codeBook);
        	jPanel_Data.add(nameBook);
        	jPanel_Data.add(author);
        	jPanel_Data.add(publishYear);
        	jPanel_Data.add(category);
        	jPanel_Data.add(amount);
        }
        JScrollPane scrollPane = new JScrollPane(jPanel_Data);
        jFrame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        jFrame.add(jPanel_Data, BorderLayout.CENTER);
		jFrame.setVisible(true);
	}
	
	public void errorFound() {
		Font font = new Font("Arial",Font.BOLD, 15);
		JFrame jFrame = new JFrame();
		jFrame.setTitle("Error Found");
		jFrame.setSize(250,290);
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		jFrame.setLayout(new BorderLayout());
		JPanel jPanel_FoundBook = new JPanel();
		JLabel jLabel_FoundBook = new JLabel("Không tìm thấy !");
		jLabel_FoundBook.setFont(font);
		jLabel_FoundBook.setHorizontalAlignment(SwingConstants.CENTER);
		jPanel_FoundBook.add(jLabel_FoundBook);
		
		JLabel jLabel_PictureIcon = new JLabel();
		ImageIcon iconPicture = new ImageIcon("C:\\Users\\dodan\\eclipse-workspace\\LibraryManagement\\src\\picture\\404.png");
		Image image = iconPicture.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(image);
		jLabel_PictureIcon.setIcon(scaledIcon);
		jLabel_PictureIcon.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));	
		jFrame.add(jLabel_PictureIcon, BorderLayout.SOUTH);
		jFrame.add(jPanel_FoundBook, BorderLayout.CENTER);	
		
		jFrame.setVisible(true);
	}
	
	public void borrowBookReader() {
		Font font = new Font("Arial",Font.BOLD, 15);
		JFrame jFrame = new JFrame();
		jFrame.setTitle("Borrow");
		jFrame.setSize(250,290);
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		jFrame.setLayout(new BorderLayout());
		JPanel jPanel_FoundBook = new JPanel();
		JLabel jLabel_FoundBook = new JLabel("Bạn đã mượn thành công !");
		jLabel_FoundBook.setFont(font);
		jLabel_FoundBook.setHorizontalAlignment(SwingConstants.CENTER);
		jPanel_FoundBook.add(jLabel_FoundBook);
		
		JLabel jLabel_PictureIcon = new JLabel();
		ImageIcon iconPicture = new ImageIcon("C:\\Users\\dodan\\eclipse-workspace\\LibraryManagement\\src\\picture\\sun.png");
		Image image = iconPicture.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(image);
		jLabel_PictureIcon.setIcon(scaledIcon);
		jLabel_PictureIcon.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));	
		jFrame.add(jLabel_PictureIcon, BorderLayout.SOUTH);
		jFrame.add(jPanel_FoundBook, BorderLayout.CENTER);	
		
		jFrame.setVisible(true);
	}
	
	public void emptyBook() {
		Font font = new Font("Arial",Font.BOLD, 15);
		JFrame jFrame = new JFrame();
		jFrame.setTitle("Error");
		jFrame.setSize(250,290);
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		jFrame.setLayout(new BorderLayout());
		JPanel jPanel_FoundBook = new JPanel();
		JLabel jLabel_FoundBook = new JLabel("Hết sách để mượn !");
		jLabel_FoundBook.setFont(font);
		jLabel_FoundBook.setHorizontalAlignment(SwingConstants.CENTER);
		jPanel_FoundBook.add(jLabel_FoundBook);
		
		JLabel jLabel_PictureIcon = new JLabel();
		ImageIcon iconPicture = new ImageIcon("C:\\Users\\dodan\\eclipse-workspace\\LibraryManagement\\src\\picture\\Buon.png");
		Image image = iconPicture.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(image);
		jLabel_PictureIcon.setIcon(scaledIcon);
		jLabel_PictureIcon.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));	
		jFrame.add(jLabel_PictureIcon, BorderLayout.SOUTH);
		jFrame.add(jPanel_FoundBook, BorderLayout.CENTER);	
		
		jFrame.setVisible(true);
	}
	
	// trả sách
	
	public void payBookSuccess() {
		Font font = new Font("Arial",Font.BOLD, 15);
		JFrame jFrame = new JFrame();
		jFrame.setTitle("Success");
		jFrame.setSize(250,290);
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		jFrame.setLayout(new BorderLayout());
		JPanel jPanel_PayBook = new JPanel();
		JLabel jLabel_PayBook = new JLabel("Trả sách thành công !");
		jLabel_PayBook.setFont(font);
		jLabel_PayBook.setHorizontalAlignment(SwingConstants.CENTER);
		jPanel_PayBook.add(jLabel_PayBook);
		
		JLabel jLabel_PictureIcon = new JLabel();
		ImageIcon iconPicture = new ImageIcon("C:\\Users\\dodan\\eclipse-workspace\\LibraryManagement\\src\\picture\\sun.png");
		Image image = iconPicture.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(image);
		jLabel_PictureIcon.setIcon(scaledIcon);
		jLabel_PictureIcon.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));	
		jFrame.add(jLabel_PictureIcon, BorderLayout.SOUTH);
		jFrame.add(jPanel_PayBook, BorderLayout.CENTER);	
		
		jFrame.setVisible(true);
	}
	
	public void payBookFail() {
		Font font = new Font("Arial",Font.BOLD, 15);
		JFrame jFrame = new JFrame();
		jFrame.setTitle("Error");
		jFrame.setSize(250,290);
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		jFrame.setLayout(new BorderLayout());
		JPanel jPanel_PayBook = new JPanel();
		JLabel jLabel_PayBook = new JLabel("Bạn chưa mượn sách này !");
		jLabel_PayBook.setFont(font);
		jLabel_PayBook.setHorizontalAlignment(SwingConstants.CENTER);
		jPanel_PayBook.add(jLabel_PayBook);
		
		JLabel jLabel_PictureIcon = new JLabel();
		ImageIcon iconPicture = new ImageIcon("C:\\Users\\dodan\\eclipse-workspace\\LibraryManagement\\src\\picture\\Buon.png");
		Image image = iconPicture.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(image);
		jLabel_PictureIcon.setIcon(scaledIcon);
		jLabel_PictureIcon.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));	
		jFrame.add(jLabel_PictureIcon, BorderLayout.SOUTH);
		jFrame.add(jPanel_PayBook, BorderLayout.CENTER);	
		jFrame.setVisible(true);
	}
	
	public void interfaceAdmin() {
		
	}
	
}
