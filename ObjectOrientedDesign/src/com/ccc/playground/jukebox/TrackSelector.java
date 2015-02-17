package com.ccc.playground.jukebox;

/**
 * The Track Selector for a Song.
 * 
 * @author Gibran E. Castillo
 *
 */
public class TrackSelector {
	private Song currentSong;
	
	public TrackSelector(Song s) {
		currentSong = s;
	}
	
	public void setTrack(Song s) {
		currentSong = s;
	}
	
	public Song getCurrentSong() {
		return currentSong;
	}
}