package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.ArtistRepository;

@RestController
@CrossOrigin(origins = "*")
public class AccountController {
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	ArtistRepository artistRepository;
	
//	@GetMapping("/account")
//	public ResponseEntity<Object> getAllAccount() {
//
//		try {
//			List<Account> accounts = accountRepository.findAll();
//
//			if(!accounts.isEmpty()) {
//				return new ResponseEntity<>(accounts, HttpStatus.OK);
//			}else {
//				return new ResponseEntity<>("account is empty!", HttpStatus.OK);
//			}
//			
//		} catch (Exception e) {
//
//			return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
	
	@GetMapping("/account")
	public ResponseEntity<Object> validateUser(@RequestParam String username, @RequestParam String password) {

		try {
			List<Account> accounts = accountRepository.findByUsernameLike(username);
			Account account = null;
			System.out.println("username:"+username);
			System.out.println("password:"+password);
			boolean validate = false;
			if(!accounts.isEmpty()) {
				System.out.println("isEmpty:"+accounts.isEmpty());
				for (int i = 0; i < accounts.size(); i++) {
					System.out.println("found Username "+(i+1)+":"+accounts.get(i).getUsername());
					System.out.println("found password "+(i+1)+":"+accounts.get(i).getPassword());
					if (accounts.get(i).getPassword().equals(password)) {
						System.out.println(accounts.get(i).getPassword()+" = "+password);
						account = accounts.get(i);
						validate=true;
						break;
					}
				}
			
				if(validate){
					return new ResponseEntity<>(account, HttpStatus.OK);
				}else {
					return new ResponseEntity<>("invalid password", HttpStatus.BAD_REQUEST);
				}
			}
			else {
				return new ResponseEntity<>("account not found", HttpStatus.BAD_REQUEST);
			}
			
		} catch (Exception e) {

			return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/account")
	public ResponseEntity<Object> addAccount(@RequestBody Account body) {

		try {
			
			Account account = accountRepository.save(body);
			
//			for (Artist artist : body.getArtists()) {
//				artist.setAccount(account);
//				
//				artistRepository.save(artist);
//			}
			

			return new ResponseEntity<>(account, HttpStatus.CREATED);

		} catch (Exception e) {

			return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/account/{accountId}")
	public ResponseEntity<Object> getAccountDetail(@PathVariable Integer accountId) {

		try {

			Optional<Account> account = accountRepository.findById(accountId);

			if (account.isPresent()) {

				return new ResponseEntity<>(account, HttpStatus.OK);
			} else {

				return new ResponseEntity<>("account not found", HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {

			return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/account/{accountId}")
	public ResponseEntity<Object> updateAccount(@PathVariable Integer accountId, @RequestBody Account body) {

		try {

			Optional<Account> account = accountRepository.findById(accountId);

			if (account.isPresent()) {
				account.get().setUsername(body.getUsername());
				account.get().setPassword(body.getPassword());

				accountRepository.save(account.get());

				return new ResponseEntity<>(account, HttpStatus.OK);
			} else {
				return new ResponseEntity<>("account not found", HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {

			return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/account/{accountId}")
	public ResponseEntity<Object> deleteAccount(@PathVariable Integer accountId) {

		try {

			Optional<Account> account = accountRepository.findById(accountId);

			if (account.isPresent()) {
				accountRepository.delete(account.get());

				return new ResponseEntity<>("DELETE SUCSESS", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("account not found", HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {

			return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
