package course.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;



import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String  year, isbn, price;
	
	
	@NotEmpty
	 @Size(min=3, max=30)	
	 private String title;

	  @ManyToOne
	    @JsonIgnore
	    @JoinColumn(name = "authorid")
	private Author author;
	
	public Book() {}
	
	public Book(String title, Author author, String year, String isbn, String price) {
		super();
		
		this.title = title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
	}





	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}


	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + this.getAuthor() + ", year=" + year + ", isbn=" + isbn
				+ ", price=" + price + "]";
	}

	public void setTitle(String title) {
		this.title = title;
	}





	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
}
