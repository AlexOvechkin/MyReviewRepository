package br.com.myreview.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import br.com.myreview.enums.Cities;
import br.com.myreview.enums.Districts;
import br.com.myreview.enums.States;

@Entity
@Table(name="est_establishments")
public class Establishment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "est_id")
	private Long id;
	
	@Column(name = "est_name", length = 50, nullable = false)
	@NotEmpty
	private String name;
	
	@Column(name = "est_cnpj", length = 14, nullable = false)
	@NotEmpty
	private String cnpj;
	
	@Column(name = "est_description", length = 300, nullable = true)
	private String description = "Sem descrição!";
	
	@Column(name = "est_stars", nullable = false)
	private Double stars = 0.0;
	
	@Column(name = "est_country", length = 100, nullable = false)
	private String country;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "est_state", nullable = false)
	private States state;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "est_city", length = 100, nullable = false)
	private Cities city;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "est_district", nullable = false)
	private Districts district;
	
	@Column(name = "est_number", length = 100, nullable = false)
	@Min(0)
	private int number;
	
	@OneToMany(mappedBy = "establishment", fetch = FetchType.LAZY)
	private List<Review> reviews;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getStars() {
		return stars;
	}
	public void setStars(Double stars) {
		this.stars = stars;
	}
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public States getState() {
		return state;
	}
	public void setState(States state) {
		this.state = state;
	}
	public Cities getCity() {
		return city;
	}
	public void setCity(Cities city) {
		this.city = city;
	}
	public Districts getDistrict() {
		return district;
	}
	public void setDistrict(Districts district) {
		this.district = district;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	
	
}
