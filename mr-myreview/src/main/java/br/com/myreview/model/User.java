package br.com.myreview.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name="usr_users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "usr_id")
	private Long id;
	
	@Column(name = "usr_first_name", length = 70, nullable = false)
	@NotEmpty
	private String firstName;
	
	@Column(name = "usr_last_name", length = 100, nullable = false)
	@NotEmpty
	private String lastName;
	
	@Column(name = "usr_email", length = 60, nullable = false)
	@NotEmpty
	private String email;
	
	@Column(name = "usr_password", length = 45, nullable = false)
	@NotEmpty
	private String password;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Review> reviews;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	
	
}
