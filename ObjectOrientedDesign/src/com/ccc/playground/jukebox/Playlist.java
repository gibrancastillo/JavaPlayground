package com.ccc.playground.jukebox;

/**
 * 
 * 
 * @author Gibran E. Castillo
 *
 */
public class Playlist {
	private CD cd;
	private Playlist p;
	
	public Playlist(CD cd) {
		this.cd = cd;
	}
	
	public Playlist(Playlist p) {
		this.p = p;
	}
	
	public Playlist(CD cd, Playlist p) {
		this.cd = cd;
		this.p = p;
	}
	
	public void playTrack(Song s) {
		// pending
	}
	
	public CD getCd() {
		return cd;
	}
	
	public void setCd(CD cd) {
		this.cd = cd;
	}
	
	public Playlist getPlaylist() {
		return p;
	}
	
	public void setPlaylist(Playlist p) {
		this.p = p;
	}
}