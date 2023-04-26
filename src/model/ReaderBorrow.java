package model;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ReaderBorrow {
	public int idUser;
	public String nameReader;
	public String nameBook;
	public int codeBook;
	
	
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getNameReader() {
		return nameReader;
	}
	public void setNameReader(String nameReader) {
		this.nameReader = nameReader;
	}
	public String getNameBook() {
		return nameBook;
	}
	public void setNameBook(String nameBook) {
		this.nameBook = nameBook;
	}
	public int getCodeBook() {
		return codeBook;
	}
	public void setCmnd(int codeBook) {
		this.codeBook = codeBook;
	}
	public ReaderBorrow() {}
	
	public ReaderBorrow(int idUser, String nameReader, String nameBook, int codeBook) {
		this.idUser = idUser;
		this.nameReader = nameReader;
		this.nameBook = nameBook;
		this.codeBook =	codeBook;
	}
	
	@Override
	public String toString() {
		return "ReaderBorrow [idUser=" + idUser + ", nameReader=" + nameReader + ", nameBook=" + nameBook
				+ ", codeBook=" + codeBook + "]";
	}
	public String toString2() {
		return idUser + "," + nameReader + "," + nameBook + "," + codeBook;
	}
	
	// lấy dữ liệu DataBorrower
	public void takeDataBorrower() {
		File file = new File("C:\\Users\\dodan\\eclipse-workspace\\LibraryManagement\\src\\alldata\\DataBorrower.txt");

	    try {
	        Scanner scanner = new Scanner(file);
	        while (scanner.hasNextLine()) {
	            String data = scanner.nextLine();
	            String[] tokens = data.split(",");
	            int idUser = Integer.parseInt(tokens[0]);
	            String nameReaderBorrowed = tokens[1];
	            String nameBook = tokens[2];
	            int codeBook = Integer.parseInt(tokens[3]);
	        
	            ReaderBorrow readerBorrowed = new ReaderBorrow(idUser, nameReaderBorrowed, nameBook, codeBook);
	            Main.dataReaderBorrowed.add(readerBorrowed);
	        }
	        scanner.close();
	    }  catch (IOException e) {
	        e.printStackTrace();
	    }
	}
		
}