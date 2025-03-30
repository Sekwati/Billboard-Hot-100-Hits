package com.billboard.billboard_hits.song;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.transaction.Transactional;

@Component
public class SongService {
	private final SongRepository songRepository;
	
	@Autowired
	public SongService(SongRepository songRepository) {
		this.songRepository = songRepository;
	}
	
	public List<Song> getSongs(){
		return songRepository.findAll();	
	}
	
	//return all the songs that have reached a specific peak position
	public List<Song> getSongByPeakPosition(int peakPosition){
		return songRepository.findAll().stream().filter(song -> song.getPeakPosition() == peakPosition).collect(Collectors.toList()); 
	}
	
	//search for a song by name
	public List<Song> getSongByName(String searchText){
		return songRepository.findAll().stream().filter(song -> song.getSongName().toLowerCase().contains(searchText.toLowerCase())).collect(Collectors.toList());
	}
	
	//search for a song by spot on the chart
	public List<Song> getSongBySpot(int spot){
		return songRepository.findAll().stream().filter(song -> song.getSpot()== spot).collect(Collectors.toList());
	}
	
	//search for a song by weeks on the chart
	public List<Song> getSongByWeeksOnChart(int weeksOnChart){
		return songRepository.findAll().stream().filter(song -> song.getWeeksOnChart()== weeksOnChart).collect(Collectors.toList());
	}
	
	//search for a song by artist name
	public List<Song> getSongByArtist(String searchText){
		return songRepository.findAll().stream().filter(song -> song.getArtist().toLowerCase().contains(searchText.toLowerCase())).collect(Collectors.toList());
	}
	
	//adding a song to the database
	public Song addSong(Song song) {
		songRepository.save(song);
		return song;
	}
	
	//updating a song
	public Song updateSong(Song updatedSong) {
		Optional<Song> existingSong = songRepository.findBySongName(updatedSong.getSongName());
		
		//Sets old value to new value
		if(existingSong.isPresent()) {
			Song songToUpdate = existingSong.get();
			
			songToUpdate.setSongName(updatedSong.getSongName());
			songToUpdate.setArtist(updatedSong.getArtist());
			songToUpdate.setPeakPosition(updatedSong.getPeakPosition());
			songToUpdate.setWeeksOnChart(updatedSong.getWeeksOnChart());
			
			//save new song in repository
			songRepository.save(songToUpdate);
			
			return songToUpdate;
		}
		//if no song was found
		return null;
	}
	
	@Transactional
	public void deleteSong(String songName) {
		songRepository.deleteBySongName(songName);
	}

}
