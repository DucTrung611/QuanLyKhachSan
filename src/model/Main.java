package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import view.View;

public class Main {
	public static ArrayList<ReaderBorrow> dataReaderBorrowed = new ArrayList<ReaderBorrow>();
	public static ArrayList<Books> dataBook = new ArrayList<Books>();
	public static ArrayList<Reader> dataReader = new ArrayList<>();
	public static ArrayList<Librarian> dataLibrarians = new ArrayList<Librarian>();
	public static Map<Reader, ArrayList<Books>> bookReaderBorrowed = new HashMap<>();
	public static ArrayList<Reader> logInCurrentReader = new ArrayList<Reader>();
	public static ArrayList<Librarian> logInCurrentLibrarian = new ArrayList<Librarian>();
	public static ArrayList<Books> result = new ArrayList<>();
	
	public static void main(String[] args) {
		Books book = new Books();
		book.takeDataBooks();
		for(Books book1 : dataBook) {
			System.out.println(book1.toString());
		}
		
		Librarian librarian = new Librarian();
		librarian.takeDataLibraian();
		for(Librarian librarian2: dataLibrarians) {
			System.out.println(librarian2.toString());
		}		
		
		Reader reader3 = new Reader();
		reader3.takeDataReader();
		for(Reader reader2 : dataReader) {
			System.out.println(reader2.toString2());
		}
		
		ReaderBorrow readerBorrow = new ReaderBorrow();
		readerBorrow.takeDataBorrower();
		for(ReaderBorrow r : dataReaderBorrowed) {
			System.out.println(r.toString());
		}
		
		View view = new View();
		view.Login();
	}
}
