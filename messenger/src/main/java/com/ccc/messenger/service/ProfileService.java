package com.ccc.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ccc.messenger.dao.DatabaseClass;
import com.ccc.messenger.model.Profile;

/**
 * A Service (stub) class to interact with the Data Access class (could use JDBC, JPA, Spring, Hibernate, etc).
 * 
 * Using an in memory Map to behave like a database, to support all the CRUD operations.
 * Create:  POST
 * Read:    GET
 * Update:  PUT
 * Delete:  DELETE
 * 
 * @author gecasti
 *
 */
public class ProfileService {
	private static Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService() {
		profiles.put("gibran", new Profile(1L, "gibran", "Gibran", "Castillo"));
	}
	
	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {
		if(profile.getProfileName().isEmpty()) {
		//if(profile.getId() <= 0) { commented this out because were using the Profile Name as the key and not the Profile ID.
			return null;
		}
		
		profiles.put(profile.getProfileName(), profile);
		
		return profile;
	}
	
	public Profile removeProfile(String profileName) {
		return profiles.remove(profileName);
	}
}