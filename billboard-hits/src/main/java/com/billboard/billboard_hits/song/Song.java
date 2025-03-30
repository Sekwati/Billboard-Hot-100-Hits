package com.billboard.billboard_hits.song;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "top_songs")
public class Song {
	
	@Id
	@Column(name = "spot", unique = true, nullable = false)
	private int spot;
	
	private String songName;
	
	private String artist;
	
	private int peakPosition;
	
	private int weeksOnChart;
	
	public Song() {
	
	}
	
	public Song(int spot, String songName, String artist, int peakPosition, int weeksOnChart) {
		this.spot = spot;
		this.songName = songName;
		this.artist = artist;
		this.peakPosition = peakPosition;
		this.weeksOnChart = weeksOnChart;
	}
	
	public Song(String songName) {
		this.songName = songName;
	}
	
	
	public int getSpot() {
		return spot;
	}
	
	public void setSpot(int spot) {
		this.spot = spot;
	}
	
	
	public String getSongName() {
		return songName;
	}
	
	public void setSongName(String songName) {
		this.songName = songName;
	}
	
	
	public String getArtist() {
		return artist;
	}
	
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	
	public int getPeakPosition() {
		return peakPosition;
	}
	
	public void setPeakPosition(int peakPosition) {
		this.peakPosition = peakPosition;
	}
	
	
	public int getWeeksOnChart() {
		return weeksOnChart;
	}
	
	public void setWeeksOnChart(int weeksOnChart) {
		this.weeksOnChart = weeksOnChart;
	}

}
