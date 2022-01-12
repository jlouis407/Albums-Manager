package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Album;
import com.example.demo.repository.AlbumRepository;

@Service
public class AlbumService {
	
	@Autowired
	private AlbumRepository albumRepository;
	
	public List<Album> listAllAlbums(){
		return albumRepository.findAll();
	}
	
	public Album getAlbumById(Long id) {
		return albumRepository.findById(id).get();
	}
	
	public Album addAlbum(@RequestBody Album album) {
		return albumRepository.save(album);
	}
	
	public ResponseEntity<Album> updateAlbum(@PathVariable Long id, @RequestBody Album albumDetails){
			
			Album album = albumRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Album with id: " + id + " does not exist."));
			
			album.setTitle(albumDetails.getTitle());
			album.setArtist(albumDetails.getArtist());
			album.setGenre(albumDetails.getGenre());
			album.setYear(albumDetails.getYear());
			
			Album updatedAlbum = albumRepository.save(album);
			return ResponseEntity.ok(updatedAlbum);
		}

}
