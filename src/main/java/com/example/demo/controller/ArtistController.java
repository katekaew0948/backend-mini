package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Account;
import com.example.demo.model.Artist;
import com.example.demo.model.Contact;
import com.example.demo.model.Image;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.ArtistRepository;
import com.example.demo.repository.ContactRepository;
import com.example.demo.repository.ImageRepository;

@RestController
public class ArtistController {

	@Autowired
	ArtistRepository artistRepository;
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	ContactRepository contactRepository;
//	@Autowired
//	ImageRepository imageRepository;
	
	@GetMapping("/artist")
	public ResponseEntity<Object> getArtist() {

		try {
			List<Artist> artists = artistRepository.findAll();

			return new ResponseEntity<>(artists, HttpStatus.OK);
		} catch (Exception e) {

			return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/artist")
	public ResponseEntity<Object> addArtist(@RequestBody Artist body ,@RequestParam Integer accId) {

		try {
			
			Optional<Account> account = accountRepository.findById(accId);

			body.setAccount(account.get());
			
			Artist artist = artistRepository.save(body);
			
			for (Contact contact : body.getContact()) {
				contact.setArtist(artist);
				
				contactRepository.save(contact);
			}
			
//			for (Image image : body.getImages()) {
//				image.setArtist(artist);
//				
//				imageRepository.save(image);
//			}

			return new ResponseEntity<>(artist, HttpStatus.CREATED);

		} catch (Exception e) {

			System.out.println(e);
			return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/artist/{artistId}")
	public ResponseEntity<Object> getArtistDetail(@PathVariable Integer artistId) {

		try {

			Optional<Artist> artist = artistRepository.findById(artistId);

			if (artist.isPresent()) {

				return new ResponseEntity<>(artist, HttpStatus.OK);
			} else {

				return new ResponseEntity<>("artist not found", HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {

			return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/artist/{artistId}")
	public ResponseEntity<Object> updateArtist(@PathVariable Integer artistId, @RequestBody Artist body) {

		try {

			Optional<Artist> artist = artistRepository.findById(artistId);

			if (artist.isPresent()) {
				artist.get().setPenName(body.getPenName());
				artist.get().setRatePrice(body.getRatePrice());
				artist.get().setExp(body.getExp());
				artist.get().setArtistId(body.getArtistId());
				artist.get().setDetail(body.getDetail());
				
				for (Contact contact : body.getContact()) {
					contact.setArtist(artist.get());
					
					contactRepository.save(contact);
				}

				artistRepository.save(artist.get());

				return new ResponseEntity<>(artist, HttpStatus.OK);
			} else {
				return new ResponseEntity<>("artist not found", HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {

			return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/artist/{artistId}")
	public ResponseEntity<Object> deleteArtist(@PathVariable Integer artistId) {

		try {

			Optional<Artist> artist = artistRepository.findById(artistId);

			if (artist.isPresent()) {
				artistRepository.delete(artist.get());

				return new ResponseEntity<>("DELETE SUCSESS", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("artist not found", HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {

			return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
