package com.ccc.messenger.dao;

import java.util.HashMap;
import java.util.Map;

import com.ccc.messenger.model.Message;
import com.ccc.messenger.model.Profile;

/**
 * An in memory Map to behave like a database, to support all the CRUD operations.
 * HTTP Request       SQL          Operation   
 *   Method        Statement
 * <> POST   --->   INSERT     --> 'C'reate
 * <> GET    --->   SELECT     --> 'R'ead (Retrieve)
 * <> PUT    --->   UPDATE     --> 'U'pdate (Modify)
 * <> DELETE --->   DELETE     --> 'D'elete (Destroy)
 * 
 * You can use the HTTP Method POST to perform an update operation; however, the standard practice is to use the HTTP Method PUT. 
 * 
 * If I had a database (like MySQL), this would be the Data Access class (using JDBC or JPA or Spring or Hibernate... etc).
 * 
 * @author gecasti
 *
 */
public class DatabaseClass {
	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<String, Profile> profiles = new HashMap<>();
	
	public static Map<Long, Message> getMessages() {
		return messages;
	}
	
	public static Map<String, Profile> getProfiles() {
		return profiles;
	}
}