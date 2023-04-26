package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import view.View;

public class Reader {
	public int idUser;
	public String userName;
	public String passWork;
	public String nameReader;
	public int ageReader;
	public String address;
	public long phoneNumber;
	public long cmnd;
	// constructor
	public Reader () {}
	
	public Reader(int idUser,String userName, String passWork, String nameReader, int ageReader, String address, long phoneNumber,
			long cmnd) {
		this.idUser = idUser;
		this.userName = userName;
		this.passWork = passWork;
		this.nameReader = nameReader;
		this.ageReader = ageReader;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.cmnd = cmnd;
	}
	
	// get and set
		public int getIdUser() {
			return idUser;
		}
		public void setIdUser(int idUser) {
			this.idUser = idUser;
		}
		
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getPassWork() {
			return passWork;
		}
		public void setPassWork(String passWork) {
			this.passWork = passWork;
		}
		public String getNameReader() {
			return nameReader;
		}
		public void setNameReader(String nameReader) {
			this.nameReader = nameReader;
		}
		public int getAgeReader() {
			return ageReader;
		}
		public void setAgeReader(int ageReader) {
			this.ageReader = ageReader;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public long getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(long phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		public long getCmnd() {
			return cmnd;
		}
		public void setCmnd(long cmnd) {
			this.cmnd = cmnd;
		}
		
		// toString
		
		public String toString2() {
			return idUser + "," + userName + "," + passWork + "," + nameReader + "," + ageReader + "," + address + "," + phoneNumber + "," + cmnd;
		}
		
		@Override
		public String toString() {
			return "Reader [idUser=" + idUser + ", userName=" + userName + ", passWork=" + passWork + ", nameReader="
					+ nameReader + ", ageReader=" + ageReader + ", address=" + address + ", phoneNumber=" + phoneNumber
					+ ", cmnd=" + cmnd + "]";
		}
		
		// lấy dự liệu thông tin đọc giả
		public void takeDataReader() {
			ArrayList<Reader> dataReaderReader = new ArrayList<>();
			try {
		        BufferedReader takeData = new BufferedReader(new FileReader("C:\\Users\\dodan\\eclipse-workspace\\LibraryManagement\\src\\alldata\\DataReader.txt"));
		        String line;
		        while ((line = takeData.readLine()) != null) {
		            String[] tokens = line.split(",");
		            int idUser = Integer.parseInt(tokens[0]);
		            String userName = tokens[1];
		            String passWork = tokens[2];
		            String nameReader = tokens[3];
		            int ageReader = Integer.parseInt(tokens[4]);
		            String address = tokens[5];
		            long phoneNumber = Long.parseLong(tokens[6]);
		            long cmnd = Long.parseLong(tokens[7]);
		            Reader reader = new Reader();   
		            	reader.setAddress(address);
		            	reader.setAgeReader(ageReader);
		            	reader.setCmnd(cmnd);
		            	reader.setIdUser(idUser);
		            	reader.setNameReader(nameReader);
		            	reader.setPassWork(passWork);
		            	reader.setPhoneNumber(phoneNumber);
		            	reader.setUserName(userName);
		            dataReaderReader.add(reader);
		            Main.dataReader = dataReaderReader;
		        }
		        takeData.close();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}
		
		// đọc giả tìm kiếm sách
		public void foundBookOfReader(String key) {
		    Books book = new Books();
		    View view = new View();
		    Main.result = book.foundBook(key);
		    if (Main.result.isEmpty()) {
		        System.out.println("Không tìm thấy sách nào.");
		        view.errorFound();
		    } else {
		        System.out.println("Kết quả tìm kiếm:");
		        for (Books bookc : Main.result) {
		        	System.out.println(bookc);
		        }
		        view.listFoundBook();
		    }
		}
		
		// kiểm tra số lượng sách có còn để mượn không
		boolean checkAmountBook(Books book) {
			return book.getAmount()-1 >= 0;
		}
		
		// đọc giả mượn sách
		public void borrowBookReader(Reader reader, int codeBookScannered) {
			View view = new View();
			ArrayList<Books> bookBorrowed = Main.bookReaderBorrowed.getOrDefault(reader, new ArrayList<>());
			boolean check = false;
			for (Books book : Main.dataBook) {
		        if (book.getBookCode() == codeBookScannered) {
		            check = true;
		            if(!checkAmountBook(book)) {
		            	System.out.println("Đã không còn sách để mượn !");
		            	view.emptyBook();
		            }else {
			            System.out.println("Bạn đã mượn thành công");
			            book.setAmount(book.getAmount()-1);
			            Books updateBook = new Books();
			            updateBook.updateDataBooks();
			            bookBorrowed.add(book);
			            Main.bookReaderBorrowed.put(reader, bookBorrowed); 
			            view.borrowBookReader();
			            // đẩy thông tin người mượn và sách họ đã mượn vào file dataBorrowed
			            try {
			                FileWriter writer = new FileWriter("C:\\Users\\dodan\\eclipse-workspace\\LibraryManagement\\src\\alldata\\DataBorrower.txt", true);
			                PrintWriter printWriter = new PrintWriter(writer);	            
			                printWriter.println(reader.getIdUser() + "," + reader.getNameReader() + "," + book.getBookName() + "," + book.getBookCode());
			                printWriter.close();
			            } catch (IOException e) {
			                System.out.println("Đã có lỗi khi viết file: " + e.getMessage());
			            }
		            }
		        }
		        
		    }
			if (!check) {
		        // Không tìm thấy cuốn sách 
				view.errorFound();
			}
			
		}
		// tra sach
		public void returnBookReaderBorrowed(int idUser, int codeBookscannered) {
		    View view = new View();
		    ArrayList<ReaderBorrow> copyDataReaderBorrows = new ArrayList<>(Main.dataReaderBorrowed);
		    for(ReaderBorrow r :copyDataReaderBorrows) {
		    	System.out.println(r.toString());
		    }
		    boolean founded = false;
		    for(ReaderBorrow readerBorrow : copyDataReaderBorrows) {
		    	if(readerBorrow.getIdUser() == idUser && readerBorrow.getCodeBook() == codeBookscannered) {
		    		copyDataReaderBorrows.remove(readerBorrow);
		    		view.payBookSuccess();
		    		founded = true;
		    		for(Books book : Main.dataBook) {
				    	if(book.getBookCode() == codeBookscannered) {
				    		book.setAmount(book.getAmount()+1);
				    		book.updateDataBooks();
				    	}
				    }
		    		try {
				        PrintWriter printWriter = new PrintWriter(new FileWriter("C:\\Users\\dodan\\eclipse-workspace\\LibraryManagement\\src\\alldata\\DataBorrower.txt"), false);
				        for (ReaderBorrow readerBorrowedBook : copyDataReaderBorrows) {
				            printWriter.println(readerBorrowedBook.toString2());
				        }
				        printWriter.close();
				    } catch (IOException e) {
				        e.printStackTrace();
				    }
		    		break;
		    	}
		    }
		    if(!founded) {
		    	view.payBookFail();
		    }
		    
		}

		
		// in ra số sách đọc giả đã mượn
		public static void printListReaderBorrowed(Reader reader) {
		    ArrayList<Books> listBooksBorrowed = Main.bookReaderBorrowed.getOrDefault(reader, new ArrayList<>());
		    if (listBooksBorrowed.size() == 0) {
		        System.out.println("Đọc giả : " + reader.getNameReader() + " chưa mượn cuốn nào");
		    } else {
		        System.out.println("Đọc giả : " + reader.getNameReader() + " đã mượn các cuốn sau:");
		        for (Books book : listBooksBorrowed) {
		            System.out.println("- " + book.getBookName());
		        }
		    }
		}
		
		// update đọc giả
		public static void updateDataReader() {
			try {
				PrintWriter printWriter2 = new PrintWriter(new FileWriter("C:\\Users\\dodan\\eclipse-workspace\\QuanLyThuVien_Opp\\src\\qltv\\AllData\\DataReader.txt"));
		        for (Reader reader : Main.dataReader) {
		            printWriter2.println(reader.toString2());
		        }
		        printWriter2.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// đăng nhập
		public void logIn(String userNameScannered, String passWorkScannered) {
			View view = new View();
			System.out.println(userNameScannered);
			boolean success = true;
			LoginAdmin : for(Librarian librarian : Main.dataLibrarians) {
				if(userNameScannered.equals(librarian.getUserName()) && passWorkScannered.equals(librarian.getPassWork())) {
					System.out.println("Đăng nhập thành công");
					success = false;
					Main.logInCurrentLibrarian.add(librarian);
					break LoginAdmin;
				}
			}
			Login : for(Reader reader : Main.dataReader) {
				if((userNameScannered.equals(reader.getUserName())) && (passWorkScannered.equals(reader.getPassWork()))) {
					System.out.println("Đăng nhập thành công");
					success = false;
					Main.logInCurrentReader.add(reader);
					view.userInterFace(reader.getNameReader());
					break Login;
				}
			}
			if(success) {
				System.out.println("Đăng nhập không thành công !");
				view.errorLogin();
			}
		}
		
		// đăng xuất
		public void logOut() {
			System.out.println("Bạn đã đăng suất !");
			Main.logInCurrentReader.remove(Main.logInCurrentReader.get(0));	
		}
}
