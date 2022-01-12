package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Album;
import com.example.demo.repository.AlbumRepository;

@Service
public class AlbumService {
	
	@Autowired
	private AlbumRepository albumRepository;
	
	public List<Album> listAll() {		
		return albumRepository.findAll();
	}
	
	public void save(Album album) {
		albumRepository.save(album);
	}
	
	public Album get(Long id) {
		return albumRepository.findById(id).get();
	}
	
	public void delete(Long id) {
		albumRepository.deleteById(id);
	}

}
