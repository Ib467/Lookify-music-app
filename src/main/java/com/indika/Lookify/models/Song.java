package com.indika.Lookify.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="songs")



//name / title / rating 

public class Song {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=5, max=20, message="Name must be at lease 5-20 characters long")
	private String name;
	
	@Size(min=5, max=20, message="Name must be at lease 5-20 characters long")
	private String title;
	
	@Min(1)
	@Max(10)
	private Integer rating;
	
	@Min(1)
	@Max(10)
	private Integer star;
	
	public Song(Long id, @Size(min = 5, max = 20, message = "Name must be at lease 5-20 characters long") String name,
			@Size(min = 5, max = 20, message = "Name must be at lease 5-20 characters long") String title,
			@Min(1) @Max(10) Integer rating, @Min(1) @Max(10) Integer star, Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.name = name;
		this.title = title;
		this.rating = rating;
		this.star = star;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	
	//updated and created dates
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
	
    
    //constructor 
	
    public Song() {}

    
    
    // -----------getters & setters --------------------
	
		
	public Integer getStar() {
		return star;
	}

	public void setStar(Integer star) {
		this.star = star;
	}

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	// -----------getters & setters --------------------
	
	

	
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	
	
}
