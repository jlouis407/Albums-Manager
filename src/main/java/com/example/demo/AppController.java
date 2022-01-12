package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.Album;
import com.example.demo.services.AlbumService;

@Controller
public class AppController {
	
	@Autowired
	AlbumService albumService;
	
	@GetMapping("/albums")
	public String viewAlbums(Model model) {
		List<Album> listStudent = albumService.listAllAlbums();
		model.addAttribute("listStudent",listStudent);
		return "albumsList";
	}
	

}
