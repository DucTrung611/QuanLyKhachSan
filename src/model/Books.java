package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class Books {
	public int bookCode;
	public String bookName;
	public String authorName;
	public int publishYear;
	public String cateGory;
	public int amount;
	public static String fileDataName = "C:\\Users\\dodan\\eclipse-workspace\\LibraryManagement\\src\\alldata\\DataBook.txt";
	
	public Books() {}

	public Books(int bookCode, String bookName, String authorName, int publishYear, String cateGory, int amount) {
		this.bookCode = bookCode;
		this.bookName = bookName;
		this.authorName = authorName;
		this.publishYear = publishYear;
		this.cateGory = cateGory;
		this.amount = amount;
	}
	
	public int getBookCode() {
		return bookCode;
	}

	public void setBookCode(int bookCode) {
		this.bookCode = bookCode;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public int getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}

	public String getCateGory() {
		return cateGory;
	}

	public void setCateGory(String cateGory) {
		this.cateGory = cateGory;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public String toString() {
		return "Books [bookCode=" + bookCode + ", bookName=" + bookName + ", authorName=" + authorName
				+ ", publishYear=" + publishYear + ", cateGory=" + cateGory + ", amount=" + amount + "]";
	}
	
	public String toString2() {
		return bookCode + "," + bookName + "," + authorName + "," + publishYear + "," + cateGory + "," + amount;
	}
	
	public static void takeDataBooks() {
		try {
	        BufferedReader br = new BufferedReader(new FileReader(fileDataName));
	        String line;
	        while ((line = br.readLine()) != null) {
	            String[] tokens = line.split(",");
	            int bookCode = Integer.parseInt(tokens[0]);
	            String bookName = tokens[1];
	            String authorName = tokens[2];
	            int publishYear = Integer.parseInt(tokens[3]);
	            String cateGory = tokens[4];
	            int amount = Integer.parseInt(tokens[5]);
	            Books book = new Books(bookCode,bookName,authorName,publishYear,cateGory,amount);
	            Main.dataBook.add(book);
	        }
	        br.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	        System.out.println("Loi");
	    }
	}
	
	// thêm sách và ghi nó vào file dataBook
	public void addBooks(int bookCode, String bookName, String authorName, int publishYear, String cateGory, int amount) {
		Books book = new Books(bookCode,bookName,authorName,publishYear,cateGory,amount);
	    Main.dataBook.add(book);
	    try {
            FileWriter writer = new FileWriter(fileDataName, true);
            PrintWriter printWriter = new PrintWriter(writer);

            // Lấy ra phần tử cuối cùng của mảng để ghi vào file
            Books addBook = Main.dataBook.get(Main.dataBook.size() - 1);

            printWriter.println(addBook.toString2());
            printWriter.close();
        } catch (IOException e) {
            System.out.println("Đã có lỗi khi viết file: " + e.getMessage());
        }
	    System.out.println("Nhập sách thành công");
	}
	
	// xóa sách trong file dataBook
	public void deleteBook(int bookCode) {
		boolean founded = false;
	    for (Books book : Main.dataBook) {
	        if (book.getBookCode() == bookCode) {
	            Main.dataBook.remove(book);
	            System.out.println("Đã xóa sách có mã " + bookCode);
	            founded = true;
	            break;
	        }
	    }
	    if (!founded) {
	        System.out.println("Không tìm thấy sách có mã " + bookCode);
	    }
	    try {
	        PrintWriter printWriter = new PrintWriter(new FileWriter(fileDataName));
	        for (Books book : Main.dataBook) {
	            printWriter.println(book.toString2());
	        }
	        printWriter.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}	
	
	public ArrayList<Books> foundBook(String keyBookCode) {
	    ArrayList<Books> result = new ArrayList<>();
	    for (Books book : Main.dataBook) {
	        if (book.getBookName().toLowerCase().contains(keyBookCode.toLowerCase())) {
	        	result.add(book);
	        }
	    }
	    return result;
	}	
	// in ra kết quả của việc tìm sách
	public void printResultFoundedBook(ArrayList<Books> result) {
		if (result.isEmpty()) {
	        System.out.println("Không tìm thấy sách nào");
	    } else {
	        System.out.println("Kết quả tìm kiếm:");
	        for (Books book : result) {
	            System.out.println(book.toString());
	        }
	    }
	}
	// cập nhật dataBooks
	public static void updateDataBooks() {
		try {
	        PrintWriter printWriter = new PrintWriter(new FileWriter(fileDataName));
	        for (Books book : Main.dataBook) {
	            printWriter.println(book.toString2());
	        }
	        printWriter.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}
