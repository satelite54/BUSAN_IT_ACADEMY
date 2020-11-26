package chapter11;

class Book {
	int bookNumber;
	String bookTitle;
	
	Book(int bookNumber, String bookTitle) {
		this.bookNumber = bookNumber;
		this.bookTitle = bookTitle;
	}
}

public class ToStringEx {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Book book1 = new Book(200,"����");
			Book book2 = new Book(300,"�ܹ�");
			
			Book book3 = book1;
			Book book4 = book3;
			
			System.out.println(book1);
			System.out.println(book1.toString());
			
			System.out.println(book2);
			System.out.println(book2.toString());
			
			System.out.println(book3.equals(book4));
	}

}
