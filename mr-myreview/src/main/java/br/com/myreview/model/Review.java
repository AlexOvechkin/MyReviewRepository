package br.com.myreview.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name="rvw_reviews")
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "rvw_id")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="usr_id")
	private User user;
	
	@JoinColumn(name="est_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Establishment establishment;
	
	@Column(name = "rvw_comment", length = 300, nullable = false)
	@NotEmpty
	private String comment;
	
	@Column(name = "rvw_stars", nullable = false)
	@NotEmpty
	private Double stars;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Establishment getEstablishment() {
		return establishment;
	}

	public void setEstablishment(Establishment establishment) {
		this.establishment = establishment;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Double getStars() {
		return stars;
	}

	public void setStars(Double stars) {
		this.stars = stars;
	}
	
	
}
