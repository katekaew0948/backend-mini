package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Account;
import com.example.demo.model.Artist;
import com.example.demo.model.Contact;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Integer> {
	List<Artist> findByAccountId(Integer account);
}
