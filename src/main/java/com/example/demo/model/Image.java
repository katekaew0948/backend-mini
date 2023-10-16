//package com.example.demo.model;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Table;
//
//import jakarta.persistence.GenerationType;
//
//@Entity
//@Table(name = "images")
//public class Image {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private int id;
//	private String url;
//    
//	@ManyToOne
//	@JoinColumn(name = "art_id")
//	private Artist artist;
//
//	public Image(int id, String url, Artist artist) {
//		super();
//		this.id = id;
//		this.url = url;
//		this.artist = artist;
//	}
//
//	public Image() {
//		super();
//	}
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getUrl() {
//		return url;
//	}
//
//	public void setUrl(String url) {
//		this.url = url;
//	}
//
//	public void setArtist(Artist artist) {
//		this.artist = artist;
//	}
//
//}
