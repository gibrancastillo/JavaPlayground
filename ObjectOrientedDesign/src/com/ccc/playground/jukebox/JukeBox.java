package com.ccc.playground.jukebox;

import java.util.Set;

/**
 * Design a musical juke box using object oriented principles.
 * 
 * The basic system components:
 * - Song
 * - CD
 * - CD player
 * - Display () (displays length of song, remaining time and play list)
 * - Playlist creation (includes add, delete, shuffle etc sub functionalities)
 * - CD selector
 * - Track selector
 * - Queueing up a song
 * - Get next song from playlist
 * 
 * A user also can be introduced:
 * - Adding
 * - Deleting
 * - Credit information
 * 
 * How do we group this functionality based on Objects (data plus functions which go together)?
 * Object Oriented Design suggest wrapping up data with their operating functions in a single entity class.
 * 
 * @author Gibran E. Castillo
 *
 */
public class JukeBox {
	private User user;
	private TrackSelector ts;
	private CDPlayer cdPlayer;
	private Set<CD> cdCollection;
	
	public JukeBox(User user, TrackSelector ts, CDPlayer cdPlayer, Set<CD> cdCollection) {
		this.user = user;
		this.ts = ts;
		this.cdPlayer = cdPlayer;
		this.cdCollection = cdCollection;
	}
	
	public Song getCurrentTrack() {
		return ts.getCurrentSong();
	}
	
	public void processOneUser(User u) {
		this.user = u;
	}
}