package com.indika.Lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.indika.Lookify.models.Song;



public interface SongRepository extends CrudRepository<Song, Long>{
	
	List<Song> findAll();
	List<Song> findByNameContainingIgnoreCase(String name);
	List<Song> findTop10ByOrderByRatingDesc();
	
	
	
}
