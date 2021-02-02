package Model;

public class Book {
	private int id;
	private String name;
	private String authorName;
	private int quantity;
	private String genre;
	public Book() {
		// TODO Auto-generated constructor stub
	}
	public Book(int id, String name, String authorName, int quantity, String genre) {
		super();
		this.id = id;
		this.name = name;
		this.authorName = authorName;
		this.quantity = quantity;
		this.genre = genre;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	
	
	
	
	

}
