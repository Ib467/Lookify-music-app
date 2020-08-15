package com.indika.Lookify.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.indika.Lookify.models.Song;
import com.indika.Lookify.repositories.SongRepository;

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
    public Song updateSong(Long id, String title, String name, int rating) {
    	Song song=songRepo.findById(id).get();
    	song.setTitle(title);
    	song.setName(name);
    	song.setRating(rating);
    	return songRepo.save(song);
 
    
     }
    
    
    
    //delete a song

    public void deleteSong(Long id) {
        this.songRepo.deleteById(id);
    }


}
