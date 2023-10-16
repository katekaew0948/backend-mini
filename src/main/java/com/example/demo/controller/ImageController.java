//package com.example.demo.controller;

//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.demo.model.Account;
//import com.example.demo.model.Artist;
//import com.example.demo.model.Image;
//import com.example.demo.repository.ArtistRepository;
//import com.example.demo.repository.ImageRepository;
//
//@RestController
//public class ImageController {
//	@Autowired
//	ImageRepository imageRepository;
//	@Autowired
//	ArtistRepository artistRepository;
//	
//	@GetMapping("/image/{artId}")
//	public ResponseEntity<Object> getImage(@PathVariable Integer artId) {
//
//		try {
//
//			Optional<Artist> artist = accountRepository.findById(accId);
//
//			body.setAccount(account.get());
//			
//			Artist artist = artistRepository.save(body);
//
//				return new ResponseEntity<>("account not found", HttpStatus.BAD_REQUEST);
//			
//
//		} catch (Exception e) {
//
//			return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
//	
//	@PostMapping("/image/{artId}")
//	public ResponseEntity<Object> addImage(@RequestBody Image body ,@PathVariable Integer artId) {
//
//		try {
//			
//			Image image = imageRepository.save(body);
//
//			return new ResponseEntity<>(image, HttpStatus.CREATED);
//
//		} catch (Exception e) {
//
//			return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}

//}
