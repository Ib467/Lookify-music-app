package com.indika.Lookify.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.indika.Lookify.models.Song;
import com.indika.Lookify.services.SongService;



@RestController
public class SongsApi {

			private final SongService songService;
			
			public SongsApi(SongService songService) {
				this.songService = songService;
			}
			
//			@RequestMapping("/songs")
//			public String index(Model model) {
//			return "B;
//			}
			
			
			@RequestMapping("/api/songs")
			public List<Song> index(){
				return songService.getAllSongs();
			}
			
			//CREATING A SONG 
			@PostMapping("/api/songs")
		    public Song create(@RequestParam(value="name") String name, 
		    					@RequestParam(value="title") String title, 
		    					@RequestParam(value="rating") Integer rating,
		    					@RequestParam(value="star") String star) {
		        Song newSong = new Song(name, title, rating, star);
		        return songService.createSong(newSong);
		    }
			
			@RequestMapping("/api/songs/{id}")
		    public Song show(@PathVariable("id") Long id) {
		        Song song = songService.findById(id);
		        return song;
		    }
			
			
			//updating a song
			@PutMapping("/api/songs/{id}")
		    public Song update(@PathVariable("id") Long id, 
		    					@RequestParam(value="name") String name, 
		    					@RequestParam(value="title") String title, 
		    					@RequestParam(value="pages") Integer rating) {
		        Song song = songService.updateSong(id, name, title, rating);
		        return song;
		    }
			
		    
			//deleting a song
			@DeleteMapping("/api/songs/{id}")
		    public void destroy(@PathVariable("id") Long id) {
		        songService.deleteSong(id);
		    }
			
}
