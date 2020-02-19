package course.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Author {

	
	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
		private Long authorid;
	

		private String name;

		@OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
		private List<Book> books;

		public Author(String name) {
			super();
			this.name = name;
		
		}

		public Author() {
		
			
		}

		public Long getId() {
			return authorid;
		}

		public void setId(Long id) {
			this.authorid = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public List<Book> getBooks() {
			return books;
		}

		public void setBooks(List<Book> books) {
			this.books = books;
		}

		@Override
		public String toString() {
			return "Author [authorid=" + authorid + ", name=" + name + "]";
		}
	
		
		
}
