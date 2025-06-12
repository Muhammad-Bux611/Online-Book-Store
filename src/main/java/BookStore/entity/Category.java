package BookStore.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
	@Id
 public	int id ;
 public	String title;
public	String discription;

	@OneToMany(mappedBy = "category")
public	List<Book> books;

	public int getId() {
	return id;
	}

	public void setId(int id) {
	this.id = id;
	}

	public String getTitle() {
	return title;
	}

	public void setTitle(String title) {
	this.title = title;
	}

	public String getDiscription() {
	return discription;
	}

	public void setDiscription(String discription) {
	this.discription = discription;
	}

	public List<Book> getBooks() {
	return books;
	}

	public void setBooks(List<Book> books) {
	this.books = books;
	}
}
