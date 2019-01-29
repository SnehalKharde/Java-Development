package logic_manager;

public class Book {
	int bookid;
	int number_of_copies;
	String bookname;
	String authorname;
	String book_type;
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthorname() {
		return authorname;
	}
	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public int getNumber_of_copies() {
		return number_of_copies;
	}
	public void setNumber_of_copies(int number_of_copies) {
		this.number_of_copies = number_of_copies;
	}
	public String getBook_type() {
		return book_type;
	}
	public void setBook_type(String book_type) {
		this.book_type = book_type;
	}
}
