package com.billboard.billboard_hits.song;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/song")
public class SongController {
	//field to store the song service
	private final SongService songService;
	
	@Autowired
	public SongController(SongService songService) {
		this.songService = songService;
	}
	
	@GetMapping
	public List<Song> getSongs(
			@RequestParam(required = false) String songName,
			@RequestParam(required = false) String artist,
			@RequestParam(required = false) Integer spot,
			@RequestParam(required = false) Integer weeksOnChart,
			@RequestParam(required = false) Integer peakPosition){
		
		// If no parameter is provided getSong will return all the parameters
		
		if(songName != null) {
			return songService.getSongByName(songName);
		}
		
		else if(artist != null) {
			return songService.getSongByArtist(artist);
		}
		
		if(spot != null && spot > 0 && spot <= 100) {
			return songService.getSongBySpot(spot);
		}
		
		if(weeksOnChart != null && weeksOnChart > 0) {
			return songService.getSongByWeeksOnChart(weeksOnChart);
		}
		
		if(peakPosition != null && peakPosition > 0 ) {
			return songService.getSongByPeakPosition(peakPosition);
		}
		
		return songService.getSongs();
	}
	
	@PostMapping
	public ResponseEntity<Song> addSong(@RequestBody Song song){
		Song createdSong = songService.addSong(song);
		return new ResponseEntity<>(createdSong, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Song> updateSong(@RequestBody Song song){
		Song resultSong = songService.updateSong(song);
		if (resultSong != null) {
			return new ResponseEntity<>(resultSong, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{songName}")
	public ResponseEntity<String> deleteSong(@PathVariable String songName){
		
		//First, check if the song exists before deleting
		List<Song> songs = songService.getSongByName(songName);
	    if (songs.isEmpty()) {
	        return new ResponseEntity<>("Song not found", HttpStatus.NOT_FOUND);
	    }
	    
	    
		songService.deleteSong(songName);
		return new ResponseEntity<>("Song deleted succesfully", HttpStatus.OK);
	}
	

}
