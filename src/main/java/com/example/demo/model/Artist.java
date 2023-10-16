package com.example.demo.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name ="artist")
public class Artist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int artistId;
	private String penName;
	private String ratePrice;
	private String detail;
	private int exp;
	
	@ManyToOne
	@JoinColumn(name = "account_id")
	private Account account;
	
	@OneToMany
	@JoinColumn(name = "art_id")
	private List<Contact> contacts;
	
//	@OneToMany
//	@JoinColumn(name = "art_id")
//	private List<Image> images;
	
	
	public Artist(int id, int artistId, String penName, String ratePrice, String detail, int exp) {
		super();
		this.id = id;
		this.artistId = artistId;
		this.penName = penName;
		this.ratePrice = ratePrice;
		this.detail = detail;
		this.exp = exp;
	}

	public Artist() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getArtistId() {
		return artistId;
	}

	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}

	public String getPenName() {
		return penName;
	}

	public void setPenName(String penName) {
		this.penName = penName;
	}

	public String getRatePrice() {
		return ratePrice;
	}

	public void setRatePrice(String ratePrice) {
		this.ratePrice = ratePrice;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<Contact> getContact() {
		return contacts;
	}

	public void setContact(List<Contact> contact) {
		this.contacts = contact;
	}

//	public List<Image> getImages() {
//		return images;
//	}
//
//	public void setImages(List<Image> images) {
//		this.images = images;
//	}
	
	
}
