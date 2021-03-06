package com.indika.Lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.indika.Lookify.models.Song;
import com.indika.Lookify.services.SongService;

@Controller
public class MainController {

	private final SongService songService;

    public MainController(SongService songService) {
        this.songService = songService;
    }

    //index page 
    @GetMapping("/")
    public String dashboard() {
    	return "index.jsp";
    }
    
    
    //dashboard mapping all songs
    @RequestMapping("/dashboard")
    public String index(Model model, @ModelAttribute("song") Song song) {
        List<Song> songs =songService.getAllSongs();
        model.addAttribute("songs", songs);
        return "dashboard.jsp";
    }
    
   
    
//----------creating a song---------------
    
    @GetMapping("/songs/new")
    public String create(@ModelAttribute("song") Song song) {
    	return "newsong.jsp";
    
    }
 
    
  //----------creating a song---------------   
//    @PostMapping("/songs/newsong")
    @RequestMapping(value="/songs/new", method=RequestMethod.POST)
    public String createSong(@Valid @ModelAttribute("song")Song song, BindingResult result, Model model) {
    	if(result.hasErrors()) {
	    	List<Song> songs =songService.getAllSongs();
			
			model.addAttribute("songs", songs);
	    	return "newsong.jsp";
    	} else {
    	songService.createSong(song);
    	return "redirect:/dashboard";
    }
    }


    
    	
//----------delete method -------------------
   
        @GetMapping(value="/songs/{id}/delete")
        public String destroy(@PathVariable("id") Long id) {
        	songService.deleteSong(id);
            return "redirect:/dashboard";
        }
    
//----------delete method -------------------
        
    
//----------Top ten page -------------------
        
        @RequestMapping("/songs/topten")
        public String topTen(Model model, @ModelAttribute("song") Song song) {
            List<Song> songs = songService.findTop10ByOrderByRatingDesc();
            model.addAttribute("songs", songs);
            return "topten.jsp";
        }
        
    
       
      //view method
        
        @RequestMapping("/songs/{id}")
        public String view(@PathVariable("id")Long id, Model model) {
            Song oneSong = songService.findById(id);
            model.addAttribute("song", oneSong);
            return "viewsong.jsp";
        }
        
        
        
         
      //to edit page 
        
        @RequestMapping("/edit-songs/{id}")
        public String editPage(@PathVariable("id")Long id, Model model) {
            Song oneSong = songService.findById(id);
            model.addAttribute("song", oneSong);
            return "editSong.jsp";
            
        }
        
      //to edit Song 
        
        @RequestMapping("/update-songs/{id}")
        public String editSong(@PathVariable("id")Long id, String title, String name, Integer rating, Integer star) {
        	songService.updateSong(id, title, name, rating, star);
        	return "redirect:/dashboard";
            
        }
 

        
       //-----------check with Kyle -------------------
      //----------Search-------------------       
        @GetMapping("/search")
        public String index(@RequestParam(value="name") String searchQuery, Model model) {
    		List<Song> songs = songService.search(searchQuery);
    		model.addAttribute("songs", songs);
    		return "search.jsp";
    	}
        
        
        

        //top ten songs 
//        @GetMapping("/search/topTen")
//    	public String topTen(Model model) {
//    		List<Song> songs = songService.findTop10();
//    		model.addAttribute("songs", songs);
//    		return "rating.jsp";
//    	}
//        
        
    	
   

    

}