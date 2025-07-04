package BookStore.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Admin {
	@Id
public	int id; 
public	String name;
public	String email;
public	String password;
	
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
	
	public String getEmail() {
	return email;
	}
	
	public void setEmail(String email) {
	this.email = email;
	}
	
	public String getPassword() {
	return password;
}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + "]";
		}

	}

