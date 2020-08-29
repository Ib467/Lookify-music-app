package com.indika.Lookify.services;



import java.util.List;

import org.springframework.stereotype.Service;

import com.indika.Lookify.models.Song;
import com.indika.Lookify.repositories.SongRepository;
//import com.indika.productsandcat.models.Category;
//import com.indika.productsandcat.models.Product;

@Service
public class SongService {
    public final SongRepository songRepo;

    public SongService(SongRepository songRepo) {
        this.songRepo=songRepo;
    }
    
    //method of get all songs
    
    public List<Song>getAllSongs(){
        return this.songRepo.findAll();
    }
    
    
    //method of get all Top ten
    
    public List<Song>findTop10ByOrderByRatingDesc(){
        return this.songRepo.findTop10ByOrderByRatingDesc();
    }
    

    //create a Song 
    
    public Song createSong(Song l) {
        return this.songRepo.save(l);
    }
  
	public List<Song> search(String name) {
		return songRepo.findByNameContainingIgnoreCase(name);
		
	}
    
    
   
    //get song for view page
    public Song findById(Long id){
        return songRepo.findById(id).get();
    }

    //update a song 
    public Song updateSong(Long id, String title, String name, Integer rating, Integer star) {
    	Song song=songRepo.findById(id).get();
    	song.setTitle(title);
    	song.setName(name);
    	song.setRating(rating);
    	song.setStar(rating);
    	return songRepo.save(song);   
     }
    
    
    
    //delete a song

    public void deleteSong(Long id) {
        this.songRepo.deleteById(id);
    }


}
