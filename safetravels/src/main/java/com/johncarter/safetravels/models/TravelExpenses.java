package com.johncarter.safetravels.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="travelexpenses")
public class TravelExpenses {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min=5, max=50, message="The Name of the Expense must be at least 5 characters long and no more than 50 characters.")
    private String name;

    @NotNull
    @Size(min=5, max=300, message="Please enter a valid description, at least 5 characters long")
    private String desc;

    @NotNull
    @Size(min=1, max=50, message="The Seller must be at least 1 character.")
    private String seller;

    @NotNull
    @Min(value=0, message="The price of the travel Expense cannot be less than 0.")
    private double price;
    
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    public TravelExpenses() {
    	
    }
    
    public TravelExpenses(Long id, String name, String desc, String seller, Double price, Date createdAt, Date updatedAt) {
    	this.id = id;
    	this.name = name;
    	this.desc = desc;
    	this.seller = seller;
    	this.price = price;
    	this.createdAt = createdAt;
    	this.updatedAt = updatedAt;
    }
    
    @PrePersist
    protected void onCreate() {
    	this.createdAt= new Date();
    }
    
    @PreUpdate
    protected void onUpdate() {
    	this.updatedAt = new Date();
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

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
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

}


