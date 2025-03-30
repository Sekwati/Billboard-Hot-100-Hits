package com.billboard.billboard_hits.song;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song,String>{
	
	void deleteBySongName(String songName);
	
	Optional<Song> findBySongName(String songName);

}
