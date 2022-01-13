package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Album;
import com.example.demo.services.AlbumService;

@Controller
public class AppController {
	
	@Autowired
	AlbumService albumService;
	
	@RequestMapping("/")
	public String viewHome(Model model) {
		List<Album> listAlbums = albumService.listAll();
		model.addAttribute("listAlbums", listAlbums);
		
		return "index";
	}
	
	@GetMapping("/index")
	public String cancel() {
		return "index";
	}
	
	@RequestMapping("/new")
	public String viewCreateAlbum(Model model) {
		Album album = new Album();
		model.addAttribute("album", album);
		
		return "newAlbum";
	}
	
	@PostMapping("/save")
	public String saveAlbum(@ModelAttribute("album") Album album) {
		albumService.save(album);
		
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public String viewEditAlbum(Model model, @PathVariable("id") Long id) {
		
		Album album = albumService.get(id);
		model.addAttribute("album", album);
		
		return "editAlbum";
		
	}	
	
	@RequestMapping("/delete/{id}")
	public String deleteAlbum(@PathVariable(name = "id") Long id) {
		albumService.delete(id);
		
		return "redirect:/";
	}
	
	
	
	

}
